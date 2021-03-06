package kr.co.mlec.board.servlet;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardFileVO;
import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.file.MlecFileRenamePolicy;

@WebServlet("/board/write")
public class WriteServlet extends HttpServlet {
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		ServletContext context = request.getServletContext();
		String path = context.getRealPath("/upload");
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/mm/dd");
		String dayPath = sdf.format(new Date());
		
		String saveDirectory = path + dayPath;
		
		File file = new File(saveDirectory);
		if(!file.exists()) {
			file.mkdirs();
		}
				
		MultipartRequest mRequest = new MultipartRequest(
				request, 
				saveDirectory, 
				1024*1024*100, 
				"utf-8",
				new MlecFileRenamePolicy()
		);
		
		
		String title = mRequest.getParameter("title");
		String writer = mRequest.getParameter("writer");
		String content = mRequest.getParameter("content");
		
		BoardVO board = new BoardVO();
		board.setTitle(title);
		board.setWriter(writer);
		board.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		int boardNo = dao.insertBoard(board);
		
		File attachFile = mRequest.getFile("attachFile");
		if(attachFile != null) {
			String oriName = mRequest.getOriginalFileName("attachFile");
			String systemName = mRequest.getFilesystemName("attachFile");
			long fileSize = attachFile.length();
			BoardFileVO fileVo = new BoardFileVO();
			fileVo.setNo(boardNo);
			fileVo.setOriName(oriName);
			fileVo.setSystemName(systemName);
			fileVo.setFilePath(dayPath);
			fileVo.setFileSize(fileSize);
			
			dao.insertFile(fileVo);
			
		}
		
		response.sendRedirect(request.getContextPath() + "/jsp/board/write.jsp");
	
	
	}
}
