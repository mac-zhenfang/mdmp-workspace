package com.mdmp;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


import com.mdmp.app.App;
import com.mdmp.datasource.DataSource;
import com.mdmp.model.Model;
import com.mdmp.org.Org;
import com.mdmp.report.Report;
import com.mdmp.user.Member;

public class MockContext {

	public static Map<String, Object> mock() {
		Map<String, Object> retMap = new HashMap<String, Object>();
		Org org = mockOrg();
		Member member = mockMember(org.getId());
		App app = mockApp(member.getId(), org.getId());
		DataSource ds = mockDataSource(app.getId());
		Model md = mockModel(member.getId());
		Report report = mockReport(md.getId(), app.getId(), ds.getId());
		retMap.put("org", org);
		retMap.put("member", member);
		retMap.put("app", app);
		retMap.put("datasource", ds);
		retMap.put("model", md);
		retMap.put("report", report);
		return retMap;
	}

	public static App mockApp(String userId, String orgId) {
		App app = new App();
		app.setId(UUID.randomUUID().toString());
		app.setUid(userId);
		app.setOid(orgId);
		app.setName("test_app");
		app.setDescription("my description");
		app.setCreatedTime("2013-04-27 09:11:01");
		return app;
	}

	public static DataSource mockDataSource(String aid) {
		DataSource ds = new DataSource();
		ds.setAid(aid);
		ds.setId(UUID.randomUUID().toString());
		ds.setName("ds");
		ds.setDescription("my description");
		ds.setCreatedTime("2013-04-27 09:11:01");
		return ds;
	}

	public static Org mockOrg() {
		Org org = new Org();
		org.setId(UUID.randomUUID().toString());
		org.setName("new org");
		org.setDescription("description");
		org.setCreatedTime("2013-04-27 09:11:01");
		return org;
	}

	public static Report mockReport(String mid, String aid, String did) {
		Report report = new Report();
		report.setDid(did);
		report.setAid(aid);
		report.setMid(mid);
		report.setName("MockReport_1");
		report.setReportType("pie");
		report.setStarttime("04/22/2013 09:11:01");
		report.setEndtime("04/27/2013 09:11:01");
		report.setLogic("{input:[\"key1\"],op:\"incr\",val:\"1\",where:\"\",groupby:[\"key2\"],output:[\"metric1\"]}");
		report.setDescription("set description for MockReport_1");
		report.setId(UUID.randomUUID().toString());
		report.setCreatedTime("2013-04-27 09:11:01");
		return report;
	}

	public static Member mockMember(String orgId) {
		Member member = new Member();
		member.setId(UUID.randomUUID().toString());
		member.setName("macf");
		member.setOid(orgId);
		member.setRole("admin");
		member.setCreatedTime("2013-04-27 09:11:01");
		return member;
	}

	public static Model mockModel(String userId) {
		Model model = new Model();
		model.setId(UUID.randomUUID().toString());
		model.setLogic("{input:[\"$key1$\"],op:\"incr\",val:\"1\",where:\"\",groupby:[\"$key2$\"],output:[\"$metric1$\"]}");
		model.setUid(userId);
		model.setName("model name");
		model.setDescription("first test");
		model.setCreatedTime("2013-04-27 09:11:01");
		return model;
	}
	// public static Org mockOrg(){
	//
	// }
}
