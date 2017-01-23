<%@ page contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title</title>
</head>
<body>
<div class="container">
	
	<div class="header">
		<c:import url="/jsp/include/topMenu.jsp" />
	</div>
	
	<div class="content">
			<hr>
			번호 : <c:out value="${boardVO.no}"/><br>
			제목 : <c:out value="${boardVO.title}"/><br>
			글쓴이 : <c:out value="${boardVO.writer}"/><br>
			내용 : <c:out value="${boardVO.content}"/><br>
			첨부파일 : ${file.oriName} (${file.fileSize} byte) 
			<a href="${pageContext.request.contextPath}/file/download?path=${file.filePath}&systemName=${file.systemName}">이미지 보기 / </a>
			<a href="${pageContext.request.contextPath}/file/download?path=${file.filePath}&systemName=${file.systemName}&downName=${file.oriName}">다운로드</a> <br>
			등록일 : <fmt:formatDate value="${boardVO.regDate}" pattern="yyyy-MM-dd hh:mm:ss" /><br>
			<hr>
			
			<a href='updateForm?no=${param.no}'>수정</a>
			<a href='delete?no=${param.no}'>삭제</a>
			<a href='list'>목록</a>
			<br>
			<br>
			댓글등록
			<form action="${pageContext.request.contextPath}/board/comment/write" method="post">
				<input type="hidden" name="no" value="${boardVO.no}" />
				<input type="hidden" name="id" value="${user.userId}" />
				아이디 : <c:out value="${user.userId}" /><br>
				댓글 : <input type="text" name="comments"/>
				<input type="submit" value="등록"/>
			</form>
			<br>
			<br>
			
			<c:choose>
				<c:when test="${modYn == 'Y'}">
					<table>
						<tr>
							<th>글쓴이</th>
							<th>댓글내용</th>
							<th>등록일시</th>
							<th>삭제/수정</th>
						</tr>
					
						<c:forEach var="comment" items="${comment}" >
							<form action="${pageContext.request.contextPath}/board/comment/update" method="post">
								<input type="hidden" name="commentNo" value="${comment.commentNo}"	/>
								<input type="hidden" name="no" value="${boardVO.no}"	/>
								<tr>
									<td style="width:50px;"><c:out value="${comment.id}" /></td>
									<td style="width:200px;"><input type="text" name="comments" value="<c:out value="${comment.comments}" />" /></td>
									<td style="width:200px;"><fmt:formatDate value="${comment.regDate}" pattern="yyyy-MM-dd" /></td>
									<td style="width:200px;">
										<input type="submit" value="등록"	/>
									</td>
								</tr>
							</form>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<table>
						<tr>
							<th>글쓴이</th>
							<th>댓글내용</th>
							<th>등록일시</th>
							<th>삭제/수정</th>
						</tr>
						<c:forEach var="comment" items="${comment}" >
							<tr>
								<td style="width:50px;"><c:out value="${comment.id}" /></td>
								<td style="width:200px;"><c:out value="${comment.comments}" /></td>
								<td style="width:200px;"><fmt:formatDate value="${comment.regDate}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
								<td style="width:200px;">
								<c:choose>
									<c:when test="${user.userId == comment.id}">
									
										<a href="${pageContext.request.contextPath}/board/comment/delete
											?no=${boardVO.no}&commentNo=${comment.commentNo}">삭제 </a>
												
										<a href="${pageContext.request.contextPath}/board/detail
											?modYn=Y&no=${boardVO.no}">수정</a>
										
									</c:when>	
								</c:choose>
								</td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
					
	</div>
	
	<div class="bottom">
		<c:import url="/jsp/include/bottom.jsp"	/>
	</div>
		
</div>
</body>
</html>