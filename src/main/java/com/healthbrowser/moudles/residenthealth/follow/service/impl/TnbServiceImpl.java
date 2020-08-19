package com.healthbrowser.moudles.residenthealth.follow.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.utils.properties.PropertiesUtil;
import com.healthbrowser.moudles.residenthealth.follow.service.TnbService;
import com.healthbrowser.moudles.residenthealth.follow.util.ResultUtil;
import com.healthbrowser.until.http.HttpUtil;

import javax.inject.Named;

@Named
public class TnbServiceImpl implements TnbService {

    private String HOST = PropertiesUtil.getFollow("HOST");

    @Override
    public JsonResult getTnb(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("REGION_TNB");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }

    @Override
    public JsonResult getTnbList(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("REGION_TNB_LIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }
}
