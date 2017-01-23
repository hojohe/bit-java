package network.exam;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;

public class Exam01 {
	
	public static void main(String[] args) {

		try {
			
			BoardDAO dao = new BoardDAO();
			
			ServerSocket server = new ServerSocket(10001);
			String request = "";
			String[] paths;
			
			while (true) {
				
				Socket client = server.accept();
				System.out.println("연결 성공!");
				
				InputStream in = client.getInputStream();
				InputStreamReader isr = new InputStreamReader(in);
				BufferedReader br = new BufferedReader(isr);
				String line = br.readLine();
				System.out.println("line " + line);
				if (line.equals("")) break;

				request += line;
				System.out.println("request > " + request);
				String[] requests = request.split(" ");
				paths = requests[1].split("\\?");
				
				System.out.println("찍어본다 > " + paths[0]);
				
				
				if (paths[0].equals("/list")) {
					
					List<BoardVO> list = dao.selectBoard();
				
					/*List<BoardVO> list = new ArrayList<>();
					
					BoardVO vo = new BoardVO();
					vo.setNo(1);
					vo.setTitle("1번글");
					vo.setContent("1번글 내용");
					vo.setRegDate(new Date());
					list.add(vo);
					
					BoardVO vo2 = new BoardVO();
					vo2.setNo(2);
					vo2.setTitle("2번글");
					vo2.setContent("2번글 내용");
					vo2.setRegDate(new Date());
					list.add(vo2);*/
					
					String htmlStart = " <html>                            "
							      + " 	<head>                             "
							      + " 		<meta charset=\"UTF-8\">       "
							      + " 		<title>게시판 조회</title>       "
							      + " 	</head>                            "
						 	      + " <body>                               "
								  + "<table border=\"1\">				   "
				                  + "                                      "
								  + "<thead>                               "
								  + "	<th>번호</th>                      "
								  + "	<th>제목</th>                      "
								  + "	<th>내용</th>                      "
								  + "	<th>글쓴이</th>                     "
								  + "	<th>등록일자</th>                   "
								  + "</thead>                              "
								  + "<tbody>                               ";
					
					String htmlRow = "";
					for(BoardVO board : list) {
						
						htmlRow +=  "<tr>                               "
								+ "	<td>" + board.getNo()      + "</td>"
								+ "	<td>" + board.getTitle()   + "</td>"
								+ "	<td>" + board.getContent() + "</td>"
								+ "	<td>" + board.getWriter()  + "</td>"
								+ "	<td>" + board.getRegDate() + "</td>"
								+ "</tr>                               ";
						

					}
					
					String htmlEnd =  "</tbody>"
									+ "</table>"
									+ "</body> "
									+ "</html> ";
					String html = htmlStart + htmlRow + htmlEnd;
					
					
					String startLine = "HTTP/1.1 200 OK\r\n";
					String headers = "Cache-Control: no-cache\r\n"
							       + "Content=Type: text/html; charset=UTF-8\r\n" //응답할때 메시지에 한글이 있을 수 있으니 UTF-8
							       + "Content-Length: " + html.getBytes().length + "\r\n\r\n";
					
					
					String all = startLine + headers + html;

					OutputStream out = client.getOutputStream();
					out.write(all.getBytes());
					out.flush();
					
					
				} else if(paths[0].equals("/delete")) {
					
				
				
				}
				
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
