package com.healthbrowser.moudles.residenthealth.team.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;

import com.alibaba.fastjson.annotation.JSONField;

public class SysTeamDto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;// null
	private String teamName;// 团队名称
	private String teamLeaderId;// 团队长（用户ID）
	private String teamIntroduction;// 团队简介
	private String healthPhone;// 健康电话
	private Date updateTime;// 修改时间
	private String updateUser;// 修改人
	private String orgId;// 所属机构
	@JSONField(format = "yyyy-MM-dd")
	private Date establishTime;// 成立时间
	@JSONField(format = "yyyy-MM-dd")
	private Date createTime;// 创建时间
	private String createUser;// 创建人
	private String status;// 状态 1正常 2冻结 3解散
	private String teamLevel;// 等级
	private Integer score;// 评分
	@JSONField(format = "yyyy-MM-dd")
	private Date disbandTime;// 解散时间
	private String disbandUser;// 解散人
	@JSONField(format = "yyyy-MM-dd")
	private Date disbandRemarks;// 解散备注
	private String electronicSignature;// 电子签章

	private List<SysTeamUserDto> teamUserList;// 团队成员
	private List<SysTeamOrgDto> teamOrgList;// 团队管辖机构
	private List<SysTeamAreaDto> teamAreaList; //团队区划
	private List<SysTeamHisDto> teamHisList; //团队成员责任
	
	private String remarks;// 备注
	

	public List<SysTeamUserDto> getTeamUserList() {
		return teamUserList;
	}

	public void setTeamUserList(List<SysTeamUserDto> teamUserList) {
		this.teamUserList = teamUserList;
	}

	public List<SysTeamOrgDto> getTeamOrgList() {
		return teamOrgList;
	}

	public void setTeamOrgList(List<SysTeamOrgDto> teamOrgList) {
		this.teamOrgList = teamOrgList;
	}

	public List<SysTeamAreaDto> getTeamAreaList() {
		return teamAreaList;
	}

	public void setTeamAreaList(List<SysTeamAreaDto> teamAreaList) {
		this.teamAreaList = teamAreaList;
	}

	public List<SysTeamHisDto> getTeamHisList() {
		return teamHisList;
	}

	public void setTeamHisList(List<SysTeamHisDto> teamHisList) {
		this.teamHisList = teamHisList;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamLeaderId() {
		return this.teamLeaderId;
	}

	public void setTeamLeaderId(String teamLeaderId) {
		this.teamLeaderId = teamLeaderId;
	}

	public String getTeamIntroduction() {
		return teamIntroduction;
	}

	public void setTeamIntroduction(String teamIntroduction) {
		this.teamIntroduction = teamIntroduction;
	}

	public String getHealthPhone() {
		return this.healthPhone;
	}

	public void setHealthPhone(String healthPhone) {
		this.healthPhone = healthPhone;
	}

	public String getOrgId() {
		return this.orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public Date getEstablishTime() {
		return this.establishTime;
	}

	public void setEstablishTime(Date establishTime) {
		this.establishTime = establishTime;
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

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTeamLevel() {
		return this.teamLevel;
	}

	public void setTeamLevel(String teamLevel) {
		this.teamLevel = teamLevel;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Date getDisbandTime() {
		return this.disbandTime;
	}

	public void setDisbandTime(Date disbandTime) {
		this.disbandTime = disbandTime;
	}

	public Date getDisbandRemarks() {
		return disbandRemarks;
	}

	public void setDisbandRemarks(Date disbandRemarks) {
		this.disbandRemarks = disbandRemarks;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getElectronicSignature() {
		return this.electronicSignature;
	}

	public void setElectronicSignature(String electronicSignature) {
		this.electronicSignature = electronicSignature;
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

	public String getDisbandUser() {
		return disbandUser;
	}

	public void setDisbandUser(String disbandUser) {
		this.disbandUser = disbandUser;
	}

}
