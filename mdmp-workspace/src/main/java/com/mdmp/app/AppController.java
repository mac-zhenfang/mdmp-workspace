/**
 * 
 */
package com.mdmp.app;

import java.io.IOException;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mdmp.report.Report;
import com.mdmp.util.Pagination;
import com.mdmp.util.StringValidator;

/**
 * @author zhefang
 * 
 */
@Controller
public class AppController {

	@Resource(name = "appService")
	private AppService appService;

	private static ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value = "/apps", method = RequestMethod.POST)
	public @ResponseBody
	App create(@RequestBody String appStr) throws IOException {
		StringValidator.verifyEmpty("jsonObject", appStr);
		App app = mapper.readValue(appStr, App.class);
		return appService.create(app);
	}

	@RequestMapping(value = "/apps/{id}", method = RequestMethod.GET)
	public @ResponseBody
	App get(@PathVariable String id) {
		return appService.get(id);
	}

	@RequestMapping(value = "/orgs/{orgId}/apps", method = RequestMethod.GET)
	public @ResponseBody
	Pagination<App> listByOrgId(@PathVariable String orgId) {
		return new Pagination<App>(appService.listAppByOrg(orgId));
	}

}
