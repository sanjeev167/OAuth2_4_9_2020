/**
 * 
 */
package com.pon.pvt.user.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import com.pon.pvt.user.modal.DashBoardModal;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Sanjeev
 *
 */
//@Service
public class DashboardServiceImpl extends ApiBase implements DashboardService{

	DashboardServiceImpl(WebClient webClient, String resourceUri) {
		super(webClient);
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public DashBoardModal getDashboardDetails() {
		// TODO Auto-generated method stub
		//Flux<DashBoardModal> dashBoardModal=webClient.get().uri(resourceBaseUri).retrieve().bodyToFlux(DashBoardModal.class);
		
		
		
		
		return null;
	}
	
	
	

}
