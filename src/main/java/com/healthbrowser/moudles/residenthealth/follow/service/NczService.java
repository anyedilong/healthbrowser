package com.healthbrowser.moudles.residenthealth.follow.service;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;

public interface NczService {
    JsonResult getNcz(JSONObject request) throws Exception;

    JsonResult getNczList(JSONObject request) throws Exception;
}
