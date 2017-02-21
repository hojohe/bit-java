package kr.co.mlec.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.mvc.Controller;
import org.springframework.mvc.ModelAndView;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

public class ListController implements Controller {
	
	private BoardDAO dao;
	
	public ListController() {
		this.dao = new BoardDAO();
	}
	
	public ModelAndView service (
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 공유 데이터 
		List<BoardVO> list = dao.selectBoard();
		
		ModelAndView mav = new ModelAndView("/board/list.do");
		mav.addAttribute("list", list);
		
		return mav;
		
		
	}
}
