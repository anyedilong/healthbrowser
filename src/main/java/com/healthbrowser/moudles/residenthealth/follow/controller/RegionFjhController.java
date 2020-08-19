package com.healthbrowser.moudles.residenthealth.follow.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.follow.service.FjhService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbrowser.moudles.common.controller.BaseController;

import javax.inject.Inject;

/**
 * @ClassName: RegionFjhController
 * @Description: 三方对接 查询肺结核信息
 * @author Administrator
 * @date 2019年8月1日
 */
@RestController
@RequestMapping("${healthpath}/follow")
public class RegionFjhController extends BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	private FjhService fjhService;
	/**
	 * 获取肺结核入户随访
	 */
	@RequestMapping("/getFjhRh")
	public JsonResult getFjhRh() throws Exception {
		String param = getParam(request);
		logger.info("获取肺结核入户随访请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = fjhService.getFjhRh(paramObj);
		logger.info("获取肺结核入户随访返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取肺结核入户随访列表
	 */
	@RequestMapping("/getFjhRhList")
	public JsonResult getFjhRhList() throws Exception {
		String param = getParam(request);
		logger.info("获取肺结核入户随访列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = fjhService.getFjhRhList(paramObj);
		logger.info("获取肺结核入户随访列表返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取肺结核随访
	 */
	@RequestMapping("/getFjh")
	public JsonResult getFjh() throws Exception {
		String param = getParam(request);
		logger.info("获取肺结核随访请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = fjhService.getFjh(paramObj);
		logger.info("获取肺结核随访返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取肺结核随访列表
	 */
	@RequestMapping("/getFjhList")
	public JsonResult getFjhList() throws Exception {
		String param = getParam(request);
		logger.info("获取肺结核随访列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = fjhService.getFjhList(paramObj);
		logger.info("获取肺结核随访列表返回：" + JSON.toJSONString(follow));
		return follow;
	}
}
