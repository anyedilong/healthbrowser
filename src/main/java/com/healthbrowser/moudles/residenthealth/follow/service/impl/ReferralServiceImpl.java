package com.healthbrowser.moudles.residenthealth.follow.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.common.utils.properties.PropertiesUtil;
import com.healthbrowser.moudles.residenthealth.follow.dto.ReferralDto;
import com.healthbrowser.moudles.residenthealth.follow.service.ReferralService;
import com.healthbrowser.moudles.residenthealth.follow.util.ResultUtil;
import com.healthbrowser.until.http.HttpRequest;
import com.healthbrowser.until.http.HttpUtil;

/**
 * 转诊
 */
@Named
public class ReferralServiceImpl implements ReferralService {
	
	@Value("${hisregionurl}")
    private String hisregionurl;
	
    @Override
    public JsonResult getInfo(JSONObject request) throws Exception {
        String host = PropertiesUtil.getFollow("HOST");
        String referral = PropertiesUtil.getFollow("REFERRAL");
        String result = HttpUtil.doPost( host+ referral, request.toJSONString());
        return ResultUtil.jsonResult(result);
    }
    
    @Override
	public PageModel getReferralPage(PageModel page, Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/referral/getReferralPage", paramMap);
		JSONObject result = JSON.parseObject(sendPost);
		
		int count = result.getInteger("count");
		List<ReferralDto> list = new ArrayList<>();
		if(count > 0) {
			list = JSONObject.parseArray(result.getString("list"), ReferralDto.class);
			page.setCount(count);
			page.setList(list);
		}
		return page;
	}
}
