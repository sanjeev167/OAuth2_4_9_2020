/**
 * 
 */
package com.pon.pvt.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @author Sanjeev
 *
 */
public class ApiBase {
	protected WebClient webClient;
	
	//@Value("resourceBaseUri")
    protected String resourceContextUri="http://localhost:8083/rs";
	
	protected String deptApiBase="/pvt/master/";
	
	//Initialize all resource request mapping paths here so that they could be used while fetching through services
    
    @Autowired
    ApiBase(@Qualifier("hospital-platform") WebClient webClient) {
        this.webClient = webClient;
       
    }
    
}
