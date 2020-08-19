package com.healthbrowser.moudles.residenthealth.check.dto;

import javax.persistence.Id;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Jzs
 * @Description: 体检-接种史
 * @author Administrator
 * @date 2019年7月30日
 */
public class JzsDto implements Serializable {

	private static final long serialVersionUID = 394694964194L;
	
	@Id
	private String id;//
	private String tjbh;// 体检编号
	private String sfzh;// 身份证号
	private String ypmc;// 药名
	@JSONField(format="yyyy-MM-dd")
	private Date jzymrq;// 接种疫苗日期
	private String jzs;// 接种史
	private String tjid;

	private String tjdw;
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTjbh() {
		return this.tjbh;
	}

	public void setTjbh(String tjbh) {
		this.tjbh = tjbh;
	}

	public String getSfzh() {
		return this.sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}

	public String getYpmc() {
		return this.ypmc;
	}

	public void setYpmc(String ypmc) {
		this.ypmc = ypmc;
	}

	public Date getJzymrq() {
		return this.jzymrq;
	}

	public void setJzymrq(Date jzymrq) {
		this.jzymrq = jzymrq;
	}

	public String getJzs() {
		return this.jzs;
	}

	public void setJzs(String jzs) {
		this.jzs = jzs;
	}

	public String getTjid() {
		return tjid;
	}

	public void setTjid(String tjid) {
		this.tjid = tjid;
	}

	public String getTjdw() {
		return tjdw;
	}

	public void setTjdw(String tjdw) {
		this.tjdw = tjdw;
	}
}
