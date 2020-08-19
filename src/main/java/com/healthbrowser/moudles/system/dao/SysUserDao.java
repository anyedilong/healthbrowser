package com.healthbrowser.moudles.system.dao;


import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import com.healthbrowser.moudles.common.dao.BaseDao;
import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.system.dao.repository.SysUserRepository;
import com.healthbrowser.moudles.system.domain.SysUser;
import org.apache.commons.lang3.StringUtils;

@Named
public class SysUserDao extends BaseDao<SysUserRepository, SysUser> {


    public SysUser getUserByUserName(String userName) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select u.* ");
        sql.append(" from sys_user u ");
        sql.append(" where u.status != '3' and  u.username = :userName ");

        Map<String, Object> map = new HashMap<>();
        map.put("userName", userName);
        return queryOne(sql.toString(), map, SysUser.class);
    }

    public void saveUser(SysUser user) {
        repository.save(user);
    }

    public void getUserPage(SysUser sysUser, PageModel page) {
        StringBuffer sql = new StringBuffer();
        sql.append(" select u.id, u.username, u.password, u.name, u.org_id, u.status,u.remarks, ");
        sql.append(" (select listagg(to_char(a.role_name), ',') WITHIN GROUP(ORDER BY a.create_time) ");
        sql.append(" 		from sys_role a join sys_role_user b on a.id = b.role_id where b.user_id = u.id) as roleNames ");
        sql.append(" from sys_user u ");
        sql.append(" join sys_org o on u.org_id = o.id ");
        sql.append(" where u.status != '3' and o.status != '3' ");
        if (StringUtils.isNotBlank(sysUser.getUsername())) {
            sql.append(" and u.username like concat(concat('%', :username), '%') ");
        }
        if (StringUtils.isNotBlank(sysUser.getName())) {
            sql.append(" and u.name like concat(concat('%', :name), '%') ");
        }
        if (StringUtils.isNotBlank(sysUser.getIsCludeSubFlg())) {
            sql.append(" and o.org_code like concat((select org_code from sys_org where id = :orgId), '%') ");
        } else {
            sql.append(" and o.id = :orgId ");
        }
        queryPage(sql.toString(), sysUser, page, SysUser.class);
    }
}
