package com.healthbrowser.moudles.system.service;

import java.util.List;


public interface SysMenuRoleService{

	//角色授权
	void authorize(String roleId, String orgId, List<Object> menuIds) throws Exception ;
	//查询角色授权信息
	List<String> showAuthorize(String roleId, String orgId);
	
	void batchDelMenuByRole(String roleId);
	
	void batchDelRoleByMenu(String menuId);
}
