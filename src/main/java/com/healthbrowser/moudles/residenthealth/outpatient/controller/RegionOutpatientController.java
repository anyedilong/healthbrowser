package com.healthbrowser.moudles.residenthealth.outpatient.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.controller.BaseController;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.residenthealth.outpatient.service.RegionOutpatientService;
import com.healthbrowser.until.StringUtil;

/**
 * @ClassName: OutpatientController
 * @Description: 三方对接 查询门诊信息
 * @author Administrator
 * @date 2019年9月12日
 */
@RestController
@RequestMapping("${healthpath}/outpatient")
public class RegionOutpatientController extends BaseController {

    @Inject
    private RegionOutpatientService outpatientService;

    /**
	 * @Description: 获取门诊的列表
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getOutpatientPage")
	public JsonResult getOutpatientPage() {
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
			return jsonResult(outpatientService.getOutpatientPage(page, paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	/**
	 * @Description: 查询门诊处方的详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getOutpatientCfList")
	public JsonResult getOutpatientCfList() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String mzId = paramObj.getString("mzId");
			if(StringUtil.isNull(mzId)) {
				return jsonResult(null, 10001, "门诊id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("mzId", mzId);

			return jsonResult(outpatientService.getOutpatientCfList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
    
	/**
	 * @Description: 查询门诊诊断的详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getOutpatientZDList")
	public JsonResult getOutpatientZDList() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String mzId = paramObj.getString("mzId");
			if(StringUtil.isNull(mzId)) {
				return jsonResult(null, 10001, "门诊id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("mzId", mzId);

			return jsonResult(outpatientService.getOutpatientZDList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 查询门诊影像的详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getOutpatientImageList")
	public JsonResult getOutpatientImageList() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String mzId = paramObj.getString("mzId");
			if(StringUtil.isNull(mzId)) {
				return jsonResult(null, 10001, "门诊id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("mzId", mzId);

			return jsonResult(outpatientService.getOutpatientImageList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 门诊影像dcm文件转换为图片
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

			return jsonResult(outpatientService.getCoverImageFormat(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 查询门诊检查的详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getOutpatientJcList")
	public JsonResult getOutpatientJcList() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String mzId = paramObj.getString("mzId");
			if(StringUtil.isNull(mzId)) {
				return jsonResult(null, 10001, "门诊id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("mzId", mzId);

			return jsonResult(outpatientService.getOutpatientJcList(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
}
