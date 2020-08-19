package com.healthbrowser.moudles.residenthealth.follow.service;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;

public interface FjhService {
    JsonResult getFjhRh(JSONObject request) throws Exception;

    JsonResult getFjhRhList(JSONObject request) throws Exception;

    JsonResult getFjh(JSONObject request) throws Exception;

    JsonResult getFjhList(JSONObject request) throws Exception;
}
