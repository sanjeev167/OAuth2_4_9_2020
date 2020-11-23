/**
 * 
 */
package com.pon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.AuthorizedClientServiceOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.ClientCredentialsOAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.DelegatingOAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.RefreshTokenOAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Sanjeev
 *
 */

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {	
	

	@Override
	public void configure(HttpSecurity  http) throws Exception {
		
		
		http.antMatcher("/**")
		    .authorizeRequests()
		    .antMatchers("/","/home", "/resources/**").permitAll()
		    .anyRequest().authenticated();

		http
		    .oauth2Login()//Redirect url has been set at this end point. So the control will return at this point after user's authorization for the resources.
		    
		    .defaultSuccessUrl("/pvt/user/db", true);//This is url which will be used after getting access token. Within this end point we will start making api call.
		
		http
		    .logout()		    
		    .clearAuthentication(true)
			.invalidateHttpSession(true)
			.deleteCookies("HPTSESSION")
			.logoutSuccessUrl("http://localhost:7777/sso/client/dologout")//After cleaning cookie at the client, it is going to clean at SSO
			.permitAll();
		
		http
		    .sessionManagement()
		    .invalidSessionUrl("http://localhost:7777/sso/client/loginPage?invalid=true")
			.maximumSessions(1)
			.maxSessionsPreventsLogin(false)
			.expiredUrl("http://localhost:7777/sso/client/loginPage?expired=true");
		
	}
	
	
	@Bean
	public WebClient webClient(ClientRegistrationRepository clientRegistrationRepository, OAuth2AuthorizedClientService authorizedClientService) {

	    AuthorizedClientServiceOAuth2AuthorizedClientManager manager = new AuthorizedClientServiceOAuth2AuthorizedClientManager(clientRegistrationRepository, authorizedClientService);
	    manager.setAuthorizedClientProvider(new DelegatingOAuth2AuthorizedClientProvider(
	            new RefreshTokenOAuth2AuthorizedClientProvider(),
	            new ClientCredentialsOAuth2AuthorizedClientProvider()));

	    ServletOAuth2AuthorizedClientExchangeFilterFunction oauth2 = new ServletOAuth2AuthorizedClientExchangeFilterFunction(manager);

	    oauth2.setDefaultClientRegistrationId("hospital");//This is different from client_id. It is client registered id

	    return WebClient.builder()
	            .filter(oauth2)
	            .apply(oauth2.oauth2Configuration())
	            .build();
	}
	
	
}