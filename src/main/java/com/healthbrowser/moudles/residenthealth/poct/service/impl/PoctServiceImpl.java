package com.healthbrowser.moudles.residenthealth.poct.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.residenthealth.poct.service.PoctService;
import com.healthbrowser.until.http.HttpUtil;
import org.springframework.beans.factory.annotation.Value;

import javax.inject.Named;
import java.io.IOException;

@Named
public class PoctServiceImpl implements PoctService {

    @Value("${hisregionurl}")
    private String hisregionurl;


    @Override
    public JSONArray getPoctList(JSONObject json) throws IOException {
        String sendPost = HttpUtil.doPost(hisregionurl + "/poct/getPoctList", json.toJSONString());
        return JSON.parseArray(sendPost);
    }

    @Override
    public JSONObject getPoct(JSONObject json) throws IOException {
        String sendPost = HttpUtil.doPost(hisregionurl + "/poct/getPoct", json.toJSONString());
        return JSON.parseObject(sendPost);
    }


}
