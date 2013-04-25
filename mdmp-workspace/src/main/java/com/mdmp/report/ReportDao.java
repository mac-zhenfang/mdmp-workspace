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
	
	public List<Report> listReportByUser(String userId);
	
	public void create(Report report);
	
	public void remove(String reportId);
	
	public void update(Report report);
	
	public void get(String reportId);
	
	
}
