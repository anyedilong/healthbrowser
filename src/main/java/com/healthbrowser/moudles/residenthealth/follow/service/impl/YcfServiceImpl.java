package com.healthbrowser.moudles.residenthealth.follow.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.utils.properties.PropertiesUtil;
import com.healthbrowser.moudles.residenthealth.follow.service.YcfService;
import com.healthbrowser.moudles.residenthealth.follow.util.ResultUtil;
import com.healthbrowser.until.http.HttpUtil;

import javax.inject.Named;

@Named
public class YcfServiceImpl implements YcfService {
    private String HOST = PropertiesUtil.getFollow("HOST");

    @Override
    public JsonResult getYcfList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("YCF_LIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getYcfSc(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("YCFSC");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getYcfScList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("YCFSCLIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getYcfCq(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("YCFCQ");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getYcfCqList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("YCFCQLIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getYcfCh(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("YCFCH");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getYcfChList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("YCFCHLIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getYcfCh42(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("YCFCH42");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getYcfCh42List(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("YCFCH42LIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }
}
