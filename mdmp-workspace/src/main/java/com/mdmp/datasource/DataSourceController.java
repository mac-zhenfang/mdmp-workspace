package com.mdmp.datasource;

import java.io.IOException;

import javax.annotation.Resource;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mdmp.util.Pagination;
import com.mdmp.util.StringValidator;


@Controller
public class DataSourceController {
	@Resource(name = "dataSourceService")
	private DataSourceService DataSourceService;

	private static ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value = "/ds", method = RequestMethod.POST)
	public @ResponseBody
	DataSource create(@RequestBody String appStr) throws IOException {
		StringValidator.verifyEmpty("jsonObject", appStr);
		DataSource DataSource = mapper.readValue(appStr, DataSource.class);
		return DataSourceService.create(DataSource);
	}

	@RequestMapping(value = "/ds/{id}", method = RequestMethod.GET)
	public @ResponseBody
	DataSource get(@PathVariable String id) {
		return DataSourceService.get(id);
	}

	@RequestMapping(value = "/apps/{appId}/ds", method = RequestMethod.GET)
	public @ResponseBody
	Pagination<DataSource> listByOrgId(@PathVariable String appId) {
		return new Pagination<DataSource>(DataSourceService.listDataSourceByApp(appId));
	}
}
