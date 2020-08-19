package com.healthbrowser.moudles.residenthealth.follow.controller;

import java.util.HashMap;
import java.util.Map;

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
import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.residenthealth.follow.service.ReferralService;
import com.healthbrowser.until.StringUtil;

//转诊
@RestController
@RequestMapping("/referral")
public class ReferralController extends BaseController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Inject
    private ReferralService referralService;
    
    
    /**
	 * @Description: 获取转诊的列表
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getReferralPage")
	public JsonResult getReferralPage() {
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
			
			return jsonResult(referralService.getReferralPage(page, paramMap));
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
    
    /**
     * 获取转诊详情
     */
    @RequestMapping("/getInfo")
    public JsonResult getInfo() throws Exception {
        String param = getParam(request);
        logger.info("查询转诊详情请求参数：" + param);
        JSONObject paramObj = JSONObject.parseObject(param);
        String id = paramObj.getString("id");
        if (StringUtils.isBlank(id)) {
            return jsonResult(null, 90001, "ID不能为空！");
        }
        JsonResult referral = referralService.getInfo(paramObj);
        logger.info("查询转诊详情返回：" + JSON.toJSONString(referral));
        return referral;
    }
}
