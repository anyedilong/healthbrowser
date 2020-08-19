package com.healthbrowser.moudles.system.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.healthbrowser.moudles.common.domain.PageModel;
import com.healthbrowser.moudles.common.service.impl.BaseServiceImpl;
import com.healthbrowser.moudles.system.dao.SysMenuDao;
import com.healthbrowser.moudles.system.domain.SysMenu;
import com.healthbrowser.moudles.system.service.SysMenuService;

@Named
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuDao,SysMenu> implements SysMenuService{

	@Override
    public List<SysMenu> getAllMenuTree() {
		return dao.getAllMenuTree();
    }

    @Override
    public List<SysMenu> getMenuTree(String treeType, String roleCap, String orgId) {
    	//需求变更：3.超级管理员 4.普通用户
        if("1".equals(treeType) || "3".equals(roleCap) || "4".equals(roleCap)) {
        	if("3".equals(roleCap)) {
        		return dao.getMenuTree(treeType);
        	}else {
        		//需求变更：临时添加
        		List<SysMenu> list = new ArrayList<>();
        		SysMenu menu = new SysMenu();
        		//a.id, a.type, a.url, a.parent_id, a.name
        		menu.setId("0e50d3dfd6f647eb99b9bcfa141bc205");
        		menu.setType("1");
        		menu.setUrl("/resHealthList");
        		menu.setParentId("0");
        		menu.setName("居民健康档案");
        		list.add(menu);
        		return list;
        	}
        }else {
        	return dao.getUserMenuTree(roleCap, orgId);
        }
    }

    @Override
    public void queryMenuPage(SysMenu sysmenu, PageModel page) {
       dao.queryMenuPage(sysmenu, page);
    }

    @Override
    public void updateMenu(String id, String status) {
            dao.updateMenu(id,status);
    }

	@Override
	public SysMenu getMenuInfoByName(String id, String name, String orderNum) throws Exception {
		return dao.getMenuInfoByName(id, name, orderNum);
	}
	
}
