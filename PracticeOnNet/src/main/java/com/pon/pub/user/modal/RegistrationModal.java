/**
 * 
 */
package com.pon.pub.user.modal;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * @author Sanjeev
 *
 */
public class RegistrationModal {

	
	@NotEmpty(message = "User name is required.")	
	private String name;
	
	@NotEmpty(message = "User login is required.")
	@Email(message = "Invalid email")
	private String userLoginId;
	
	//@ValidPassword	
	@NotEmpty(message = "Password is required.")	
	private String password;
	
	//@NotEmpty(message = "Password confirm is required.")	
	private String passwordConf;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserLoginId() {
		return userLoginId;
	}

	public void setUserLoginId(String userLoginId) {
		this.userLoginId = userLoginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConf() {
		return passwordConf;
	}

	public void setPasswordConf(String passwordConf) {
		this.passwordConf = passwordConf;
	}
	
	
}
