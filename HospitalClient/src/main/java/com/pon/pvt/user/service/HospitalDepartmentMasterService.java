/**
 * 
 */
package com.pon.pvt.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import com.google.gson.Gson;
import com.pon.pvt.user.modal.ApiResultAsPojo;
import com.pon.pvt.user.modal.HospitalDepartmentMasterModal;
import com.pon.util.ApiError;

import reactor.core.publisher.Mono;

/**
 * @author Sanjeev
 *
 */
@Service
public class HospitalDepartmentMasterService extends ApiBase implements CrudService {

	Logger log = LoggerFactory.getLogger(HospitalDepartmentMasterService.class);

	HospitalDepartmentMasterService(WebClient webClient) {
		super(webClient);
	}

	@Override
	public ApiResultAsPojo get(Long recordId) {

		log.info("\t\tStarted:=>HospitalDepartmentMasterService =>get");
		ApiResultAsPojo apiResultAsPojo = new ApiResultAsPojo();

		try {
			// configure WebClient for fetch
			RequestHeadersSpec<?> spec = webClient.get().uri(resourceContextUri +deptApiBase+ "departments?id=" + recordId);
		
			ClientResponse clientResponse = spec.exchange().block();
			HttpStatus httpStatus = clientResponse.statusCode();	
			System.out.println("Sanjeev = "+httpStatus);
			if (httpStatus.is2xxSuccessful()) {
				// do fetch and map result
				apiResultAsPojo.setSuccessFull(true);
				apiResultAsPojo.setResponseMsg("Record found.");
				apiResultAsPojo.setDataPojo(clientResponse.toEntity(HospitalDepartmentMasterModal.class).block().getBody());
			} else {				
				ApiError apiError = clientResponse.toEntity(ApiError.class).block().getBody();
				//System.out.println("Sanjeev = "+ToStringBuilder.reflectionToString(apiError));
				System.out.println("Sanjeev = "+new Gson().toJson(apiError));
				
				apiResultAsPojo.setSuccessFull(false);
				apiResultAsPojo.setResponseMsg(apiError.getMessage());
				// Not required set datapojo
			}
		} catch (Exception ex) {
			throw ex;
		}

		log.info("\t\tEnded:=>HospitalDepartmentMasterService =>get");
		return apiResultAsPojo;
	}

	@Override
	public ApiResultAsPojo getAll() {

		log.info("\t\tStarted:=>HospitalDepartmentMasterService =>getAll");
		ApiResultAsPojo apiResultAsPojo = new ApiResultAsPojo();
		try {
			// configure WebClient for fetch
			RequestHeadersSpec<?> spec = webClient.get().uri(resourceContextUri +deptApiBase+ "departments");
			ClientResponse clientResponse = spec.exchange().block();
			HttpStatus httpStatus = clientResponse.statusCode();

			if (httpStatus.is2xxSuccessful()) {
				// do fetch and map result
				apiResultAsPojo.setSuccessFull(true);
				apiResultAsPojo.setResponseMsg("Record found.");
				apiResultAsPojo.setDataPojo(
						clientResponse.toEntityList(HospitalDepartmentMasterModal.class).block().getBody());
				System.out.println("Sanjeev = "+new Gson().toJson(apiResultAsPojo.getDataPojo()));
			} else {
				ApiError apiError = clientResponse.toEntity(ApiError.class).block().getBody();
				apiResultAsPojo.setSuccessFull(false);
				apiResultAsPojo.setResponseMsg(apiError.getMessage());
				// Not required set datapojo
			}
		} catch (Exception ex) {
			throw ex;
		}
		log.info("\t\tEnded:=>HospitalDepartmentMasterService =>getAll");
		return apiResultAsPojo;
	}

	@Override
	public ApiResultAsPojo delete(Long recordId) {
		log.info("\t\tStarted:=>HospitalDepartmentMasterService =>delete");
		ApiResultAsPojo apiResultAsPojo = new ApiResultAsPojo();

		try {
			// configure WebClient for fetch
			RequestHeadersSpec<?> spec = webClient.delete().uri(resourceContextUri +deptApiBase+"department?=" + recordId);
			ClientResponse clientResponse = spec.exchange().block();

			HttpStatus httpStatus = clientResponse.statusCode();
			if (httpStatus.NO_CONTENT == HttpStatus.NO_CONTENT) {
				apiResultAsPojo.setSuccessFull(true);
				apiResultAsPojo.setResponseMsg("Record has been deleted successfully.");
			} else {
				ApiError apiError = clientResponse.toEntity(ApiError.class).block().getBody();
				apiResultAsPojo.setSuccessFull(false);
				apiResultAsPojo.setResponseMsg(apiError.getMessage());
			}
		} catch (Exception ex) {
			throw ex;
		}
		log.info("\t\tEnded:=>HospitalDepartmentMasterService =>delete");
		return apiResultAsPojo;
	}

	@Override
	public ApiResultAsPojo create(Object hospitalDepartmentMasterModal) {

		log.info("\t\tStarted:=>HospitalDepartmentMasterService =>create");
		ApiResultAsPojo apiResultAsPojo = new ApiResultAsPojo();
		try {
			// configure WebClient for fetch
			RequestHeadersSpec<?> spec = webClient.post().uri(resourceContextUri +deptApiBase+"department")
					.body(Mono.just(hospitalDepartmentMasterModal), HospitalDepartmentMasterModal.class);

			ClientResponse clientResponse = spec.exchange().block();
			HttpStatus httpStatus = clientResponse.statusCode();

			if (httpStatus.is2xxSuccessful()) {
				// do fetch and map result
				apiResultAsPojo.setSuccessFull(true);
				apiResultAsPojo.setResponseMsg("Record found.");
				apiResultAsPojo
						.setDataPojo(clientResponse.toEntity(HospitalDepartmentMasterModal.class).block().getBody());
			} else {
				ApiError apiError = clientResponse.toEntity(ApiError.class).block().getBody();
				apiResultAsPojo.setSuccessFull(false);
				apiResultAsPojo.setResponseMsg(apiError.getMessage());
				// Not required set datapojo
			}
		} catch (Exception ex) {
			throw ex;
		}
		log.info("\t\tEnded:=>HospitalDepartmentMasterService =>create");
		return apiResultAsPojo;
	}

	@Override
	public ApiResultAsPojo update(Long recordId, Object object) {

		log.info("\t\tStarted:=>HospitalDepartmentMasterService =>update");
		ApiResultAsPojo apiResultAsPojo = new ApiResultAsPojo();
		try {
			// configure WebClient for fetch
			RequestHeadersSpec<?> spec = webClient.put().uri(resourceContextUri +deptApiBase+"department/?id=" + recordId)
					.body(Mono.just(object), HospitalDepartmentMasterModal.class);
			ClientResponse clientResponse = spec.exchange().block();

			HttpStatus httpStatus = clientResponse.statusCode(); 

			if (httpStatus.is2xxSuccessful()) {
				// do fetch and map result
				apiResultAsPojo.setSuccessFull(true);
				apiResultAsPojo.setResponseMsg("Record found.");
				apiResultAsPojo
						.setDataPojo(clientResponse.toEntity(HospitalDepartmentMasterModal.class).block().getBody());
			} else {
				ApiError apiError = clientResponse.toEntity(ApiError.class).block().getBody();
				apiResultAsPojo.setSuccessFull(false);
				apiResultAsPojo.setResponseMsg(apiError.getMessage());
				// Not required set datapojo
			}
		} catch (Exception ex) {
			throw ex;
		}
		log.info("\t\tEnded:=>HospitalDepartmentMasterService =>update");
		return apiResultAsPojo;
	}

}
