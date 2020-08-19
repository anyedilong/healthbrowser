package com.healthbrowser.moudles.system.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.controller.BaseController;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.system.domain.SysUser;
import com.healthbrowser.moudles.system.service.SysRoleUserService;
import com.healthbrowser.moudles.system.service.SysUserService;
import com.healthbrowser.until.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.Date;

@RestController
@RequestMapping("${healthpath}/user")
public class SysUserController extends BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private SysUserService userService;
    @Inject
    private SysRoleUserService sysRoleUserService;

    @RequestMapping("saveUser")
    public JsonResult saveUser() {
        try {
            // 获取参数
            String param = getParam(request);
            if (StringUtils.isNotBlank(param)) {
                SysUser sysUser = JSON.parseObject(param, SysUser.class);
                userService.saveUser(sysUser);
                return jsonResult();
            } else {
                return jsonResult(null, 10001, "参数错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return jsonResult(null, 90001, e.getMessage());
        }
    }

    @RequestMapping("getUser")
    public JsonResult getUser() {
        try {
            // 获取参数
            String param = getParam(request);
            if (StringUtils.isNotBlank(param)) {
                SysUser sysUser = JSON.parseObject(param, SysUser.class);
                String userId = sysUser.getId();
                if (StringUtils.isBlank(userId)) {
                    return jsonResult(null, 10001, "ID不能为空！");
                }
                SysUser user = userService.get(userId);
                if(user != null) {
                    String roleIds = sysRoleUserService.showAuthorize(sysUser.getId());
                    user.setRoleIds(roleIds);
                }
                return jsonResult(user);
            } else {
                return jsonResult(null, 10001, "参数错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return jsonResult(null, 90001, e.getMessage());
        }
    }

    @RequestMapping("delUser")
    public JsonResult delUser() {
        try {
            // 获取参数
            String param = getParam(request);
            if (StringUtils.isNotBlank(param)) {
                SysUser sysUser = JSON.parseObject(param, SysUser.class);
                String userId = sysUser.getId();
                if (StringUtils.isBlank(userId)) {
                    return jsonResult(null, 10001, "ID不能为空！");
                }
                userService.delete(userId);
                return jsonResult();
            } else {
                return jsonResult(null, 10001, "参数错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return jsonResult(null, 90001, e.getMessage());
        }
    }

    @RequestMapping("getUserList")
    public JsonResult getUserList() {
        try {
            // 获取参数
            String param = getParam(request);
            JSONObject paramObj = JSONObject.parseObject(param);
            if (StringUtils.isNotBlank(param)) {
                PageModel page = new PageModel();
                JSONObject pageObj = paramObj.getJSONObject("page");
                if (pageObj != null) {
                    int pageNo = pageObj.getInteger("page_no");
                    int pageSize = pageObj.getInteger("page_size");
                    page = new PageModel(pageNo, pageSize);
                }
                SysUser sysUser = JSON.parseObject(param, SysUser.class);
                userService.getUserPage(sysUser, page);
                return jsonResult(page);
            } else {
                return jsonResult(null, 10001, "参数错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return jsonResult(null, 90001, e.getMessage());
        }
    }
}
