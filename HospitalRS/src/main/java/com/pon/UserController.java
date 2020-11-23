/**
 * 
 */
package com.pon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sanjeev
 *
 */
@RestController("/rs/api/user/")
public class UserController {
    @GetMapping("/details")
    public UserDTO userDetails(HttpServletRequest request,HttpServletResponse response) {
        return new UserDTO();
    }
}
