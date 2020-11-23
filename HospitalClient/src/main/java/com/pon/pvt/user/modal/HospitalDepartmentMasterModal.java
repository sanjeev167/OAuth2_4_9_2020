/**
 * 
 */
package com.pon.pvt.user.modal;

/**
 * @author Sanjeev
 *
 */
public class HospitalDepartmentMasterModal {

	private Long id;
	private String name;
	private long createdBy;
	private long updatedBy;
	private String activeC;

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
