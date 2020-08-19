package com.healthbrowser.moudles.residenthealth.follow.service;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;

public interface LnrService {
    JsonResult getJkgl(JSONObject request) throws Exception;

    JsonResult getJkglList(JSONObject request) throws Exception;

    JsonResult getLnrZyy(JSONObject request) throws Exception;

    JsonResult getLnrZyyList(JSONObject request) throws Exception;
}
