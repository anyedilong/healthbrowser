package com.healthbrowser;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.MultipartConfigElement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

import com.healthbrowser.config.spring.InstanceFactory;


@ComponentScan(basePackages = {"com.healthbrowser"},includeFilters = {
		@ComponentScan.Filter(value = Service.class, type = FilterType.ANNOTATION),
		@ComponentScan.Filter(value = Named.class, type = FilterType.ANNOTATION),
		@ComponentScan.Filter(value = Inject.class, type = FilterType.ANNOTATION)})
@Configuration
@EnableAutoConfiguration
public class Application {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		application.setWebEnvironment(true);
		ApplicationContext context = application.run();
		InstanceFactory instanceFactory = new InstanceFactory();
		instanceFactory.setApplicationContext(context);
	}

	/**
     * 	文件上传配置  
     * @return  
     */  
    @Bean  
    public MultipartConfigElement multipartConfigElement() {  
        MultipartConfigFactory factory = new MultipartConfigFactory();  
        //单个文件最大  
        factory.setMaxFileSize("10240MB"); //KB,MB  
        //设置总上传数据总大小  
        factory.setMaxRequestSize("102400MB");
        return factory.createMultipartConfig();
    }
}
