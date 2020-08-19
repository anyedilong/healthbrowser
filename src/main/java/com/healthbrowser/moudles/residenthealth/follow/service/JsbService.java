package com.healthbrowser.moudles.residenthealth.follow.service;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;

public interface JsbService {
    JsonResult getJsbJb(JSONObject request) throws Exception;

    JsonResult getJsbJbList(JSONObject request) throws Exception;

    JsonResult getJsb(JSONObject request) throws Exception;

    JsonResult getJsbList(JSONObject request) throws Exception;
}
