/**
 * 
 */
package com.pon.pvt.user.modal;

import java.io.Serializable;

import net.minidev.json.JSONObject;

/**
 * @author Sanjeev
 *
 */
public class ApiResultAsJson implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	private boolean isSuccessFull=false;
	private JSONObject jsonObject;//This will be used when data is retrieved successfully 
	private String responseMsg;//This will contain any business error as well as successs message
	
	
	public boolean isSuccessFull() {
		return isSuccessFull;
	}
	public void setSuccessFull(boolean isSuccessFull) {
		this.isSuccessFull = isSuccessFull;
	}
	public JSONObject getJsonObject() {
		return jsonObject;
	}
	public void setJsonObject(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
	public String getResponseMsg() {
		return responseMsg;
	}
	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	
   
}
