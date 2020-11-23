/**
 * 
 */
package com.pon.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutHandler;

/**
 * @author Sanjeev
 *
 */
@Configuration
@Order(1)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private static final Logger log = LoggerFactory.getLogger(SecurityConfiguration.class);

    @Value("${user.oauth.user.username}")
    private String username;

    @Value("${user.oauth.user.password}")
    private String password;
    
    @Autowired
    BCryptPasswordEncoder passwordEncoder;
   
    /**
	 * This AuthenticationManager bean will be used by Authorization server.
	 * **/
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
    
    
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication()
            .withUser(username).password(passwordEncoder.encode(password)).roles("USER");
    }
    
    
    @Override
	public void configure(WebSecurity web) throws Exception {
    	///login is a default url for login submission and needs to be allowed otherwise full authentication will be asked
		web.ignoring().antMatchers("/resources/**","*.css","*.js", "/favicon.ico",
				                   "/", "/home","/pub/**", "/error/**","/client/register/**","/client/loginPage");		
	}
	
    
    @Autowired
    @Qualifier("oAuth2TokenCleanerOnLogout")
    LogoutHandler oAuth2TokenCleanerOnLogout;

	/**
	 * [1] form login has been enabled. [2] httpBasic() has been disabled. [3] Any
	 * other request needs to be authenticated only. [4] AS related token call end
	 * points are opened by default. /oauth/token, /oauth/token-key,
	 * /oauth/token-refresh, /oauth/token-check,
	 **/

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.httpBasic().disable();
		http.requestMatchers().antMatchers("/client/**","/client/dologin","/client/dologout","/oauth/authorize");
		http.authorizeRequests().anyRequest().authenticated();	
		
		http
		    .formLogin()
		    .loginProcessingUrl("/client/dologin")
		    .loginPage("/client/loginPage")//Custom-Page will be opened at this url.	
		    .failureUrl("/client/loginPage?error=true")	       
	        .permitAll();
		http
		    .logout().logoutUrl("/client/dologout")	
		   // .addLogoutHandler(oAuth2TokenCleanerOnLogout)//Not working for JWT
	        .logoutSuccessUrl("/client/loginPage?logout=true")
	        .clearAuthentication(true)//Will clear all the authentication details
			.invalidateHttpSession(true)		   
			.deleteCookies("JSESSIONID")
			
            .permitAll(); 
		http
		   .sessionManagement()           
	       .invalidSessionUrl("/client/loginPage?invalid=true")
	       .maximumSessions(1)
		   .maxSessionsPreventsLogin(false)
		   .expiredUrl("/client/loginPage?expired=true");       
      /*  http 
	 	    .rememberMe()
	 	    .rememberMeParameter("remember-me")
	 	    .rememberMeCookieName("pon-remember-me")
	 	    .tokenValiditySeconds(24*60*60)
	 	    .tokenRepository(tokenRepository());*/
	

	}

	
	
	
/**
 * Admin area security configuration
 * 
 * **/	
	
	@Configuration
	@Order(2)
	public static class SpecialSecurityConfig extends WebSecurityConfigurerAdapter {
		
		@Override
		public void configure(WebSecurity web) throws Exception {
	    	///login is a default url for login submission and needs to be allowed otherwise full authentication will be asked
			web.ignoring().antMatchers("/resources/**","*.css","*.js", "/favicon.ico",
					                   "/", "/home","/pub/**", "/error/**");		
		}
		
	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	    	
	    	//Here the request starts with /admin/** will come
	        //@formatter:off
	   http.csrf().disable();
	   http.httpBasic().disable();			
	   http.requestMatchers().antMatchers("/admin/**","/admin/login");//Keep ,"/admin/login" here to open admin login page
	   http.authorizeRequests().anyRequest().authenticated();	  	
	    	
	   http
		    .formLogin()
		    .loginProcessingUrl("/admin/doalogin")
		    .loginPage("/admin/aloginPage")			   
		    .failureUrl("/admin/aloginPage?error=true")	
	        .permitAll();
		http
		    .logout().logoutUrl("/admin/doalogout")		    
	        .logoutSuccessUrl("/admin/aloginPage?logout=true")
	        .clearAuthentication(true)//Will clear all the authentication details
			.invalidateHttpSession(true)		   
			.deleteCookies("JSESSIONID")
            .permitAll(); 
		http
		   .sessionManagement()           
	       .invalidSessionUrl("/admin/aloginPage?invalid=true")
	       .maximumSessions(1)
		   .maxSessionsPreventsLogin(false)
		   .expiredUrl("/admin/aloginPage?expired=true");       
      /*  http 
	 	    .rememberMe()
	 	    .rememberMeParameter("remember-me")
	 	    .rememberMeCookieName("pon-remember-me")
	 	    .tokenValiditySeconds(24*60*60)
	 	    .tokenRepository(tokenRepository());*/
	        //@formatter:on
	    }
	}  

    
}