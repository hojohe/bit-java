package kr.co.mlec.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.co.mlec.form.MemberVO;

public class AuthInterceptor extends HandlerInterceptorAdapter {
	// preHandle = 컨트롤러가 실행 전에 수행!
	// postHandle = 컨트롤러가 실행 후에 수행!
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession();
		MemberVO member = (MemberVO) session.getAttribute("user");
		if (member != null) {
			return true;
		}
		response.sendRedirect("loginForm.do");
		return false; // 실행하고 있던 컨트롤러를 중단해라
	}
}
