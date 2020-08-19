package com.healthbrowser.moudles.residenthealth.follow.service;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;

public interface GxbService {
    JsonResult getGxb(JSONObject request) throws Exception;

    JsonResult getGxbList(JSONObject request) throws Exception;
}
