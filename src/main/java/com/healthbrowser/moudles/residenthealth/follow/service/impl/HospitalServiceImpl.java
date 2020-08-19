package com.healthbrowser.moudles.residenthealth.follow.service.impl;

import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.utils.properties.PropertiesUtil;
import com.healthbrowser.moudles.residenthealth.follow.service.HospitalService;
import com.healthbrowser.moudles.residenthealth.follow.util.ResultUtil;
import com.healthbrowser.until.http.HttpRequest;
import org.springframework.beans.factory.annotation.Value;

import javax.inject.Named;
import java.util.HashMap;
import java.util.Map;

@Named
public class HospitalServiceImpl implements HospitalService {

    @Value("${hisregionurl}")
    private String hospitalUrl;

    private String HOST = PropertiesUtil.getFollow("HOST");

    @Override
    public JsonResult getBasy(String id, String orgCode) throws Exception {
        String url = PropertiesUtil.getFollow("REGION_BASY");
        Map<String, String> request = new HashMap<>();
        request.put("id", id);
        String result = HttpRequest.sendPost(hospitalUrl + url, request);
        return ResultUtil.jsonResult(result);
    }
}
