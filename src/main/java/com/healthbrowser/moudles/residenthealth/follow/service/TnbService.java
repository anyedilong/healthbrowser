package com.healthbrowser.moudles.residenthealth.follow.service;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;

public interface TnbService {
    JsonResult getTnb(JSONObject request) throws Exception;

    JsonResult getTnbList(JSONObject request) throws Exception;
}
