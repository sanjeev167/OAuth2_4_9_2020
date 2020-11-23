/**
 * 
 */
package com.pon.pvt.master.dept.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Sanjeev
 *
 */

@Entity(name="hpt_department")
public class Department {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
	@Column(name="name", length=100, nullable=false, unique=false)
	String name;
	
	@Column(name="created_by")
	long createdBy=8l;
	
	@Column(name="updated_by")
	long updatedBy=9l;
	
	@Column(name="active_c")
	String activeC;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public long getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getActiveC() {
		return activeC;
	}

	public void setActiveC(String activeC) {
		this.activeC = activeC;
	}
	
	
	
}
