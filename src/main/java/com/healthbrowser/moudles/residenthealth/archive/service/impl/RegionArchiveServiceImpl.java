package com.healthbrowser.moudles.residenthealth.archive.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.residenthealth.archive.dto.BsxxDto;
import com.healthbrowser.moudles.residenthealth.archive.dto.JbxxjlbDto;
import com.healthbrowser.moudles.residenthealth.archive.dto.JzsxxbDto;
import com.healthbrowser.moudles.residenthealth.archive.dto.ShhjbDto;
import com.healthbrowser.moudles.residenthealth.archive.service.RegionArchiceService;
import com.healthbrowser.until.StringUtil;
import com.healthbrowser.until.http.HttpRequest;


@Named
public class RegionArchiveServiceImpl implements RegionArchiceService {

	@Value("${hisregionurl}")
    private String hisregionurl;
	
	@Override
	public PageModel getArchivePage(PageModel page, Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/archive/getArchivePage", paramMap);
		JSONObject result = JSON.parseObject(sendPost);
		
		int count = result.getInteger("count");
		List<JbxxjlbDto> list = new ArrayList<>();
		if(count > 0) {
			list = JSONObject.parseArray(result.getString("list"), JbxxjlbDto.class);
			for(int i = 0; i < list.size(); i++) {
				JbxxjlbDto info = list.get(i);
				info.setSignId((StringUtil.isNull(info.getSignId()) ? "未签约" : "已签约"));
				info.setXb("1".equals(info.getXb()) ? "男" : "女");
				if(info.getCsrq() != null)
					info.setNl(this.getAge(info.getCsrq()));
			}
			page.setCount(count);
			page.setList(list);
		}
		return page;
	}
	
	@Override
	public PageModel getArchivePageByCon(PageModel page, Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/archive/getArchivePageByCon", paramMap);
		JSONObject result = JSON.parseObject(sendPost);
		
		int count = result.getInteger("count");
		List<JbxxjlbDto> list = new ArrayList<>();
		if(count > 0) {
			list = JSONObject.parseArray(result.getString("list"), JbxxjlbDto.class);
			for(int i = 0; i < list.size(); i++) {
				JbxxjlbDto info = list.get(i);
				info.setSignId((StringUtil.isNull(info.getSignId()) ? "未签约" : "已签约"));
				info.setXb("1".equals(info.getXb()) ? "男" : "女");
				if(info.getCsrq() != null)
					info.setNl(this.getAge(info.getCsrq()));
			}
			page.setCount(count);
			page.setList(list);
		}
		return page;
	}

	@Override
	public JbxxjlbDto getArchiveDetail(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/archive/queryArchiveDetail", paramMap);
		JbxxjlbDto archive = JSON.parseObject(sendPost, JbxxjlbDto.class);
		if(archive == null) return null;
		archive.setXb("1".equals(archive.getXb()) ? "男" : "女");
		//年龄
		if(archive.getCsrq() != null)
			archive.setNl(this.getAge(archive.getCsrq()));
		return archive;
	}
	
	@Override
	public JbxxjlbDto getArchiveDetailBySfzh(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/archive/getArchiveDetailBySfzh", paramMap);
		JbxxjlbDto archive = JSON.parseObject(sendPost, JbxxjlbDto.class);
		if(archive == null) return null;
		archive.setXb("1".equals(archive.getXb()) ? "男" : "女");
		//年龄
		if(archive.getCsrq() != null)
			archive.setNl(this.getAge(archive.getCsrq()));
		return archive;
	}
	
	@Override
	public JbxxjlbDto getArchiveDetailByCon(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/archive/queryArchiveDetailByCon", paramMap);
		JbxxjlbDto archive = JSON.parseObject(sendPost, JbxxjlbDto.class);
		if(archive == null) return null;
		archive.setXb("1".equals(archive.getXb()) ? "男" : "女");
		//年龄
		if(archive.getCsrq() != null)
			archive.setNl(this.getAge(archive.getCsrq()));
		return archive;
	}

	@Override
	public List<BsxxDto> getBSxxDetail(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/archive/queryBSxxDetail", paramMap);
		List<BsxxDto> bsxxList = JSON.parseArray(sendPost, BsxxDto.class);
		return bsxxList;
	}

	@Override
	public JzsxxbDto getJZSxxDetail(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/archive/queryJZSxxDetail", paramMap);
		JzsxxbDto jzsxx = JSON.parseObject(sendPost, JzsxxbDto.class);
		return jzsxx;
	}

	@Override
	public ShhjbDto getSHfsDetail(Map<String, String> paramMap) throws Exception {
		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/archive/querySHhjDetail", paramMap);
		ShhjbDto shhj = JSON.parseObject(sendPost, ShhjbDto.class);
		return shhj;
	}
   
	/**
	 * 	计算年龄
	 */
	private String getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance(); 
        if (cal.before(birthDay)) { //出生日期晚于当前时间，无法计算
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);  //当前年份
        int monthNow = cal.get(Calendar.MONTH);  //当前月份
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH); //当前日期
        cal.setTime(birthDay); 
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);  
        int age = yearNow - yearBirth;   //计算整岁数
        int month = monthNow - monthBirth;
        int day = dayOfMonthNow - dayOfMonthBirth;
        if(age > 6) {
        	return age+"";
        }else if(age > 1 && age <=6) {
        	return age + "岁" + month + "个月";
        }else {
        	return month + "月" + day + "天";
        }
	}
	
}
