/**
 * 
 */
package com.mdmp.report;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mdmp.ErrorCode;

/**
 * @author zhefang
 * 
 */
public class ReportServiceUtil {

	public static void verify(Report report) throws ReportServiceException {

	}

	protected static void verifyLogic(String reportLogic, String modelLogic)
			throws ReportServiceException {

	}

	protected static long changeTimestamp(String datetime) {
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		Date dt2;
		try {
			dt2 = sdf.parse(datetime);
		} catch (ParseException e) {
			throw new ReportServiceException(
					ErrorCode.REPORT_WRONG_DATA_FORMAT, e);
		}
		long lTime = dt2.getTime();
		return lTime;
	}
}
