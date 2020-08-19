package com.healthbrowser.moudles.residenthealth.follow.dto;

import java.io.Serializable;

import javax.persistence.Id;

/**
 * @ClassName: FollowLnrZyyglJg
 * @Description: 随访-老年人-中医药管理-结果
 * @author Administrator
 * @date 2019年8月2日
 */
public class FollowLnrZyyglJgDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = 262616161;
	
	@Id
	private String id;//
	private String tjbh;// 体检编号
	private String ywbh;// 药物编号
	private String phz;// 平和质
	private String qxz;// 气虚质
	private String yxuz;// 阳虚质
	private String yxz;// 阴虚质
	private String tsz;// 痰湿质
	private String srz;// 湿热质
	private String xyz;// 血瘀质
	private String qyz;// 气郁质
	private String tbz;// 特秉质
	private String phzdf;// 平和质得分
	private String qxzdf;// 气虚质评分
	private String yxuzdf;// 阳虚质评分
	private String yxzdf;// 阴虚质评分
	private String tszpf;// 痰湿质评分
	private String srzpf;// 湿热质评分
	private String xyzpf;// 血瘀质评分
	private String qyzpf;// 气郁质评分
	private String tbzpf;// 特秉质评分
	private String phzjy="2";// 平和质建议
	private String qxzjy="2";// 气虚质建议
	private String yxuzjy="2";// 阳虚质建议
	private String yxzjy="2";// 阴虚质建议
	private String tszjy="2";// 痰湿质建议
	private String srzjy="2";// 湿热质建议
	private String xyzjy="2";// 血瘀质建议
	private String qyzjy="2";// 气郁质建议
	private String tbzjy="2";// 特秉质建议
	private String phzjyms;// 平和质建议描述
	private String qxzjyms;// 气虚质建议描述
	private String yxuzjyms;// 阳虚质建议描述
	private String yxzjyms;// 阴虚质简要描述
	private String tszjyms;// 痰湿质建议描述
	private String srzjyms;// 湿热质建议描述
	private String xyzjyms;// 血瘀质建议描述
	private String qyzjyms;// 气郁质建议描述
	private String tbzjyms;// 特秉质建议描述
	private String sfsc;// 是否删除
	private String sfzh;// 身份证号

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

	public String getYwbh() {
		return this.ywbh;
	}

	public void setYwbh(String ywbh) {
		this.ywbh = ywbh;
	}

	public String getPhz() {
		return this.phz;
	}

	public void setPhz(String phz) {
		this.phz = phz;
	}

	public String getQxz() {
		return this.qxz;
	}

	public void setQxz(String qxz) {
		this.qxz = qxz;
	}

	public String getYxuz() {
		return this.yxuz;
	}

	public void setYxuz(String yxuz) {
		this.yxuz = yxuz;
	}

	public String getYxz() {
		return this.yxz;
	}

	public void setYxz(String yxz) {
		this.yxz = yxz;
	}

	public String getTsz() {
		return this.tsz;
	}

	public void setTsz(String tsz) {
		this.tsz = tsz;
	}

	public String getSrz() {
		return this.srz;
	}

	public void setSrz(String srz) {
		this.srz = srz;
	}

	public String getXyz() {
		return this.xyz;
	}

	public void setXyz(String xyz) {
		this.xyz = xyz;
	}

	public String getQyz() {
		return this.qyz;
	}

	public void setQyz(String qyz) {
		this.qyz = qyz;
	}

	public String getTbz() {
		return this.tbz;
	}

	public void setTbz(String tbz) {
		this.tbz = tbz;
	}

	public String getPhzdf() {
		return this.phzdf;
	}

	public void setPhzdf(String phzdf) {
		this.phzdf = phzdf;
	}

	public String getQxzdf() {
		return this.qxzdf;
	}

	public void setQxzdf(String qxzdf) {
		this.qxzdf = qxzdf;
	}

	public String getYxuzdf() {
		return this.yxuzdf;
	}

	public void setYxuzdf(String yxuzdf) {
		this.yxuzdf = yxuzdf;
	}

	public String getYxzdf() {
		return this.yxzdf;
	}

	public void setYxzdf(String yxzdf) {
		this.yxzdf = yxzdf;
	}

	public String getTszpf() {
		return this.tszpf;
	}

	public void setTszpf(String tszpf) {
		this.tszpf = tszpf;
	}

	public String getSrzpf() {
		return this.srzpf;
	}

	public void setSrzpf(String srzpf) {
		this.srzpf = srzpf;
	}

	public String getXyzpf() {
		return this.xyzpf;
	}

	public void setXyzpf(String xyzpf) {
		this.xyzpf = xyzpf;
	}

	public String getQyzpf() {
		return this.qyzpf;
	}

	public void setQyzpf(String qyzpf) {
		this.qyzpf = qyzpf;
	}

	public String getTbzpf() {
		return this.tbzpf;
	}

	public void setTbzpf(String tbzpf) {
		this.tbzpf = tbzpf;
	}

	public String getPhzjy() {
		return this.phzjy;
	}

	public void setPhzjy(String phzjy) {
		this.phzjy = phzjy;
	}

	public String getQxzjy() {
		return this.qxzjy;
	}

	public void setQxzjy(String qxzjy) {
		this.qxzjy = qxzjy;
	}

	public String getYxuzjy() {
		return this.yxuzjy;
	}

	public void setYxuzjy(String yxuzjy) {
		this.yxuzjy = yxuzjy;
	}

	public String getYxzjy() {
		return this.yxzjy;
	}

	public void setYxzjy(String yxzjy) {
		this.yxzjy = yxzjy;
	}

	public String getTszjy() {
		return this.tszjy;
	}

	public void setTszjy(String tszjy) {
		this.tszjy = tszjy;
	}

	public String getSrzjy() {
		return this.srzjy;
	}

	public void setSrzjy(String srzjy) {
		this.srzjy = srzjy;
	}

	public String getXyzjy() {
		return this.xyzjy;
	}

	public void setXyzjy(String xyzjy) {
		this.xyzjy = xyzjy;
	}

	public String getQyzjy() {
		return this.qyzjy;
	}

	public void setQyzjy(String qyzjy) {
		this.qyzjy = qyzjy;
	}

	public String getTbzjy() {
		return this.tbzjy;
	}

	public void setTbzjy(String tbzjy) {
		this.tbzjy = tbzjy;
	}

	public String getPhzjyms() {
		return this.phzjyms;
	}

	public void setPhzjyms(String phzjyms) {
		this.phzjyms = phzjyms;
	}

	public String getQxzjyms() {
		return this.qxzjyms;
	}

	public void setQxzjyms(String qxzjyms) {
		this.qxzjyms = qxzjyms;
	}

	public String getYxuzjyms() {
		return this.yxuzjyms;
	}

	public void setYxuzjyms(String yxuzjyms) {
		this.yxuzjyms = yxuzjyms;
	}

	public String getYxzjyms() {
		return this.yxzjyms;
	}

	public void setYxzjyms(String yxzjyms) {
		this.yxzjyms = yxzjyms;
	}

	public String getTszjyms() {
		return this.tszjyms;
	}

	public void setTszjyms(String tszjyms) {
		this.tszjyms = tszjyms;
	}

	public String getSrzjyms() {
		return this.srzjyms;
	}

	public void setSrzjyms(String srzjyms) {
		this.srzjyms = srzjyms;
	}

	public String getXyzjyms() {
		return this.xyzjyms;
	}

	public void setXyzjyms(String xyzjyms) {
		this.xyzjyms = xyzjyms;
	}

	public String getQyzjyms() {
		return this.qyzjyms;
	}

	public void setQyzjyms(String qyzjyms) {
		this.qyzjyms = qyzjyms;
	}

	public String getTbzjyms() {
		return this.tbzjyms;
	}

	public void setTbzjyms(String tbzjyms) {
		this.tbzjyms = tbzjyms;
	}

	public String getSfsc() {
		return this.sfsc;
	}

	public void setSfsc(String sfsc) {
		this.sfsc = sfsc;
	}

	public String getSfzh() {
		return this.sfzh;
	}

	public void setSfzh(String sfzh) {
		this.sfzh = sfzh;
	}
	
}
