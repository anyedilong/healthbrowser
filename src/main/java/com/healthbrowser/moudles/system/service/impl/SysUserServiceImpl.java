package com.healthbrowser.moudles.system.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.common.service.impl.BaseServiceImpl;
import com.healthbrowser.moudles.system.dao.SysRoleUserDao;
import com.healthbrowser.moudles.system.dao.SysUserDao;
import com.healthbrowser.moudles.system.domain.SysRoleUser;
import com.healthbrowser.moudles.system.domain.SysUser;
import com.healthbrowser.moudles.system.service.SysUserService;
import com.healthbrowser.until.UUIDUtil;
import com.healthbrowser.until.encode.Md5Encrypt;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


@Named
public class SysUserServiceImpl extends BaseServiceImpl<SysUserDao, SysUser> implements SysUserService {

    @Inject
    private SysRoleUserDao sysRoleUserDao;

    @Override
    public SysUser getUserByUserName(String userName) throws Exception {
        return dao.getUserByUserName(userName);
    }

    @Override
    public void saveUser(SysUser sysUser) throws Exception {
        //根据用户名判断是否已存在用户
        SysUser user = getUserByUserName(sysUser.getUsername());
        if (user != null && StringUtils.isBlank(sysUser.getId())) {
            throw new Exception("该用户名已存在！");
        }

        //判断是否新增
        if (StringUtils.isBlank(sysUser.getId())) {
            sysUser.setId(UUIDUtil.getUUID());
            String password = sysUser.getPassword();
            if (StringUtils.isBlank(password)) {
                password = "123456";
            }
            sysUser.setPassword(Md5Encrypt.getMD5Code(password));
        }
        sysUser.setSecurityToken(UUIDUtil.getUUID());
        sysUser.setCreateTime(new Date());
        sysUser.setCreateUser("");
        sysUser.setStatus("1");
        dao.saveUser(sysUser);

        //删除用户之前角色
        sysRoleUserDao.batchDelRoleByUserId(sysUser.getId());
        //保存用户和角色的关系
        List<String> roleIds = Arrays.asList(sysUser.getRoleIds().split(","));
        List<SysRoleUser> list = new ArrayList<>();
        for (String roleId : roleIds) {
            SysRoleUser info = new SysRoleUser();
            info.setId(UUIDUtil.getUUID());
            info.setRoleId(roleId);
            info.setUserId(sysUser.getId());
            list.add(info);
        }
        sysRoleUserDao.batchSaveRoleUser(list);
    }

    @Override
    public void getUserPage(SysUser sysUser, PageModel page) {
        dao.getUserPage(sysUser, page);
    }

}
