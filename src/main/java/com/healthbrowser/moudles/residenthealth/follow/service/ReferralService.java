package com.healthbrowser.moudles.residenthealth.follow.service;

import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.domain.PageModel;

public interface ReferralService {
	
	//获取转诊的列表
	PageModel getReferralPage(PageModel page, Map<String, String> paramMap) throws Exception;
	
    JsonResult getInfo(JSONObject request) throws Exception;
}
