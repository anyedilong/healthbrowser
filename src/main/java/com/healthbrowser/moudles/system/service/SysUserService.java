package com.healthbrowser.moudles.system.service;


import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.common.service.BaseService;
import com.healthbrowser.moudles.system.domain.SysUser;


public interface SysUserService extends BaseService<SysUser> {

    //根据用户名查询用户信息
    SysUser getUserByUserName(String userName) throws Exception;

    //保存用户
    void saveUser(SysUser user) throws Exception;

    //查询用户列表
    void getUserPage(SysUser sysUser, PageModel page);
}
