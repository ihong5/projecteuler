package net.inkihong.project.euler.controller.jsp;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import net.inkihong.project.euler.model.Solution;

@Controller
public class JSPController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/solutions/{problem}", method = RequestMethod.GET)
	public ModelAndView solution(@PathVariable int problem) {
		ModelAndView solution = new ModelAndView("solution");
		Solution s = null;
		solution.addObject("solution", s);
		return solution;
	}
}