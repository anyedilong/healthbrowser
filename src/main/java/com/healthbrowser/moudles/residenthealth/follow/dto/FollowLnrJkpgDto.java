package com.healthbrowser.moudles.residenthealth.follow.dto;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;


/**
 * @ClassName: FollowLnrJkpg
 * @Description: 随访-老年人-健康评估
 * @author Administrator
 * @date 2019年8月2日
 */
public class FollowLnrJkpgDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 19494949L;
	
	@Id
	private String id;//
	private String yhbh;// 用户编号
	private String tjbh;// 体检编号
	private String dah;// 档案号
	private String sfzh;// 身份证号
	private String jc;// 进餐
	private String sx;// 梳洗
	private String cy;// 穿衣
	private String rc;// 如厕
	private String hd;// 活动
	private String jcdf;//简餐得分
	private String sxdf;//梳洗得分
	private String cydf;//穿衣得分
	private String  rcdf;//如厕得分
	private String hddf;//活动得分
	private String zdf;// 总得分
	private Date xcsfrq;// 下次随访日期
	@Column(name = "sfys")
	private String sfys;// 随访医生

	private Date xcsfbd;// 下次随访变动
	private String cjr;// 建表人
	private Date cjrq;// 建表日期
	private String scxgr;// 上次修改人
	private Date scxgrq;// 上次修改日期
	private Date sfrq;// 随访日期

	private String dataSource;// 数据来源 1平台 2平板 3手机
	private String dataSourceNo;// 数据来源唯一标志
	private String importDeviceNum;// 导入设备号
	private Date importTime;// 导入时间
	private String importUser;// 导入人
	private String importIp;// 导入IP
	private String synFlg="0";// 是否同步 0 否 1 是
	private String synId;// 同步ID
	private Date synTime;// 同步时间
	
	private String updateFlg;

	public String getJcdf() {
		return jcdf;
	}

	public void setJcdf(String jcdf) {
		this.jcdf = jcdf;
	}

	public String getSxdf() {
		return sxdf;
	}

	public void setSxdf(String sxdf) {
		this.sxdf = sxdf;
	}

	public String getCydf() {
		return cydf;
	}

	public void setCydf(String cydf) {
		this.cydf = cydf;
	}

	public String getRcdf() {
		return rcdf;
	}

	public void setRcdf(String rcdf) {
		this.rcdf = rcdf;
	}

	public String getHddf() {
		return hddf;
	}

	public void setHddf(String hddf) {
		this.hddf = hddf;
	}

	public String getUpdateFlg() {
		return updateFlg;
	}

	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYhbh() {
		return this.yhbh;
	}

	public void setYhbh(String yhbh) {
		this.yhbh = yhbh;
	}

	public String getTjbh() {
		return this.tjbh;
	}

	public void setTjbh(String tjbh) {
		this.tjbh = tjbh;
	}

	public String getDah() {
		return this.dah;
	}

	public void setDah(String dah) {
		this.dah = dah;
	}

	public String getSfzh() {
		return this.sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getJc() {
		return this.jc;
	}

	public void setJc(String jc) {
		this.jc = jc;
	}

	public String getSx() {
		return this.sx;
	}

	public void setSx(String sx) {
		this.sx = sx;
	}

	public String getCy() {
		return this.cy;
	}

	public void setCy(String cy) {
		this.cy = cy;
	}

	public String getRc() {
		return this.rc;
	}

	public void setRc(String rc) {
		this.rc = rc;
	}

	public String getHd() {
		return this.hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}

	public String getZdf() {
		return this.zdf;
	}

	public void setZdf(String zdf) {
		this.zdf = zdf;
	}

	public Date getXcsfrq() {
		return this.xcsfrq;
	}

	public void setXcsfrq(Date xcsfrq) {
		this.xcsfrq = xcsfrq;
	}

	public String getSfys() {
		return this.sfys;
	}

	public void setSfys(String sfys) {
		this.sfys = sfys;
	}

	public Date getXcsfbd() {
		return this.xcsfbd;
	}

	public void setXcsfbd(Date xcsfbd) {
		this.xcsfbd = xcsfbd;
	}

	public String getCjr() {
		return this.cjr;
	}

	public void setCjr(String cjr) {
		this.cjr = cjr;
	}

	public Date getCjrq() {
		return this.cjrq;
	}

	public void setCjrq(Date cjrq) {
		this.cjrq = cjrq;
	}

	public String getScxgr() {
		return this.scxgr;
	}

	public void setScxgr(String scxgr) {
		this.scxgr = scxgr;
	}

	public Date getScxgrq() {
		return this.scxgrq;
	}

	public void setScxgrq(Date scxgrq) {
		this.scxgrq = scxgrq;
	}

	public String getImportDeviceNum() {
		return this.importDeviceNum;
	}

	public void setImportDeviceNum(String importDeviceNum) {
		this.importDeviceNum = importDeviceNum;
	}

	public Date getImportTime() {
		return this.importTime;
	}

	public void setImportTime(Date importTime) {
		this.importTime = importTime;
	}

	public String getImportUser() {
		return this.importUser;
	}

	public void setImportUser(String importUser) {
		this.importUser = importUser;
	}

	public String getImportIp() {
		return this.importIp;
	}

	public void setImportIp(String importIp) {
		this.importIp = importIp;
	}

	public Date getSfrq() {
		return this.sfrq;
	}

	public void setSfrq(Date sfrq) {
		this.sfrq = sfrq;
	}

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
}
