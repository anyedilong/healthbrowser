package com.healthbrowser.moudles.residenthealth.archive.service;

import java.util.List;
import java.util.Map;

import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.residenthealth.archive.dto.BsxxDto;
import com.healthbrowser.moudles.residenthealth.archive.dto.JbxxjlbDto;
import com.healthbrowser.moudles.residenthealth.archive.dto.JzsxxbDto;
import com.healthbrowser.moudles.residenthealth.archive.dto.ShhjbDto;

public interface RegionArchiceService {
    
	//获取档案的列表
	PageModel getArchivePage(PageModel page, Map<String, String> paramMap) throws Exception;
	//根据门诊住院条件获取档案的列表
	PageModel getArchivePageByCon(PageModel page, Map<String, String> paramMap) throws Exception;
	//获取档案的详情-管理员登录
	JbxxjlbDto getArchiveDetail(Map<String, String> paramMap) throws Exception;
	//获取档案的详情-管理员登录
	JbxxjlbDto getArchiveDetailBySfzh(Map<String, String> paramMap) throws Exception;
	//获取档案的详情-his嵌入
	JbxxjlbDto getArchiveDetailByCon(Map<String, String> paramMap) throws Exception;
	//查询病史信息的详情
	List<BsxxDto> getBSxxDetail(Map<String, String> paramMap) throws Exception;
	//查询家族史信息的详情
	JzsxxbDto getJZSxxDetail(Map<String, String> paramMap) throws Exception;
	//查询生活环境信息的详情
	ShhjbDto getSHfsDetail(Map<String, String> paramMap) throws Exception;
	
}
