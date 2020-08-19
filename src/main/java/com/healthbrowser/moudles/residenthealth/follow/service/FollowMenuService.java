package com.healthbrowser.moudles.residenthealth.follow.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.residenthealth.follow.dto.FollowMenuDto;

public interface FollowMenuService {
    
	List<FollowMenuDto> getfollowMenu(JSONObject request) throws Exception;
   
}
