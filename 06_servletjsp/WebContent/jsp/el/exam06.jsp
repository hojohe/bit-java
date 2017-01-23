<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String[] names = {"홍","길","동","민","중","의"};
	pageContext.setAttribute("names", names);
	
	List<String> list = new ArrayList<>();
	list.add("홍");
	list.add("길");
	list.add("동");
	
	pageContext.setAttribute("list", list);
	
	

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	name[0] : ${names[0]}<br>
	list[0] : ${list[0]}<br>
	list[1] : ${list[1]}<br>
	list[2] : ${list[2]}<br>
</body>
</html>