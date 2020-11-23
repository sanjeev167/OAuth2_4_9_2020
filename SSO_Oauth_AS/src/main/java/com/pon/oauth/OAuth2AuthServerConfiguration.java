/**
 * 
 */
package com.pon.oauth;

import java.security.KeyPair;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.event.AbstractAuthenticationFailureEvent;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

/**
 * @author Sanjeev
 *
 */

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthServerConfiguration extends AuthorizationServerConfigurerAdapter {

	private static final Logger log = LoggerFactory.getLogger(OAuth2AuthServerConfiguration.class);
	@Autowired
	private Environment environment;
	
	@Value("${user.oauth.accessTokenValidity}")
    private int accessTokenValidity;

    @Value("${user.oauth.refreshTokenValidity}")
    private int refreshTokenValidity;
    
    //Pon Client properties
    @Value("${user.oauth.clientPonId}")
    private String clientPonID;

    @Value("${user.oauth.clientPonSecret}")
    private String clientPonSecret;

    @Value("${user.oauth.redirectPonUris}")
    private String redirectPonURLs;
    
    @Value("${user.oauth.autoPonApprove}")
    private boolean autoPonApprove;
    
    @Value("${user.oauth.clientPonAllowedScopes}")
    private String clientPonAllowedScopes;   

  //Doctor Client properties    
    
    @Value("${user.oauth.clientDoctorId}")
    private String clientDoctorID;

    @Value("${user.oauth.clientDoctorSecret}")
    private String clientDoctorSecret;

    @Value("${user.oauth.redirectDoctorUris}")
    private String redirectDoctorURLs;
    
    @Value("${user.oauth.autoDoctorApprove}")
    private boolean autoDoctorApprove;
    
    @Value("${user.oauth.clientDoctorAllowedScopes}")
    private String clientDoctorAllowedScopes;   

  //Hospital Client properties    
    
    @Value("${user.oauth.clientHospitalId}")
    private String clientHospitalID;

    @Value("${user.oauth.clientHospitalSecret}")
    private String clientHospitalSecret;

    @Value("${user.oauth.redirectHospitalUris}")
    private String redirectHospitalURLs;
    
    @Value("${user.oauth.autoHospitalApprove}")
    private boolean autoHospitalApprove;
    
    @Value("${user.oauth.clientHospitalAllowedScopes}")
    private String clientHospitalAllowedScopes;   
   

   
    
    private AuthenticationManager authenticationManager;   
    private BCryptPasswordEncoder passwordEncoder;    
   // private UserDetailsService userDetailsService;
    
    /**
     * Initialize all the above declared varibles
     * ***/
    @Autowired
    public OAuth2AuthServerConfiguration(AuthenticationConfiguration authenticationConfiguration, BCryptPasswordEncoder passwordEncoder) throws Exception {
        this.authenticationManager = authenticationConfiguration.getAuthenticationManager();        
        this.passwordEncoder = passwordEncoder;
       // this.userDetailsService = userDetailsService;
    }
    
    /**
     * Spring security Oauth expose 2 end points. It protects these end points behind the denyAll() method. 
     * The tokenKeyAccess and tokenKeyAccess enable these end points.
     * **/
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security
          .tokenKeyAccess("permitAll()")
          .checkTokenAccess("isAuthenticated()")
          //Replaces Basic Authentication and allows you to pass all necessary params as a part of a request body. 
          //In case of basic authentication, all parameters go through Url. Here, we are forcing to pass those parameters as a part of request body.
          .allowFormAuthenticationForClients(); // (1)
        
    }    
    
   
    
    /**
     * Now, Configure different clients which will access token from this AS.
     * ***/
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
       
    	clients
    	
     .inMemory()
	            .withClient(clientPonID)
	            .secret(passwordEncoder.encode(clientPonSecret))
	           // .resourceIds("")
	            .authorizedGrantTypes("authorization_code", "refresh_token")
	            .autoApprove(autoPonApprove)
	            .scopes(clientPonAllowedScopes)
	           // .authorities("READ_ONLY_CLIENT")
	            .redirectUris(redirectPonURLs)
	            .accessTokenValiditySeconds(accessTokenValidity)
	            .refreshTokenValiditySeconds(refreshTokenValidity)
      .and()
		      .withClient(clientDoctorID)
		      .secret(passwordEncoder.encode(clientDoctorSecret))
		      .authorizedGrantTypes("authorization_code", "refresh_token")
		      //.resourceIds("")
		      .autoApprove(autoDoctorApprove)
		      .scopes("Doctor_Profile","Doctor_Admin","Doctor_Patient")
		     // .authorities("READ_ONLY_CLIENT")
		      .redirectUris(redirectDoctorURLs)
		      .accessTokenValiditySeconds(accessTokenValidity)
		      .refreshTokenValiditySeconds(refreshTokenValidity)
       .and()
		      .withClient(clientHospitalID)
		      .secret(passwordEncoder.encode(clientHospitalSecret))
		      .authorizedGrantTypes("authorization_code", "refresh_token")
		      //.resourceIds("")
		      .autoApprove(autoHospitalApprove)
		      .scopes("Hospital_Profile","Hospital_Admin","Hospital_Patient")
		     // .authorities("READ_ONLY_CLIENT")
		      .redirectUris(redirectHospitalURLs)
		      .accessTokenValiditySeconds(accessTokenValidity)
		      .refreshTokenValiditySeconds(refreshTokenValidity);
           
    }
   
    
    /**
     * Here, we are telling which authenticationManager AS will use for authenticating users and clients for an end point. 
     * After authenticating  user and client, an access token is issued. So we need to tell this manager which tokenStore and accessTokenConverter 
     * will be used.
     * ***/
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(this.authenticationManager)           
            //.userDetailsService(userDetailsService) //will be used When it will be configured.Right now in memory approach is used
	           .tokenEnhancer(jwtTokenEnhancer())          
	           .tokenStore(tokenStore());
    }
    
    
    /**
	 * This is a token store bean where you to tell which token store AS will use
	 * **/
    private TokenStore tokenStore;
	@Bean
	public TokenStore tokenStore() {
		if (tokenStore == null) {
			// tokenStore= new InMemoryTokenStore();//In this case, you have to change application.properties for check_token
			// tokenStore= new JdbcTokenStore(dataSource);//In this case, you have to change application.properties for check_token
			tokenStore = new JwtTokenStore(jwtTokenEnhancer());
		}
		return tokenStore;
	}
	
	/**
	 * This is required when JWT token-store is stored. It will be used for signing access token
	 * **/

	@Bean
	protected JwtAccessTokenConverter jwtTokenEnhancer() {

		String certificateFilePath = environment.getProperty("security.jwt.key-store");
		String certificateAlias = environment.getProperty("security.jwt.key-pair-alias");
		
		String pwd = environment.getProperty("security.jwt.key-store-password");

		System.out.println("certificateFilePath = " + certificateFilePath);
		System.out.println("certificateAlias = " + certificateAlias);
		System.out.println("pwd = " + pwd);
		
		KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(new ClassPathResource(certificateFilePath),
				pwd.toCharArray());
		
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setKeyPair(keyStoreKeyFactory.getKeyPair(certificateAlias));
		return converter;
	}

	
	/**
	 * This is required to be configured for any type of token implementation
	 * **/
	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		defaultTokenServices.setSupportRefreshToken(true);
		return defaultTokenServices;
	}
    
  //Following code is not a part of AS configuration. Will be used for checking proof of concept only.	

  	@EventListener
  	public void authSuccessEventListener(AuthenticationSuccessEvent authorizedEvent) {

  		
  		System.out.println("BB   = "+authorizedEvent.getAuthentication().getDetails());
  		// write custom code here for login success audit
  		System.out.println("\nAS [Authentication Success] => Will check authentication in the following cases."
  				+ " \n [1] When the client comes here for access token with a user and client credential."
  				+ " \n [2] When RS comes here for token verification [auth/check_token]."
  				+ " \n [3] When RS comes here for [auth/token_key] in case of jwt token.");
  		
  		System.out.println("\n Client or User Name : " + authorizedEvent.getAuthentication().getName());
  		System.out.println(" Client or User Authorities : " + authorizedEvent.getAuthentication().getAuthorities());
  		System.out.println(" Client or User Details : " + authorizedEvent.getAuthentication().getDetails());
  	}

  	@EventListener
  	public void authFailedEventListener(AbstractAuthenticationFailureEvent oAuth2AuthenticationFailureEvent) {
  		// write custom code here login failed audit.
  		System.out.println("\nAS [Authentication Failure] => Will check authentication in the following cases."
  				+ " \n [1] When the client comes here for access token with user and client credential."
  				+ " \n [2] When RS comes here for token verification [auth/check_token]."
  				+ " \n [3] When RS comes here for [auth/token_key] in case of jwt token.");
  		
  		System.out.println("\n Client or User Name : " + oAuth2AuthenticationFailureEvent.getAuthentication().getName());
  		System.out.println(" Client or User Authorities : "+ oAuth2AuthenticationFailureEvent.getAuthentication().getAuthorities());
  		System.out.println(" Client or User Details : " + oAuth2AuthenticationFailureEvent.getAuthentication().getDetails());
  	}
    
}
