<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/board/delete.js"></script>

</head>
<body>
<h1>상세보기</h1>

<c:if test="${kinck eq vo.USER_KINCK }">
<button type="button" onclick="remove()">글 삭제</button> |
<a href="/BoardModify.do?board_no=${vo.BOARD_NO }"><button>글 수정</button></a> |	
</c:if>
<a href="/home.do"><button>메인</button></a>
<form id="delete">
<table border="1">
	<tr>
		<td>번호</td>
		<td><input type="text" value="${vo.BOARD_NO}" readonly="readonly" name="board_no"/></td>
	</tr>
	<tr>
		<td>제목</td>
		<td><input type="text" value="${vo.BOARD_TITLE }"readonly="readonly"/></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input type="text" value="${vo.BOARD_CONTENT }"readonly="readonly"/></td>
	</tr>
	<tr>
		<td>작성자</td>
		<td><input type="text" value="${vo.USER_KINCK }"readonly="readonly"/></td>
	</tr>
	<tr>
		<td>날짜</td>
		<td><input type="text" value="${vo.BOARD_DAY }"readonly="readonly"/></td>
	</tr>
	<tr>
		<td>조회수</td>
		<td><input type="text" value="${vo.BOARD_VIEW}"readonly="readonly" name="board_view"/></td>
	</tr>
</table>
</form>
</body>
</html>