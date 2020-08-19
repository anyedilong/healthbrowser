package com.healthbrowser.moudles.residenthealth.archive.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.config.filter.StatelessParams;
import com.healthbrowser.moudles.common.controller.BaseController;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.residenthealth.archive.dto.ArchiveQueryCon;
import com.healthbrowser.moudles.residenthealth.archive.service.RegionArchiceService;
import com.healthbrowser.moudles.system.domain.SysUser;
import com.healthbrowser.until.StringUtil;
import com.healthbrowser.until.cache.EhCacheEmun;
import com.healthbrowser.until.cache.EhCacheUtils;

/**
 * @ClassName: RegionArchiveController
 * @Description: 档案对接接口
 * @author Administrator
 * @date 2019年9月6日
 */
@RestController
@RequestMapping("${healthpath}/archive")
public class RegionArchiveController extends BaseController {

	@Autowired
	private RegionArchiceService archiceService;
	
	/**
	 * @Description: 获取档案的列表
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getArchivePage")
	public JsonResult getArchivePage() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			//姓名
			String name = paramObj.getString("name");
			//证件类型和证号编号
			String zjlx = paramObj.getString("zjlx");
			String zjbh = paramObj.getString("zjbh");
			//时间段
			String startTime = paramObj.getString("startTime");
			String endTime = paramObj.getString("endTime");
			// 分页
			Integer pageSize = 0, pageNo = 0;
			JSONObject pageObj = paramObj.getJSONObject("page");
			if (null != pageObj) {
				pageSize = StringUtil.toInteger(pageObj.getString("pageSize"));// 页大小
				pageNo = StringUtil.toInteger(pageObj.getString("pageNo"));// 页索引
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("hzmc", name);
			paramMap.put("zjlx", zjlx);
			paramMap.put("sfzh", zjbh);
			paramMap.put("startTime", startTime);
			paramMap.put("endTime", endTime);
			paramMap.put("pageSize", pageSize+"");
			paramMap.put("pageNo", pageNo+"");
			PageModel page = new PageModel(pageNo, pageSize);
			
			//ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		   // HttpServletRequest request = attributes.getRequest();
			String auth = StatelessParams.getAuth(request);
			SysUser user = (SysUser) EhCacheUtils.get(EhCacheEmun.SYS_CACHE, auth);
			if("0".equals(user.getOrgId()) || !StringUtil.isNull(zjbh)) {
				return jsonResult(archiceService.getArchivePage(page, paramMap));
			}else {
				page.setList(new ArrayList<>());
				return jsonResult(page);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 根据门诊住院条件获取档案的列表
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getArchivePageByCon")
	public JsonResult getArchivePageByCon() {
		try {
			// 获取参数
			String param = getParam(request);
			ArchiveQueryCon info = JSONObject.parseObject(param, ArchiveQueryCon.class);
			// 分页
			JSONObject paramObj = JSONObject.parseObject(param);
			Integer pageSize = 0, pageNo = 0;
			JSONObject pageObj = paramObj.getJSONObject("page");
			if (null != pageObj) {
				pageSize = StringUtil.toInteger(pageObj.getString("pageSize"));// 页大小
				pageNo = StringUtil.toInteger(pageObj.getString("pageNo"));// 页索引
			}
			Map<String, String> paramMap = new HashMap<>();
			if(!StringUtil.isNull(info.getStartTime())) {
				paramMap.put("startTime", info.getStartTime());
			}
			if(!StringUtil.isNull(info.getEndTime())) {
				paramMap.put("endTime", info.getEndTime());
			}
			if(!StringUtil.isNull(info.getIsMedical())) {
				paramMap.put("isMedical", info.getIsMedical());
			}
			if(!StringUtil.isNull(info.getIsOutCost())) {
				paramMap.put("isOutCost", info.getIsOutCost());
			}
			if(!StringUtil.isNull(info.getIsOutRx())) {
				paramMap.put("isOutRx", info.getIsOutRx());
			}
			if(!StringUtil.isNull(info.getIsOutImage())) {
				paramMap.put("isOutImage", info.getIsOutImage());
			}
			if(!StringUtil.isNull(info.getIsOutJcz())) {
				paramMap.put("isOutJcz", info.getIsOutJcz());
			}
			if(!StringUtil.isNull(info.getIsOutZd())) {
				paramMap.put("isOutZd", info.getIsOutZd());
			}
			if(!StringUtil.isNull(info.getIsHospital())) {
				paramMap.put("isHospital", info.getIsHospital());
			}
			if(!StringUtil.isNull(info.getIsHosImage())) {
				paramMap.put("isHosImage", info.getIsHosImage());
			}
			if(!StringUtil.isNull(info.getIsHosJcz())) {
				paramMap.put("isHosJcz", info.getIsHosJcz());
			}
			if(!StringUtil.isNull(info.getIsHosOutCost())) {
				paramMap.put("isHosOutCost", info.getIsHosOutCost());
			}
			if(!StringUtil.isNull(info.getIsHosZd())) {
				paramMap.put("isHosZd", info.getIsHosZd());
			}
			if(!StringUtil.isNull(info.getIsHosEmr())) {
				paramMap.put("isHosEmr", info.getIsHosEmr());
			}
			paramMap.put("pageSize", pageSize+"");
			paramMap.put("pageNo", pageNo+"");
			PageModel page = new PageModel(pageNo, pageSize);
			return jsonResult(archiceService.getArchivePageByCon(page, paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	/**
	 * @Description: 查询档案的详情（健康浏览器-管理员）
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getArchiveDetail")
	public JsonResult getArchiveDetail() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String archiveId = paramObj.getString("archiveId");
			if(StringUtil.isNull(archiveId)) {
				return jsonResult(null, 10001, "档案id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("archiveId", archiveId);
			return jsonResult(archiceService.getArchiveDetail(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 查询档案的详情（健康浏览器-管理员）
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getArchiveDetailBySfzh")
	public JsonResult getArchiveDetailBySfzh() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String sfzh = paramObj.getString("sfzh");
			if(StringUtil.isNull(sfzh)) {
				return jsonResult(null, 10001, "身份证号为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("sfzh", sfzh);
			return jsonResult(archiceService.getArchiveDetailBySfzh(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 查询档案的详情（健康浏览器-嵌入his系统档案查询）
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getArchiveDetailByCon")
	public JsonResult getArchiveDetailByCon() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			//姓名
			String name = paramObj.getString("name");
			//证件类型和证号编号
			String zjlx = paramObj.getString("zjlx");
			String zjbh = paramObj.getString("zjbh");
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("hzmc", name);
			paramMap.put("zjlx", zjlx);
			paramMap.put("sfzh", zjbh);
			return jsonResult(archiceService.getArchiveDetailByCon(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 查询病史信息的详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getBSxxDetail")
	public JsonResult getBSxxDetail() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String jmId = paramObj.getString("jmId");
			if(StringUtil.isNull(jmId)) {
				return jsonResult(null, 10001, "居民id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("jmId", jmId);

			return jsonResult(archiceService.getBSxxDetail(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 查询家族史信息的详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getJZSxxDetail")
	public JsonResult getJZSxxDetail() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String jmId = paramObj.getString("jmId");
			if(StringUtil.isNull(jmId)) {
				return jsonResult(null, 10001, "居民id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("jmId", jmId);

			return jsonResult(archiceService.getJZSxxDetail(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 查询生活环境信息的详情
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getSHfsDetail")
	public JsonResult getSHfsDetail() {
		try {
			// 获取参数
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			String jmId = paramObj.getString("jmId");
			if(StringUtil.isNull(jmId)) {
				return jsonResult(null, 10001, "居民id为空");
			}
			Map<String, String> paramMap = new HashMap<>();
			paramMap.put("jmId", jmId);

			return jsonResult(archiceService.getSHfsDetail(paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
}
