package com.pon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
public class SbOauthAsApplication extends SpringBootServletInitializer {

	private static final Logger log = LoggerFactory.getLogger(SbOauthAsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SbOauthAsApplication.class, args);
	}

	
	
	
}
