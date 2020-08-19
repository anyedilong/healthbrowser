package com.healthbrowser.moudles.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.controller.BaseController;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.system.domain.SysReaderLog;
import com.healthbrowser.moudles.system.service.SysReaderLogService;

@RestController
@RequestMapping("${healthpath}/readerlog")
public class SysReaderLogController extends BaseController {

	@Autowired
	private SysReaderLogService sysReaderLogService;

	/**
	 * @Description: 调阅日志列表查询 
	 * @param 
	 * @return 
	 * @return JsonResult 
	 * @throws
	 */
	@RequestMapping("queryReaderLogPage")
	public JsonResult queryReaderLogPage() {
		try {
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			if (paramObj != null) {
				PageModel page = new PageModel();
				JSONObject pageObj = paramObj.getJSONObject("page");
				if (pageObj != null) {
					int pageNo = pageObj.getInteger("pageNo");
					int pageSize = pageObj.getInteger("pageSize");
					page = new PageModel(pageNo, pageSize);
				}
				SysReaderLog sysReaderLog = JSON.parseObject(param, SysReaderLog.class);
				sysReaderLogService.queryReaderLogPage(sysReaderLog, page);
				return jsonResult(page);
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 10001, "系统错误");
		}

	}

}
