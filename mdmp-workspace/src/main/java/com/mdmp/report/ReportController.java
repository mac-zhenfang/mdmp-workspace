/**
 * 
 */
package com.mdmp.report;

import java.io.IOException;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mdmp.util.Pagination;
import com.mdmp.util.StringValidator;

/**
 * @author zhefang
 *
 */
@Controller
public class ReportController {
	
	@Resource(name = "reportService")
	private ReportService reportService;
	
	protected void setService(ReportService reportService) {
		this.reportService = reportService;
	}
	
	private static ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value = "/reports", method = RequestMethod.POST)
	public @ResponseBody
	Report create(@RequestBody String reportStr) throws IOException {
		StringValidator.verifyEmpty("jsonObject", reportStr);
		Report report = mapper.readValue(reportStr, Report.class);
		return reportService.create(report);
	}
	
	@RequestMapping(value = "/reports/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Report get(@PathVariable String id) {
		return reportService.get(id);
	}

//	@RequestMapping(value = "/reports/{id}", method = RequestMethod.PUT)
//	public @ResponseBody
//	Object update(@PathVariable String id, @RequestBody String reportStr) throws IOException {
//		StringValidator.verifyEmpty("jsonObject", reportStr);
//		Report report = mapper.readValue(reportStr, Report.class);
//		report.setId(id);
//		reportService.update(report);
//		return Success.get();
//	}

//	@RequestMapping(value = "/reports/{id}", method = RequestMethod.DELETE)
//	public @ResponseBody
//	Object remove(@PathVariable String id) {
//		reportService.remove(id);
//		return Success.get();
//	}
	
	@RequestMapping(value = "/apps/{appId}/reports", method = RequestMethod.GET)
	public @ResponseBody
	Pagination<Report> listByProjectId(@PathVariable String appId) {
		return new Pagination<Report>(reportService.listReportsByApp(appId));
	}

	@RequestMapping(value = "/reports/{id}/actions/getData/invoke", method = RequestMethod.POST)
	public @ResponseBody
	Report getData(@PathVariable String id, @RequestParam String starttime, @RequestParam String endtime)
			throws Exception {
		Report report = reportService.get(id);
		
		report.setData(mapper.writeValueAsString(reportService.getData(id, starttime, endtime)));
		return report;
	}
}
