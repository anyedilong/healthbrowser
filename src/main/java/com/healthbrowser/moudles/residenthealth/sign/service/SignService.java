package com.healthbrowser.moudles.residenthealth.sign.service;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;

public interface SignService {

    JsonResult getSignInfo(JSONObject request) throws Exception;

    JsonResult getSignServiceList(JSONObject request) throws Exception;

    JsonResult getSignServiceInfo(JSONObject request) throws Exception;
}
