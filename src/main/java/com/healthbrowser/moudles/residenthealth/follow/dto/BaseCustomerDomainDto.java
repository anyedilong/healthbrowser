package com.healthbrowser.moudles.residenthealth.follow.dto;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;


public class BaseCustomerDomainDto implements Serializable {
    
	private static final long serialVersionUID = 462626331331L;
	
	private String id;
    private String jlh;
    private String hzmc;// 患者名称
    private String xb;// 患者性别
    private String xbName;// 患者性别 value
    private String sfzh;// 身份证号
    @JSONField(format = "yyyy-MM-dd")
    private Date csrq;// 出生日期
    private String sj;// 联系方式
    private String rqlx; // 人群类型
    private String jkfl;// 健康分类Code值
    private String jkflName;// 健康分类名字
    private String rqlxName; // 人群类型 value
    private String tsrqlxText;//特殊人群类型
    private String xzz;// 现住址
	private String jtzz;// 家庭住址
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJlh() {
        return jlh;
    }

    public void setJlh(String jlh) {
        this.jlh = jlh;
    }

    public String getHzmc() {
        return hzmc;
    }

    public void setHzmc(String hzmc) {
        this.hzmc = hzmc;
    }

    public String getSfzh() {
        return sfzh;
    }

    public void setSfzh(String sfzh) {
        this.sfzh = sfzh;
    }

    public String getXb() {
        return xb;
    }

    public void setXb(String xb) {
        this.xb = xb;
    }

    public Date getCsrq() {
        return csrq;
    }

    public void setCsrq(Date csrq) {
        this.csrq = csrq;
    }

    public String getSj() {
        return sj;
    }

    public void setSj(String sj) {
        this.sj = sj;
    }

    public String getRqlx() {
        return rqlx;
    }

    public void setRqlx(String rqlx) {
        this.rqlx = rqlx;
    }

    public String getXbName() {
        return xbName;
    }

    public void setXbName(String xbName) {
        this.xbName = xbName;
    }

    public String getJkflName() {
        return jkflName;
    }

    public void setJkflName(String jkflName) {
        this.jkflName = jkflName;
    }

    public String getRqlxName() {
        return rqlxName;
    }

    public void setRqlxName(String rqlxName) {
        this.rqlxName = rqlxName;
    }

    public String getJkfl() {
        return jkfl;
    }

    public void setJkfl(String jkfl) {
        this.jkfl = jkfl;
    }

	public String getTsrqlxText() {
		return tsrqlxText;
	}

	public void setTsrqlxText(String tsrqlxText) {
		this.tsrqlxText = tsrqlxText;
	}

	public String getXzz() {
		return xzz;
	}

	public void setXzz(String xzz) {
		this.xzz = xzz;
	}

	public String getJtzz() {
		return jtzz;
	}

	public void setJtzz(String jtzz) {
		this.jtzz = jtzz;
	}

}
