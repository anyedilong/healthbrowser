package com.healthbrowser.moudles.residenthealth.follow.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.follow.service.YcfService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbrowser.moudles.common.controller.BaseController;

import javax.inject.Inject;

/**
 * @ClassName: RegionYcfController
 * @Description: 三方对接 查询孕产妇信息
 * @author Administrator
 * @date 2019年8月1日
 */
@RestController
@RequestMapping("${healthpath}/follow")
public class RegionYcfController extends BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	private YcfService ycfService;

	/**
	 * 获取孕产妇列表
	 */
	@RequestMapping("/getYcfList")
	public JsonResult getYcfList() throws Exception {
		String param = getParam(request);
		logger.info("获取孕产妇列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = ycfService.getYcfList(paramObj);
		logger.info("获取孕产妇列表返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取孕产妇首次随访
	 */
	@RequestMapping("/getYcfSc")
	public JsonResult getYcfSc() throws Exception {
		String param = getParam(request);
		logger.info("获取孕产妇首次随访请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = ycfService.getYcfSc(paramObj);
		logger.info("获取孕产妇首次随访返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取孕产妇首次随访列表
	 */
	@RequestMapping("/getYcfScList")
	public JsonResult getYcfScList() throws Exception {
		String param = getParam(request);
		logger.info("获取孕产妇首次随访列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = ycfService.getYcfScList(paramObj);
		logger.info("获取孕产妇首次随访列表返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取孕产妇产前
	 */
	@RequestMapping("/getYcfCq")
	public JsonResult getYcfCq() throws Exception {
		String param = getParam(request);
		logger.info("获取孕产妇产前随访请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = ycfService.getYcfCq(paramObj);
		logger.info("获取孕产妇产前随访返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取孕产妇产前列表
	 */
	@RequestMapping("/getYcfCqList")
	public JsonResult getYcfCqList() throws Exception {
		String param = getParam(request);
		logger.info("获取孕产妇产前随访列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = ycfService.getYcfCqList(paramObj);
		logger.info("获取孕产妇产前随访列表返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取孕产妇产后
	 */
	@RequestMapping("/getYcfCh")
	public JsonResult getYcfCh() throws Exception {
		String param = getParam(request);
		logger.info("获取孕产妇产后随访请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = ycfService.getYcfCh(paramObj);
		logger.info("获取孕产妇产后随访返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取孕产妇产后列表
	 */
	@RequestMapping("/getYcfChList")
	public JsonResult getYcfChList() throws Exception {
		String param = getParam(request);
		logger.info("获取孕产妇产后随访列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = ycfService.getYcfChList(paramObj);
		logger.info("获取孕产妇产后随访列表返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取孕产妇产后42
	 */
	@RequestMapping("/getYcfCh42")
	public JsonResult getYcfCh42() throws Exception {
		String param = getParam(request);
		logger.info("获取孕产妇产后42随访请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = ycfService.getYcfCh42(paramObj);
		logger.info("获取孕产妇产后42随访返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 获取孕产妇产后42列表
	 */
	@RequestMapping("/getYcfCh42List")
	public JsonResult getYcfCh42List() throws Exception {
		String param = getParam(request);
		logger.info("获取孕产妇产后42随访列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = ycfService.getYcfCh42List(paramObj);
		logger.info("获取孕产妇产后随访列表返回：" + JSON.toJSONString(follow));
		return follow;
	}
	
}
