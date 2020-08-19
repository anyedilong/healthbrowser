package com.healthbrowser.moudles.residenthealth.hospital.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.common.utils.properties.PropertiesUtil;
import com.healthbrowser.moudles.residenthealth.hospital.dto.HospitalImageDto;
import com.healthbrowser.moudles.residenthealth.hospital.dto.HospitalInftoDto;
import com.healthbrowser.moudles.residenthealth.hospital.dto.HospitalJcDto;
import com.healthbrowser.moudles.residenthealth.hospital.dto.HospitalOrderDto;
import com.healthbrowser.moudles.residenthealth.hospital.dto.HospitalOutCostDto;
import com.healthbrowser.moudles.residenthealth.hospital.dto.HospitalZdDto;
import com.healthbrowser.moudles.residenthealth.hospital.service.RegionHospitalService;
import com.healthbrowser.until.http.HttpRequest;



@Named
public class RegionHospitalServiceImpl implements RegionHospitalService {

	@Value("${hisregionurl}")
    private String hisregionurl;
	
	@Override
	public PageModel getHospitalPage(PageModel page, Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/hospital/getHospitalPage", paramMap);
		JSONObject result = JSON.parseObject(sendPost);
		
		int count = result.getInteger("count");
		List<HospitalInftoDto> list = new ArrayList<>();
		if(count > 0) {
			list = JSONObject.parseArray(result.getString("list"), HospitalInftoDto.class);
			page.setCount(count);
			page.setList(list);
		}
		return page;
	}
	
	@Override
	public HospitalInftoDto getHospitalDetail(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/hospital/getHospitalDetail", paramMap);
		HospitalInftoDto info = JSON.parseObject(sendPost, HospitalInftoDto.class);
		return info;
	}

	@Override
	public List<HospitalOutCostDto> getHospitalCostList(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/hospital/getHospitalCostList", paramMap);
		List<HospitalOutCostDto> list = JSON.parseArray(sendPost, HospitalOutCostDto.class);
		if(list == null) {
			list = new ArrayList<>();
		}
		return list;
	}

	@Override
	public List<HospitalZdDto> getHospitalZDList(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/hospital/getHospitalZDList", paramMap);
		List<HospitalZdDto> list = JSON.parseArray(sendPost, HospitalZdDto.class);
		if(list == null) {
			list = new ArrayList<>();
		}
		return list;
	}

	@Override
	public List<HospitalImageDto> getHospitalImageList(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/hospital/getHospitalImageList", paramMap);
		List<HospitalImageDto> list = JSON.parseArray(sendPost, HospitalImageDto.class);
		if(list == null) {
			list = new ArrayList<>();
		}
		return list;
	}

	@Override
	public String getCoverImageFormat(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/hospital/getCoverImageFormat", paramMap);
		String parse = (String)JSON.parse(sendPost);
		return parse;
	}
	
	@Override
	public List<HospitalJcDto> getHospitalJcList(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/hospital/getHospitalJcList", paramMap);
		List<HospitalJcDto> list = JSON.parseArray(sendPost, HospitalJcDto.class);
		if(list == null) {
			list = new ArrayList<>();
		}
		return list;
	}
	@Override
	public List<HospitalOrderDto> getHospitalOrderList(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/hospital/getHospitalOrderList", paramMap);
		List<HospitalOrderDto> list = JSON.parseArray(sendPost, HospitalOrderDto.class);
		if(list == null) {
			list = new ArrayList<>();
		}
		return list;
	}

	@Override
	public HospitalOrderDto getHospitalOrderDetail(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/hospital/getHospitalOrderDetail", paramMap);
		HospitalOrderDto info = JSON.parseObject(sendPost, HospitalOrderDto.class);
		return info;
	}
}
