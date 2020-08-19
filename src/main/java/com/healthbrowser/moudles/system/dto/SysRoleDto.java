package com.healthbrowser.moudles.system.dto;

import java.io.Serializable;


public class SysRoleDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;// null
	private String roleName;// 角色名称
	private String status;// 状态 1正常 2 冻结
	private String remarks;// 备注
	private String userId;
	private String level;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}


}
