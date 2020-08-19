package com.healthbrowser.moudles.residenthealth.follow.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @ClassName: FollowEtXse
 * @Description: 随访-儿童-新生儿
 * @author Administrator
 * @date 2019年8月13日
 */
public class FollowEtXseDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 14969219191L;
	
	@Id
	private String id;//
	private String etbh;// 儿童编号
	private String dah;// 档案号
	private String sfzh;// sfzh
	private String xb;// 性别
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date csrq;// 出生日期
	private String jtzz;// 家庭住址
	private String fqm;// 父亲名
	private String fqgz;// 父亲工作
	private String fqdh;// 父亲电话
	private Date fqcsrq;// 父亲出生日期
	private String mqm;// 母亲名
	private String mqgz;// 母亲工作
	private String mqdh;// 母亲电话
	private Date mqcsrq;// 母亲出生日期
	private String csyz;// 出生孕周
	private String mqrsqhbqk;// 母亲妊娠期患病情况
	private String rsqqthbms;// 妊娠期其他患病描述
	private String zcjgmc;// 助产机构名称
	private String csqk;// 出生情况
	private String qtcsqk;// 其他出生情况
	@Column(length = 1)
	private String xsezx;// 新生儿窒息		1无 2有
	private String apgarpf;// apgar评分
	private String sfjx;// 是否畸形		1无 2有
	private String jxms;// 有畸形描述
	private String xsetlsc;// 新生儿听力筛查
	private String xsejbsc;// 新生儿疾病筛查
	private String qtjbms;// 其他疾病描述
	@Column(precision = 6, scale = 2)
	private String cstz;// 出生体重
	@Column(precision = 6, scale = 2)
	private String mqtz;// 目前体重
	@Column(precision = 5, scale = 2)
	private String cssc;// 出生身长
	@Column(length = 1)
	private String wyfs;// 喂养方式
	private String cnl;// 吃奶量
	private String cncs;// 吃奶次数
	private String ot;// 呕吐
	private String db;// 大便
	private String dbcs;// 大便次数
	@Column(precision = 4, scale = 1)
	private String tw;// 体温
	private String ml;// 脉率
	private String hxpl;// 呼吸频率
	private String ms;// 面色
	private String qtms;// 其他面色
	private String hd;// 黄疸
	@Column(precision = 5, scale = 2)
	private String zx;// 左囟
	@Column(precision = 5, scale = 2)
	private String yx;// 右囟
	private String xm;// 囟门
	private String xmqt;// 囟门其他
	private String ywg;// 眼外观
	private String ywgycms;// 眼外观异常描述
	private String szhdd;// 四肢活动度
	private String szhddycms;// 四肢活动度异常描述
	private String ewg;// 耳外观
	private String ewgms;// 耳外观异常描述
	private String jbbk;// 颈部包块
	private String jbbkycms;// 颈部包块异常描述
	private String bz;// 鼻子
	private String bycms;// 鼻异常描述
	private String pf;// 皮肤
	private String pfqt;// 皮肤异常描述
	private String kq;// 口腔
	private String kqycms;// 口腔异常描述
	private String gm;// 肛门
	private String gmycms;// 肛门异常描述
	private String xftz;// 心肺听诊
	private String xftzms;// 心肺听诊描述
	private String wszq;// 外生殖器
	private String wszqycms;// 外生殖器异常描述
	private String fbcz;// 腹部触诊
	private String fbczycms;// 腹部触诊异常描述
	private String jz;// 脊柱
	private String jzycms;// 脊柱异常描述
	private String qd;// 脐带
	private String qdqt;// 其他脐带
	private String zzjy;// 转诊建议
	private String zzyy;// 转诊原因
	private String jgjks;// 机构及科室
	private String zd;// 指导
	private Date bcsfrq;// 本次随访日期
	private String xcsfdd;// 下次随访地点
	private Date xcsfrq;// 下次随访日期
	@Column(name = "sfysqm")
	private String sfysqm;// 随访医生签名
	private String chest;//胸部
	private String chestValue;//胸部描述
	private String zdms;//指导描述
	private String fqsfzh;
	private String mqsfzh;
	@Column(name = "jbr")
	private String jbr;// 建表人
	private Date jbrq;// 建表日期
	@Column(name = "scxgr")
	private String scxgr;// 上次修改人
	private Date scxgrq;// 上次修改日期
	private String tjbh;// 体检编号
	private String sfsc;// 是否删除
	private String dataSource;// 数据来源 1平台 2平板 3手机
	private String dataSourceNo;// 数据来源唯一标志
	private String importDeviceNum;// 导入设备号
	private Date importTime;// 导入时间
	private String importUser;// 导入人
	private String importIp;// 导入IP
	private String synFlg = "0";// 是否同步 0 否 1 是
	private String synId;// 同步ID
	private Date synTime;// 同步时间

	private String updateFlg;
	

	public String getChestValue() {
		return chestValue;
	}

	public void setChestValue(String chestValue) {
		this.chestValue = chestValue;
	}

	public String getFqsfzh() {
		return fqsfzh;
	}

	public void setFqsfzh(String fqsfzh) {
		this.fqsfzh = fqsfzh;
	}

	public String getMqsfzh() {
		return mqsfzh;
	}

	public void setMqsfzh(String mqsfzh) {
		this.mqsfzh = mqsfzh;
	}

	public String getChest() {
		return chest;
	}

	public void setChest(String chest) {
		this.chest = chest;
	}

	public String getZdms() {
		return zdms;
	}

	public void setZdms(String zdms) {
		this.zdms = zdms;
	}

	public String getUpdateFlg() {
		return updateFlg;
	}

	public void setUpdateFlg(String updateFlg) {
		this.updateFlg = updateFlg;
	}

	public String getDb() {
		return this.db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getDbcs() {
		return this.dbcs;
	}

	public void setDbcs(String dbcs) {
		this.dbcs = dbcs;
	}

	public String getTw() {
		return this.tw;
	}

	public void setTw(String tw) {
		this.tw = tw;
	}

	public String getMl() {
		return this.ml;
	}

	public void setMl(String ml) {
		this.ml = ml;
	}

	public String getHxpl() {
		return this.hxpl;
	}

	public void setHxpl(String hxpl) {
		this.hxpl = hxpl;
	}

	public String getMs() {
		return this.ms;
	}

	public void setMs(String ms) {
		this.ms = ms;
	}

	public String getQtms() {
		return this.qtms;
	}

	public void setQtms(String qtms) {
		this.qtms = qtms;
	}

	public String getHd() {
		return this.hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}

	public String getZx() {
		return this.zx;
	}

	public void setZx(String zx) {
		this.zx = zx;
	}

	public String getYx() {
		return this.yx;
	}

	public void setYx(String yx) {
		this.yx = yx;
	}

	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getXmqt() {
		return this.xmqt;
	}

	public void setXmqt(String xmqt) {
		this.xmqt = xmqt;
	}

	public String getYwg() {
		return this.ywg;
	}

	public void setYwg(String ywg) {
		this.ywg = ywg;
	}

	public String getYwgycms() {
		return this.ywgycms;
	}

	public void setYwgycms(String ywgycms) {
		this.ywgycms = ywgycms;
	}

	public String getSzhdd() {
		return this.szhdd;
	}

	public void setSzhdd(String szhdd) {
		this.szhdd = szhdd;
	}

	public String getSzhddycms() {
		return this.szhddycms;
	}

	public void setSzhddycms(String szhddycms) {
		this.szhddycms = szhddycms;
	}

	public String getEwg() {
		return this.ewg;
	}

	public void setEwg(String ewg) {
		this.ewg = ewg;
	}

	public String getEwgms() {
		return this.ewgms;
	}

	public void setEwgms(String ewgms) {
		this.ewgms = ewgms;
	}

	public String getJbbk() {
		return this.jbbk;
	}

	public void setJbbk(String jbbk) {
		this.jbbk = jbbk;
	}

	public String getJbbkycms() {
		return this.jbbkycms;
	}

	public void setJbbkycms(String jbbkycms) {
		this.jbbkycms = jbbkycms;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getBycms() {
		return this.bycms;
	}

	public void setBycms(String bycms) {
		this.bycms = bycms;
	}

	public String getPf() {
		return this.pf;
	}

	public void setPf(String pf) {
		this.pf = pf;
	}

	public String getPfqt() {
		return this.pfqt;
	}

	public void setPfqt(String pfqt) {
		this.pfqt = pfqt;
	}

	public String getKq() {
		return this.kq;
	}

	public void setKq(String kq) {
		this.kq = kq;
	}

	public String getKqycms() {
		return this.kqycms;
	}

	public void setKqycms(String kqycms) {
		this.kqycms = kqycms;
	}

	public String getGm() {
		return this.gm;
	}

	public void setGm(String gm) {
		this.gm = gm;
	}

	public String getGmycms() {
		return this.gmycms;
	}

	public void setGmycms(String gmycms) {
		this.gmycms = gmycms;
	}

	public String getXftz() {
		return this.xftz;
	}

	public void setXftz(String xftz) {
		this.xftz = xftz;
	}

	public String getXftzms() {
		return this.xftzms;
	}

	public void setXftzms(String xftzms) {
		this.xftzms = xftzms;
	}

	public String getWszq() {
		return this.wszq;
	}

	public void setWszq(String wszq) {
		this.wszq = wszq;
	}

	public String getWszqycms() {
		return this.wszqycms;
	}

	public void setWszqycms(String wszqycms) {
		this.wszqycms = wszqycms;
	}

	public String getFbcz() {
		return this.fbcz;
	}

	public void setFbcz(String fbcz) {
		this.fbcz = fbcz;
	}

	public String getFbczycms() {
		return this.fbczycms;
	}

	public void setFbczycms(String fbczycms) {
		this.fbczycms = fbczycms;
	}

	public String getJz() {
		return this.jz;
	}

	public void setJz(String jz) {
		this.jz = jz;
	}

	public String getJzycms() {
		return this.jzycms;
	}

	public void setJzycms(String jzycms) {
		this.jzycms = jzycms;
	}

	public String getQd() {
		return this.qd;
	}

	public void setQd(String qd) {
		this.qd = qd;
	}

	public String getQdqt() {
		return this.qdqt;
	}

	public void setQdqt(String qdqt) {
		this.qdqt = qdqt;
	}

	public String getZzjy() {
		return this.zzjy;
	}

	public void setZzjy(String zzjy) {
		this.zzjy = zzjy;
	}

	public String getZzyy() {
		return this.zzyy;
	}

	public void setZzyy(String zzyy) {
		this.zzyy = zzyy;
	}

	public String getJgjks() {
		return this.jgjks;
	}

	public void setJgjks(String jgjks) {
		this.jgjks = jgjks;
	}

	public String getZd() {
		return this.zd;
	}

	public void setZd(String zd) {
		this.zd = zd;
	}

	public Date getBcsfrq() {
		return this.bcsfrq;
	}

	public void setBcsfrq(Date bcsfrq) {
		this.bcsfrq = bcsfrq;
	}

	public String getXcsfdd() {
		return this.xcsfdd;
	}

	public void setXcsfdd(String xcsfdd) {
		this.xcsfdd = xcsfdd;
	}

	public Date getXcsfrq() {
		return this.xcsfrq;
	}

	public void setXcsfrq(Date xcsfrq) {
		this.xcsfrq = xcsfrq;
	}

	public String getSfysqm() {
		return this.sfysqm;
	}

	public void setSfysqm(String sfysqm) {
		this.sfysqm = sfysqm;
	}

	public String getJbr() {
		return this.jbr;
	}

	public void setJbr(String jbr) {
		this.jbr = jbr;
	}

	public Date getJbrq() {
		return this.jbrq;
	}

	public void setJbrq(Date jbrq) {
		this.jbrq = jbrq;
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

	public String getSfsc() {
		return this.sfsc;
	}

	public void setSfsc(String sfsc) {
		this.sfsc = sfsc;
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

	public String getSynFlg() {
		return this.synFlg;
	}

	public void setSynFlg(String synFlg) {
		this.synFlg = synFlg;
	}

	public String getTjbh() {
		return this.tjbh;
	}

	public void setTjbh(String tjbh) {
		this.tjbh = tjbh;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEtbh() {
		return this.etbh;
	}

	public void setEtbh(String etbh) {
		this.etbh = etbh;
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

	public String getXb() {
		return this.xb;
	}

	public void setXb(String xb) {
		this.xb = xb;
	}

	public Date getCsrq() {
		return this.csrq;
	}

	public void setCsrq(Date csrq) {
		this.csrq = csrq;
	}

	public String getJtzz() {
		return this.jtzz;
	}

	public void setJtzz(String jtzz) {
		this.jtzz = jtzz;
	}

	public String getFqm() {
		return this.fqm;
	}

	public void setFqm(String fqm) {
		this.fqm = fqm;
	}

	public String getFqgz() {
		return this.fqgz;
	}

	public void setFqgz(String fqgz) {
		this.fqgz = fqgz;
	}

	public String getFqdh() {
		return this.fqdh;
	}

	public void setFqdh(String fqdh) {
		this.fqdh = fqdh;
	}

	public Date getFqcsrq() {
		return this.fqcsrq;
	}

	public void setFqcsrq(Date fqcsrq) {
		this.fqcsrq = fqcsrq;
	}

	public String getMqm() {
		return this.mqm;
	}

	public void setMqm(String mqm) {
		this.mqm = mqm;
	}

	public String getMqgz() {
		return this.mqgz;
	}

	public void setMqgz(String mqgz) {
		this.mqgz = mqgz;
	}

	public String getMqdh() {
		return this.mqdh;
	}

	public void setMqdh(String mqdh) {
		this.mqdh = mqdh;
	}

	public Date getMqcsrq() {
		return this.mqcsrq;
	}

	public void setMqcsrq(Date mqcsrq) {
		this.mqcsrq = mqcsrq;
	}

	public String getCsyz() {
		return this.csyz;
	}

	public void setCsyz(String csyz) {
		this.csyz = csyz;
	}

	public String getMqrsqhbqk() {
		return this.mqrsqhbqk;
	}

	public void setMqrsqhbqk(String mqrsqhbqk) {
		this.mqrsqhbqk = mqrsqhbqk;
	}

	public String getRsqqthbms() {
		return this.rsqqthbms;
	}

	public void setRsqqthbms(String rsqqthbms) {
		this.rsqqthbms = rsqqthbms;
	}

	public String getZcjgmc() {
		return this.zcjgmc;
	}

	public void setZcjgmc(String zcjgmc) {
		this.zcjgmc = zcjgmc;
	}

	public String getCsqk() {
		return this.csqk;
	}

	public void setCsqk(String csqk) {
		this.csqk = csqk;
	}

	public String getQtcsqk() {
		return this.qtcsqk;
	}

	public void setQtcsqk(String qtcsqk) {
		this.qtcsqk = qtcsqk;
	}

	public String getXsezx() {
		return this.xsezx;
	}

	public void setXsezx(String xsezx) {
		this.xsezx = xsezx;
	}

	public String getApgarpf() {
		return this.apgarpf;
	}

	public void setApgarpf(String apgarpf) {
		this.apgarpf = apgarpf;
	}

	public String getSfjx() {
		return this.sfjx;
	}

	public void setSfjx(String sfjx) {
		this.sfjx = sfjx;
	}

	public String getJxms() {
		return this.jxms;
	}

	public void setJxms(String jxms) {
		this.jxms = jxms;
	}

	public String getXsetlsc() {
		return this.xsetlsc;
	}

	public void setXsetlsc(String xsetlsc) {
		this.xsetlsc = xsetlsc;
	}

	public String getXsejbsc() {
		return this.xsejbsc;
	}

	public void setXsejbsc(String xsejbsc) {
		this.xsejbsc = xsejbsc;
	}

	public String getQtjbms() {
		return this.qtjbms;
	}

	public void setQtjbms(String qtjbms) {
		this.qtjbms = qtjbms;
	}

	public String getCstz() {
		return this.cstz;
	}

	public void setCstz(String cstz) {
		this.cstz = cstz;
	}

	public String getMqtz() {
		return this.mqtz;
	}

	public void setMqtz(String mqtz) {
		this.mqtz = mqtz;
	}

	public String getCssc() {
		return this.cssc;
	}

	public void setCssc(String cssc) {
		this.cssc = cssc;
	}

	public String getWyfs() {
		return this.wyfs;
	}

	public void setWyfs(String wyfs) {
		this.wyfs = wyfs;
	}

	public String getCnl() {
		return this.cnl;
	}

	public void setCnl(String cnl) {
		this.cnl = cnl;
	}

	public String getCncs() {
		return this.cncs;
	}

	public void setCncs(String cncs) {
		this.cncs = cncs;
	}

	public String getOt() {
		return this.ot;
	}

	public void setOt(String ot) {
		this.ot = ot;
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
