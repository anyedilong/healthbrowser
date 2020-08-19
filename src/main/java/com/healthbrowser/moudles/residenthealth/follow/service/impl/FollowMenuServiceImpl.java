package com.healthbrowser.moudles.residenthealth.follow.service.impl;

import java.util.List;

import javax.inject.Named;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.utils.properties.PropertiesUtil;
import com.healthbrowser.moudles.residenthealth.follow.dto.FollowMenuDto;
import com.healthbrowser.moudles.residenthealth.follow.service.FollowMenuService;
import com.healthbrowser.until.http.HttpUtil;

/**
 * 	随访菜单
 */
@Named
public class FollowMenuServiceImpl implements FollowMenuService {
    private String HOST = PropertiesUtil.getFollow("HOST");

    @Override
    public List<FollowMenuDto> getfollowMenu(JSONObject request) throws Exception {
        String url = PropertiesUtil.getFollow("FOLLOW_MENU_LIST");
        String result = HttpUtil.doPost( HOST + url, request.toJSONString());
        return JSON.parseArray(result, FollowMenuDto.class);
    }
}
