/**
 * 
 */
package com.pon.oauth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

/**
 * @author Sanjeev
 *
 */
@Component
@Qualifier("oAuth2TokenCleanerOnLogout")
public class OAuth2TokenCleanerOnLogout implements LogoutHandler{
	@Autowired
    private TokenStore tokenStore;  

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		// TODO Auto-generated method stub
		System.out.println("Going to clean token at SSO.");
		
		 String authHeader = request.getHeader("Authorization");
	        if (authHeader != null) {
	            String tokenValue = authHeader.replace("Bearer", "").trim();
	            OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
	            System.out.println("accessToken is being removed = "+accessToken);
	            tokenStore.removeAccessToken(accessToken);
	            System.out.println("Have cleaned token at SSO.");
	        }
	        
	}
}
