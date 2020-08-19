package com.healthbrowser.moudles.common.service;


public interface LoginService {

	//生成认证的token
	String produceAuthToken()throws Exception;
	//是否锁定
	boolean islock()throws Exception;
	//锁定用户ip
	void lockUser(String flag)throws Exception;
	//第三方登录验证 
	String thirdPartLogin(String orgId, String authCode, String doctorCode, String doctorName)throws Exception;
	
}
