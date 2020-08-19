package com.healthbrowser.moudles.residenthealth.follow.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.utils.properties.PropertiesUtil;
import com.healthbrowser.moudles.residenthealth.follow.service.JsbService;
import com.healthbrowser.moudles.residenthealth.follow.util.ResultUtil;
import com.healthbrowser.until.http.HttpUtil;

import javax.inject.Named;

@Named
public class JsbServiceImpl implements JsbService {

    private String HOST = PropertiesUtil.getFollow("HOST");

    @Override
    public JsonResult getJsbJb(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("REGION_JSBJB");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getJsbJbList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("REGION_JSBJBLIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getJsb(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("REGION_JSB");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getJsbList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("REGION_JSBLIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }
}
