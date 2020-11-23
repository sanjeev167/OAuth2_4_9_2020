/**
 * 
 */
package com.pon.pvt.user.ctrl;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.pon.Base.JsonPojo.PageJsonResponse;
import com.pon.pvt.user.modal.ApiErrorResponse;
import com.pon.pvt.user.modal.ApiResultAsPojo;
import com.pon.pvt.user.modal.HospitalDepartmentMasterModal;
import com.pon.pvt.user.service.HospitalDepartmentMasterService;

/**
 * @author Sanjeev
 *
 */
@Controller
@RequestMapping("/pvt/dept/")
public class HospitalDepartmentMasterController {

	Logger log = LoggerFactory.getLogger(HospitalDepartmentMasterController.class);

	private HospitalDepartmentMasterService hospitalDepartmentMasterService;

	@Autowired
	HospitalDepartmentMasterController(HospitalDepartmentMasterService hospitalDepartmentMasterService) {
		this.hospitalDepartmentMasterService = hospitalDepartmentMasterService;
	}

	@GetMapping("") // Keep it blank as '/' will come here from the controller level requesting map.
	public ModelAndView loadPage(Model model, HttpServletRequest request, HttpServletResponse response) {

		log.info("Started:=>HospitalDepartmentMasterController =>loadPage");

		ModelAndView modelAndView = new ModelAndView();
		String targetPage = "hptDept/hptDept";
		modelAndView.setViewName(targetPage);
		// modelAndView.setView(view);
		try {
			prepareSupportivePageListDataForComboOrGridIfAny(model);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		log.info("Ended:=>HospitalDepartmentMasterController =>loadPage");

		return modelAndView;
	}

	@GetMapping("get")
	@ResponseBody
	public String get(@RequestParam("recrodId") Long recrodId, HttpServletRequest request, HttpServletResponse response) {
		log.info("Started:=>HospitalDepartmentMasterController =>get");
		PageJsonResponse pageJsonResponse = new PageJsonResponse();
	
		try {
			ApiResultAsPojo apiResultAsPojo = hospitalDepartmentMasterService.get(recrodId);

			pageJsonResponse.setActionHasError(apiResultAsPojo.isSuccessFull());
			pageJsonResponse.setActionResponseMsg(apiResultAsPojo.getResponseMsg());
			if (apiResultAsPojo.isSuccessFull())
				pageJsonResponse.setActionResponseData((HospitalDepartmentMasterModal) apiResultAsPojo.getDataPojo());
			else
				pageJsonResponse.setActionResponseData((ApiErrorResponse) apiResultAsPojo.getDataPojo());
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		log.info("Ended:=>HospitalDepartmentMasterController =>get");
		printFinalPageJsonResponseAtConsole(pageJsonResponse);
		// Finally return a JSON data object as pageJsonResponse
		return null;
	}

	@SuppressWarnings("unchecked")
	@GetMapping("getAll")
	@ResponseBody
	public String getAll(HttpServletRequest request, HttpServletResponse response) {

		log.info("Started:=>HospitalDepartmentMasterController =>getAll");
		PageJsonResponse pageJsonResponse = new PageJsonResponse();
		try {
			ApiResultAsPojo apiResultAsPojo = hospitalDepartmentMasterService.getAll();
			pageJsonResponse.setActionHasError(apiResultAsPojo.isSuccessFull());
			pageJsonResponse.setActionResponseMsg(apiResultAsPojo.getResponseMsg());
			if (apiResultAsPojo.isSuccessFull())
				pageJsonResponse.setActionResponseData(
						(ArrayList<HospitalDepartmentMasterModal>) apiResultAsPojo.getDataPojo());
			else
				pageJsonResponse.setActionResponseData((ApiErrorResponse) apiResultAsPojo.getDataPojo());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		log.info("Ended:=>HospitalDepartmentMasterController =>getAll");
		printFinalPageJsonResponseAtConsole(pageJsonResponse);
		// Finally return a JSON data object as pageJsonResponse
		return null;
	}

	@PostMapping("create")
	@ResponseBody
	public String create(@Valid HospitalDepartmentMasterModal hospitalDepartmentMasterModal, BindingResult result,
			HttpServletRequest request, HttpServletResponse response) {

		log.info("Started:=>HospitalDepartmentMasterController =>saveHptDepartment");
		PageJsonResponse pageJsonResponse = new PageJsonResponse();

		try {
			if (result.hasErrors()) {
				pageJsonResponse.setFormInputHasError(true);
				// Now Set error details in pageJsonResponse
			} else {

				ApiResultAsPojo apiResultAsPojo = hospitalDepartmentMasterService.create(hospitalDepartmentMasterModal);
				pageJsonResponse.setActionResponseMsg(apiResultAsPojo.getResponseMsg());
				pageJsonResponse.setActionHasError(apiResultAsPojo.isSuccessFull());

				if (apiResultAsPojo.isSuccessFull())
					;// Do nothing as no data is coming back while saving a record.
				else
					pageJsonResponse.setActionResponseData((ApiErrorResponse) apiResultAsPojo.getDataPojo());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		log.info("Ended:=>HospitalDepartmentMasterController =>create");
		printFinalPageJsonResponseAtConsole(pageJsonResponse);
		// Finally return a JSON data object as pageJsonResponse

		return null;
	}

	@PostMapping("update")
	@ResponseBody
	public String updateHptDepartment(@Valid HospitalDepartmentMasterModal hospitalDepartmentMasterModal,
			@RequestParam Long recordId, BindingResult result, HttpServletRequest request,
			HttpServletResponse response) {

		log.info("Started:=>HospitalDepartmentMasterController =>update");
		PageJsonResponse pageJsonResponse = new PageJsonResponse();

		try {
			if (result.hasErrors()) {
				pageJsonResponse.setFormInputHasError(true);
				// Now Set error details in pageJsonResponse
			} else {

				ApiResultAsPojo apiResultAsPojo = hospitalDepartmentMasterService.update(recordId,
						hospitalDepartmentMasterModal);
				pageJsonResponse.setActionResponseMsg(apiResultAsPojo.getResponseMsg());
				pageJsonResponse.setActionHasError(apiResultAsPojo.isSuccessFull());

				if (apiResultAsPojo.isSuccessFull())
					;// Do nothing as no data is coming back while saving a record.
				else
					pageJsonResponse.setActionResponseData((ApiErrorResponse) apiResultAsPojo.getDataPojo());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		log.info("Ended:=>HospitalDepartmentMasterController =>update");

		printFinalPageJsonResponseAtConsole(pageJsonResponse);
		// Finally return a JSON data object as pageJsonResponse

		return null;
	}

	@GetMapping("delete/{recordId}")
	@ResponseBody
	public String delete(@RequestParam Long recordId, HttpServletRequest request, HttpServletResponse response) {

		log.info("Started:=>HospitalDepartmentMasterController =>delete");
		PageJsonResponse pageJsonResponse = new PageJsonResponse();

		try {
			ApiResultAsPojo apiResultAsPojo = hospitalDepartmentMasterService.delete(recordId);
			pageJsonResponse.setActionResponseMsg(apiResultAsPojo.getResponseMsg());
			pageJsonResponse.setActionHasError(apiResultAsPojo.isSuccessFull());

			if (apiResultAsPojo.isSuccessFull())
				;// Do nothing as no data is coming back while saving a record.
			else
				pageJsonResponse.setActionResponseData((ApiErrorResponse) apiResultAsPojo.getDataPojo());

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		log.info("Ended:=>HospitalDepartmentMasterController =>delete");

		printFinalPageJsonResponseAtConsole(pageJsonResponse);
		// Finally return a JSON data object as pageJsonResponse

		return null;
	}
	
	private void printFinalPageJsonResponseAtConsole(PageJsonResponse pageJsonResponse) {

		log.info("Started:=>loadPage =>prepareSupportivePageListDataForComboOrGrid");

		log.info("Ended:=>loadPage =>prepareSupportivePageListDataForComboOrGrid");

	}
    
	private void prepareSupportivePageListDataForComboOrGridIfAny(Model model) {

		log.info("\tStarted:=>loadPage =>prepareSupportivePageListDataForComboOrGridIfAny");

		log.info("\tEnded:=>loadPage =>prepareSupportivePageListDataForComboOrGridIfAny");

	}

}
