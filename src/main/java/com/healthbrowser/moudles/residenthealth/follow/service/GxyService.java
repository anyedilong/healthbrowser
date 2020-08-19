package com.healthbrowser.moudles.residenthealth.follow.service;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;

public interface GxyService {
    JsonResult getGxyJb(JSONObject request) throws Exception;

    JsonResult getGxyJbList(JSONObject request) throws Exception;

    JsonResult getGxySz(JSONObject request) throws Exception;

    JsonResult getGxySzList(JSONObject request) throws Exception;

    JsonResult getGxy(JSONObject request) throws Exception;

    JsonResult getGxyList(JSONObject request) throws Exception;
}
