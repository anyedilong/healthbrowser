package com.healthbrowser.moudles.residenthealth.follow.service;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;

public interface YcfService {

    JsonResult getYcfList(JSONObject request) throws Exception;

    JsonResult getYcfSc(JSONObject request) throws Exception;

    JsonResult getYcfScList(JSONObject request) throws Exception;

    JsonResult getYcfCq(JSONObject request) throws Exception;

    JsonResult getYcfCqList(JSONObject request) throws Exception;

    JsonResult getYcfCh(JSONObject request) throws Exception;

    JsonResult getYcfChList(JSONObject request) throws Exception;

    JsonResult getYcfCh42(JSONObject request) throws Exception;

    JsonResult getYcfCh42List(JSONObject request) throws Exception;
}
