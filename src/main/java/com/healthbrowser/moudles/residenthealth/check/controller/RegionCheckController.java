package com.healthbrowser.moudles.residenthealth.check.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.controller.BaseController;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.residenthealth.check.service.RegionCheckService;
import com.healthbrowser.until.StringUtil;

/**
 * @ClassName: RegionCheckController
 * @Description: 三方对接 保存体检信息
 * @author Administrator
 * @date 2019年7月29日
 */
@RestController
@RequestMapping("${healthpath}/check")
public class RegionCheckController extends BaseController {

	@Autowired
	private RegionCheckService checkService;
	
	/**
	 * @Description: 获取体检的列表
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getCheckPage")
	public JsonResult getCheckPage() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			//证件编号
			String jmId = paramObj.getString("jmId");
			// 分页
			Integer pageSize = 0, pageNo = 0;
			JSONObject pageObj = paramObj.getJSONObject("page");
			if (null != pageObj) {
				pageSize = StringUtil.toInteger(pageObj.getString("pageSize"));// 页大小
				pageNo = StringUtil.toInteger(pageObj.getString("pageNo"));// 页索引
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("jmId", jmId);
			paramMap.put("pageSize", pageSize+"");
			paramMap.put("pageNo", pageNo+"");
			PageModel page = new PageModel(pageNo, pageSize);
			
			return jsonResult(checkService.getCheckPage(page, paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	/**
	 * @Description: 查询体检的详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getCheckDetail")
	public JsonResult getCheckDetail() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String tjId = paramObj.getString("tjId");
			if(StringUtil.isNull(tjId)) {
				return jsonResult(null, 10001, "体检id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("tjId", tjId);

			return jsonResult(checkService.getCheckDetail(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 获取健康检查详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getJkjcDetail")
	public JsonResult getJkjcDetail() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String tjId = paramObj.getString("tjId");
			if(StringUtil.isNull(tjId)) {
				return jsonResult(null, 10001, "体检id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("tjId", tjId);

			return jsonResult(checkService.getJkjcDetail(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 获取健康问题详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getJkwtbDetail")
	public JsonResult getJkwtbDetail() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String tjId = paramObj.getString("tjId");
			if(StringUtil.isNull(tjId)) {
				return jsonResult(null, 10001, "体检id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("tjId", tjId);

			return jsonResult(checkService.getJkwtbDetail(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 获取评估指导详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getPgzdjlbDetail")
	public JsonResult getPgzdjlbDetail() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String tjId = paramObj.getString("tjId");
			if(StringUtil.isNull(tjId)) {
				return jsonResult(null, 10001, "体检id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("tjId", tjId);

			return jsonResult(checkService.getPgzdjlbDetail(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 获取生活方式详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getShfsDetail")
	public JsonResult getShfsDetail() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String tjId = paramObj.getString("tjId");
			if(StringUtil.isNull(tjId)) {
				return jsonResult(null, 10001, "体检id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("tjId", tjId);

			return jsonResult(checkService.getShfsDetail(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 获取辅助检查详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getXzjcjlbDetail")
	public JsonResult getXzjcjlbDetail() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String tjId = paramObj.getString("tjId");
			if(StringUtil.isNull(tjId)) {
				return jsonResult(null, 10001, "体检id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("tjId", tjId);

			return jsonResult(checkService.getXzjcjlbDetail(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 获取一般症状详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getYbzzbDetail")
	public JsonResult getYbzzbDetail() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String tjId = paramObj.getString("tjId");
			if(StringUtil.isNull(tjId)) {
				return jsonResult(null, 10001, "体检id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("tjId", tjId);

			return jsonResult(checkService.getYbzzbDetail(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 获取脏器功能详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getZqgnbDetail")
	public JsonResult getZqgnbDetail() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String tjId = paramObj.getString("tjId");
			if(StringUtil.isNull(tjId)) {
				return jsonResult(null, 10001, "体检id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("tjId", tjId);

			return jsonResult(checkService.getZqgnbDetail(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 获取家族病床史详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getJzbcsList")
	public JsonResult getJzbcsList() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String tjId = paramObj.getString("tjId");
			if(StringUtil.isNull(tjId)) {
				return jsonResult(null, 10001, "体检id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("tjId", tjId);

			return jsonResult(checkService.getJzbcsList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 获取接种史详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getJzsList")
	public JsonResult getJzsList() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String tjId = paramObj.getString("tjId");
			if(StringUtil.isNull(tjId)) {
				return jsonResult(null, 10001, "体检id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("tjId", tjId);

			return jsonResult(checkService.getJzsList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 获取药剂记录详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getYjjlbList")
	public JsonResult getYjjlbList() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String tjId = paramObj.getString("tjId");
			if(StringUtil.isNull(tjId)) {
				return jsonResult(null, 10001, "体检id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("tjId", tjId);

			return jsonResult(checkService.getYjjlbList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 获取住院史详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getZysList")
	public JsonResult getZysList() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String tjId = paramObj.getString("tjId");
			if(StringUtil.isNull(tjId)) {
				return jsonResult(null, 10001, "体检id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("tjId", tjId);

			return jsonResult(checkService.getZysList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	

}
