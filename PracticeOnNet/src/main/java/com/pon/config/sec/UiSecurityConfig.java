/**
 * 
 */
package com.pon.config.sec;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Sanjeev
 *
 */



@Configuration
public class UiSecurityConfig extends WebSecurityConfigurerAdapter {
	
	

	@Override
	public void configure(HttpSecurity http) throws Exception {
		
	http.antMatcher("/**")
		.authorizeRequests()
		.antMatchers("/","/resources/**").permitAll()
		.anyRequest().authenticated();

	http .oauth2Login().defaultSuccessUrl("/pvt/user/db", true);	       
	 
	http
	    .logout()		    
	    .logoutSuccessUrl("http://localhost:7777/sso/client/dologout")
	    .clearAuthentication(true)//Will clear all the authentication details
		.invalidateHttpSession(true)		   
		.deleteCookies("PONSESSION")
	    .permitAll(); 
	http
	   .sessionManagement()           
	   .invalidSessionUrl("http://localhost:7777/sso/client/loginPage?invalid=true")
	   .maximumSessions(1)
	   .maxSessionsPreventsLogin(false)
	   .expiredUrl("http://localhost:7777/sso/client/loginPage?expired=true"); 
		
		
	}
	

	 @Bean
	    WebClient webClient(ClientRegistrationRepository clientRegistrationRepository, 
	      OAuth2AuthorizedClientRepository authorizedClientRepository) {
	        ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2 = 
	          new ServletOAuth2AuthorizedClientExchangeFilterFunction(clientRegistrationRepository, 
	          authorizedClientRepository);
	        oauth2.setDefaultOAuth2AuthorizedClient(true);
	        return WebClient.builder().apply(oauth2.oauth2Configuration()).build();
	    }

}