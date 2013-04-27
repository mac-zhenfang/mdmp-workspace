/**
 * 
 */
package com.mdmp.data;

import com.mdmp.MdmpException;

/**
 * @author zhefang
 * 
 */
public class DataNotFoundException extends MdmpException {

	public DataNotFoundException(String errorCode, Throwable cause) {
		super(errorCode, cause);
		// TODO Auto-generated constructor stub
	}

	public DataNotFoundException(String error) {
		super(error);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 163565318812368753L;

}
