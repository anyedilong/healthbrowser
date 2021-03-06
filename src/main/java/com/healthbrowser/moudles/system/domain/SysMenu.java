package com.healthbrowser.moudles.system.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.healthbrowser.moudles.common.domain.BaseDomain;

/**
 * 菜单表
 */
@Entity
@Table(name = "sys_menu")
public class SysMenu extends BaseDomain {

	private static final long serialVersionUID = 1123236546L;
	
	@Id
    private  String id;//内码
    private  String type;//类型1.系统菜单2.健康居民菜单
    private  String url;//路径
    private  String name;//菜单名称
    @Column(name = "parent_id")
    private  String parentId;//上级菜单内码
    @Column(name = "menu_level")
    private  String menuLevel;//菜单等级
    @Column(name = "order_num")
    private  String orderNum;//排序号
    private  String status;//状态1正常2冻结3删除
    
    @Transient
    private String parentName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(String menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

}
