package com.healthbrowser.moudles.residenthealth.servicepackage.dto;

import javax.persistence.Id;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


public class ServicePackageDto implements Serializable {

	private static final long serialVersionUID = 154694616L;

	@Id
	private String id;// id
	private String packageName;// 包名
	private String orgId;// 机构ID
	private Integer money;// 金额 默认为0
	private String sortCode;// 人群分类code ,,隔开
	private String availableFlg;// 是否可用 0 否 1 是
	private String subAvailableFlg;// 下级是否可用 0 否 1 是
	private String createUser;// 创建人
	@JSONField(format="yyyy-MM-dd")
	private Date createTime;// 创建时间
	private String updateUser;// 修改人
	@JSONField(format="yyyy-MM-dd")
	private Date updateTime;// 修改时间
	private String deleteFlg;// 是否删除 0 否 1是
	private String updateFlg;//是否修改
	
	private List<ServicePackageProjectDto> projectList;// 项目包--》项目
	
	private String accretion;//是否是增值包
	private String contract;//是否是签约包
	private String remarks; //备注

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getAccretion() {
		return accretion;
	}

	public void setAccretion(String accretion) {
		this.accretion = accretion;
	}

	public String getContract() {
		return contract;
	}

	public void setContract(String contract) {
		this.contract = contract;
	}

	public String getUpdateFlg() {
		return updateFlg;
	}

	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public String getSortCode() {
		return sortCode;
	}

	public void setSortCode(String sortCode) {
		this.sortCode = sortCode;
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

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public List<ServicePackageProjectDto> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ServicePackageProjectDto> projectList) {

		if (null != projectList && projectList.size() > 0) {
			for (int i = 0; i < projectList.size(); i++) {
				ServicePackageProjectDto project = projectList.get(i);
				if (null != project) {
					project.setOrderNum(i);
				}
			}
		}

		this.projectList = projectList;
	}

}
