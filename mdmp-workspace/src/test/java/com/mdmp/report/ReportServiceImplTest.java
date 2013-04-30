/**
 * 
 */
package com.mdmp.report;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.mdmp.MockContext;
import com.mdmp.model.Model;
import com.mdmp.model.ModelDao;
import com.mdmp.user.Member;
import com.mdmp.util.UserSessionUtil;

/**
 * @author zhefang
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/applicationContext.xml")
@TransactionConfiguration(defaultRollback = true)
@Transactional
public class ReportServiceImplTest {

	@Resource(name = "modelDao")
	private ModelDao modelDao;

	@Resource(name = "reportService")
	ReportService reportService;
	Map<String, Object> mocks = null;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mocks = MockContext.mock();
	}

	@Test
	public void testCreateGetList() throws Exception {
		Model model = (Model) mocks.get("model");
		Member member = (Member) mocks.get("member");
		Report report = (Report) mocks.get("report");
		modelDao.create(model);
		UserSessionUtil.setUser(member);
		reportService.create(report);
		Report retReport = reportService.get(report.getId());
		assertEquals(report.getAid(), retReport.getAid());

		List<Report> reports = reportService.listReportsByApp(report.getAid());
		System.out.println(reports.size());
		assertEquals(reports.get(0).getId(), report.getId());
		assertEquals(reports.get(0).getAid(), report.getAid());
	}

}
