/**
 * 
 */
package com.pon.pvt.user.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Sanjeev
 *
 */

@Controller
@RequestMapping("/pvt/user/")
public class DashboardController {
	
	@Autowired
	WebClient webClient;
	
	@GetMapping("db")
	public String dashboard(Model model, HttpServletRequest request, HttpServletResponse response) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		model.addAttribute("username", currentPrincipalName);
		model.addAttribute("roles", authentication.getAuthorities());
		return "user/db";
	}
	
	
	@GetMapping("bulletinpage")
	public String bulletinpage(Model model, HttpServletRequest request, HttpServletResponse response) {		
		return "user/bulletinpage";
	}
	
	

}
