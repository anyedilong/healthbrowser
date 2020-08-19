package com.healthbrowser.moudles.residenthealth.team.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbrowser.moudles.common.controller.BaseController;

/**
 * @ClassName: RegionTeamController
 * @Description: 三方对接 查询团队项目相关信息
 * @author Administrator
 * @date 2019年7月25日
 */

@RestController
@RequestMapping("${healthpath}/team")
public class RegionTeamController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	

	
}
