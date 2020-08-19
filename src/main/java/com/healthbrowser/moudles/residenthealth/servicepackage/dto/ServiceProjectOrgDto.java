package com.healthbrowser.moudles.residenthealth.servicepackage.dto;

import java.io.Serializable;

import javax.persistence.Id;


public class ServiceProjectOrgDto implements Serializable {

	private static final long serialVersionUID = 461261616L;

	@Id
	private String id;// null
	private String projectId;// 服务项目ID
	private String orgId;// 机构ID
	private String availableFlg;// 是否可用 0 否 1 是
	private String subAvailableFlg;// 下级是否可用 0 否 1 是

	private String orgCode;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getAvailableFlg() {
		return availableFlg;
	}

	public void setAvailableFlg(String availableFlg) {
		this.availableFlg = availableFlg;
	}

	public String getSubAvailableFlg() {
		return subAvailableFlg;
	}

	public void setSubAvailableFlg(String subAvailableFlg) {
		this.subAvailableFlg = subAvailableFlg;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

}
