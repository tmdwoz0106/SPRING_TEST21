<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/board/insert.js"></script>
<title>Insert title here</title>
</head>
<body>
<form id="insertForm">
<input type="hidden" name="user_no" value="${user_no}"/>
<input type="hidden" name="board_no" value="${max}"/>
<table border="1">
	<tr>
		<td>제목</td>
		<td><input type="text" name="board_title"/></td>
	</tr>
	<tr>
		<td>내용</td>
		<td><input type="text" name="board_content"/></td>
	</tr>
</table>
</form>
<button type="button" onclick="insert()">추가</button>
</body>
</html>