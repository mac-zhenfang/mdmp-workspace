/**
 * 
 */
package com.mdmp.report;

import java.util.List;

import com.mdmp.data.Metrics;

/**
 * @author zhefang
 * 
 */
public interface ReportService {

	public Report create(Report report);

	public List<Report> listReportsByApp(String appId);

	public List<Metrics> getData(String reportId, String starttime,
			String endtime);

	public Report get(String reportId);
}