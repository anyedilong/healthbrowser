package com.healthbrowser.moudles.residenthealth.check.service;

import java.util.List;
import java.util.Map;

import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.residenthealth.check.dto.CheckDto;
import com.healthbrowser.moudles.residenthealth.check.dto.JkjcDto;
import com.healthbrowser.moudles.residenthealth.check.dto.JkwtbDto;
import com.healthbrowser.moudles.residenthealth.check.dto.JzbcsDto;
import com.healthbrowser.moudles.residenthealth.check.dto.JzsDto;
import com.healthbrowser.moudles.residenthealth.check.dto.PgzdjlbDto;
import com.healthbrowser.moudles.residenthealth.check.dto.ShfsDto;
import com.healthbrowser.moudles.residenthealth.check.dto.XzjcjlbDto;
import com.healthbrowser.moudles.residenthealth.check.dto.YbzzbDto;
import com.healthbrowser.moudles.residenthealth.check.dto.YjjlbDto;
import com.healthbrowser.moudles.residenthealth.check.dto.ZqgnbDto;
import com.healthbrowser.moudles.residenthealth.check.dto.ZysDto;

public interface RegionCheckService {
    
	//获取体检的列表
	PageModel getCheckPage(PageModel page, Map<String, String> paramMap) throws Exception;
	//获取体检的详情
	CheckDto getCheckDetail(Map<String, String> paramMap) throws Exception;
	//获取健康检查详情
	JkjcDto getJkjcDetail(Map<String, String> paramMap) throws Exception;
	//获取健康问题详情
	JkwtbDto getJkwtbDetail(Map<String, String> paramMap) throws Exception;
	//获取评估指导详情
	PgzdjlbDto getPgzdjlbDetail(Map<String, String> paramMap) throws Exception;
	//获取生活方式详情
	ShfsDto getShfsDetail(Map<String, String> paramMap) throws Exception;
	//获取辅助检查详情
	XzjcjlbDto getXzjcjlbDetail(Map<String, String> paramMap) throws Exception;
	//获取一般症状详情
	YbzzbDto getYbzzbDetail(Map<String, String> paramMap) throws Exception;
	//获取脏器功能详情
	ZqgnbDto getZqgnbDetail(Map<String, String> paramMap) throws Exception;
	//获取家族病床史详情
	List<JzbcsDto> getJzbcsList(Map<String, String> paramMap) throws Exception;
	//获取接种史详情
	List<JzsDto> getJzsList(Map<String, String> paramMap) throws Exception;
	//获取药剂记录详情
	List<YjjlbDto> getYjjlbList(Map<String, String> paramMap) throws Exception;
	//获取住院史详情
	List<ZysDto> getZysList(Map<String, String> paramMap) throws Exception;
	
}
