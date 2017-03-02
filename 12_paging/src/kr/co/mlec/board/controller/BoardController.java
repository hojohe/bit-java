package kr.co.mlec.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.mvc.Controller;
import org.springframework.mvc.ModelAndView;
import org.springframework.mvc.RequestMapping;

import com.google.gson.Gson;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.repository.vo.PageResultVO;
import kr.co.mlec.repository.vo.SearchVO;

@Controller
public class BoardController {
	
	private BoardDAO dao;
	
	public BoardController() {
		this.dao = new BoardDAO();
	}
	
	@RequestMapping("/board/list1.do")
	public ModelAndView list1(SearchVO search) throws Exception {
		List<BoardVO> list = dao.selectBoard(search);
		int count = dao.selectBoardCount(search);
		
		// 마지막 페이지 구하기
//		int lastPage = (count % 10 == 0) ? count / 10 : count / 10 + 1;
//		System.out.println(lastPage);
		
		int lastPage = (int)Math.ceil(count / 10d);
		
		ModelAndView mav = new ModelAndView("board/list1");
		mav.addAttribute("list", list);
		mav.addAttribute("count", count);
		mav.addAttribute("lastPage", lastPage);
		mav.addAttribute("pageNo", search.getPageNo());
		return mav;
	}
	
	
	@RequestMapping("/board/list2.do")
	public ModelAndView list2(SearchVO search) throws Exception {
		List<BoardVO> list = dao.selectBoard(search);
		int count = dao.selectBoardCount(search);
		
		// 마지막 페이지
		int lastPage = (int)Math.ceil(count / 10d);
		
		// 목록에 보여질 탭 사이즈
		int tabSize  = 10;
		
		int pageNo = search.getPageNo();
		
		ModelAndView mav = new ModelAndView("board/list2");
		mav.addAttribute("list", list);
		mav.addAttribute("count", count);
		mav.addAttribute("lastPage", lastPage);
		mav.addAttribute("pageNo", pageNo);

		// 현재 페이지에 해당하는 탭 위치, 탭 시작 페이지, 탭 끝 페이지, 이전.다음 페이지 존재 여부 
		int currTab   = (pageNo  -1) / tabSize + 1;
		int beginPage = (currTab -1) * tabSize + 1;  
		int endPage   = (currTab * tabSize < lastPage) ? currTab * tabSize : lastPage;
		boolean prev  = beginPage != 1; 
		boolean next  = endPage != lastPage;

		mav.addAttribute("beginPage", beginPage);
		mav.addAttribute("endPage"  , endPage);
		mav.addAttribute("prev", prev);
		mav.addAttribute("next", next);
		return mav;
	}
	
	@RequestMapping("/board/list3.do")
	public ModelAndView list3(SearchVO search) throws Exception {
		List<BoardVO> list = dao.selectBoard(search);
		int count = dao.selectBoardCount(search);
		
		ModelAndView mav = new ModelAndView("board/list3");
		mav.addAttribute("list", list);
		mav.addAttribute("pageResult", new PageResultVO(search.getPageNo(), count));
		return mav;
	}
	
	@RequestMapping("/board/list4.do")
	public ModelAndView list4(SearchVO search) throws Exception {
		List<BoardVO> list = dao.selectBoard(search);
		int count = dao.selectBoardCount(search);
		
		ModelAndView mav = new ModelAndView("board/list4");
		mav.addAttribute("list", list);
		mav.addAttribute("pageResult", new PageResultVO(search.getPageNo(), count));
		return mav;
	}
	
	@RequestMapping("/board/list5.do")
	public ModelAndView list5(SearchVO search) throws Exception {
		List<BoardVO> list = dao.selectBoard(search);
		int count = dao.selectBoardCount(search);
		
		ModelAndView mav = new ModelAndView("board/list5");
		mav.addAttribute("list", list);
		mav.addAttribute("pageResult", new PageResultVO(search.getPageNo(), count));
		return mav;
	}

	@RequestMapping("/board/list6.do")
	public String list6(SearchVO search) throws Exception {
		List<BoardVO> list = dao.selectBoard(search);
		int count = dao.selectBoardCount(search);
		
		Map<String, Object> result = new HashMap<>();
		result.put("list", list);
		result.put("pageResult", new PageResultVO(search.getPageNo(), count));
		return "ajax:" + new Gson().toJson(result);
	}
	
	public static void main(String[] args) {
		for (int count = 0; count < 100; count++) {
			// 마지막 페이지 구하기
			int p1 = (count % 10 == 0) ? count / 10 : count / 10 + 1;
			int p2 = (int)Math.ceil(count / 10d);
			System.out.println(p1 + "-" + p2);
		}
	}
}










