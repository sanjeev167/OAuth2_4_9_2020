/**
 * 
 */
package com.pon.pvt.user.modal;

import java.io.Serializable;

/**
 * @author Sanjeev
 *
 */
/**
 * This will be used for storing error response of rest call
 * **/
public class ApiErrorResponse implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private String message;
	private ErrorDetails errorDetails;
	private ErrorHelp errorHelp;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorDetails getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(ErrorDetails errorDetails) {
		this.errorDetails = errorDetails;
	}
	public ErrorHelp getErrorHelp() {
		return errorHelp;
	}
	public void setErrorHelp(ErrorHelp errorHelp) {
		this.errorHelp = errorHelp;
	}
	
	
	
	

}
