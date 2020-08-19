package com.healthbrowser.moudles.system.service;


import java.util.List;

import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.common.service.BaseService;
import com.healthbrowser.moudles.system.domain.SysMenu;


public interface SysMenuService  extends BaseService<SysMenu>{


	//获取全部菜单数据
    List<SysMenu> getAllMenuTree();
	//获取登录者菜单数据
    List<SysMenu> getMenuTree(String treeType, String roleCap, String orgId);
    //获取菜单数据(分页)
    void queryMenuPage(SysMenu sysmenu, PageModel page);

    void updateMenu(String id,String status);
    
    SysMenu getMenuInfoByName(String id, String name, String orderNum) throws Exception;
    
}
