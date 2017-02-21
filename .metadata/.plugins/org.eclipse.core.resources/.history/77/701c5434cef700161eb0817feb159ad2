<%@page import="kr.co.mlec.board.dao.BoardDAO"%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	BoardDAO dao = new BoardDAO();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	dao.deleteBoard(no);
%>	
<%	if (dao.deleteBoard(no)) { %>
		<h2>게시물 삭제가 완료되었습니다.</h2><br>
<%	} else { %>
		<h2>글번호에 해당하는 게시물이 없습니다.</h2><br>
<%	} %>
	<a href='list.jsp'>목록</a>
</body>
</html>