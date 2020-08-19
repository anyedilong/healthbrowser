package com.healthbrowser.moudles.residenthealth.follow.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.utils.properties.PropertiesUtil;
import com.healthbrowser.moudles.residenthealth.follow.service.EtService;
import com.healthbrowser.moudles.residenthealth.follow.util.ResultUtil;
import com.healthbrowser.until.http.HttpUtil;
import org.apache.commons.lang3.StringUtils;

import javax.inject.Named;

/**
 * 儿童随访查询
 */
@Named
public class EtServiceImpl implements EtService {
    private String HOST = PropertiesUtil.getFollow("HOST");

    @Override
    public JsonResult getEtList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("REGION_ET_LIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getEtJb(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("ETJBINFO");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getXse(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("XSEINFO");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getXseList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("XSELIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getEt1(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("ET1INFO");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getEt1List(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("ET1LIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getEt3(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("ET3INFO");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getEt3List(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("ET3LIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getEt6(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("ET6INFO");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getEt6List(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("ET6LIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getEt1Zyy(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("ET1ZYY");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getEt1ZyyList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("ET1ZYYLIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getEt3Zyy(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("ET3ZYY");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getEt3ZyyList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("ET3ZYYLIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getEt6Zyy(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("ET6ZYY");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getEt6ZyyList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("ET6ZYYLIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }
}
