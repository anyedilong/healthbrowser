package com.healthbrowser.moudles.common.domain;


/**
 * 
 * @ClassName JsonResult
 * @Description 系统消息
 * @author sen
 * @Date 2016年11月21日 上午9:48:53
 * @version 1.0.0
 */
public class JsonResult {

	private Object data;// 结果集
	private int retCode;
	private String retMsg;
	private String authorToke;
	private String hostip;

	public JsonResult() {
		this.retCode = ProcessStatus.COMMON_SUCCESS.getRetCode();
		this.retMsg = ProcessStatus.COMMON_SUCCESS.getRetMsg();
		this.data = null;
	}

	public JsonResult(Object data, String authorToke) {
		this.retCode = ProcessStatus.COMMON_SUCCESS.getRetCode();
		this.retMsg = ProcessStatus.COMMON_SUCCESS.getRetMsg();
		this.data = data;
		this.authorToke = authorToke;
	}
	
	public JsonResult(Object data) {
		this.retCode = ProcessStatus.COMMON_SUCCESS.getRetCode();
		this.retMsg = ProcessStatus.COMMON_SUCCESS.getRetMsg();
		this.data = data;
		this.hostip = "10.179.81.6:8083";
	}

	public JsonResult(Object data, int retCode, String retMsg) {
		this.data = data;
		this.retCode = retCode;
		this.retMsg = retMsg;
	}
	
	public JsonResult(Object data, ProcessStatus processStatus) {
		this.data = data;
		this.retCode = processStatus.getRetCode();;
		this.retMsg = processStatus.getRetMsg();
	}
	
	public void setResponseStatus(ResponseStatus responseStatus) {
		this.setRetCode(responseStatus.getCode());
		this.setRetMsg(responseStatus.getMessage());
	}
	
	public int getRetCode() {
		return retCode;
	}

	public void setRetCode(int retCode) {
		this.retCode = retCode;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getAuthorToke() {
		return authorToke;
	}

	public void setAuthorToke(String authorToke) {
		this.authorToke = authorToke;
	}

	public String getHostip() {
		return hostip;
	}

	public void setHostip(String hostip) {
		this.hostip = hostip;
	}
	
	
}