package com.healthbrowser.moudles.residenthealth.follow.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.utils.properties.PropertiesUtil;
import com.healthbrowser.moudles.residenthealth.follow.service.LnrService;
import com.healthbrowser.moudles.residenthealth.follow.util.ResultUtil;
import com.healthbrowser.until.http.HttpUtil;

import javax.inject.Named;

@Named
public class LnrServiceImpl implements LnrService {
    private String HOST = PropertiesUtil.getFollow("HOST");
    @Override
    public JsonResult getJkgl(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("LNRJKGL");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getJkglList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("LNRJKGLLIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getLnrZyy(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("LNRZYY");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getLnrZyyList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("LNRZYYLIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }
}
