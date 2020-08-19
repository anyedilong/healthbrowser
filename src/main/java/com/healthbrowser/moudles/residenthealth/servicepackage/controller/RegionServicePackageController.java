package com.healthbrowser.moudles.residenthealth.servicepackage.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthbrowser.moudles.common.controller.BaseController;

/**
 * @ClassName: RegionServicePackageController
 * @Description: 三方对接 查询服务包和服务项
 * @author Administrator
 * @date 2019年7月25日
 */

@RestController
@RequestMapping("${healthpath}/servicepackage")
public class RegionServicePackageController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	
}
