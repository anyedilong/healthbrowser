package com.healthbrowser.moudles.common.service.impl;

import org.apache.shiro.codec.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.healthbrowser.moudles.common.service.LoginService;
import com.healthbrowser.moudles.system.dao.repository.SysBlackBillRepository;
import com.healthbrowser.moudles.system.domain.SysBlackBill;
import com.healthbrowser.until.UUIDUtil;
import com.healthbrowser.until.http.HttpRequest;
import com.healthbrowser.until.sha1.SHA1Encrypt;

import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;


@Service("loginService")
public class LoginServiceImpl implements LoginService{

	@Autowired
	private SysBlackBillRepository bbRepository;
	
	@Value("${hisregionurl}")
    private String hisregionurl;
	
	
	@Override
	public String produceAuthToken() throws Exception {
		String ip = InetAddress.getLocalHost().getHostAddress();
		bbRepository.deleteByIp(ip);
		//生成新的key值
		String key = UUIDUtil.getUUID();
		String baseSecurity = Base64.encodeToString(key.getBytes());
		String newAuthToken = Base64.encodeToString((baseSecurity).getBytes());
		// 将用户信息放入缓存新的key值中
		String newAuthCode = SHA1Encrypt.encryptToken(key);
		return newAuthToken + "," + key + "," + newAuthCode;
	}
	
	@Override
	public boolean islock() throws Exception {
		String ip = InetAddress.getLocalHost().getHostAddress();
		SysBlackBill info = bbRepository.queryInfoByIp(ip);
		if(info != null && "1".equals(info.getStatus())) {
			return true;
		}else {
			return false;
		}
	}
	
	@Override
	public void lockUser(String flag)throws Exception {
		String ip = InetAddress.getLocalHost().getHostAddress();
		SysBlackBill info = bbRepository.queryInfoByIp(ip);
		if(info == null) {
			SysBlackBill bill = new SysBlackBill();
			bill.setId(UUIDUtil.getUUID());
			bill.setUserIp(ip);
			if("surprise".equals(flag) ) {
				bill.setStatus("1");
			}else {
				bill.setTimes(1);
				bill.setStatus("0");
			}
			bbRepository.save(bill);
		}else if("0".equals(info.getStatus())) {
			Integer times = info.getTimes() + 1;
			if(times < 9) {
				bbRepository.updateInfo(ip, times, "0");
			}else {
				bbRepository.updateInfo(ip, times, "1");
			}
		}
	}

	@Override
	public String thirdPartLogin(String orgId, String authCode, String doctorCode, String doctorName) throws Exception {
		Map<String, String> paramMap = new HashMap<>();
		paramMap.put("orgId", orgId);
		paramMap.put("authCode", authCode);
		paramMap.put("doctorCode", doctorCode);
		paramMap.put("doctorName", doctorName);
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/healthbrowser/checkUserLegal", paramMap);
		return JSON.parse(sendPost).toString();
	}



}
