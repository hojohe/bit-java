package kr.co.mlec.login.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.mlec.board.dao.MemberDAO;
import kr.co.mlec.board.vo.MemberVO;

@Controller
@RequestMapping("/login")
public class LoginController {

	private MemberDAO dao;
	public LoginController() {
		dao = new MemberDAO();
	}
	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest request) throws Exception {
		//세션을 삭제한 후 main.jsp 페이지로 이동시킨다.
		HttpSession session = request.getSession();
		session.invalidate();//세션삭제
		return "redirect:/main/main.do";
		
	}
	
	@RequestMapping("/loginForm.do")
	public void loginForm() throws Exception {}
/*	public String loginForm() throws Exception {
		ModelAndView mav = new ModelAndView();
		return "login/loginForm";
	}
*/	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request, RedirectAttributes attr) throws Exception {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		MemberVO member = dao.getMemberInfo(id, password);
		
		if(member == null) {
			ModelAndView mav = new ModelAndView("login/loginForm");
			attr.addFlashAttribute("msg", "입력하신 정보가 올바르지 않습니다.");
			return "redirect:/login/loginForm";
		}
		
		if(id.equals(member.getUserId()) && password.equals(member.getPassword())) {
			
			MemberVO login = new MemberVO();
			login.setUserId(member.getUserId());
			login.setPassword(member.getPassword());
			login.setEmail(member.getEmail());
			
			HttpSession session = request.getSession();
			session.setAttribute("user", member);
			return "redirect:/main/main.do";
		}
		else {
			ModelAndView mav = new ModelAndView("login/loginForm");
			attr.addFlashAttribute("msg", "입력하신 정보가 올바르지 않습니다.");
			return "redirect:/login/loginForm";
		}
	}
}
