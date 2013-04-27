/**
 * 
 */
package com.mdmp.report;

import com.mdmp.MdmpException;

/**
 * @author zhefang
 *
 */
public class ReportServiceException extends MdmpException{

	public ReportServiceException(String errorCode, Throwable cause) {
		super(errorCode, cause);
		// TODO Auto-generated constructor stub
	}

	public ReportServiceException(String commonUnsupportError) {
		super(commonUnsupportError);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -7282240616756773277L;

}
