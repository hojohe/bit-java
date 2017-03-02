package kr.co.mlec.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@RequestMapping("/main.do")
	public void main() throws Exception {}
	/*public ModelAndView main() throws Exception {
		return new ModelAndView("main/main");
	}*/
}