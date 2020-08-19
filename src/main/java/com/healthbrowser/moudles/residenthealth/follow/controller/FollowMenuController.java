package com.healthbrowser.moudles.residenthealth.follow.controller;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.controller.BaseController;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.follow.dto.FollowMenuDto;
import com.healthbrowser.moudles.residenthealth.follow.service.FollowMenuService;

//随访菜单
@RestController
@RequestMapping("${healthpath}/followmenu")
public class FollowMenuController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private FollowMenuService followMenuService;
    
    
    /**
     * 	获取随访菜单
     */
    @RequestMapping("/getfollowMenu")
    public JsonResult getfollowMenu() throws Exception {
        String param = getParam(request);
        logger.info("查询随访菜单详情请求参数：" + param);
        JSONObject paramObj = JSONObject.parseObject(param);
        String sfzh = paramObj.getString("sfzh");
        if (StringUtils.isBlank(sfzh)) {
            return jsonResult(null, 90001, "身份证号不能为空！");
        }
        List<FollowMenuDto> menuList = followMenuService.getfollowMenu(paramObj);
        logger.info("查询随访菜单详情返回：" + JSON.toJSONString(menuList));
        return jsonResult(menuList);
    }
}
