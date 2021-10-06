<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/board/modify.js"></script>
</head>
<body>
<h1>수정페이지</h1>
<form id="modify">
<input type="text" name="board_no" value="${vo.BOARD_NO }" />
	<table>
		<tr>
			<td>제목</td>
			<td><input type="text" name="board_title" /></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><input type="text" name="board_content" /></td>
		</tr>
	</table>
</form>
<button type="button" onclick="modify()">수정</button>
<a href="/home.do"><button>홈으로</button></a>
</body>
</html>