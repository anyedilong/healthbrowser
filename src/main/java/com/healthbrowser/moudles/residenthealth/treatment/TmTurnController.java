package com.healthbrowser.moudles.residenthealth.treatment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.controller.BaseController;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.residenthealth.follow.util.ResultUtil;
import com.healthbrowser.until.StringUtil;
import com.healthbrowser.until.http.HttpUtil;

@RestController
@RequestMapping("/treat/turn")
public class TmTurnController extends BaseController {
   
	/**
	 * @Description: 查询双向转诊列表
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getTurnPage")
	public JsonResult getTurnPage() {
		try {
			String param = getParam(request);
			JSONObject paramJson = JSON.parseObject(param);
			String sfzh = paramJson.getString("sfzh");
			String pageNo = paramJson.getString("pageNo");
			String pageSize = paramJson.getString("pageSize");
			if (StringUtil.isNull(sfzh)) {
				return jsonResult(null, 10000, "参数身份证号不能为空");
			} 
			if (StringUtil.isNull(pageNo)) {
				return jsonResult(null, 10000, "参数页码不能为空");
			} 
			if (StringUtil.isNull(pageSize)) {
				return jsonResult(null, 10000, "参数页面大小不能为空");
			} 
			String url = "http://192.168.10.254:8010//hcplatform/treat/turn/getTurnPage";
			url = url+"?sfzh="+sfzh+"&pageNo="+pageNo+"&pageSize="+pageSize;
			String result = HttpUtil.doPost(url, param);
	        return ResultUtil.jsonResult(result);
		}catch(Exception e) {
			e.printStackTrace();
			return jsonResult(null, 10001, e.getMessage());
		}
	}

	/**
	 * @Description: 双向转诊详情查看
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getTurnDetail")
	public JsonResult getTurnDetail() {
		try {
			String param = getParam(request);
			JSONObject jsonObj = JSON.parseObject(param);
			String id = jsonObj.getString("id");
			String type = jsonObj.getString("type");
			if (StringUtil.isNull(id)) {
				return jsonResult(null, 10000, "标识不能为空");
			} 
			if (StringUtil.isNull(type)) {
				return jsonResult(null, 10000, "类型不能为空");
			} 
			String url = "http://192.168.10.254:8010//hcplatform/treat/turn/getTurnDetail";
			url = url+"?id="+id+"&type="+type;
			String result = HttpUtil.doPost(url, param);
	        return ResultUtil.jsonResult(result);
		}catch(Exception e) {
			e.printStackTrace();
			return jsonResult(null, 10001, e.getMessage());
		}
	}
}
