/**
 * 
 */
package com.pon.pvt.master.dept.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pon.pvt.master.dept.dto.DepartmentDto;
import com.pon.pvt.master.dept.entity.Department;
import com.pon.pvt.master.dept.repo.DepartmentRepository;

/**
 * @author Sanjeev
 *
 */
@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired DepartmentRepository repository;	

	public Department add(DepartmentDto dto) {
		repository.save(toEntity(dto));
		return toEntity(dto);
	}
	
	
    public void deleteById(long id) {
        repository.deleteById(id);
    }
    
    
    public List<Department> getDepartments() {
        return (List<Department>) repository.findAll();
    }
    
    public Department getDepartmentById(long id) {
        Optional<Department> optionalDepartment = repository.findById(id);
        //return optionalDepartment.orElseThrow(() -> new DepartmentNotFoundException("Couldn't find a Department with id: " + id));
        return optionalDepartment.get();
    }
    
    
    @Override
	public void update(long id, DepartmentDto departmentDto) {
    	departmentDto.setId(id);
    	repository.save(toEntity(departmentDto));
		
	}
    
    private Department toEntity(DepartmentDto dto) {
        Department entity = new Department();
        entity.setName(dto.getName());
        
        return entity;
    }


	@Override
	public boolean isDepartmentExist(String name) {
		// TODO Auto-generated method stub
		Department department=repository.findByName(name);
		if(department==null)
		   return false;
		else			
		   return true;
				
	}


	@Override
	public void deleteAllDepartments() {
		// TODO Auto-generated method stub
		repository.deleteAll();
		
	}


	
}
