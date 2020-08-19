package com.healthbrowser.moudles.system.service;

import java.util.List;

import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.common.service.BaseService;
import com.healthbrowser.moudles.system.domain.SysRole;
import com.healthbrowser.moudles.system.dto.SysRoleDto;



public interface SysRoleService extends BaseService<SysRole>{

	//获取角色列表(分页)
	void getRolePage(SysRoleDto entity, PageModel page);
	//获取角色列表
	List<SysRoleDto> getRoleList(SysRoleDto role);
	//根据角色名称和所属机构判断是否被占用
	SysRoleDto queryRoleByNameOrgId(SysRole sysRole);
	
}
