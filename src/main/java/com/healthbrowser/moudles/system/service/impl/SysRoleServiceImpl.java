package com.healthbrowser.moudles.system.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.common.service.impl.BaseServiceImpl;
import com.healthbrowser.moudles.system.dao.SysRoleDao;
import com.healthbrowser.moudles.system.domain.SysRole;
import com.healthbrowser.moudles.system.dto.SysRoleDto;
import com.healthbrowser.moudles.system.service.SysRoleService;


/**
 * <br>
 * <b>功能：</b>SysRoleService<br>
 * <b>作者：</b>blt<br>
 * <b>版权所有：<b>版权所有(C) 2019，blt<br>
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends BaseServiceImpl<SysRoleDao, SysRole> implements SysRoleService {


	@Override
	public void getRolePage(SysRoleDto sysRoleDto, PageModel page) {
		dao.getRolePage(sysRoleDto, page);
	}

	@Override
	public List<SysRoleDto> getRoleList(SysRoleDto role) {
		return dao.getRoleList(role);
	}

	@Override
	public SysRoleDto queryRoleByNameOrgId(SysRole sysRole) {
		return dao.queryRoleByNameOrgId(sysRole);
	}


}
