package com.healthbrowser.moudles.residenthealth.sign.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Transient;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @ClassName Sign
 * @Description 签约表
 * @author sen
 * @Date 2017年1月11日 下午1:50:04
 * @version 1.0.0
 */
public class SignDto implements Serializable {

	private static final long serialVersionUID = 53646363416L;
	
	@Id
	private String id;// ID
	// 签约记录
	private String signItemId;// 签约记录ID
	private String upLoad = "1";// 1未传2传
	private String signType;// 1、个人 2、家庭
	private String familyId;// 家庭ID
	private String familyNum;// 家庭编号
	// 医生团队ID
	private String teamId;
	private String familyPhone;// 家庭电话
	private String adderss;// 住址
	private String healthPhone;// 健康电话
	private String teamTelephone;// 团队固定电话
	private String responsibleUser;// 责任医生
	private Integer cycleYear;// 签约周期/年
	private String remarks;// 备注
	private double money;// 金额 默认为0
	private String renewFlg;// 是否自动续约 0 否 1是
	private Integer renewCycle;// 续约周期/年
	private String status;// 状态 1签约 2 解约 3到期 4申请 5驳回
	@JSONField(format = "yyyy-MM-dd")
	private Date renewEndTime;// 当前周期到期时间
	@JSONField(format = "yyyy-MM-dd")
	private Date signTime;// 签约时间
	private String signUser;// 签约人
	private String signUserName;// 签约人
	private String signCustomerIdcard;// 签约客户
	private String signCustomerName;// 签约客户姓名
	private String releaseCustomerIdcard;// 解约客户
	private String releaseCustomerName;// 签约客户姓名
	private String releaseUser = "";// 解约人
	private String releaseUserName;// 解约人姓名
	@JSONField(format = "yyyy-MM-dd")
	private Date releaseTime = null;// 解约时间
	@Column(name = "release_type")
	private String releaseType;// 解约类型 字典 如 到期解约 会员解约等
	@Transient
	private String releaseTypeName;// 解约类型 字典 如 到期解约 会员解约等
	private String releaseItemId;// 解约记录ID
	private String releaseRemarks;// 解约备注
	private Date createTime;// 创建时间
	private String createUser;// 创建人
	private String deleteFlg;// 是否删除 0 否 1 是
	private String signStatus; // 签约状态
	// 上传相关字段
	private String dataSource;// 数据来源 1平台 2平板 3手机
	private String dataSourceNo;// 数据来源唯一标志
	private String importDeviceNum;// 导入设备号
	private Date importTime;// 导入时间
	private String importUser;// 导入人
	private String importIp;// 导入IP
	private String synId;// 同步ID
	private Date synTime;// 同步时间
	private String synFlg = "0";// 是否同步 0 否 1 是
	
	private SignItemDto signItem;
	private SignLogDto signLog;
	// 签约成员 一对多
	private List<SignCustomerDto> signCustomerList;
	// 签约周期
	private List<SignRenewDto> signRenewList;
	//签约复查
	private List<SignRecordDto> signRecordList;
	
	public String getDataSource() {
		return dataSource;
	}

	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}

	public String getDataSourceNo() {
		return dataSourceNo;
	}

	public void setDataSourceNo(String dataSourceNo) {
		this.dataSourceNo = dataSourceNo;
	}

	public String getImportDeviceNum() {
		return importDeviceNum;
	}

	public void setImportDeviceNum(String importDeviceNum) {
		this.importDeviceNum = importDeviceNum;
	}

	public Date getImportTime() {
		return importTime;
	}

	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}

	public String getImportUser() {
		return importUser;
	}

	public void setImportUser(String importUser) {
		this.importUser = importUser;
	}

	public String getImportIp() {
		return importIp;
	}

	public void setImportIp(String importIp) {
		this.importIp = importIp;
	}

	public String getSynFlg() {
		return synFlg;
	}

	public void setSynFlg(String synFlg) {
		this.synFlg = synFlg;
	}

	public String getSynId() {
		return synId;
	}

	public void setSynId(String synId) {
		this.synId = synId;
	}

	public Date getSynTime() {
		return synTime;
	}

	public void setSynTime(Date synTime) {
		this.synTime = synTime;
	}

	public String getUpLoad() {
		return upLoad;
	}

	public void setUpLoad(String upLoad) {
		this.upLoad = upLoad;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSignItemId() {
		return signItemId;
	}

	public void setSignItemId(String signItemId) {
		this.signItemId = signItemId;
	}

	public String getSignType() {
		return signType;
	}

	public void setSignType(String signType) {
		this.signType = signType;
	}

	public String getFamilyId() {
		return familyId;
	}

	public void setFamilyId(String familyId) {
		this.familyId = familyId;
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getFamilyPhone() {
		return familyPhone;
	}

	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}

	public String getAdderss() {
		return adderss;
	}

	public void setAdderss(String adderss) {
		this.adderss = adderss;
	}

	public String getHealthPhone() {
		return healthPhone;
	}

	public void setHealthPhone(String healthPhone) {
		this.healthPhone = healthPhone;
	}

	public String getTeamTelephone() {
		return teamTelephone;
	}

	public void setTeamTelephone(String teamTelephone) {
		this.teamTelephone = teamTelephone;
	}

	public String getResponsibleUser() {
		return responsibleUser;
	}

	public void setResponsibleUser(String responsibleUser) {
		this.responsibleUser = responsibleUser;
	}

	public Integer getCycleYear() {
		return cycleYear;
	}

	public void setCycleYear(Integer cycleYear) {
		this.cycleYear = cycleYear;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public String getRenewFlg() {
		return renewFlg;
	}

	public void setRenewFlg(String renewFlg) {
		this.renewFlg = renewFlg;
	}

	public Integer getRenewCycle() {
		return renewCycle;
	}

	public void setRenewCycle(Integer renewCycle) {
		this.renewCycle = renewCycle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getReleaseItemId() {
		return releaseItemId;
	}

	public void setReleaseItemId(String releaseItemId) {
		this.releaseItemId = releaseItemId;
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

	public String getSignUser() {
		return signUser;
	}

	public void setSignUser(String signUser) {
		this.signUser = signUser;
	}

	public String getReleaseUser() {
		return releaseUser;
	}

	public void setReleaseUser(String releaseUser) {
		this.releaseUser = releaseUser;
	}

	public String getSignCustomerIdcard() {
		return signCustomerIdcard;
	}

	public void setSignCustomerIdcard(String signCustomerIdcard) {
		this.signCustomerIdcard = signCustomerIdcard;
	}

	public String getReleaseCustomerIdcard() {
		return releaseCustomerIdcard;
	}

	public void setReleaseCustomerIdcard(String releaseCustomerIdcard) {
		this.releaseCustomerIdcard = releaseCustomerIdcard;
	}

	public Date getRenewEndTime() {
		return renewEndTime;
	}

	public void setRenewEndTime(Date renewEndTime) {
		this.renewEndTime = renewEndTime;
	}

	public String getReleaseRemarks() {
		return releaseRemarks;
	}

	public void setReleaseRemarks(String releaseRemarks) {
		this.releaseRemarks = releaseRemarks;
	}

	public String getReleaseType() {
		return releaseType;
	}

	public void setReleaseType(String releaseType) {
		this.releaseType = releaseType;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	public String getSignUserName() {
		return signUserName;
	}

	public String getSignCustomerName() {
		return signCustomerName;
//		return CacheUtils.getCustomerName(signCustomerIdcard);
	}

	public String getReleaseCustomerName() {
//		return CacheUtils.getCustomerName(releaseCustomerIdcard);
		return releaseCustomerName;
	}

	public String getReleaseUserName() {
//		return CacheUtils.getUserName(releaseUser);
		return releaseUserName;
	}

	public String getReleaseTypeName() {
//		return DictUtil.getDictValue("releaseType", releaseType);
		return releaseTypeName;
	}

	public String getFamilyNum() {
		return familyNum;
	}

	public void setFamilyNum(String familyNum) {
		this.familyNum = familyNum;
	}

	public String getSignStatus() {
		return signStatus;
	}

	public void setSignStatus(String signStatus) {
		this.signStatus = signStatus;
	}

	public void setSignUserName(String signUserName) {
		this.signUserName = signUserName;
	}

	public void setSignCustomerName(String signCustomerName) {
		this.signCustomerName = signCustomerName;
	}

	public void setReleaseCustomerName(String releaseCustomerName) {
		this.releaseCustomerName = releaseCustomerName;
	}

	public void setReleaseUserName(String releaseUserName) {
		this.releaseUserName = releaseUserName;
	}

	public void setReleaseTypeName(String releaseTypeName) {
		this.releaseTypeName = releaseTypeName;
	}

	public SignItemDto getSignItem() {
		return signItem;
	}

	public void setSignItem(SignItemDto signItem) {
		this.signItem = signItem;
	}

	public SignLogDto getSignLog() {
		return signLog;
	}

	public void setSignLog(SignLogDto signLog) {
		this.signLog = signLog;
	}

	public List<SignCustomerDto> getSignCustomerList() {
		return signCustomerList;
	}

	public void setSignCustomerList(List<SignCustomerDto> signCustomerList) {
		this.signCustomerList = signCustomerList;
	}

	public List<SignRenewDto> getSignRenewList() {
		return signRenewList;
	}

	public void setSignRenewList(List<SignRenewDto> signRenewList) {
		this.signRenewList = signRenewList;
	}

	public List<SignRecordDto> getSignRecordList() {
		return signRecordList;
	}

	public void setSignRecordList(List<SignRecordDto> signRecordList) {
		this.signRecordList = signRecordList;
	}

}
