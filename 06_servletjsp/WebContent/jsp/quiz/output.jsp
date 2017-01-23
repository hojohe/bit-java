<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	int dan = Integer.parseInt(request.getParameter("dan"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>구구단 예제 output</title>
</head>
<body>
<h2>단 : <%=dan%></h2>


<%
	for(int i =1; i <= 9; i++) {
		int result = Integer.parseInt(request.getParameter("dan")) * i; 
%>
		<%=dan%> * <%=i%> = <%=result%><%;%><br>
<%
	}
%> 

</body>
</html>