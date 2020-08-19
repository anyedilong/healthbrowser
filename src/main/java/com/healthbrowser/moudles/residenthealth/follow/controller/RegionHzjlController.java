package com.healthbrowser.moudles.residenthealth.follow.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.controller.BaseController;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.follow.service.HzjlService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

//会诊记录
@RestController
@RequestMapping("${healthpath}/hzjl")
public class RegionHzjlController extends BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private HzjlService hzjlService;

    /**
     * 会诊记录
     */
    @RequestMapping("/getInfo")
    public JsonResult getInfo() throws Exception {
        String param = getParam(request);
        logger.info("获取会诊记录请求参数：" + param);
        JSONObject paramObj = JSONObject.parseObject(param);
        String id = paramObj.getString("id");
        if (StringUtils.isBlank(id)) {
            return jsonResult(null, 90001, "ID不能为空！");
        }
        JsonResult follow = hzjlService.getHzjl(paramObj);
        logger.info("获取会诊记录返回：" + JSON.toJSONString(follow));
        return follow;
    }
}
