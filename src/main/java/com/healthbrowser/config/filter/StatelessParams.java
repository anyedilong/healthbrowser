package com.healthbrowser.config.filter;


import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.codec.Base64;

import com.healthbrowser.until.StringUtil;

public class StatelessParams {

    /**
     * 获取加密验证
     * @param request
     * @return
     */
    public static  final String  getAuth(HttpServletRequest request){
        try {
              String authToken=request.getHeader("authToken");
              if(!StringUtil.isNull(authToken)){
                  return  authToken;
              }
        }catch (Exception e){
            e.printStackTrace();
        }
      return  null;
    }
    
    /**
	 * <li>描述:授权码</li>
	 * <li>方法名称:getSecurityToken</li>
	 * <li>参数:@param request
	 * <li>参数:@return</li>
	 */
	public static final String getSecurityToken(ServletRequest request) {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String token = httpRequest.getHeader("authToken");
		if (!StringUtil.isNull(token)) {
			// 进行解密
			String decodeToken = Base64.decodeToString(token);
			String tokenArray[] = decodeToken.split(":");

			if (tokenArray.length > 0 && !StringUtil.isNull(tokenArray[0])) {
				String securityToken = Base64.decodeToString(tokenArray[0]);

				return securityToken;
			}
		}
		return null;
	}
}
