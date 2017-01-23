<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%

	List<String> list = new ArrayList<>();
	list.add("one");
	list.add("two");
	list.add("three");
	list.add("four");
	pageContext.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
	<%--
		for(int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
	--%>
	
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:out value="${i}"	/><br>
	</c:forEach>
	
	생년월일 : 
	<select>
		<c:forEach var="i" begin="1980" end="2000">
			<option><c:out value="${i}"	/></option>
		</c:forEach>
	</select>
	<br>
	<%--
		for(String s : list) {
			System.out.println(s);
		}
	--%>
	<br>
	<c:forEach var="s" items="${list}" varStatus="loop">
		<c:out value="${s}"	/><br>
	</c:forEach>
	<br>
	<br>
	
	<c:set var="cnt" value="1" scope="page" />
	<c:forEach var="s" items="${list}">
		
		<c:if test="${cnt==4}">
			<c:set var="a" value=""	/>
		</c:if>
		<c:if test="${cnt!=4}">
			<c:set var="a" value=","/>
		</c:if>
		
		<c:out value="${s}"	/><c:out value="${a}"	/>
		<c:set var="cnt" value="${cnt + 1}"	/>
	</c:forEach>
	
	<br>
	<br>
	<c:forEach var="s" items="${list}" varStatus="loop">
		${loop.first}:::${loop.last}:::${loop.index}:::${loop.count}<br>
	</c:forEach>
	
	
	
	<br>
	<br>
	<c:forEach var="s" items="${list}" varStatus="loop">
		<c:out value="${s}"	/>
		<c:if test="${not loop.first}">
			,
		</c:if>
	</c:forEach>
	
	
</body>
</html>