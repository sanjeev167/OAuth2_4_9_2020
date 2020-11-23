/**
 * 
 */
package com.pon.pvt.user.modal;

import net.minidev.json.JSONObject;

/**
 * @author Sanjeev
 *
 */
public class ApiResultAsPojo {
	private boolean isSuccessFull=false;
	private Object dataPojo;//This will be used when data is retrieved successfully 
	private String responseMsg;//This will contain any business error as well as successs message
	
	
	public boolean isSuccessFull() {
		return isSuccessFull;
	}
	public void setSuccessFull(boolean isSuccessFull) {
		this.isSuccessFull = isSuccessFull;
	}
	public Object getDataPojo() {
		return dataPojo;
	}
	public void setDataPojo(Object dataPojo) {
		this.dataPojo = dataPojo;
	}
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	
	
}
