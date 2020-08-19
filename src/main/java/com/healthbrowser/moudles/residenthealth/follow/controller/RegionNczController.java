package com.healthbrowser.moudles.residenthealth.follow.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.follow.service.NczService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbrowser.moudles.common.controller.BaseController;

import javax.inject.Inject;

/**
 * @ClassName: RegionNczController
 * @Description: 三方对接 查询脑卒中随访信息
 * @author Administrator
 * @date 2019年8月2日
 */
@RestController
@RequestMapping("${healthpath}/follow")
public class RegionNczController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());


	@Inject
	private NczService nczService;
	/**
	 * 脑卒中
	 */
	@RequestMapping("/getNcz")
	public JsonResult getNcz() throws Exception {
		String param = getParam(request);
		logger.info("获取脑卒中随访请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = nczService.getNcz(paramObj);
		logger.info("获取脑卒中随访返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 脑卒中列表
	 */
	@RequestMapping("/getNczList")
	public JsonResult getNczList() throws Exception {
		String param = getParam(request);
		logger.info("脑卒中列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = nczService.getNczList(paramObj);
		logger.info("脑卒中列表返回：" + JSON.toJSONString(follow));
		return follow;
	}
}
