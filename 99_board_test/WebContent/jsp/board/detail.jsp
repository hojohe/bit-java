<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<script src="../js/jquery-3.1.1.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div class="header">
		<c:import url="/jsp/include/topMenu.jsp" />
	</div>
	<div class="content">
		<h3>게시판 상세</h3>
		
		제목 : <c:out value="${board.title}" /><br>
		글쓴이 : <c:out value="${board.writer}" /><br>
		내용 : <br>
		<c:out value="${board.content}" /><br>
		등록일시 : <fmt:formatDate value="${board.regDate}" pattern="yyyy-MM-dd hh:mm:ss" /><br>
		첨부파일 : ${file.oriName} | ${file.fileSize} byte
		<a href="${pageContext.request.contextPath}/file/download?path=${file.filePath}&systemName=${file.systemName}&downName=${file.oriName}">다운로드</a>
		<a href="${pageContext.request.contextPath}/upload${file.filePath}/${file.systemName}">미리보기</a><br>
		<a href="${pageContext.request.contextPath}/board/updateForm?no=${board.no}">수정</a>
		<a href="${pageContext.request.contextPath}/board/delete?no=${board.no}">삭제</a>
		<a href="${pageContext.request.contextPath}/board/list">목록</a>
		
		<h3>댓글</h3>
		<form id="frm" action="${pageContext.request.contextPath}/comment/write" method="post">
			<input type="hidden" name="no" value="${board.no}" />
			<input type="text" name="userId" />
			<input type="text" name="content" />
			<input type="submit" value="등록" />
		</form>
		
		<c:choose>
			<c:when test="${empty comment}">
				<h4>댓글이 존재하지 않습니다.</h4>
			</c:when>
			<c:otherwise>
				
			<form action="${pageContext.request.contextPath}/comment/update" method="post" >
				<input type="hidden" name="no" value="${board.no}"	/>
				<input type="hidden" name="commentNo" value="${commentNo}"	/>
				<table>
					<c:forEach var="comment" items="${comment}" >
						<c:choose>
						<c:when test="${commentNo eq comment.commentNo}">
								<tr>
									<td><c:out value="${comment.userId}" /></td>
									<td><input type="text" name="content" value="<c:out value="${comment.content}"/>"/></td>
									<td><fmt:formatDate value="${comment.regDate}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
									<td><input type="submit" value="등록"/></td>
								</tr>
						</c:when>
						<c:otherwise>
							<tr>
								<td><c:out value="${comment.userId}" /></td>
								<td><c:out value="${comment.content}" /></td>
								<td><fmt:formatDate value="${comment.regDate}" pattern="yyyy-MM-dd hh:mm:ss" /></td>
								<td><a href="${pageContext.request.contextPath}/board/detail?no=${board.no}&commentNo=${comment.commentNo}">수정</a></td>
								<td><a href="${pageContext.request.contextPath}/comment/delete?no=${board.no}&commentNo=${comment.commentNo}">삭제</a></td>
							</tr>
						</c:otherwise>
						</c:choose>
					</c:forEach>
				</table>
			</form>
					
			</c:otherwise>
		</c:choose>
	</div>
	<div class="bottom">
		<c:import url="/jsp/include/bottom.jsp" />
	</div>
</div>
<script>

$("#frm").submit(function () {
	
	alert("1" + $("input[name=content]").val());
	
	
	$.ajax({
		url: "${pageContext.request.contextPath}/comment/write",
		data: {
			"no":	'${board.no}',
			"userId":	$("input[name=userId]").val() ,
			"content": $("input[name=content]").val()
		},
		type: "POST",
		dataType: "json"
	}).done(function (result) {
		console.dir(result[0]);
	});
	
	return false;
});
</script>
</body>
</html>