package com.healthbrowser.moudles.residenthealth.follow.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.follow.service.LnrService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbrowser.moudles.common.controller.BaseController;

import javax.inject.Inject;

/**
 * @ClassName: RegionLnrController
 * @Description: 三方对接 查询老年人信息
 * @author Administrator
 * @date 2019年8月2日
 */
@RestController
@RequestMapping("${healthpath}/follow")
public class RegionLnrController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	private LnrService lnrService;
	/**
	 * 老年人健康管理
	 */
	@RequestMapping("/getJkpg")
	public JsonResult getJkpg() throws Exception {
		String param = getParam(request);
		logger.info("获取老年人健康管理随访请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = lnrService.getJkgl(paramObj);
		logger.info("获取老年人健康管理随访返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 老年人健康管理列表
	 */
	@RequestMapping("/getJkpgList")
	public JsonResult getJkpgList() throws Exception {
		String param = getParam(request);
		logger.info("老年人健康管理列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = lnrService.getJkglList(paramObj);
		logger.info("老年人健康管理列表返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 老年人中医药
	 */
	@RequestMapping("/getLnrZyy")
	public JsonResult getLnrZyy() throws Exception {
		String param = getParam(request);
		logger.info("获取老年人中医药随访请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = lnrService.getLnrZyy(paramObj);
		logger.info("获取老年人中医药随访返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 老年人中医药列表
	 */
	@RequestMapping("/getLnrZyyList")
	public JsonResult getLnrZyyList() throws Exception {
		String param = getParam(request);
		logger.info("老年人中医药列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = lnrService.getLnrZyyList(paramObj);
		logger.info("老年人中医药列表返回：" + JSON.toJSONString(follow));
		return follow;
	}
}
