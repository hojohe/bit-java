package kr.co.mlec.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mvc.Controller;
import org.springframework.mvc.ModelAndView;

public class LoginFormController implements Controller {

	public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mav = new ModelAndView("/jsp/login/loginForm.jsp");
		return mav;
	}
}
