package com.healthbrowser.moudles.system.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.healthbrowser.moudles.system.domain.SysRole;
import com.healthbrowser.moudles.system.service.SysRoleUserService;
import com.healthbrowser.until.UUIDUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.controller.BaseController;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.system.dto.SysRoleDto;
import com.healthbrowser.moudles.system.service.SysMenuRoleService;
import com.healthbrowser.moudles.system.service.SysRoleService;

@RestController
@RequestMapping("${healthpath}/role")
public class SysRoleController extends BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private SysRoleService roleService;
	@Autowired
	private SysMenuRoleService sysMenuRoleService;
	@Autowired
	private SysRoleUserService sysRoleUserService;

	/**
	 * @Description: 列表数据(分页)
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getRolePage")
	public JsonResult getRolePage() {
		try {
			String param = getParam(request);
    		if(StringUtils.isNoneBlank(param)){
    			SysRoleDto sysRole = JSON.parseObject(param, SysRoleDto.class);
    			if (sysRole == null) {
    				sysRole = new SysRoleDto();
    			}
				JSONObject obj = JSON.parseObject(param).getJSONObject("page");
				PageModel page = new PageModel(obj.getInteger("pageNo"), obj.getInteger("pageSize"));
				roleService.getRolePage(sysRole, page);
				return jsonResult(page);
    		}else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
	
	/**
	 * @Description: 列表数据
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("getRoleList")
	public JsonResult getRoleList() {
		try {
			String param = getParam(request);
    		if(StringUtils.isNoneBlank(param)){
    			SysRoleDto sysRole = JSON.parseObject(param, SysRoleDto.class);
    			if (sysRole == null) {
    				sysRole = new SysRoleDto();
    			}
    			List<SysRoleDto> list = roleService.getRoleList(sysRole);
    			return jsonResult(list);
    		}else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	/**
	 * @Description: 角色授权
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("authorize")
	public JsonResult authorize() {
		try {
			String param = getParam(request);
			JSONObject paramObj = JSON.parseObject(param);
			if (paramObj != null) {
				// 授权功能
				List<Object> menuIds = Arrays.asList(paramObj.getString("menuIds").split(","));
				// 角色ID
				String roleId = paramObj.getString("id");
				String orgId = paramObj.getString("orgId");
				sysMenuRoleService.authorize(roleId, orgId, menuIds);
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
			return jsonResult();
		}catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	/**
	 * @Description: 查询角色授权信息
	 * @param @return
	 * @return JsonResult
	 * @throws
	 */
	@RequestMapping("showAuthorize")
	public JsonResult showAuthorize() {
		try {
			String param = getParam(request);
			JSONObject paramObj = JSON.parseObject(param);
			if (paramObj != null) {
				// 角色ID
				String roleId = paramObj.getString("id");
				String orgId = paramObj.getString("orgId");
				List<String> roleMenuList = sysMenuRoleService.showAuthorize(roleId, orgId);
				return jsonResult(roleMenuList);
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
		}catch(Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	//角色保存
	@RequestMapping("saveRole")
	public JsonResult saveRole () {
		try {
			// 获取参数
			String param = getParam(request);
			if (StringUtils.isNotBlank(param)) {
				SysRole sysRole = JSON.parseObject(param, SysRole.class);
				// 获取当前用户所属的组织机构
				String userId = "";
				sysRole.setCreateTime(new Date());
				sysRole.setCreateUser(userId);
				//根据角色名称和所属机构判断是否被占用
				SysRoleDto tempRole = roleService.queryRoleByNameOrgId(sysRole);
				if(tempRole != null && StringUtils.isBlank(sysRole.getId())) {
					return jsonResult(null, 10001, "该机构下的角色名称已被占用！");
				}else {
					// 保存
					if (StringUtils.isBlank(sysRole.getId())) {
						sysRole.setId(UUIDUtil.getUUID());
					}
					roleService.save(sysRole);
					return jsonResult();
				}
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	//角色删除
	@RequestMapping("deleteRole")
	public JsonResult deleteRole () {
		try {
			// 获取参数
			String param = getParam(request);
			if (StringUtils.isNotBlank(param)) {
				JSONObject jsonObject = JSONObject.parseObject(param);
				String roleId = jsonObject.getString("id");
				if (StringUtils.isBlank(roleId)) {
					return jsonResult(null, 10002, "角色ID必填");
				}
				roleService.delete(roleId);
				sysMenuRoleService.batchDelMenuByRole(roleId);
				sysRoleUserService.batchDelUserByRole(roleId);
				return jsonResult();
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}

	//角色信息查询
	@RequestMapping("roleInfo")
	public JsonResult roleInfo () {
		try {
			// 获取参数
			String param = getParam(request);
			if (StringUtils.isNotBlank(param)) {
				JSONObject jsonObject = JSONObject.parseObject(param);
				String roleId = jsonObject.getString("id");
				if (StringUtils.isBlank(roleId)) {
					return jsonResult(null, 10002, "角色ID必填");
				}
				SysRole sysRole = roleService.get(roleId);
				return jsonResult(sysRole);
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 90001, e.getMessage());
		}
	}
}
