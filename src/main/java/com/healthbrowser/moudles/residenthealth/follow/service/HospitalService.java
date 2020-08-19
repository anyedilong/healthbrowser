package com.healthbrowser.moudles.residenthealth.follow.service;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;

public interface HospitalService {

    //病案首页详情
    JsonResult getBasy(String id, String orgCode) throws Exception;
}
