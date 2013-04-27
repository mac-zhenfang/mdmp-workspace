package com.mdmp.report;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Service;

import com.mdmp.ErrorCode;

@Service("reportDao")
public class ReportDaoImpl extends SqlSessionDaoSupport implements ReportDao {

	@Override
	public List<Report> listReportByApp(String appId) {
		return getSqlSession().selectList("Report.listReportByApp", appId);
	}

	@Override
	public void create(Report report) {
		getSqlSession().insert("Report.create", report);
	}

	@Override
	public void remove(String reportId) {
		// TODO Auto-generated method stub
		throw new ReportServiceException(ErrorCode.COMMON_UNSUPPORT_ERROR);
	}

	@Override
	public void updateReportType(Report report) {
		// TODO Auto-generated method stub
		throw new ReportServiceException(ErrorCode.COMMON_UNSUPPORT_ERROR);
	}

	@Override
	public void updateReportTime(Report report) {
		// TODO Auto-generated method stub
		throw new ReportServiceException(ErrorCode.COMMON_UNSUPPORT_ERROR);
	}

	@Override
	public void updateReportLogic(Report report) {
		// TODO Auto-generated method stub
		throw new ReportServiceException(ErrorCode.COMMON_UNSUPPORT_ERROR);
	}

	@Override
	public Report get(String reportId) {
		return getSqlSession().selectOne("Report.get", reportId);
	}

}
