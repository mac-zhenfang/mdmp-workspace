package com.mdmp;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.mdmp.app.App;
import com.mdmp.datasource.DataSource;
import com.mdmp.member.Member;
import com.mdmp.model.Model;
import com.mdmp.org.Org;
import com.mdmp.report.Report;


public class MockContext {

	public static Map<String, Object> mock(String orgId, String memberId,
			String modelId) {
		return mock(orgId, memberId, null, null, modelId, null);
	}

	public static Map<String, Object> mock(String orgId, String memberId,
			String appId, String datasourceId, String modelId, String reportId) {
		Map<String, Object> retMap = new HashMap<String, Object>();
		if (null == orgId) {
			orgId = UUID.randomUUID().toString();
		}
		Org org = mockOrg(orgId);
		if (null == memberId) {
			memberId = UUID.randomUUID().toString();
		}
		Member member = mockMember(memberId, org.getId());
		if (null == appId) {
			appId = UUID.randomUUID().toString();
		}
		App app = mockApp(appId, member.getId(), org.getId());
		if (null == datasourceId) {
			datasourceId = UUID.randomUUID().toString();
		}
		DataSource ds = mockDataSource(datasourceId, app.getId());
		if (null == modelId) {
			modelId = UUID.randomUUID().toString();
		}
		Model md = mockModel(modelId, member.getId());
		if (null == reportId) {
			reportId = UUID.randomUUID().toString();
		}
		Report report = mockReport(reportId, member.getId(), md.getId(),
				app.getId(), ds.getId());
		retMap.put("org", org);
		retMap.put("member", member);
		retMap.put("app", app);
		retMap.put("datasource", ds);
		retMap.put("model", md);
		retMap.put("report", report);
		return retMap;
	}

	public static Map<String, Object> mock() {
		return mock(UUID.randomUUID().toString(), UUID.randomUUID().toString(),
				UUID.randomUUID().toString(), UUID.randomUUID().toString(),
				UUID.randomUUID().toString(), UUID.randomUUID().toString());
	}

	public static App mockApp(String appId, String userId, String orgId) {
		App app = new App();
		app.setId(appId);
		app.setUid(userId);
		app.setOid(orgId);
		app.setName("test_app_"+System.currentTimeMillis());
		app.setDescription("my description");
		app.setCreatedTime("2013-04-27 09:11:01");
		return app;
	}

	public static DataSource mockDataSource(String dsId, String aid) {
		DataSource ds = new DataSource();
		ds.setAid(aid);
		ds.setId(dsId);
		ds.setName("ds_"+System.currentTimeMillis());
		ds.setDescription("my description");
		ds.setCreatedTime("2013-04-27 09:11:01");
		return ds;
	}

	public static Org mockOrg(String orgId) {
		Org org = new Org();
		org.setId(orgId);
		org.setName("new org_"+System.currentTimeMillis());
		org.setDescription("description");
		org.setCreatedTime("2013-04-27 09:11:01");
		return org;
	}

	public static Report mockReport(String rptId, String uid, String mid,
			String aid, String did) {
		Report report = new Report();
		report.setId(rptId);
		report.setDid(did);
		report.setAid(aid);
		report.setUid(uid);
		report.setMid(mid);
		report.setName("MockReport_1_"+System.currentTimeMillis());
		report.setReportType("pie");
		report.setStarttime("04/22/2013 09:11:01");
		report.setEndtime("04/27/2013 09:11:01");
		report.setLogic("{input:[\"key1\"],op:\"incr\",val:\"1\",where:\"\",groupby:[\"key2\"],output:[\"metric1\"]}");
		report.setDescription("set description for MockReport_1");
		report.setCreatedTime("2013-04-27 09:11:01");
		return report;
	}

	public static Member mockMember(String memberId, String orgId) {
		Member member = new Member();
		member.setId(memberId);
		member.setName("macf_"+System.currentTimeMillis());
		member.setOid(orgId);
		member.setRole("admin");
		member.setCreatedTime("2013-04-27 09:11:01");
		return member;
	}

	public static Model mockModel(String modelId, String userId) {
		Model model = new Model();
		model.setId(modelId);
		model.setLogic("{input:[\"$key1$\"],op:\"incr\",val:\"1\",where:\"\",groupby:[\"$key2$\"],output:[\"$metric1$\"]}");
		model.setUid(userId);
		model.setName("model name_"+System.currentTimeMillis());
		model.setDescription("first test");
		model.setCreatedTime("2013-04-27 09:11:01");
		return model;
	}
	// public static Org mockOrg(){
	//
	// }
}
