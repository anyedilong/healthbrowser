package com.healthbrowser.moudles.residenthealth.follow.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.follow.dto.*;
import com.healthbrowser.moudles.residenthealth.follow.service.EtService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbrowser.moudles.common.controller.BaseController;

import javax.inject.Inject;
import java.util.List;

/**
 * @ClassName: RegionEtController
 * @Description: 三方对接 查询儿童信息
 * @author Administrator
 * @date 2019年8月14日
 */
@RestController
@RequestMapping("${healthpath}/follow")
public class RegionEtController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	private EtService etService;

	/**
	 * 获取儿童列表
	 */
	@RequestMapping("/getEtList")
	public JsonResult getEtList() throws Exception {
		String param = getParam(request);
		logger.info("获取儿童列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = etService.getEtList(paramObj);
		logger.info("获取儿童列表返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取儿童基本
	 */
	@RequestMapping("/getEtJb")
	public JsonResult getInfo() throws Exception {
		String param = getParam(request);
		logger.info("查询儿童基本详情请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = etService.getEtJb(paramObj);
		logger.info("查询儿童基本详情返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取新生儿
	 */
	@RequestMapping("/getXse")
	public JsonResult getXse() throws Exception {
		String param = getParam(request);
		logger.info("查询新生儿详情请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = etService.getXse(paramObj);
		logger.info("查询新生儿详情返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取新生儿列表
	 */
	@RequestMapping("/getXseList")
	public JsonResult getXseList() throws Exception {
		String param = getParam(request);
		logger.info("获取新生儿列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = etService.getXseList(paramObj);
		logger.info("获取新生儿列表返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取儿童1岁
	 */
	@RequestMapping("/getEt1")
	public JsonResult getEt1() throws Exception {
		String param = getParam(request);
		logger.info("查询儿童1岁详情请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = etService.getEt1(paramObj);
		logger.info("查询儿童1岁详情返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取儿童1岁列表
	 */
	@RequestMapping("/getEt1List")
	public JsonResult getEt1List() throws Exception {
		String param = getParam(request);
		logger.info("查询儿童1岁列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = etService.getEt1List(paramObj);
		logger.info("查询儿童1岁列表返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取儿童3岁
	 */
	@RequestMapping("/getEt3")
	public JsonResult getEt3() throws Exception {
		String param = getParam(request);
		logger.info("查询儿童3岁详情请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = etService.getEt3(paramObj);
		logger.info("查询儿童3岁详情返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取儿童3岁列表
	 */
	@RequestMapping("/getEt3List")
	public JsonResult getEt3List() throws Exception {
		String param = getParam(request);
		logger.info("查询儿童1岁列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = etService.getEt3List(paramObj);
		logger.info("查询儿童1岁列表返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取儿童6岁
	 */
	@RequestMapping("/getEt6")
	public JsonResult getEt6() throws Exception {
		String param = getParam(request);
		logger.info("查询儿童6岁详情请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = etService.getEt6(paramObj);
		logger.info("查询儿童6岁详情返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取儿童6岁列表
	 */
	@RequestMapping("/getEt6List")
	public JsonResult getEt6List() throws Exception {
		String param = getParam(request);
		logger.info("查询儿童6岁列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = etService.getEt6List(paramObj);
		logger.info("查询儿童6岁列表返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取儿童1岁中医药
	 */
	@RequestMapping("/getEt1Zyy")
	public JsonResult getEt1Zyy() throws Exception {
		String param = getParam(request);
		logger.info("查询儿童1岁中医药详情请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = etService.getEt1Zyy(paramObj);
		logger.info("查询儿童1岁中医药详情返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取儿童1岁中医药列表
	 */
	@RequestMapping("/getEt1ZyyList")
	public JsonResult getEt1ZyyList() throws Exception {
		String param = getParam(request);
		logger.info("查询儿童1岁中医药列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = etService.getEt1ZyyList(paramObj);
		logger.info("查询儿童1岁中医药列表返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取儿童3岁中医药
	 */
	@RequestMapping("/getEt3Zyy")
	public JsonResult getEt3Zyy() throws Exception {
		String param = getParam(request);
		logger.info("查询儿童3岁中医药详情请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = etService.getEt3Zyy(paramObj);
		logger.info("查询儿童3岁中医药详情返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取儿童3岁中医药列表
	 */
	@RequestMapping("/getEt3ZyyList")
	public JsonResult getEt3ZyyList() throws Exception {
		String param = getParam(request);
		logger.info("查询儿童1岁中医药列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = etService.getEt3ZyyList(paramObj);
		logger.info("查询儿童3岁中医药列表返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取儿童6岁中医药
	 */
	@RequestMapping("/getEt6Zyy")
	public JsonResult getEt6Zyy() throws Exception {
		String param = getParam(request);
		logger.info("查询儿童6岁中医药详情请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = etService.getEt6Zyy(paramObj);
		logger.info("查询儿童6岁中医药详情返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取儿童6岁中医药列表
	 */
	@RequestMapping("/getEt6ZyyList")
	public JsonResult getEt6ZyyList() throws Exception {
		String param = getParam(request);
		logger.info("查询儿童6岁中医药列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = etService.getEt6ZyyList(paramObj);
		logger.info("查询儿童6岁中医药列表返回：" + JSON.toJSONString(follow));
		return follow;
	}
}
