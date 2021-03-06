package com.healthbrowser.moudles.residenthealth.follow.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;


/**
 * @ClassName: FollowGxySzmqyy
 * @Description: 高血压首诊---目前用药
 * @author Administrator
 * @date 2019年7月31日
 */
public class FollowGxySzmqyyDto extends BaseDto implements Serializable {

	/**  
	 * @Fields serialVersionUID : TODO 
	 */  
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String sfzh;//身份证号
	private String tjbh;//体检编号
	private String ym;//药名
	private String dcjl;//单次剂量
	private String dcdw;//单次单位
	private String yypc;//用药频次
	private String yf;//用法
	private String importDeviceNum;//导入设备号
	private Date importTime;//导入时间
	private String importUser;//导入人
	private String importIp;//导入ip
	
	
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
	public String getTjbh() {
		return tjbh;
	}
	public void setTjbh(String tjbh) {
		this.tjbh = tjbh;
	}
	public String getYm() {
		return ym;
	}
	public void setYm(String ym) {
		this.ym = ym;
	}
	public String getDcjl() {
		return dcjl;
	}
	public void setDcjl(String dcjl) {
		this.dcjl = dcjl;
	}
	public String getDcdw() {
		return dcdw;
	}
	public void setDcdw(String dcdw) {
		this.dcdw = dcdw;
	}
	public String getYypc() {
		return yypc;
	}
	public void setYypc(String yypc) {
		this.yypc = yypc;
	}
	public String getYf() {
		return yf;
	}
	public void setYf(String yf) {
		this.yf = yf;
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
	
}
