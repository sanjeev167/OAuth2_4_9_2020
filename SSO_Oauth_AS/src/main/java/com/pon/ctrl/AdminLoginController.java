/**
 * 
 */
package com.pon.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pon.modal.RegistrationModal;


/**
 * @author Sanjeev
 *
 */
@Controller
@RequestMapping("/admin")
public class AdminLoginController {

	
	@GetMapping( "/aloginPage" )
	public String getLoginPage(RegistrationModal registrationModal, Model model,
			@RequestParam(value = "error", required = false) boolean error,
			@RequestParam(value = "logout", required = false) boolean logout,
			@RequestParam(value = "authenticate", required = false) boolean authenticate,
			@RequestParam(value = "invalid", required = false) boolean invalid,
			@RequestParam(value = "expired", required = false) boolean expired) {
        //System.out.println("Admin Login called");
		if (error)
			model.addAttribute("errorMessge", "Either Username or Password is incorrect !!");
		if (logout)
			model.addAttribute("logout", "You have been logged out successfully !!");
		if (authenticate)
			model.addAttribute("authenticate", "First authenticate yourself !!");
		if (expired)
			model.addAttribute("expired", "Your current session has expired !!");
		if (invalid)
			model.addAttribute("invalid", "Your session is invalid !!");		

		return "/admin/alogin";
	}
	
	
	
}
