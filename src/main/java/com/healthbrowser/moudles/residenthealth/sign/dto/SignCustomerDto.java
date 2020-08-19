package com.healthbrowser.moudles.residenthealth.sign.dto;

import javax.persistence.Id;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;


public class SignCustomerDto implements Serializable {

	private static final long serialVersionUID = 1649912616L;

	@Id
	private String id;// ID
	private String signId;// 签约ID
	private String customerIdacard;// 成员身份证号
	private String customerName;// 成员身份证号
	private String crowdSortCode;// 健康分类code
	private String manageType;// 管理方式
	private double money;// 金额 默认为0
	private String status;// 状态 1 签约 2 解约
	@JSONField(format = "yyyy-MM-dd")
	private Date signTime;// 签约时间
	private String signItemId;// 签约记录ID
	@JSONField(format = "yyyy-MM-dd")
	private Date releaseTime;// 解约时间
	private String releaseItemId;// 解约记录ID
	private String remarks;// 备注

	// 签约服务包
	private List<SignCustomerPackageDto> signCustomerPackageList;
	// 签约服务
	private List<SignCustomerProjectDto> signCustomerProjectList;
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSignId() {
		return this.signId;
	}

	public void setSignId(String signId) {
		this.signId = signId;
	}

	public String getCustomerIdacard() {
		return this.customerIdacard;
	}

	public void setCustomerIdacard(String customerIdacard) {
		this.customerIdacard = customerIdacard;
	}

	public String getCrowdSortCode() {
		return this.crowdSortCode;
	}

	public void setCrowdSortCode(String crowdSortCode) {
		this.crowdSortCode = crowdSortCode;
	}

	public Date getSignTime() {
		return this.signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public String getSignItemId() {
		return this.signItemId;
	}

	public void setSignItemId(String signItemId) {
		this.signItemId = signItemId;
	}

	public Date getReleaseTime() {
		return this.releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getReleaseItemId() {
		return this.releaseItemId;
	}

	public void setReleaseItemId(String releaseItemId) {
		this.releaseItemId = releaseItemId;
	}

	public String getManageType() {
		return this.manageType;
	}

	public void setManageType(String manageType) {
		this.manageType = manageType;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getMoney() {
		return this.money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	public List<SignCustomerPackageDto> getSignCustomerPackageList() {
		return signCustomerPackageList;
	}
	public void setSignCustomerPackageList(List<SignCustomerPackageDto> signCustomerPackageList) {
		this.signCustomerPackageList = signCustomerPackageList;
	}
	public List<SignCustomerProjectDto> getSignCustomerProjectList() {
		return signCustomerProjectList;
	}
	public void setSignCustomerProjectList(List<SignCustomerProjectDto> signCustomerProjectList) {
		this.signCustomerProjectList = signCustomerProjectList;
	}
	public String getCustomerName() {
		return customerName;
	}

}
