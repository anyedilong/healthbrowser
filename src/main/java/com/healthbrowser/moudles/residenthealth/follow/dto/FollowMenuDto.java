package com.healthbrowser.moudles.residenthealth.follow.dto;

import java.io.Serializable;

public class FollowMenuDto implements Serializable {
	
	private static final long serialVersionUID = 4626216161L;
	
	private String path;
    private String name;
    private String tit;
    private String icls;
    
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTit() {
		return tit;
	}
	public void setTit(String tit) {
		this.tit = tit;
	}
	public String getIcls() {
		return "el-icon-s-tools";
	}
	public void setIcls(String icls) {
		this.icls = icls;
	}

    
}
