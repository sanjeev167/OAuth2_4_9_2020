/**
 * 
 */
package com.pon.pvt.master.dept.service;

import java.util.List;

import com.pon.pvt.master.dept.dto.DepartmentDto;
import com.pon.pvt.master.dept.entity.Department;

/**
 * @author Sanjeev
 *
 */
public interface DepartmentService {
	
	
	Department getDepartmentById(long id);
	List<Department> getDepartments();
	void deleteById(long id);
	Department add(DepartmentDto departmentDto);
	void update(long id, DepartmentDto departmentDto);
	boolean isDepartmentExist(String name);
	void deleteAllDepartments();	
	
}
