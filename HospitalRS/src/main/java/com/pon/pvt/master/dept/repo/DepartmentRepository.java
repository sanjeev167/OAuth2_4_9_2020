/**
 * 
 */
package com.pon.pvt.master.dept.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pon.pvt.master.dept.entity.Department;

/**
 * @author Sanjeev
 *
 */

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

	Department findByName(String name);
	
	
}