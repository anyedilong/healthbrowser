package com.healthbrowser.moudles.residenthealth.hospital.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.controller.BaseController;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.residenthealth.hospital.service.RegionHospitalService;
import com.healthbrowser.until.StringUtil;

/**
 * @ClassName: OutpatientController
 * @Description: 三方对接 查询住院信息
 * @author Administrator
 * @date 2019年9月12日
 */
@RestController
@RequestMapping("${healthpath}/hospital")
public class RegionHospitalHController extends BaseController {

    @Inject
    private RegionHospitalService hospitalService;

    /**
	 * @Description: 获取住院的列表
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getHospitalPage")
	public JsonResult getHospitalPage() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			//证件编号
			String sfzh = paramObj.getString("sfzh");
			// 分页
			Integer pageSize = 0, pageNo = 0;
			JSONObject pageObj = paramObj.getJSONObject("page");
			if (null != pageObj) {
				pageSize = StringUtil.toInteger(pageObj.getString("pageSize"));// 页大小
				pageNo = StringUtil.toInteger(pageObj.getString("pageNo"));// 页索引
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("sfzh", sfzh);
			paramMap.put("pageSize", pageSize+"");
			paramMap.put("pageNo", pageNo+"");
			PageModel page = new PageModel(pageNo, pageSize);
			
			return jsonResult(hospitalService.getHospitalPage(page, paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	/**
	 * @Description: 查询住院详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getHospitalDetail")
	public JsonResult getHospitalDetail() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String id = paramObj.getString("id");
			if(StringUtil.isNull(id)) {
				return jsonResult(null, 10001, "住院id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("id", id);

			return jsonResult(hospitalService.getHospitalDetail(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 查询住院花费明细的详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getHospitalCostList")
	public JsonResult getHospitalCostList() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String zyId = paramObj.getString("zyId");
			String startTime = paramObj.getString("startTime");
			String endTime = paramObj.getString("endTime");
			String name = paramObj.getString("name");
			if(StringUtil.isNull(zyId)) {
				return jsonResult(null, 10001, "住院id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("zyId", zyId);
			paramMap.put("startTime", startTime);
			paramMap.put("endTime", endTime);
			paramMap.put("name", name);

			return jsonResult(hospitalService.getHospitalCostList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 查询住院诊断的详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getHospitalZDList")
	public JsonResult getHospitalZDList() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String zyId = paramObj.getString("zyId");
			if(StringUtil.isNull(zyId)) {
				return jsonResult(null, 10001, "住院id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("zyId", zyId);

			return jsonResult(hospitalService.getHospitalZDList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 查询住院影像的详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getHospitalImageList")
	public JsonResult getHospitalImageList() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String zyId = paramObj.getString("zyId");
			if(StringUtil.isNull(zyId)) {
				return jsonResult(null, 10001, "住院id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("zyId", zyId);

			return jsonResult(hospitalService.getHospitalImageList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 住院影像dcm文件转换为图片
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getCoverImageFormat")
	public JsonResult getCoverImageFormat() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String imageId = paramObj.getString("imageId");
			String imagePath = paramObj.getString("imagePath");
			if(StringUtil.isNull(imageId)) {
				return jsonResult(null, 10001, "影像id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("imageId", imageId);
			paramMap.put("imagePath", imagePath);

			return jsonResult(hospitalService.getCoverImageFormat(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 查询住院检查的详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getHospitalJcList")
	public JsonResult getHospitalJcList() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String zyId = paramObj.getString("zyId");
			if(StringUtil.isNull(zyId)) {
				return jsonResult(null, 10001, "住院id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("zyId", zyId);

			return jsonResult(hospitalService.getHospitalJcList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
    
	/**
	 * @Description: 查询住院医嘱列表
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getHospitalOrderList")
	public JsonResult getHospitalOrderList() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String zyId = paramObj.getString("zyId");
			if(StringUtil.isNull(zyId)) {
				return jsonResult(null, 10001, "住院id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("zyId", zyId);

			return jsonResult(hospitalService.getHospitalOrderList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 查询住院医嘱详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getHospitalOrderDetail")
	public JsonResult getHospitalOrderDetail() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String id = paramObj.getString("id");
			if(StringUtil.isNull(id)) {
				return jsonResult(null, 10001, "住院医嘱标识为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("id", id);

			return jsonResult(hospitalService.getHospitalOrderDetail(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
}
