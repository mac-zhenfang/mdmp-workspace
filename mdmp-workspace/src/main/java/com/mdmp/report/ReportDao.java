/**
 * 
 */
package com.mdmp.report;

import java.util.List;

/**
 * @author zhefang
 *
 */
public interface ReportDao {
	
	public List<Report> listReportByApp(String appId);
	
	public void create(Report report);
	
	public void remove(String reportId);
	
	public void updateReportType(Report report);
	
	public void updateReportTime(Report report);

	public void updateReportLogic(Report report);

	public Report get(String reportId);
}
