package com.healthbrowser.moudles.residenthealth.follow.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.follow.service.TnbService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbrowser.moudles.common.controller.BaseController;

import javax.inject.Inject;

/**
 * @ClassName: RegionTnbController
 * @Description: 三方对接  查询糖尿病信息
 * @author Administrator
 * @date 2019年7月31日
 */
@RestController
@RequestMapping("${healthpath}/follow")
public class RegionTnbController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	private TnbService tnbService;


	/**
	 * 糖尿病
	 */
	@RequestMapping("/getTnb")
	public JsonResult getTnb() throws Exception {
		String param = getParam(request);
		logger.info("获取糖尿病请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = tnbService.getTnb(paramObj);
		logger.info("获取糖尿病返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 糖尿病列表
	 */
	@RequestMapping("/getTnbList")
	public JsonResult getTnbList() throws Exception {
		String param = getParam(request);
		logger.info("糖尿病列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = tnbService.getTnbList(paramObj);
		logger.info("糖尿病列表返回：" + JSON.toJSONString(follow));
		return follow;
	}
}
