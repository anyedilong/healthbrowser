package com.healthbrowser.moudles.residenthealth.poct.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.util.Map;

public interface PoctService {
    JSONArray getPoctList(JSONObject json) throws IOException;

    JSONObject getPoct(JSONObject json) throws IOException;
}
