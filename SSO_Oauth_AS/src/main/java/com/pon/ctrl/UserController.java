/**
 * 
 */
package com.pon.ctrl;


import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Sanjeev
 *
 */

@RestController
public class UserController {

    @GetMapping("/userinfo")
    public Principal user(Principal principal) {
    
        return principal;
    }
    
    
}