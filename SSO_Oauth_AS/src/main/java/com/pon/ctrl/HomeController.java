/**
 * 
 */
package com.pon.ctrl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Sanjeev
 *
 */

@Controller
public class HomeController {
	@GetMapping({ "/", "home" })
	public String home(HttpServletRequest request, HttpServletResponse response) {

		return "home";
	}

	
	

}
