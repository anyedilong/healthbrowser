package com.healthbrowser.moudles.residenthealth.follow.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.follow.service.GxbService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbrowser.moudles.common.controller.BaseController;

import javax.inject.Inject;

/**
 * @ClassName: RegionGxbController
 * @Description: 三方对接 查询冠心病信息
 * @author Administrator
 * @date 2019年8月2日
 */
@RestController
@RequestMapping("${healthpath}/follow")
public class RegionGxbController extends BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	private GxbService gxbService;
	/**
	 * 冠心病
	 */
	@RequestMapping("/getGxb")
	public JsonResult getGxb() throws Exception {
		String param = getParam(request);
		logger.info("获取冠心病随访请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		String id = paramObj.getString("id");
		if (StringUtils.isBlank(id)) {
			return jsonResult(null, 90001, "ID不能为空！");
		}
		JsonResult follow = gxbService.getGxb(paramObj);
		logger.info("获取冠心病随访返回：" + JSON.toJSONString(follow));
		return follow;
	}

	/**
	 * 冠心病列表
	 */
	@RequestMapping("/getGxbList")
	public JsonResult getGxbList() throws Exception {
		String param = getParam(request);
		logger.info("冠心病列表请求参数：" + param);
		JSONObject paramObj = JSONObject.parseObject(param);
		JsonResult follow = gxbService.getGxbList(paramObj);
		logger.info("冠心病列表返回：" + JSON.toJSONString(follow));
		return follow;
	}
}
