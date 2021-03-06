package com.healthbrowser.moudles.system.dao;


import java.util.List;

import javax.inject.Named;

import com.healthbrowser.moudles.common.dao.BaseDao;
import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.system.dao.repository.SysRoleRepository;
import com.healthbrowser.moudles.system.domain.SysRole;
import com.healthbrowser.moudles.system.dto.SysRoleDto;
import com.healthbrowser.until.StringUtil;

@Named
public class SysRoleDao extends BaseDao<SysRoleRepository, SysRole>{

	/**
     *	 获取角色列表（分页）
     * @param sysRoleDto
     * @param page
     * @return
     */
    public void getRolePage(SysRoleDto sysRoleDto, PageModel page){
            StringBuffer sql = new StringBuffer();
    		sql.append(" select r.id id, r.role_name as roleName, r.remarks remarks, r.status as status ")
    			.append(" from sys_role r ")
    			.append(" where r.delete_flg ='0' ");
    		if(!StringUtil.isNull(sysRoleDto.getRoleName())){
    			sql.append(" and r.role_name like CONCAT('%',CONCAT(:roleName,'%')) ");
    		}
            queryPage(sql.toString(), sysRoleDto, page, SysRoleDto.class);
    }

    /**
     *	 获取角色列表
     * @param sysRoleDto
     * @return List<SysRoleDto>
     */
    public List<SysRoleDto> getRoleList(SysRoleDto sysRoleDto){
            StringBuffer sb=new StringBuffer();
            sb.append(" select r.id id, r.role_name roleName, r.remarks remarks, r.status as status ")
				.append(" from sys_role r ")
				.append(" where r.status ='1' and r.delete_flg ='0' ");
            return queryList(sb.toString(), sysRoleDto, SysRoleDto.class);
    }
    
    /**
     *	 根据角色名称和所属机构判断是否被占用
     * @param sysRole
     * @return SysRoleDto
     */
    public SysRoleDto queryRoleByNameOrgId(SysRole sysRole){
            StringBuffer sb=new StringBuffer();
            sb.append(" select r.id id, r.role_name roleName ")
				.append(" from sys_role r ")
				.append(" where r.status = '1' and r.delete_flg ='0' ");
            sb.append(" and r.role_name = :roleName ");
            return queryOne(sb.toString(), sysRole, SysRoleDto.class);
    }
}
