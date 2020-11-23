/**
 * 
 */
package com.pon.pub.user.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pon.pub.user.modal.RegistrationModal;

/**
 * @author Sanjeev
 *
 */
@Controller
@RequestMapping("/pub/user/")
public class LoginAndRegistrationController {
	
	@GetMapping("login")
	public String login( HttpServletRequest request, HttpServletResponse response) {
		
		return "login";
	}
	
	
	@GetMapping("register")
	public String register( RegistrationModal registrationModal, HttpServletRequest request, HttpServletResponse response) {
		
		return "register";
	}
	
	@GetMapping("fgotpwd")
	public String fgotpwd( RegistrationModal registrationModal, HttpServletRequest request, HttpServletResponse response) {
		
		return "fgotpwd";
	}
	
	
	

}
