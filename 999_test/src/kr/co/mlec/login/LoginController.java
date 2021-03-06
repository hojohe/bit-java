package kr.co.mlec.login;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.mvc.Controller;
import org.springframework.mvc.ModelAndView;

import kr.co.mlec.board.dao.MemberDAO;
import kr.co.mlec.board.vo.MemberVO;

public class LoginController implements Controller {

	public ModelAndView service(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		MemberDAO dao = new MemberDAO();
		MemberVO member = dao.getMemberInfo(id, password);
		
		if(member == null) {
			request.setAttribute("msg", "입력하신 정보가 올바르지 않습니다.");
			RequestDispatcher rd = request.getRequestDispatcher("/jsp/login/loginForm.jsp");
			rd.forward(request, response);
		}
		
		if(id.equals(member.getUserId()) && password.equals(member.getPassword())) {
			
			MemberVO login = new MemberVO();
			login.setUserId(member.getUserId());
			login.setPassword(member.getPassword());
			login.setEmail(member.getEmail());
			
			HttpSession session = request.getSession();
			session.setAttribute("user", member);
			
			return new ModelAndView("redirect:" + request.getContextPath() + "/main/main.do");
		}
		else {
			ModelAndView mav = new ModelAndView("/jsp/login/loginForm.jsp");
			mav.addAttribute("msg", "입력하신 정보가 올바르지 않습니다.");
			return mav;
		}
	}
}
