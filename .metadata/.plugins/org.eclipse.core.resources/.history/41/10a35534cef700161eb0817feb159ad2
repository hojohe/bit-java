<%@page import="java.text.SimpleDateFormat"%>
<%@page import="kr.co.mlec.board.vo.BoardVO"%>
<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	BoardDAO dao = new BoardDAO();
	BoardVO boardVO = dao.selectOneBoard(Integer.parseInt(request.getParameter("no")));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<hr>
	<% if (boardVO != null) { %>
			번호 : <%=boardVO.getNo()%><br>
			제목 : <%=boardVO.getTitle()%><br>
			글쓴이 : <%=boardVO.getWriter()%><br>
			내용 : <%=boardVO.getContent()%><br>
			등록일 : <%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(boardVO.getRegDate())%><br>
	<% } else { %>
			글번호에 해당하는 게시물이 없습니다.
	<% } %>
		<hr>
		<a href='updateForm.jsp?no=<%=boardVO.getNo()%>'>수정</a>
		<a href='delete.jsp?no=<%=boardVO.getNo()%>'>삭제</a>
		<a href='list.jsp'>목록</a>
</body>
</html>

		
		
		
