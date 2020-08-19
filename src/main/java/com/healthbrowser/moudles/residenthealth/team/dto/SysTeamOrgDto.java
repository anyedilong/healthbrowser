package com.healthbrowser.moudles.residenthealth.team.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;


public class SysTeamOrgDto implements Serializable {

	private static final long serialVersionUID = 16464864L;

	@Id
	private String id;//ID
	private String teamId;// 团队ID
	private String orgId;// 机构ID
	private Date createTime;// 操作时间
	private String createUser;// 操作人
	private Date updateTime;// 修改时间
	private String updateUser;// 修改人
	private String status;//状态 1正常 2删除
	
	private String operationType;// 操作类型 1 add 2 update 3 delete

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
}
