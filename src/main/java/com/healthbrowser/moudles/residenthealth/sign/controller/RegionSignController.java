package com.healthbrowser.moudles.residenthealth.sign.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.sign.service.SignService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbrowser.moudles.common.controller.BaseController;

import javax.inject.Inject;

/**
 * @ClassName: RegionSignController
 * @Description: 三方对接 查询签约的信息
 * @author Administrator
 * @date 2019年7月25日
 */

@RestController
@RequestMapping("${healthpath}/sign")
public class RegionSignController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	private SignService signService;
	/**
	 * 	获取签约详情
	 */
	@RequestMapping("/getSignInfo")
	public JsonResult getSignInfo() throws Exception {
		String param = getParam(request);
		logger.info("查询签约详情请求参数：" + param);
		JSONObject paramJson = JSONObject.parseObject(param);
		String jmId = paramJson.getString("jmId");
		if (StringUtils.isBlank(jmId)) {
			return jsonResult(null, 90001, "居民编号不能为空！");
		}
		JsonResult sign = signService.getSignInfo(paramJson);
		logger.info("查询签约详情返回：" + JSON.toJSONString(sign));
		return sign;
	}
	
	/**
	 * 	获取履约服务分页
	 */
	@RequestMapping("/getSignServiceList")
	public JsonResult getSignServiceList() throws Exception {
		String param = getParam(request);
		logger.info("查询签约列表请求参数：" + param);
		JSONObject paramJson = JSONObject.parseObject(param);
		String jmId = paramJson.getString("jmId");
		if (StringUtils.isBlank(jmId)) {
			return jsonResult(null, 90001, "居民编号不能为空！");
		}
		JsonResult sign = signService.getSignServiceList(paramJson);
		logger.info("查询签约服务列表返回：" + JSON.toJSONString(sign));
		return sign;
	}
	
	/**
	 * 	获取履约服务详情
	 */
	@RequestMapping("/getSignServiceInfo")
	public JsonResult getSignServiceInfo() throws Exception {
		String param = getParam(request);
		logger.info("查询签约详情请求参数：" + param);
		JSONObject paramJson = JSONObject.parseObject(param);
		String signId = paramJson.getString("signId");
		String packeageId = paramJson.getString("packeageId");
		String projectId = paramJson.getString("projectId");
		if (StringUtils.isBlank(signId) || StringUtils.isBlank(packeageId) || StringUtils.isBlank(projectId)) {
			return jsonResult(null, 90001, "参数不能为空！");
		}
		JsonResult sign = signService.getSignServiceInfo(paramJson);
		logger.info("查询签约服务详情返回：" + JSON.toJSONString(sign));
		return sign;
	}


}
