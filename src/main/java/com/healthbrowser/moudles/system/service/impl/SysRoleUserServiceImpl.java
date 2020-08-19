package com.healthbrowser.moudles.system.service.impl;

import javax.inject.Named;

import com.healthbrowser.moudles.common.service.impl.BaseServiceImpl;
import com.healthbrowser.moudles.system.dao.SysRoleUserDao;
import com.healthbrowser.moudles.system.domain.SysMenuRole;
import com.healthbrowser.moudles.system.service.SysRoleUserService;



@Named
public class SysRoleUserServiceImpl extends BaseServiceImpl<SysRoleUserDao, SysMenuRole> implements SysRoleUserService {

		
	@Override
	public String showAuthorize(String userId) {
		return dao.showAuthorize(userId);
	}
	
	@Override
	public void batchDelRoleByUserId(String userId) {
		dao.batchDelRoleByUserId(userId);
	}

	@Override
	public void batchDelUserByRole(String roleId) {
		dao.batchDelUserByRole(roleId);
	}
}
