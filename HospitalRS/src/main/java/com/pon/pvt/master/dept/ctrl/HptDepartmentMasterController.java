/**
 * 
 */
package com.pon.pvt.master.dept.ctrl;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.pon.config.exception.EntityNotFoundException;
import com.pon.pvt.master.dept.dto.DepartmentDto;
import com.pon.pvt.master.dept.entity.Department;
import com.pon.pvt.master.dept.service.DepartmentService;

/**
 * @author Sanjeev
 *
 */
@RestController
@RequestMapping("/pvt/master/")
public class HptDepartmentMasterController {

	Logger log = LoggerFactory.getLogger(HptDepartmentMasterController.class);

	private DepartmentService departmentService;

	@Autowired
	HptDepartmentMasterController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	// -------------------Retrieve All Departments------------------------------------

	@GetMapping("departments")
	public ResponseEntity<List<Department>> retrieveAlldepartments() {
		log.info("Started: retrieveAlldepartments"); 
		System.out.println("########### Sanjeev Control received for Department API calls.");
		List<Department> departments=departmentService.getDepartments();
		
		if(departments.isEmpty()) {System.out.println("########### Sanjeev No record found.");
			throw new EntityNotFoundException(Department.class, "id","");}
		
		
		log.info("Ended: retrieveAlldepartments"); 
		
		return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);//Going with body and a status code
	}

	
	// -------------------Retrieve Retrieve Single Department--------------------------
	@GetMapping("departments/{id}")
	public ResponseEntity<?> retrieveDepartment( @PathVariable long id) {
		System.out.println("########### Sanjeev Get request received.");
		log.info("Fetching Department with id {}", id);
		Department department = departmentService.getDepartmentById(id);
		if (department == null) {
            log.error("Department with id {} not found.", id);            
            throw new EntityNotFoundException(Department.class, "id", id+"");
        }
		log.info("Ended: retrieveDepartment");

		return new ResponseEntity<Department>(department, HttpStatus.OK);
	}

	
	// -------------------Create a Department-------------------------------------------
	@PostMapping("departments")
	public ResponseEntity<?> createDepartment(@RequestBody DepartmentDto departmentDto,UriComponentsBuilder ucBuilder) {

		log.info("Creating: Department : {} "+departmentDto);
		if(departmentService.isDepartmentExist(departmentDto.getName())) {
			log.error("Unable to create. A Department with name {} already exist", departmentDto.getName());
			throw new DataIntegrityViolationException("Duplicate Entry");			
		}		
		Department savedDepartment = departmentService.add(departmentDto);

		 HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(savedDepartment.getId()).toUri());
	        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// -------------------Update a Department-------------------------------------------
	@PutMapping("departments/{id}")
	public ResponseEntity<?> updateDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable long id) {

		log.info("Updating Department with id {}", id);

		Department department = departmentService.getDepartmentById(id);

		if (department == null) {
			log.error("Unable to update. Department with id {} not found.", id);
			throw new EntityNotFoundException(Department.class, "id", id+"");			
		}		

		departmentService.update(id, departmentDto);
		log.info("Ended: updateDepartment");

		 return new ResponseEntity<DepartmentDto>(departmentDto, HttpStatus.OK);
	}
	
	// ------------------- Delete a Department-----------------------------------------
	
	@DeleteMapping("departments/{id}")
	public ResponseEntity<?> deleteDepartment( @PathVariable long id) {
		log.info("Fetching & Deleting Departmentser with id {}", id);
		Department department=departmentService.getDepartmentById(id);
		if(department==null) {			
			log.error("Unable to delete. Department with id {} not found.", id);
			throw new EntityNotFoundException(Department.class, "id", id+"");
		}
		departmentService.deleteById(id);
		log.info("Started: deleteDepartment");
		return new ResponseEntity<Department>(HttpStatus.NO_CONTENT);

	}

	// ------------------- Delete All Departments-----------------------------
	 
	@DeleteMapping("departments")
    public ResponseEntity<Department> deleteAllUsers() {
        log.info("Deleting All Departments"); 
        departmentService.deleteAllDepartments();        
        return new ResponseEntity<Department>(HttpStatus.NO_CONTENT);
    }
	

}
