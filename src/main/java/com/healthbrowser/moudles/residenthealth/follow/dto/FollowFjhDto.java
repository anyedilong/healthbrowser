package com.healthbrowser.moudles.residenthealth.follow.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * @ClassName: FollowFjh
 * @Description: 肺结核随访表
 * @author Administrator
 * @date 2019年8月1日
 */
public class FollowFjhDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 156496496496L;
	
	@Id
	private String id;
	private String sfzh;//身份证号
	private String hzbh;//患者编号
	@JSONField(format="yyyy-MM-dd")
	private Date sfsj;//随访时间
	private String ddry;//督导人员
	private String sffs;//随访方式
	private String zlyx;//治疗月序
	private String zzjtz;//症状及体征
	private String qt;//其他
	private String xyl;//吸烟量
	private String xypl;//吸烟频率
	private String yjl;//饮酒量
	private String yjpl;//饮酒频率
	@JSONField(format="yyyy-MM-dd")
	private Date xcsfsj;//下次随访时间
	private String sfys;//随访医生
	private String hlfa;//化疗方案
	private String yyyf;//用药用法
	private String ypjx;//药品剂型
	private String lfycs;//漏服药次数
	private String ywblfy;//药物不良反应
	private String ywblfyms;//药物不良反应描述
	private String bfzhhbz;//并发症或合并症
	private String bfzhhbzms;//并发症或合并症描述
	@JSONField(format="yyyy-MM-dd")
	private Date tzzlsj;//停止治疗时间
	private String tzzlyy;//停止治疗原因
	private String yfshzcs;//应访视患者次数
	private String sjfscs;//实际访视次数
	private String yfycs;//应服药次数
	private String sjfycs;//实际服药次数
	private String fyl;//服药率
	private String pgys;//评估医生
	private String zzkb;//转诊科别
	private String zzyy;//转诊原因
	private String zzsfjg;//转诊两周内随访结果
	private String zzclyj;//转诊处理意见
	private String status="0";
	@JSONField(format="yyyy-MM-dd")
	private Date createTime;
	private String createUser;
	private String orgId;
	private String updateOrgId;
	private Date updateTime;
	private String updateUserId;

	private String dataSource;// 数据来源 1平台 2平板 3手机
	private String dataSourceNo;// 数据来源唯一标志
	private String importDeviceNum;// 导入设备号
	private Date importTime;// 导入时间
	private String importUser;// 导入人
	private String importIp;// 导入IP
	private String synFlg="0";// 是否同步 0 否 1 是
	private String synId;// 同步ID
	private Date synTime;// 同步时间

	private String updateFlg;// 同步是否修改
	
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
	public String getUpdateFlg() {
		return updateFlg;
	}
	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
	}
	public String getUpdateOrgId() {
		return updateOrgId;
	}
	public void setUpdateOrgId(String updateOrgId) {
		this.updateOrgId = updateOrgId;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getUpdateUserId() {
		return updateUserId;
	}
	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}
	public String getSynFlg() {
		return synFlg;
	}
	public void setSynFlg(String synFlg) {
		this.synFlg = synFlg;
	}
	public Date getSynTime() {
		return synTime;
	}
	public void setSynTime(Date synTime) {
		this.synTime = synTime;
	}
	public String getSynId() {
		return synId;
	}
	public void setSynId(String synId) {
		this.synId = synId;
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
	public String getOrgId() {
		return orgId;
	}
	public void setOrgId(String orgId) {
		this.orgId = orgId;
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
	public String getSfzh() {
		return sfzh;
	}
	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	public String getHzbh() {
		return hzbh;
	}
	public void setHzbh(String hzbh) {
		this.hzbh = hzbh;
	}
	public Date getSfsj() {
		return sfsj;
	}
	public void setSfsj(Date sfsj) {
		this.sfsj = sfsj;
	}
	public String getDdry() {
		return ddry;
	}
	public void setDdry(String ddry) {
		this.ddry = ddry;
	}
	public String getSffs() {
		return sffs;
	}
	public void setSffs(String sffs) {
		this.sffs = sffs;
	}
	public String getZlyx() {
		return zlyx;
	}
	public void setZlyx(String zlyx) {
		this.zlyx = zlyx;
	}
	public String getZzjtz() {
		return zzjtz;
	}
	public void setZzjtz(String zzjtz) {
		this.zzjtz = zzjtz;
	}
	public String getQt() {
		return qt;
	}
	public void setQt(String qt) {
		this.qt = qt;
	}
	public String getXyl() {
		return xyl;
	}
	public void setXyl(String xyl) {
		this.xyl = xyl;
	}
	public String getXypl() {
		return xypl;
	}
	public void setXypl(String xypl) {
		this.xypl = xypl;
	}
	public String getYjl() {
		return yjl;
	}
	public void setYjl(String yjl) {
		this.yjl = yjl;
	}
	public String getYjpl() {
		return yjpl;
	}
	public void setYjpl(String yjpl) {
		this.yjpl = yjpl;
	}
	public Date getXcsfsj() {
		return xcsfsj;
	}
	public void setXcsfsj(Date xcsfsj) {
		this.xcsfsj = xcsfsj;
	}
	public String getSfys() {
		return sfys;
	}
	public void setSfys(String sfys) {
		this.sfys = sfys;
	}
	public String getHlfa() {
		return hlfa;
	}
	public void setHlfa(String hlfa) {
		this.hlfa = hlfa;
	}
	public String getYyyf() {
		return yyyf;
	}
	public void setYyyf(String yyyf) {
		this.yyyf = yyyf;
	}
	public String getYpjx() {
		return ypjx;
	}
	public void setYpjx(String ypjx) {
		this.ypjx = ypjx;
	}
	public String getLfycs() {
		return lfycs;
	}
	public void setLfycs(String lfycs) {
		this.lfycs = lfycs;
	}
	public String getYwblfy() {
		return ywblfy;
	}
	public void setYwblfy(String ywblfy) {
		this.ywblfy = ywblfy;
	}
	public String getYwblfyms() {
		return ywblfyms;
	}
	public void setYwblfyms(String ywblfyms) {
		this.ywblfyms = ywblfyms;
	}
	public String getBfzhhbz() {
		return bfzhhbz;
	}
	public void setBfzhhbz(String bfzhhbz) {
		this.bfzhhbz = bfzhhbz;
	}
	public String getBfzhhbzms() {
		return bfzhhbzms;
	}
	public void setBfzhhbzms(String bfzhhbzms) {
		this.bfzhhbzms = bfzhhbzms;
	}
	public Date getTzzlsj() {
		return tzzlsj;
	}
	public void setTzzlsj(Date tzzlsj) {
		this.tzzlsj = tzzlsj;
	}
	public String getTzzlyy() {
		return tzzlyy;
	}
	public void setTzzlyy(String tzzlyy) {
		this.tzzlyy = tzzlyy;
	}
	public String getYfshzcs() {
		return yfshzcs;
	}
	public void setYfshzcs(String yfshzcs) {
		this.yfshzcs = yfshzcs;
	}
	public String getSjfscs() {
		return sjfscs;
	}
	public void setSjfscs(String sjfscs) {
		this.sjfscs = sjfscs;
	}
	public String getYfycs() {
		return yfycs;
	}
	public void setYfycs(String yfycs) {
		this.yfycs = yfycs;
	}
	public String getSjfycs() {
		return sjfycs;
	}
	public void setSjfycs(String sjfycs) {
		this.sjfycs = sjfycs;
	}
	public String getFyl() {
		return fyl;
	}
	public void setFyl(String fyl) {
		this.fyl = fyl;
	}
	public String getPgys() {
		return pgys;
	}
	public void setPgys(String pgys) {
		this.pgys = pgys;
	}
	public String getZzkb() {
		return zzkb;
	}
	public void setZzkb(String zzkb) {
		this.zzkb = zzkb;
	}
	public String getZzyy() {
		return zzyy;
	}
	public void setZzyy(String zzyy) {
		this.zzyy = zzyy;
	}
	public String getZzsfjg() {
		return zzsfjg;
	}
	public void setZzsfjg(String zzsfjg) {
		this.zzsfjg = zzsfjg;
	}
	public String getZzclyj() {
		return zzclyj;
	}
	public void setZzclyj(String zzclyj) {
		this.zzclyj = zzclyj;
	}
	
	
	
	

}
