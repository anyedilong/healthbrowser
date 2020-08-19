package com.healthbrowser.moudles.residenthealth.follow.service;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;

public interface HzjlService {
    JsonResult getHzjl(JSONObject request) throws Exception;
}
