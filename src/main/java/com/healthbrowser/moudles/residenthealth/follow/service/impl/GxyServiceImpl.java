package com.healthbrowser.moudles.residenthealth.follow.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.utils.properties.PropertiesUtil;
import com.healthbrowser.moudles.residenthealth.follow.service.GxyService;
import com.healthbrowser.moudles.residenthealth.follow.util.ResultUtil;
import com.healthbrowser.until.http.HttpUtil;

import javax.inject.Named;

@Named
public class GxyServiceImpl implements GxyService {

    private String HOST = PropertiesUtil.getFollow("HOST");

    @Override
    public JsonResult getGxyJb(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("REGION_GXYJB");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getGxyJbList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("REGION_GXYJB_LIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getGxySz(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("REGION_GXYSZ");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getGxySzList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("REGION_GXYSZ_LIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getGxy(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("REGION_GXY");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getGxyList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("REGION_GXY_LIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }
}
