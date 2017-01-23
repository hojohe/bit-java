<%@page import="jsp.Count"%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Count c = new Count();
	c.setNum(100);
	
	pageContext.setAttribute("c", c);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	프로젝트 경로명 : ${pageContext.request.contextPath}<br>
	<!-- test@a.com -->
	c.num : ${c.num}<br>
	c.num : ${c["num"]}<br>
	<%-- 
	c.val : ${c.val}<br>	// 오류발생
	--%>
</body>
</html>