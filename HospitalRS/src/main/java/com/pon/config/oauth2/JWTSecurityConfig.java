/**
 * 
 */
package com.pon.config.oauth2;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Sanjeev
 *
 */
@Configuration
public class JWTSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
          .authorizeRequests(authz -> authz
            .antMatchers(HttpMethod.GET, "/pvt/master/**").hasAuthority("Hospital_Admin")
            .antMatchers(HttpMethod.POST, "/pvt/master").hasAuthority("Hospital_Admin")
            .anyRequest().authenticated())
          .oauth2ResourceServer(oauth2 -> oauth2.jwt());
	}
    
    
    @EventListener
    public void authSuccessEventListener(AuthenticationSuccessEvent authorizedEvent){
        // write custom code here for login success audit
        System.out.println("\n\nRS = > gets => SUCCESS ACKNOWLEDGEMENT. ");
        System.out.println("\nAuthorization verified by AS for the user [ "+authorizedEvent.getAuthentication().getPrincipal()+" ] "
        		);
        
       
    }
    @EventListener
    public void authFailedEventListener(AbstractAuthenticationFailureEvent oAuth2AuthenticationFailureEvent){
        // write custom code here login failed audit.
    	System.out.println("\n\nRS = > gets => FAILURE ACKNOWLEDGEMENT. ");
    	 System.out.println("\nAuthorization failed by AS for the user [ "+oAuth2AuthenticationFailureEvent.getAuthentication().getPrincipal()+" ]."
    	 		);
         
    	
    }
}