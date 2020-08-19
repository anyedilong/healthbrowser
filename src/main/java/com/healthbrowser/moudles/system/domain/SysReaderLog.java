package com.healthbrowser.moudles.system.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.alibaba.fastjson.annotation.JSONField;
import com.healthbrowser.moudles.common.domain.BaseDomain;

/**
 * 调阅日志表
 */
@Entity
@Table(name = "sys_reader_log")
public class SysReaderLog extends BaseDomain {

	private static final long serialVersionUID = 1123233346L;

	@Id
	private String id;// 内码
	@Column(name = "reader_name")
	private String readerName;// 调阅人
	private String name;// 居民名称
	@JSONField(format = "yyyy-MM-dd")
	private Date readerTime;// 调阅时间
	private String remark;//描述

	@Transient
	private String startTime;
	@Transient
	private String endTime;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReaderName() {
		return readerName;
	}

	public void setReaderName(String readerName) {
		this.readerName = readerName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getReaderTime() {
		return readerTime;
	}

	public void setReaderTime(Date readerTime) {
		this.readerTime = readerTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}


}
