package kr.co.mlec.board.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardCommentVO;
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.board.vo.PageResultVO;
import kr.co.mlec.board.vo.SearchVO;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	ServletContext servletContext;
	
	private BoardDAO dao;
	public BoardController() {
		this.dao = new BoardDAO();
	}
	
	@RequestMapping("/writeForm.do")
	public void writeForm() throws Exception {}
//	public String writeForm() throws Exception {
//		return "board/writeForm";
//	}
	
	@RequestMapping("/write.do")
	public String write(MultipartHttpServletRequest mRequest, RedirectAttributes attr) throws Exception {

		String uploadDir = servletContext.getRealPath("/upload");
		
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
		String datePath = sdf.format(new Date());
		
		String savePath = uploadDir + datePath;
		File f = new File(savePath);
		if (!f.exists()) f.mkdirs();
		
		String id = mRequest.getParameter("id");
		System.out.println("id : " + id);
		
		
		Iterator<String> iter = mRequest.getFileNames();
		while(iter.hasNext()) {
			
			String formFileName = iter.next();
			// 폼에서 파일을 선택하지 않아도 객체 생성됨
			MultipartFile mFile = mRequest.getFile(formFileName);
			
			// 원본 파일명
			String oriFileName = mFile.getOriginalFilename();
			System.out.println("원본 파일명 : " + oriFileName);
			
			if(oriFileName != null && !oriFileName.equals("")) {
			
				// 확장자 처리
				String ext = "";
				// 뒤쪽에 있는 . 의 위치 
				int index = oriFileName.lastIndexOf(".");
				if (index != -1) {
					// 파일명에서 확장자명(.포함)을 추출
					ext = oriFileName.substring(index);
				}
				
				// 파일 사이즈
				long fileSize = mFile.getSize();
				System.out.println("파일 사이즈 : " + fileSize);
				
				// 고유한 파일명 만들기	
				String saveFileName = "mlec-" + UUID.randomUUID().toString() + ext;
				System.out.println("저장할 파일명 : " + saveFileName);
			
				// 임시저장된 파일을 원하는 경로에 저장
				mFile.transferTo(new File(savePath + "/" + saveFileName));
				
				// 게시판과 파일 테이블에 저장할 글번호를 조회
				
				BoardVO board = new BoardVO();
				board.setTitle(mRequest.getParameter("title"));
				board.setWriter(mRequest.getParameter("writer"));
				board.setContent(mRequest.getParameter("content"));
				
				// 게시물 저장 처리 부탁..
				BoardDAO dao = new BoardDAO();
				int no = dao.insertBoard(board);
				
				BoardFileVO boardFile = new BoardFileVO();
				boardFile.setNo(no);
				boardFile.setOriName(oriFileName);
				boardFile.setSystemName(saveFileName);
				boardFile.setFilePath(datePath);
				boardFile.setFileSize(fileSize);
				
				dao.insertBoardFile(boardFile);
				
				
			} 
		} 
		
		
		attr.addFlashAttribute("msg", "게시물이 등록되었습니다");
		
		return "redirect:/board/list.do";
		
	}
	
	@RequestMapping("/updateForm.do")
	public ModelAndView updateForm(int no) throws Exception {

		BoardVO board = dao.selectOneBoard(no);
		
		ModelAndView mav = new ModelAndView("board/updateForm");
		mav.addObject("board", board);
		
		return mav;
	}	
	
	@RequestMapping("/update.do")
	public String update (BoardVO board, RedirectAttributes attr) throws Exception {
		
		/*BoardVO boardVO = new BoardVO();
		boardVO.setNo(Integer.parseInt(request.getParameter("no")));
		boardVO.setTitle(request.getParameter("title"));
		boardVO.setContent(request.getParameter("content"));
		dao.updateBoard(boardVO);*/
		
//		dao.updateBoard((BoardVO)WebUtil.getParamToVO(request, BoardVO.class));
		
		dao.updateBoard(board);

		attr.addFlashAttribute("msg", "게시물이 수정되었습니다");
		
		return "redirect:/board/list.do";
		
	}
	
	
	@RequestMapping("/list.do")
	public ModelAndView list(SearchVO search) throws Exception {
System.out.println(search.getBegin());
System.out.println(search.getEnd());
System.out.println(search.getPageNo());

		List<BoardVO> list = dao.selectBoard(search);
		int count = dao.selectBoardCount(search);
		
		ModelAndView mav = new ModelAndView("board/list");
		mav.addObject("list", list);
		
		mav.addObject("pageResult", new PageResultVO(search.getPageNo(), count));
		return mav;
		
	}
	
	
	@RequestMapping("/detail.do")
	public ModelAndView detail(@RequestParam(value="no") int no) throws Exception {
		
		// 게시물 정보 추출
		BoardVO boardVO = dao.selectOneBoard(no);
		// 게시물과 연관된 파일 정보 추출
		BoardFileVO fileVO = dao.selectBoardFileByNo(no);

		ModelAndView mav = new ModelAndView("board/detail");
		mav.addObject("boardVO", boardVO);
		mav.addObject("file", fileVO);
		
		return mav;
	}
	
	@RequestMapping("/delete.do")
	public String delete(int no, RedirectAttributes attr) throws Exception {
		
		dao.deleteBoard(no);
	
		attr.addFlashAttribute("msg", "게시물이 삭제되었습니다");
		return "redirect:/board/list.do";

	}
	
	@RequestMapping("/commentUpdate.do")
	@ResponseBody
	public List<BoardCommentVO> commentUpdate(BoardCommentVO comment) throws Exception {
		
		// 게시판과 파일 테이블에 저장할 글번호를 조회
		/*BoardCommentVO comment = new BoardCommentVO();
		comment.setContent(request.getParameter("content"));
		comment.setCommentNo(commentNo);*/
		
//		dao.updateBoardComment((BoardCommentVO)WebUtil.getParamToVO(request, BoardCommentVO.class));
		
		dao.updateBoardComment(comment);
		return dao.selectBoardCommentByNo(comment.getNo());
		
		
		
	}
	
	@RequestMapping("/commentRegist.do")
	@ResponseBody
	public List<BoardCommentVO> commentRegist(BoardCommentVO comment) throws Exception {
		
		
		// 게시판과 파일 테이블에 저장할 글번호를 조회
		/*BoardCommentVO comment = new BoardCommentVO();
		comment.setNo(no);
		comment.setContent(request.getParameter("content"));
		comment.setUserId(request.getParameter("userId"));*/
		
		// 게시물 저장 처리 부탁..
		dao.insertBoardComment(comment);
		return dao.selectBoardCommentByNo(comment.getNo());
	}
	
	@RequestMapping("/commentList.do")
	@ResponseBody
	public List<BoardCommentVO> commentList(int no) throws Exception {
		
		return dao.selectBoardCommentByNo(no);
	}
	
	
	
	@RequestMapping("/commentDelete.do")
	@ResponseBody
	public List<BoardCommentVO> commentDelete(BoardCommentVO comment) throws Exception {

		dao.deleteBoardComment(comment.getCommentNo());
		return dao.selectBoardCommentByNo(comment.getNo());
	}
	
}
