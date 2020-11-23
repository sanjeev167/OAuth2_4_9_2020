/**
 * 
 */
package com.pon.pub.user.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Sanjeev
 *
 */
@Controller

public class HomeController {
	
	
	@GetMapping({"/","home"})
	public String welcome(Model model,HttpServletRequest request, HttpServletResponse response) {
		
		return "home";
		
		
	}

}
