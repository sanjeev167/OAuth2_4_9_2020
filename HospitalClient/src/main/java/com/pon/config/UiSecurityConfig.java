/**
 * 
 */
package com.pon.config;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

/**
 * @author Sanjeev
 *
 */
/**
 * The @EnableOAuth2Client enables an OAuth2-client configuration of Spring Security Web application.
 * The @EnableOAuth2Client allows us to use Authorization Code Grant from one or more OAuth2 Authorization servers. 
 * To use @EnableOAuth2Client we need to register OAuth2ClientContextFilter in our application. 
 * The @EnableOAuth2Client enables auto-wiring of OAuth2ClientContext that can be used to create OAuth2RestTemplate bean.
**/

//@EnableOAuth2Client
@Configuration
//public class UiSecurityConfig extends WebSecurityConfigurerAdapter {
public class UiSecurityConfig  {//Uncomment above when use it	
/***
	//It is required for auto-wiring
	@Autowired
	OAuth2ClientContext oauth2ClientContext;

	/**
	 * AuthorizationCodeResourceDetails: Details of OAuth2 protected resource such
	 * as client id, client secret etc. This will be picked from properties file
	 * 
	 * pon is our SSO authorization server where this client which I am configuring is already registered. So using this pon.client, 
	 * it will read and configure all the client details available at pon SSO.
	 * 1. pon.client.client_id
	 * 2. pon.client.client_secret
	 * 3. pon.client.client_redirect_uri
	 * 4. pon.client.scope
	 * 5. pon.client.user_info
	 * 
	 **/
/**
	@Bean
	@ConfigurationProperties("pon.client")
	public AuthorizationCodeResourceDetails ponClient() {
		return new AuthorizationCodeResourceDetails();
	}
**/
	/**
	 * ResourceServerProperties: This is Spring Boot class. It contains OAuth2 resource details which this client application will access.
	 * pon.resource includes following
	 * 1. Base url of the resource server where the API call will be sent.
	 * 2. The scope name which will be accessed
	 * 3. 
	 **/
	/**
	@Bean
	@ConfigurationProperties("pon.resource")
	public ResourceServerProperties ponResource() {
		return new ResourceServerProperties();
	}

**/

	/**
	 * FilterRegistrationBean: This is Spring Boot class. It registers filters in Servlet 3.0 container in Spring Boot application.
	 **/
/**
	@Bean
	public FilterRegistrationBean<OAuth2ClientContextFilter> oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
		
		FilterRegistrationBean<OAuth2ClientContextFilter> registration = new FilterRegistrationBean<OAuth2ClientContextFilter>();
		
		registration.setFilter(filter);
		registration.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);
		return registration;
	}
**/
	/**
	 * OAuth2ClientContextFilter: This is the security filter for an OAuth2 client.
	 * 
	 * OAuth2ClientAuthenticationProcessingFilter: This is the OAuth2 client filter
	 * that acquires an OAuth2 access token from an authorization server.
	 * 
	 * OAuth2RestTemplate: Rest template that makes OAuth2-authenticated REST
	 * requests. UserInfoTokenServices: This is Spring Boot class. It is the
	 * implementation of ResourceServerTokenServices that uses a user info REST
	 * service.
	 * 
	 ***/
/**
	private Filter oauth2ClientFilter() {
		
		///
		OAuth2ClientAuthenticationProcessingFilter oauth2ClientFilter = new OAuth2ClientAuthenticationProcessingFilter(	"/login/github");
		
		OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(ponClient(), oauth2ClientContext);
		
		oauth2ClientFilter.setRestTemplate(restTemplate);
		
		UserInfoTokenServices tokenServices = new UserInfoTokenServices(ponResource().getUserInfoUri(), ponClient().getClientId());
		
		///
		tokenServices.setRestTemplate(restTemplate);
		
		oauth2ClientFilter.setTokenServices(tokenServices);
		
		return oauth2ClientFilter;
	}
**/	
	
	
/**
	@Override
	public void configure(HttpSecurity http) throws Exception {

		http.antMatcher("/**").authorizeRequests().antMatchers("/", "/resources/**").permitAll().anyRequest()
				.authenticated();

		http.oauth2Login().defaultSuccessUrl("/pvt/user/db", true);
		http.logout().logoutSuccessUrl("http://localhost:7777/sso/client/dologout").clearAuthentication(true)
				    .invalidateHttpSession(true).deleteCookies("HPTSESSION").permitAll();
		http.sessionManagement().invalidSessionUrl("http://localhost:7777/sso/client/loginPage?invalid=true")
								.maximumSessions(1).maxSessionsPreventsLogin(false)
								.expiredUrl("http://localhost:7777/sso/client/loginPage?expired=true");
	}
**/
}