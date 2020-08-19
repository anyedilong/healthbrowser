package com.healthbrowser.moudles.residenthealth.follow.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.utils.properties.PropertiesUtil;
import com.healthbrowser.moudles.residenthealth.follow.service.HzjlService;
import com.healthbrowser.moudles.residenthealth.follow.util.ResultUtil;
import com.healthbrowser.until.http.HttpUtil;

import javax.inject.Named;

@Named
public class HzjlServiceImpl implements HzjlService {
    private String HOST = PropertiesUtil.getFollow("HOST");

    @Override
    public JsonResult getHzjl(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("REGION_HZJL");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }
}
