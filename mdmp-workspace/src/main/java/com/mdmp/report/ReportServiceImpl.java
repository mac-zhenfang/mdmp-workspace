/**
 * 
 */
package com.mdmp.report;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mdmp.UserSessionUtil;
import com.mdmp.data.CalDataDao;
import com.mdmp.data.Metrics;
import com.mdmp.model.Model;
import com.mdmp.model.ModelDao;

/**
 * @author zhefang
 * 
 */
@Service("reportService")
public class ReportServiceImpl implements ReportService {

	@Resource(name = "reportDao")
	private ReportDao reportDao;

	@Resource(name = "dataDao")
	private CalDataDao dataDao;

	@Resource(name = "modelDao")
	private ModelDao modelDao;

	@Transactional
	@Override
	public Report create(Report report) {
		ReportServiceUtil.verify(report);
		report.setId(UUID.randomUUID().toString());
		// TODO check if the user can create Report - ThreadLocal
		report.setUid(UserSessionUtil.getUser().getId());
		// get logic from Model, verify the logic that send from user follow the
		// grand rule
		Model model = modelDao.get(report.getMid());

		ReportServiceUtil.verifyLogic(report.getLogic(), model.getLogic());

		reportDao.create(report);
		return report;
	}

	@Override
	public List<Report> listReportsByApp(String appId) {
		List<Report> reports = reportDao.listReportByApp(appId);
		return reports == null ? new ArrayList<Report>() : reports;
	}

	/**
	 * time: MM/dd/yyyy HH:mm:ss Change this to Milli
	 * */
	@Override
	public List<Metrics> getData(String reportId, String starttime,
			String endtime) {
		// TODO Auto-generated method stub
		long start = ReportServiceUtil.changeTimestamp(starttime);
		long end = ReportServiceUtil.changeTimestamp(endtime);
		return dataDao.listByTimestamp(reportId, start, end);
	}

	@Override
	public Report get(String reportId) {
		return reportDao.get(reportId);
	}
}
