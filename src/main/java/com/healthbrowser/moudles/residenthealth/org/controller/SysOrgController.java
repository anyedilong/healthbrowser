package com.healthbrowser.moudles.residenthealth.org.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.controller.BaseController;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.org.dto.SysOrgDto;
import com.healthbrowser.until.http.HttpRequest;


@RestController
@RequestMapping("/region/org")
public class SysOrgController extends BaseController {

	@Value("${hisregionurl}")
    private String hisregionurl;
	
	
	@RequestMapping("queryOrgList")
    public JsonResult queryOrgList(){
        try {
        	Map<String, String> paramMap = new HashMap<>();
    		String sendPost = HttpRequest.sendPost(hisregionurl + "/his/healthbrowser/queryOrgInfoList", paramMap);
			List<SysOrgDto> list = JSONObject.parseArray(sendPost, SysOrgDto.class);;
			return jsonResult(list);
        }catch (Exception e){
            e.printStackTrace();
            return  jsonResult(null,90001,"系统错误");
        }
    }
	
}
