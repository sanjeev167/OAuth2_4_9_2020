/**
 * 
 */
package com.pon.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pon.modal.RegistrationModal;


/**
 * @author Sanjeev
 *
 */
@Controller
@RequestMapping("/client")
public class SSO_LoginController {

	
	@GetMapping( "/loginPage" )
	public String getLoginPage(RegistrationModal registrationModal, Model model,
			@RequestParam(value = "error", required = false) boolean error,
			@RequestParam(value = "logout", required = false) boolean logout,
			@RequestParam(value = "authenticate", required = false) boolean authenticate,
			@RequestParam(value = "invalid", required = false) boolean invalid,
			@RequestParam(value = "expired", required = false) boolean expired) {
		
		

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

		return "login";
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register(RegistrationModal registrationModal, Model model, HttpServletRequest request, HttpServletResponse response) {
		
		ModelAndView mv = new ModelAndView("register");
		
		return mv;
	}

	
	@RequestMapping(value = "/fgotpwd", method = RequestMethod.GET)
	public String fgotpwd(Model model) {
		
		return "fgotpwd";
	}

	@RequestMapping(value = "/fgotpwd", method = RequestMethod.POST)
	public String sendFgotpwd(Model model) {
		
		return "fgotpwd";
	}
	
}
