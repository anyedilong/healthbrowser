package com.healthbrowser.moudles.residenthealth.poct.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.controller.BaseController;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.poct.service.PoctService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.io.IOException;

@RestController
@RequestMapping("/poct")
public class PoctController extends BaseController {

    @Inject
    private PoctService poctService;

    /**
     * 查询检验列表
     * 聂亚威
     *
     * @return
     */
    @RequestMapping("getPoctList")
    public JsonResult getPoctList() throws IOException {
        String param = getParam(request);
        logger.info("查询检验列表请求参数：" + param);
        JSONObject json = JSONObject.parseObject(param);
        if (StringUtils.isBlank(json.getString("residentId")))
            return jsonResult(null, 9001, "居民ID不能为空！");
        JSONArray array = poctService.getPoctList(json);
        logger.info("查询检验列表返回：" + array);
        return jsonResult(array);
    }

    /**
     * 查询检验详情
     * 聂亚威
     *
     * @return
     */
    @RequestMapping("getPoct")
    public JsonResult getPoct() throws IOException {
        String param = getParam(request);
        logger.info("查询检验详情请求参数：" + param);
        JSONObject json = JSONObject.parseObject(param);
        if (StringUtils.isBlank(json.getString("id")))
            return jsonResult(null, 9001, "ID不能为空！");
        JSONObject resp = poctService.getPoct(json);
        logger.info("查询检验详情返回：" + resp);
        return jsonResult(resp);
    }

}
