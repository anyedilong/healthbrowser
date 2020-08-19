package com.healthbrowser.moudles.residenthealth.follow.service;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.follow.dto.*;

import java.util.List;

public interface EtService {
    JsonResult getEtList(JSONObject request) throws Exception;

    JsonResult getEtJb(JSONObject request) throws Exception;

    JsonResult getXse(JSONObject request) throws Exception;

    JsonResult getXseList(JSONObject request) throws Exception;

    JsonResult getEt1(JSONObject request) throws Exception;

    JsonResult getEt1List(JSONObject request) throws Exception;

    JsonResult getEt3(JSONObject request) throws Exception;

    JsonResult getEt3List(JSONObject request) throws Exception;

    JsonResult getEt6(JSONObject request) throws Exception;

    JsonResult getEt6List(JSONObject request) throws Exception;

    JsonResult getEt1Zyy(JSONObject request) throws Exception;

    JsonResult getEt1ZyyList(JSONObject request) throws Exception;

    JsonResult getEt3Zyy(JSONObject request) throws Exception;

    JsonResult getEt3ZyyList(JSONObject request) throws Exception;

    JsonResult getEt6Zyy(JSONObject request) throws Exception;

    JsonResult getEt6ZyyList(JSONObject request) throws Exception;
}
