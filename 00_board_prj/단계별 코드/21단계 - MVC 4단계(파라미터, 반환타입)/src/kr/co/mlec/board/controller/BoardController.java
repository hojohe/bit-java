package kr.co.mlec.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.mvc.ModelAndView;
import org.springframework.mvc.RequestMapping;
import org.springframework.mvc.RequestParam;
import org.springframework.mvc.WebUtil;

import com.google.gson.Gson;
import com.oreilly.servlet.MultipartRequest;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardCommentVO;
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.file.MlecFileRenamePolicy;

public class BoardController {
	private BoardDAO dao;
	public BoardController() {
		this.dao = new BoardDAO();
	}
	
	@RequestMapping("/board/writeForm.do")
	public void writeForm() throws Exception {}
	
	@RequestMapping("/board/write.do")
	public ModelAndView write(HttpServletRequest request) throws Exception {
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/upload");
		
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		String datePath = sdf.format(new Date());
		
		String savePath = path + datePath;
		File f = new File(savePath);
		if (!f.exists()) f.mkdirs();
		
		// 파일 처리를 위한 API 클래스 호출
		MultipartRequest mRequest = new MultipartRequest(
				request, 
				savePath, 
				1024 * 1024 * 10, 
				"UTF-8",
				new MlecFileRenamePolicy()
		);
		
		// 게시판과 파일 테이블에 저장할 글번호를 조회
		int no = dao.insertBoard((BoardVO)WebUtil.getParamToVO(mRequest, BoardVO.class));
		
		File file = mRequest.getFile("attachFile");
		if (file != null) {
			String oriName = mRequest.getOriginalFileName("attachFile");
			String systemName = mRequest.getFilesystemName("attachFile");
			long fileSize = file.length();
			
			BoardFileVO boardFile = new BoardFileVO();
			boardFile.setNo(no);
			boardFile.setOriName(oriName);
			boardFile.setSystemName(systemName);
			boardFile.setFilePath(datePath);
			boardFile.setFileSize(fileSize);
			
			dao.insertBoardFile(boardFile);
		}
		
		ModelAndView mav = new ModelAndView("list.do");
		mav.addAttribute("msg", "게시물이 등록되었습니다");
		return mav;
	}

	@RequestMapping("/board/updateForm.do")
	public ModelAndView updateForm(int no) throws Exception {
		BoardVO board = dao.selectOneBoard(no);
		ModelAndView mav = new ModelAndView("board/updateForm");
		mav.addAttribute("board", board);
		return mav;
	}
	
	@RequestMapping("/board/update.do")
	public ModelAndView update(BoardVO board) throws Exception {
		dao.updateBoard(board);

		ModelAndView mav = new ModelAndView("list.do");
		mav.addAttribute("msg", "게시물이 수정되었습니다");
		return mav;
	}
	
	@RequestMapping("/board/list.do")
	public ModelAndView list() throws Exception {
		List<BoardVO> list = dao.selectBoard();
		ModelAndView mav = new ModelAndView("board/list");
		mav.addAttribute("list", list);
		return mav;
	}
	
	@RequestMapping("/board/detail.do")
	public ModelAndView detail(@RequestParam(value="no") int no) throws Exception {
		// 게시물 정보 추출
		BoardVO boardVO = dao.selectOneBoard(no);
		
		// 게시물과 연관된 파일 정보 추출
		BoardFileVO fileVO = dao.selectBoardFileByNo(no);
		
		ModelAndView mav = new ModelAndView("board/detail");
		mav.addAttribute("boardVO", boardVO);
		mav.addAttribute("file", fileVO);
		return mav;
	}
	
	@RequestMapping("/board/delete.do")
	public ModelAndView delete(int no) throws Exception {
		dao.deleteBoard(no);
		
		ModelAndView mav = new ModelAndView("list.do");
		mav.addAttribute("msg", "게시물이 삭제되었습니다");
		return mav;
	}
	
	@RequestMapping("/board/commentUpdate.do")
	public String commentUpdate(BoardCommentVO comment) throws Exception {
		// 게시판과 파일 테이블에 저장할 글번호를 조회
		dao.updateBoardComment(comment);
		return "ajax:" + new Gson().toJson(dao.selectBoardCommentByNo(comment.getNo()));
	}
	
	@RequestMapping("/board/commentRegist.do")
	public String commentRegist(BoardCommentVO comment) throws Exception {
		dao.insertBoardComment(comment);
		return "ajax:" + new Gson().toJson(dao.selectBoardCommentByNo(comment.getNo()));
	}
	
	@RequestMapping("/board/commentList.do")
	public String commentList(int no) throws Exception {
		return "ajax:" + new Gson().toJson(dao.selectBoardCommentByNo(no));
	}
	
	@RequestMapping("/board/commentDelete.do")
	public String commentDelete(BoardCommentVO comment) throws Exception {
		dao.deleteBoardComment(comment.getCommentNo());
		return "ajax:" + new Gson().toJson(dao.selectBoardCommentByNo(comment.getNo()));
	}
}










