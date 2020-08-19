package com.healthbrowser.moudles.residenthealth.follow.service;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;

public interface YfjzService {
    JsonResult getInfo(JSONObject request) throws Exception;

    JsonResult getList(JSONObject request) throws Exception;

}
