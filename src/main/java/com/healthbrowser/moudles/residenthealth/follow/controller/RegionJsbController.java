package com.healthbrowser.moudles.residenthealth.follow.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.follow.service.JsbService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbrowser.moudles.common.controller.BaseController;

import javax.inject.Inject;

/**
 * @ClassName: RegionJsbController
 * @Description: 三方对接  查询精神病信息
 * @author Administrator
 * @date 2019年8月1日
 */
@RestController
@RequestMapping("${healthpath}/follow")
public class RegionJsbController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	private JsbService jsbService;
	/**
	 * 精神病基本信息
	 */
	@RequestMapping("/getJsbJb")
	public JsonResult getJsbJb() throws Exception {
		String param = getParam(request);
		logger.info("获取精神病基本信息请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = jsbService.getJsbJb(paramObj);
		logger.info("获取精神病基本信息返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 精神病基本信息列表
	 */
	@RequestMapping("/getJsbJbList")
	public JsonResult getJsbJbList() throws Exception {
		String param = getParam(request);
		logger.info("脑卒中列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = jsbService.getJsbJbList(paramObj);
		logger.info("精神病基本信息列表返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 精神病信息
	 */
	@RequestMapping("/getJsb")
	public JsonResult getJsb() throws Exception {
		String param = getParam(request);
		logger.info("获取精神病请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = jsbService.getJsb(paramObj);
		logger.info("获取精神病返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 精神病信息列表
	 */
	@RequestMapping("/getJsbList")
	public JsonResult getJsbList() throws Exception {
		String param = getParam(request);
		logger.info("获取精神病列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = jsbService.getJsbList(paramObj);
		logger.info("获取精神病列表返回：" + JSON.toJSONString(follow));
		return follow;
	}
}
