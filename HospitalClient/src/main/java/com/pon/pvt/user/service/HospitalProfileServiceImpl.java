/**
 * 
 */
package com.pon.pvt.user.service;

import org.springframework.web.reactive.function.client.WebClient;

import com.pon.pvt.user.modal.HospitalProfileModal;

/**
 * @author Sanjeev
 *
 */
public class HospitalProfileServiceImpl extends ApiBase implements HospitalProfileService{

	HospitalProfileServiceImpl(WebClient webClient) {
		super(webClient);
		// TODO Auto-generated constructor stub
	}

	@Override
	public HospitalProfileModal getHospitalProfile(Integer hptId) {
		// TODO Auto-generated method stub
		return null;
	}

}
