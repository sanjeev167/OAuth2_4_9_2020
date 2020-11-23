/**
 * 
 */
package com.pon.pvt.user.service;



import com.pon.pvt.user.modal.ApiResultAsPojo;

/**
 * @author Sanjeev
 *
 */
public interface CrudService {
	
	public ApiResultAsPojo get(Long recordId);
	
	public ApiResultAsPojo getAll();
	
	public ApiResultAsPojo delete(Long recordId);
	
	public ApiResultAsPojo create(Object object);
 
	public ApiResultAsPojo update(Long recordId,Object object);
}
