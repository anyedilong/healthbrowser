package com.healthbrowser.moudles.residenthealth.follow.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.controller.BaseController;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.follow.service.HospitalService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

//住院信息
@RestController
@RequestMapping("${healthpath}/hospital")
public class RegionHospitalController extends BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private HospitalService hospitalService;

    /**
     * 病案首页
     */
    @RequestMapping("/getBasy")
    public JsonResult getInfo() throws Exception {
        String param = getParam(request);
        logger.info("获取病案首页请求参数：" + param);
        JSONObject paramObj = JSONObject.parseObject(param);
        String id = paramObj.getString("id");
        String orgCode = paramObj.getString("orgCode");
        if (StringUtils.isBlank(id)) {
            return jsonResult(null, 90001, "ID不能为空！");
        }
        JsonResult follow = hospitalService.getBasy(id, orgCode);
        logger.info("获取病案首页返回：" + JSON.toJSONString(follow));
        return follow;
    }
}
