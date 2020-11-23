/**
 * 
 */
package com.pon.Base.JsonPojo;

/**
 * @author Sanjeev
 *
 */
public class PageJsonResponse {

	private String actionResponseMsg;
	private boolean actionHasError=false;
	private Object actionResponseData;	
	
	private boolean formInputHasError=false;
	private Object errorResponseData;
	public String getActionResponseMsg() {
		return actionResponseMsg;
	}
	public void setActionResponseMsg(String actionResponseMsg) {
		this.actionResponseMsg = actionResponseMsg;
	}
	public boolean isActionHasError() {
		return actionHasError;
	}
	public void setActionHasError(boolean actionHasError) {
		this.actionHasError = actionHasError;
	}
	public Object getActionResponseData() {
		return actionResponseData;
	}
	public void setActionResponseData(Object actionResponseData) {
		this.actionResponseData = actionResponseData;
	}
	public boolean isFormInputHasError() {
		return formInputHasError;
	}
	public void setFormInputHasError(boolean formInputHasError) {
		this.formInputHasError = formInputHasError;
	}
	public Object getErrorResponseData() {
		return errorResponseData;
	}
	public void setErrorResponseData(Object errorResponseData) {
		this.errorResponseData = errorResponseData;
	}
	
	
	
}
