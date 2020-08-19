package com.healthbrowser.config.filter;


import java.util.List;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.healthbrowser.until.StringUtil;
import com.healthbrowser.until.cache.EhCacheEmun;
import com.healthbrowser.until.cache.EhCacheUtils;
import com.healthbrowser.until.sha1.SHA1Encrypt;

@Configuration  
public  class WebFilterInterceptor extends WebMvcConfigurerAdapter  {

    @Value("${healthpath}")
    private String healthpath;

    @Override
	public void addCorsMappings(CorsRegistry registry) {
    	registry.addMapping("/**");
	}

    @Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig());
		return new CorsFilter(source);
	}

	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		return corsConfiguration;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		//调用父类的配置
        super.configureMessageConverters(converters);
        //创建fastJson消息转换器
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        //创建配置类
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        //修改配置返回内容的过滤
        fastJsonConfig.setSerializerFeatures(
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty
        );
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //将fastjson添加到视图消息转换器列表内
        converters.add(fastConverter);
	}
    
    @Override
    public void addInterceptors(InterceptorRegistry registry){
    	/**
	     * 	平台验证
	     */
        registry.addInterceptor(new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
				
            	// 客户端请求的授权码
				String key = StatelessParams.getSecurityToken(request);
				if (StringUtil.isNull(key)) {
					// 身份认证错误
					onAuthFail(response);
					return false;
				}
				// 验证缓存中是否存在该用户信息
				String authCode = SHA1Encrypt.encryptToken(key); 
				String cacheAuthCode = (String) EhCacheUtils.get(EhCacheEmun.SYS_CACHE, key);
				if(StringUtil.isNull(authCode) || !authCode.equals(cacheAuthCode)) { 
				    //身份认证错误 
					onAuthFail(response); 
					return false; 
				}
                return true;
            }
        }).addPathPatterns(String.format("%s/**", healthpath));
    }

    /**
	 * <li>描述:身份认证错误默认返回401状态码</li>
	 * <li>方法名称:onAuthFail</li>
	 * <li>参数:@param response
	 * <li>参数:@throws Exception</li>
	 * <li>返回类型:void</li>
	 * <li>最后更新作者:gaoqs</li>
	 */
	private void onAuthFail(ServletResponse response) throws Exception {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		response.setContentType("application/json;charset=UTF-8");
		//JsonResult ret = new JsonResult("身份认证错误", ProcessStatus.AUTH_ERROR);
		//ret.setResponseStatus(ResponseStatus.HTTP_UNAUTHORIZED);
		httpResponse.getWriter().write("{\"retCode\":20001,\"retMsg\":\"身份认证错误\"}");
		httpResponse.getWriter().flush();
		httpResponse.getWriter().close();
	}
}
