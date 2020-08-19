package com.healthbrowser.moudles.residenthealth.outpatient.service;



import java.util.List;
import java.util.Map;

import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.residenthealth.outpatient.dto.OutpatientImageDto;
import com.healthbrowser.moudles.residenthealth.outpatient.dto.OutpatientJcDto;
import com.healthbrowser.moudles.residenthealth.outpatient.dto.OutpatientRecipeDto;
import com.healthbrowser.moudles.residenthealth.outpatient.dto.OutpatientZdDto;

public interface RegionOutpatientService {

    //查询门诊列表
	PageModel getOutpatientPage(PageModel page, Map<String, String> paramMap) throws Exception;
    //查询门诊处方的详情
	List<OutpatientRecipeDto> getOutpatientCfList(Map<String, String> paramMap) throws Exception;
	//查询门诊诊断的详情
	List<OutpatientZdDto> getOutpatientZDList(Map<String, String> paramMap) throws Exception;
	//查询门诊影像的详情
	List<OutpatientImageDto> getOutpatientImageList(Map<String, String> paramMap) throws Exception;
	//门诊影像的转换
	String getCoverImageFormat(Map<String, String> paramMap) throws Exception;
	//查询门诊检查的详情
	List<OutpatientJcDto> getOutpatientJcList(Map<String, String> paramMap) throws Exception;
}
