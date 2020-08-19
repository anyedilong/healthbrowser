package com.healthbrowser.moudles.residenthealth.hospital.service;

import java.util.List;
import java.util.Map;

import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.residenthealth.hospital.dto.HospitalImageDto;
import com.healthbrowser.moudles.residenthealth.hospital.dto.HospitalInftoDto;
import com.healthbrowser.moudles.residenthealth.hospital.dto.HospitalJcDto;
import com.healthbrowser.moudles.residenthealth.hospital.dto.HospitalOrderDto;
import com.healthbrowser.moudles.residenthealth.hospital.dto.HospitalOutCostDto;
import com.healthbrowser.moudles.residenthealth.hospital.dto.HospitalZdDto;

public interface RegionHospitalService {

    //查询住院列表
	PageModel getHospitalPage(PageModel page, Map<String, String> paramMap) throws Exception;
	//查询住院的详情
	HospitalInftoDto getHospitalDetail(Map<String, String> paramMap) throws Exception;
    //查询住院花费明细的详情
	List<HospitalOutCostDto> getHospitalCostList(Map<String, String> paramMap) throws Exception;
	//查询住院诊断的详情
	List<HospitalZdDto> getHospitalZDList(Map<String, String> paramMap) throws Exception;
	//查询住院影像的详情
	List<HospitalImageDto> getHospitalImageList(Map<String, String> paramMap) throws Exception;
	//门诊影像的转换
	String getCoverImageFormat(Map<String, String> paramMap) throws Exception;
	//查询住院检查的详情
	List<HospitalJcDto> getHospitalJcList(Map<String, String> paramMap) throws Exception;
	//查询住院医嘱列表
	List<HospitalOrderDto> getHospitalOrderList(Map<String, String> paramMap) throws Exception;
	//查询住院医嘱详情
	HospitalOrderDto getHospitalOrderDetail(Map<String, String> paramMap) throws Exception;
}
