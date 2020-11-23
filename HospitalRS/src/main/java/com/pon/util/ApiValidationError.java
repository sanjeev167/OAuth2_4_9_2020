/**
 * 
 */
package com.pon.util;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Sanjeev
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)

public class ApiValidationError extends ApiSubError{

	
	   private String object;
	   private String field;
	   private Object rejectedValue;
	   private String message;

	   ApiValidationError(String object, String message) {
	       this.object = object;
	       this.message = message;
	   }

	public ApiValidationError(String object, String field, Object rejectedValue, String message) {
		this.object=object;
		this.rejectedValue=rejectedValue;
		this.message=message;
		this.field=field;
		
	}
}
