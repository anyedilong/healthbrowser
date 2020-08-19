package com.healthbrowser.moudles.residenthealth.check.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
import com.healthbrowser.moudles.residenthealth.check.service.RegionCheckService;
import com.healthbrowser.until.http.HttpRequest;


@Named
public class RegionCheckServiceImpl implements RegionCheckService {

	@Value("${hisregionurl}")
    private String hisregionurl;
	
	
	@Override
	public PageModel getCheckPage(PageModel page, Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/check/getCheckPage", paramMap);
		JSONObject result = JSON.parseObject(sendPost);
		
		int count = result.getInteger("count");
		List<CheckDto> list = new ArrayList<>();
		if(count > 0) {
			list = JSONObject.parseArray(result.getString("list"), CheckDto.class);
			page.setCount(count);
			page.setList(list);
		}
		return page;
	}

	@Override
	public CheckDto getCheckDetail(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/check/queryCheckDetail", paramMap);
		CheckDto check = JSON.parseObject(sendPost, CheckDto.class);
		return check;
	}
	
	@Override
	public JkjcDto getJkjcDetail(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/check/queryJkjcDetail", paramMap);
		JkjcDto jkjc = JSON.parseObject(sendPost, JkjcDto.class);
		return jkjc;
	}

	@Override
	public JkwtbDto getJkwtbDetail(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/check/queryJkwtbDetail", paramMap);
		JkwtbDto jkwtb = JSON.parseObject(sendPost, JkwtbDto.class);
		return jkwtb;
	}

	@Override
	public PgzdjlbDto getPgzdjlbDetail(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/check/queryPgzdjlbDetail", paramMap);
		PgzdjlbDto pgzdjlb = JSON.parseObject(sendPost, PgzdjlbDto.class);
		return pgzdjlb;
	}

	@Override
	public ShfsDto getShfsDetail(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/check/queryShfsDetail", paramMap);
		ShfsDto shfs = JSON.parseObject(sendPost, ShfsDto.class);
		return shfs;
	}

	@Override
	public XzjcjlbDto getXzjcjlbDetail(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/check/queryXzjcjlbDetail", paramMap);
		XzjcjlbDto xzjcjlb = JSON.parseObject(sendPost, XzjcjlbDto.class);
		return xzjcjlb;
	}

	@Override
	public YbzzbDto getYbzzbDetail(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/check/queryYbzzbDetail", paramMap);
		YbzzbDto ybzzb = JSON.parseObject(sendPost, YbzzbDto.class);
		return ybzzb;
	}

	@Override
	public ZqgnbDto getZqgnbDetail(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/check/queryZqgnbDetail", paramMap);
		ZqgnbDto zqgnb = JSON.parseObject(sendPost, ZqgnbDto.class);
		return zqgnb;
	}

	@Override
	public List<JzbcsDto> getJzbcsList(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/check/queryJzbcsDetail", paramMap);
		List<JzbcsDto> list = JSON.parseArray(sendPost, JzbcsDto.class);
		return list;
	}

	@Override
	public List<JzsDto> getJzsList(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/check/queryJzsDetail", paramMap);
		List<JzsDto> list = JSON.parseArray(sendPost, JzsDto.class);
		return list;
	}

	@Override
	public List<YjjlbDto> getYjjlbList(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/check/queryYjjlbDetail", paramMap);
		List<YjjlbDto> list = JSON.parseArray(sendPost, YjjlbDto.class);
		return list;
	}

	@Override
	public List<ZysDto> getZysList(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/check/queryZysDetail", paramMap);
		List<ZysDto> list = JSON.parseArray(sendPost, ZysDto.class);
		return list;
	}

	
}
