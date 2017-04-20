package net.inkihong.project.euler.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.inkihong.project.euler.model.Solution;
import net.inkihong.project.euler.service.SolutionService;

@Controller
public class SolutionController {
	
	@RequestMapping(value = "/api/{problem}", method = RequestMethod.GET)
	public @ResponseBody Solution getSolution(@PathVariable int problem) {
		Solution s = new Solution();
		SolutionService service = new SolutionService();
		s.setqNo(problem);
		s.setAnswer(service.getAnswer(problem));
		return s;
	}
}
