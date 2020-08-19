package com.healthbrowser.moudles.residenthealth.team.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import com.alibaba.fastjson.annotation.JSONField;


public class SysTeamUserDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;// ID
	private String teamId;// 团队ID
	private String userId;// 用户ID
	private String teamRole;// 团队职责（用户类型）
	private String remarks;// 备注
	private String teamLeaderFlg;// 是否团队长 0 否 1 是
	private String status;// 状态1正常 2 删除
	@JSONField(format = "yyyy-MM-dd")
	private Date createTime;// 操作时间
	private String createUser;// 操作人
	private String teamRoleName;
	@JSONField(format = "yyyy-MM-dd")
	private Date updateTime;// 修改时间
	private String updateUser;// 修改人
	private String operationType;// 操作类型 1 add 2 update 3 delete

	public String getOperationType() {
		return operationType;
	}

	public void setOperationType(String operationType) {
		this.operationType = operationType;
	}

	public String getId() {
		return this.id;
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

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {

		this.userId = userId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getTeamRole() {
		return teamRole;
	}

	public void setTeamRole(String teamRole) {
		this.teamRole = teamRole;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTeamLeaderFlg() {
		return this.teamLeaderFlg;
	}

	public void setTeamLeaderFlg(String teamLeaderFlg) {
		this.teamLeaderFlg = teamLeaderFlg;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getTeamRoleName() {
		return teamRoleName;
	}

	public void setTeamRoleName(String teamRoleName) {
		this.teamRoleName = teamRoleName;
	}

}
