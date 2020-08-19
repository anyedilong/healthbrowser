package com.healthbrowser.moudles.system.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.healthbrowser.moudles.common.controller.BaseController;
import com.healthbrowser.moudles.common.domain.JsonResult;
import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.system.domain.SysMenu;
import com.healthbrowser.moudles.system.service.SysMenuRoleService;
import com.healthbrowser.moudles.system.service.SysMenuService;
import com.healthbrowser.until.StringUtil;
import com.healthbrowser.until.UUIDUtil;

@RestController
@RequestMapping("${healthpath}/menu")
public class SysMenuController extends BaseController {

	@Inject
	private SysMenuService sysMenuService;
	@Autowired
	private SysMenuRoleService sysMenuRoleService;

	
	/**
	 * @Description: 全部菜单树形查询 
	 * @param @return 
	 * @return JsonResult 
	 * @throws
	 */
	@RequestMapping("getAllMenuTree")
	public JsonResult getAllMenuTree() {
		try {
			List<SysMenu> list = sysMenuService.getAllMenuTree();
			return jsonResult(list);
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 10001, "系统错误");
		}
	}
	
	/**
	 * @Description: 登录者菜单树形查询 
	 * @param @return 
	 * @return JsonResult 
	 * @throws
	 */
	@RequestMapping("getmenutree")
	public JsonResult getMenuTree() {
		try {
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			if (paramObj != null) {
				//1.系统菜单树 2.居民健康菜单树
				String treeType = paramObj.getString("treeType");
				//角色 1.医生 2.护士 3.管理员 4.普通用户
				String roleCap = paramObj.getString("roleCap");
				String orgId = paramObj.getString("orgId");
				List<SysMenu> list = sysMenuService.getMenuTree(treeType, roleCap, orgId);
				return jsonResult(list);
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 10001, "系统错误");
		}
	}

	/**
	 * @Description: 菜单列表查询 
	 * @param 
	 * @return 
	 * @return JsonResult 
	 * @throws
	 */
	@RequestMapping("querymenu")
	public JsonResult queryMenu() {
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
				SysMenu sysmenu = JSON.parseObject(param, SysMenu.class);
				String parentId = sysmenu.getParentId();
				if (StringUtil.isNull(parentId)) {
					sysmenu.setParentId("0");
				}
				sysMenuService.queryMenuPage(sysmenu, page);
				return jsonResult(page);
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 10001, "系统错误");
		}

	}

	/**
	 * @Description: 保存菜单 
	 * @param 
	 * @return 
	 * @return JsonResult 
	 * @throws
	 */
	@RequestMapping("save")
	public JsonResult saveMenu() {
		try {
			String param = getParam(request);
			SysMenu sysMenu = JSONObject.parseObject(param, SysMenu.class);
			if (StringUtil.isNull(sysMenu.getId())) {
				sysMenu.setId(UUIDUtil.getUUID());
			}
			//菜单名称不能重复
			SysMenu temp = sysMenuService.getMenuInfoByName(sysMenu.getId(), sysMenu.getName(), sysMenu.getOrderNum());
			if(temp != null) {
				return jsonResult(null, 10001, "菜单名称和排序不能重复！！！");
			}
			if (StringUtil.isNull(sysMenu.getParentId())) {
				sysMenu.setParentId("0");
			}
			sysMenuService.save(sysMenu);
			return jsonResult();
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 10001, "系统错误");
		}
	}

	/**
	 * @Description: 修改菜单状态 
	 * @param 
	 * @return 
	 * @return JsonResult 
	 * @throws
	 */
	@RequestMapping("updatemenu")
	public JsonResult updateMenu() {
		String param = getParam(request);
		JSONObject paramObj = JSONObject.parseObject(param);
		if (paramObj != null) {
			String id = paramObj.getString("id");
			String status = paramObj.getString("status");
			sysMenuService.updateMenu(id, status);
		}
		return jsonResult();
	}

	/**
	 * @Description:菜单详情 
	 * @param 
	 * @return 
	 * @return JsonResult 
	 * @throws
	 */
	@RequestMapping("show")
	public JsonResult getMenu() {
		try {
			String param = getParam(request);
			JSONObject paramObj = JSONObject.parseObject(param);
			if (paramObj != null) {
				String id = paramObj.getString("id");
				if (StringUtil.isNull(id)) {
					return jsonResult(null, 10001, "参数错误");
				}
				SysMenu sysMenu = sysMenuService.get(id);
				return jsonResult(sysMenu);
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 10001, "系统错误");
		}

	}

	/**
	 * @Description: 删除菜单 
	 * @param @return 
	 * @return JsonResult 
	 * @throws
	 */
	@RequestMapping("delete")
	@ResponseBody
	public JsonResult delete() {
		try {
			String param = getParam(request);
			JSONObject paramObj = JSON.parseObject(param);
			if (paramObj != null) {
				String ids = paramObj.getString("ids");
				String[] idArr = ids.split(",");
				for (int i = 0; i < idArr.length; i++) {
					sysMenuRoleService.batchDelRoleByMenu(idArr[i]);
					sysMenuService.updateMenu(idArr[i], "3");
				}
			} else {
				return jsonResult(null, 10001, "参数错误");
			}
			return jsonResult();
		} catch (Exception e) {
			e.printStackTrace();
			return jsonResult(null, 10001, "系统错误");
		}
	}
}
