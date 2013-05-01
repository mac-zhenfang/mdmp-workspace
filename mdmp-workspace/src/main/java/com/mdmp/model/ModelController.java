/**
 * 
 */
package com.mdmp.model;

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
import com.mdmp.util.StringValidator;

/**
 * @author zhefang
 * 
 */

@Controller
public class ModelController {
	@Resource(name = "modelService")
	private ModelService modelService;

	protected void setService(ModelService modelService) {
		this.modelService = modelService;
	}

	private static ObjectMapper mapper = new ObjectMapper();

	@RequestMapping(value = "/models", method = RequestMethod.POST)
	public @ResponseBody
	Model create(@RequestBody String modelStr) throws IOException {
		StringValidator.verifyEmpty("jsonObject", modelStr);
		Model model = mapper.readValue(modelStr, Model.class);
		return modelService.create(model);
	}

	@RequestMapping(value = "/models/{id}", method = RequestMethod.GET)
	public @ResponseBody
	Model get(@PathVariable String id) {
		return modelService.get(id);
	}

}
