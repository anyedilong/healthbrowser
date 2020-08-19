package com.healthbrowser.moudles.residenthealth.sign.dto;

import java.io.Serializable;

import javax.persistence.Id;

public class SignItemAnnexDto implements Serializable {

	private static final long serialVersionUID = 358589844964L;
	
	@Id
	private String id;// ID
	private String signItemId;// 签约文件ID
	private String annexMd5;// 附件

	private String fileUrl;//文件地址
	
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSignItemId() {
		return this.signItemId;
	}

	public void setSignItemId(String signItemId) {
		this.signItemId = signItemId;
	}

	public String getAnnexMd5() {
		return this.annexMd5;
	}

	public void setAnnexMd5(String annexMd5) {
		this.annexMd5 = annexMd5;
	}

	public String getFileUrl() {
		return fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

}
