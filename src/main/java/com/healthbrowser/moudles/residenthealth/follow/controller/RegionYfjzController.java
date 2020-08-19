package com.healthbrowser.moudles.residenthealth.follow.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.controller.BaseController;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.follow.service.YfjzService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

/**
 * @ClassName: RegionTnbController
 * @Description: 三方对接  预防接种
 * @author Administrator
 * @date 2019年9月9日
 */
@RestController
@RequestMapping("/yfjz")
public class RegionYfjzController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	private YfjzService yfjzService;


	/**
	 * 预防接种
	 */
	@RequestMapping("/getInfo")
	public JsonResult getInfo() throws Exception {
		String param = getParam(request);
		logger.info("获取预防接种请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = yfjzService.getInfo(paramObj);
		logger.info("获取预防接种返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 预防接种列表
	 */
	@RequestMapping("/getList")
	public JsonResult getList() throws Exception {
		String param = getParam(request);
		logger.info("预防接种列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = yfjzService.getList(paramObj);
		logger.info("预防接种列表返回：" + JSON.toJSONString(follow));
		return follow;
	}
}
