package com.healthbrowser.until.cache;

public enum EhCacheEmun {
	
	SYS_CACHE("sysCache");
	
	private String value;

	private EhCacheEmun(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}


}