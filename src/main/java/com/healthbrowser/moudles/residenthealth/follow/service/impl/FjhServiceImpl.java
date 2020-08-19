package com.healthbrowser.moudles.residenthealth.follow.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.utils.properties.PropertiesUtil;
import com.healthbrowser.moudles.residenthealth.follow.service.FjhService;
import com.healthbrowser.moudles.residenthealth.follow.util.ResultUtil;
import com.healthbrowser.until.http.HttpUtil;

import javax.inject.Named;

@Named
public class FjhServiceImpl implements FjhService {
    private String HOST = PropertiesUtil.getFollow("HOST");
    @Override
    public JsonResult getFjhRh(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("FJHRH");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getFjhRhList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("FJHRHLIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getFjh(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("FJH");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getFjhList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("FJHLIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }
}
