package com.healthbrowser.moudles.residenthealth.sign.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.utils.properties.PropertiesUtil;
import com.healthbrowser.moudles.residenthealth.follow.util.ResultUtil;
import com.healthbrowser.moudles.residenthealth.sign.service.SignService;
import com.healthbrowser.until.http.HttpUtil;

import javax.inject.Named;

//签约
@Named
public class SignServiceImpl implements SignService {

    private String HOST = PropertiesUtil.getFollow("HOST");

    @Override
    public JsonResult getSignInfo(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("REGION_SIGN");
        String result = HttpUtil.doPost(HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getSignServiceList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("REGION_RECORD_LIST");
        String result = HttpUtil.doPost(HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }
    
    @Override
    public JsonResult getSignServiceInfo(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("REGION_RECORD_INFO");
        String result = HttpUtil.doPost(HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }
}
