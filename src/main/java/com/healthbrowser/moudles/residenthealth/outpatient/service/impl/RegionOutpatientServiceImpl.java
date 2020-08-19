package com.healthbrowser.moudles.residenthealth.outpatient.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.residenthealth.outpatient.dto.MedicalrecordDto;
import com.healthbrowser.moudles.residenthealth.outpatient.dto.OutpatientImageDto;
import com.healthbrowser.moudles.residenthealth.outpatient.dto.OutpatientJcDto;
import com.healthbrowser.moudles.residenthealth.outpatient.dto.OutpatientRecipeDto;
import com.healthbrowser.moudles.residenthealth.outpatient.dto.OutpatientZdDto;
import com.healthbrowser.moudles.residenthealth.outpatient.service.RegionOutpatientService;
import com.healthbrowser.until.http.HttpRequest;



@Named
public class RegionOutpatientServiceImpl implements RegionOutpatientService {

	@Value("${hisregionurl}")
    private String hisregionurl;
	
	@Override
	public PageModel getOutpatientPage(PageModel page, Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/outpatient/getOutpatientPage", paramMap);
		JSONObject result = JSON.parseObject(sendPost);
		
		int count = result.getInteger("count");
		List<MedicalrecordDto> list = new ArrayList<>();
		if(count > 0) {
			list = JSONObject.parseArray(result.getString("list"), MedicalrecordDto.class);
			page.setCount(count);
			page.setList(list);
		}
		return page;
	}

	@Override
	public List<OutpatientRecipeDto> getOutpatientCfList(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/outpatient/getOutpatientCfList", paramMap);
		List<OutpatientRecipeDto> list = JSON.parseArray(sendPost, OutpatientRecipeDto.class);
		if(list == null) {
			list = new ArrayList<>();
		}
		return list;
	}

	@Override
	public List<OutpatientZdDto> getOutpatientZDList(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/outpatient/getOutpatientZDList", paramMap);
		List<OutpatientZdDto> list = JSON.parseArray(sendPost, OutpatientZdDto.class);
		if(list == null) {
			list = new ArrayList<>();
		}
		return list;
	}

	@Override
	public List<OutpatientImageDto> getOutpatientImageList(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/outpatient/getOutpatientImageList", paramMap);
		List<OutpatientImageDto> list = JSON.parseArray(sendPost, OutpatientImageDto.class);
		if(list == null) {
			list = new ArrayList<>();
		}
		return list;
	}
	
	@Override
	public String getCoverImageFormat(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/outpatient/getCoverImageFormat", paramMap);
		String parse = (String)JSON.parse(sendPost);
		return parse;
	}

	@Override
	public List<OutpatientJcDto> getOutpatientJcList(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/outpatient/getOutpatientJcList", paramMap);
		List<OutpatientJcDto> list = JSON.parseArray(sendPost, OutpatientJcDto.class);
		if(list == null) {
			list = new ArrayList<>();
		}
		return list;
	}
    
}
