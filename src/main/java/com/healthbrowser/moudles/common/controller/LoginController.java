package com.healthbrowser.moudles.common.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.config.filter.StatelessParams;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.service.LoginService;
import com.healthbrowser.moudles.system.domain.SysUser;
import com.healthbrowser.moudles.system.service.SysUserService;
import com.healthbrowser.until.cache.EhCacheEmun;
import com.healthbrowser.until.cache.EhCacheUtils;
import com.healthbrowser.until.encode.Md5Encrypt;

/**
 * @ClassName: LoginController
 * @Description: 
 * @author Administrator
 * @date 2019年9月5日
 */
@RestController
@RequestMapping("login")
public class LoginController extends BaseController {

	@Autowired
	private SysUserService userService;
	@Autowired
	private LoginService loginService;
	
	@Value("${healthResidentPagePath}")
    private String healthResidentPagePath;
	
	
	/**
	 * @Description: 平台管理员登录
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("index")
	public JsonResult index() {
		try {
			//判断改ip是否被锁定
			if(loginService.islock()) {
				return jsonResult(null, 11001, "电脑已被锁定，请联系上级管理员解冻");
			}
		    String param = getParam(request);
		    JSONObject paramObj = JSONObject.parseObject(param);
		    String userName = paramObj.getString("username");
		    String password = paramObj.getString("password");
			// 根据登录名获取账号信息
			SysUser user = userService.getUserByUserName(userName);

			if (null != user) {
				String pwd = user.getPassword();
				password = Md5Encrypt.getMD5Code(password);
				if (password.equals(pwd)) {
					//验证用户是否可以正常使用
					if("2".equals(user.getStatus())){
						return jsonResult(null, 30001, "用户已冻结，请联系上级管理员解冻");
					}
					//获取用户登录后key和token
					String keyTokenStr = loginService.produceAuthToken();
					EhCacheUtils.put(EhCacheEmun.SYS_CACHE, keyTokenStr.split(",")[1], keyTokenStr.split(",")[2]);
					EhCacheUtils.put(EhCacheEmun.SYS_CACHE, keyTokenStr.split(",")[0], user);
					return jsonResult(keyTokenStr.split(",")[0], user);
				} else {
					// 密码错误
					loginService.lockUser("loginError");
					return jsonResult(null, 20001, "账户名与密码不匹配，请重新输入");
				}
			} else {
				// 用户名不存在
				loginService.lockUser("loginError");
				return jsonResult(null, 20002, "账户名不存在，请重新输入");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	/**
	 * @Description: 第三方平台用户登录
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("/healthBrowser/index")
	public JsonResult thirdPartLogin() {
		try {
			String param = getParam(request);
		    JSONObject paramObj = JSONObject.parseObject(param);
		    System.out.println(">>>>>>>>>>>>>>>>"+paramObj);
			//从heaher里面取出机构id和授权码
			String orgId = request.getHeader("orgId");
			String authCode = request.getHeader("authCode");
			//登录用户的编号和名称
			String doctorCode = paramObj.getString("doctorCode");
			String doctorName = paramObj.getString("doctorName");
			String flag = loginService.thirdPartLogin(orgId, authCode, doctorCode, doctorName);
			//flag : 1.医生， 2.护士 3.验证失败
			if("1".equals(flag) || "2".equals(flag)) {
				//获取用户登录后key和token
				String keyTokenStr = loginService.produceAuthToken();
				EhCacheUtils.put(EhCacheEmun.SYS_CACHE, keyTokenStr.split(",")[1], keyTokenStr.split(",")[2]);
				SysUser user = new SysUser();
				user.setName(doctorName);
				EhCacheUtils.put(EhCacheEmun.SYS_CACHE, keyTokenStr.split(",")[0], user);
				String resultAddress = healthResidentPagePath+"?role="+flag+"&orgId="+orgId+"&authToken="+keyTokenStr.split(",")[0];
				return jsonResult(resultAddress);
			}else {
				return jsonResult("登录账户验证失败！！！");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult("健康居民浏览器停止工作，请联系管理员!!!");
		}
	}
	
	
	/**
	 * @Description 用户退出
	 * @return
	 * @author tz
	 */
	@RequestMapping("exit")
	public JsonResult exit() {
		try {
			// 客户端请求的授权码
			String key = StatelessParams.getSecurityToken(request);
			EhCacheUtils.remove(EhCacheEmun.SYS_CACHE, key);
			String auth = StatelessParams.getAuth(request);
			EhCacheUtils.remove(EhCacheEmun.SYS_CACHE, auth);
			return jsonResult();
		}catch(Exception e) {
			e.printStackTrace();
			return jsonResult(null,10001,"系统错误"); 
		}
	}
	
	/**
	 * @Description 锁定使用者的ip
	 * @return
	 * @author tz
	 */
	@RequestMapping("giveSurprise")
	public void giveSurprise() {
		try {
			loginService.lockUser("surprise");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
