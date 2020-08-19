package com.healthbrowser.moudles.residenthealth.follow.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.domain.ProcessStatus;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

public class ResultUtil {

    public static JsonResult jsonResult(String result) {
        if (StringUtils.isBlank(result))
            return new JsonResult();
        JSONObject json = JSONObject.parseObject(result);
        String retCode = json.getString("retCode");
        if (StringUtils.isNotBlank(retCode) && "0".equals(retCode)) {
            Object data = json.get("data");
            if (data == null) {
                return new JsonResult("{}");
            } else if (data instanceof Map) {
                JSONObject dataJson = (JSONObject) data;
                if (dataJson.getJSONArray("list") != null) {
                    return new JsonResult(dataJson.getJSONArray("list"));
                }
                String pageNo = dataJson.getString("pageNo");
                if (StringUtils.isNotBlank(pageNo)) {
                    return new JsonResult("{}");
                }
                dataJson.put("imgStr", "");
            }

            return new JsonResult(data);
        } else if (StringUtils.isNotBlank(retCode) && !"0".equals(retCode)) {
            ProcessStatus status = new ProcessStatus(Integer.parseInt(retCode), json.getString("retMsg"));
            return new JsonResult(null, status);
        }
        return new JsonResult(json);
    }
}
