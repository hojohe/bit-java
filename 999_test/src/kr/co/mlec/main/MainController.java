package kr.co.mlec.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mvc.Controller;
import org.springframework.mvc.ModelAndView;

public class MainController implements Controller {
	public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/main/main.jsp");
		return mav;
	}
}