package com.healthbrowser.moudles.residenthealth.follow.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.follow.service.GxyService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbrowser.moudles.common.controller.BaseController;

import javax.inject.Inject;

/**
 * @ClassName: RegionGxyController
 * @Description: 三方对接 查询高血压信息
 * @author Administrator
 * @date 2019年7月31日
 */
@RestController
@RequestMapping("${healthpath}/follow")
public class RegionGxyController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	private GxyService gxyService;

	/**
	 * 高血压基本信息
	 */
	@RequestMapping("/getGxyJb")
	public JsonResult getGxyJb() throws Exception {
		String param = getParam(request);
		logger.info("获取高血压基本信息请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = gxyService.getGxyJb(paramObj);
		logger.info("获取高血压基本信息返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 高血压基本信息列表
	 */
	@RequestMapping("/getGxyJbList")
	public JsonResult getGxyJbList() throws Exception {
		String param = getParam(request);
		logger.info("高血压基本信息列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = gxyService.getGxyJbList(paramObj);
		logger.info("高血压基本信息列表返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 高血压首诊
	 */
	@RequestMapping("/getGxySz")
	public JsonResult getGxySz() throws Exception {
		String param = getParam(request);
		logger.info("获取高血压首诊请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = gxyService.getGxySz(paramObj);
		logger.info("获取高血压首诊返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 高血压首诊列表
	 */
	@RequestMapping("/getGxySzList")
	public JsonResult getGxySzList() throws Exception {
		String param = getParam(request);
		logger.info("高血压首诊列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = gxyService.getGxySzList(paramObj);
		logger.info("高血压首诊列表返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 高血压
	 */
	@RequestMapping("/getGxy")
	public JsonResult getGxy() throws Exception {
		String param = getParam(request);
		logger.info("获取高血压请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = gxyService.getGxy(paramObj);
		logger.info("获取高血压返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 高血压列表
	 */
	@RequestMapping("/getGxyList")
	public JsonResult getGxyList() throws Exception {
		String param = getParam(request);
		logger.info("高血压列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = gxyService.getGxyList(paramObj);
		logger.info("高血压列表返回：" + JSON.toJSONString(follow));
		return follow;
	}
}
