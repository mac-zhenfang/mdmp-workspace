/**
 * 
 */
package com.mdmp.workspace;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author zhefang
 * 
 */

@Controller
public class WorkspaceController {
	
	@RequestMapping(value="/welcome",method={RequestMethod.GET})
	public ModelAndView getFirstPage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("welcome");
		mv.addObject("name", "My First Spring Mvc");
		return mv;
	}
	@RequestMapping(value="/index",method={RequestMethod.GET})
	public ModelAndView indexPage(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("name", "mdmp");
		return mv;
	}
	
	
}
