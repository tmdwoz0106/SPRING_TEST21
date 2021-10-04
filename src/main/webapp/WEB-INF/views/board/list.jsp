<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/board/list.js"></script>
</head>
<body>
<h1>게시판 페이지</h1>
<label>검색</label>
	<select id="type">
		<option value="board_title">제목</option>
		<option value="user_kinck">작성자</option>
		<option value="board_day">날짜</option>
	</select>
<label>검색</label>
	<input type="text" id="keyword" />
	<button type="button" onclick="list(1)">검색</button>
<table border="1" width="70%">
	<tr>
		<td>제목</td>
		<td>날짜</td>
		<td>작성자</td>
		<td>조회수</td>
	</tr>
	<tbody id="tbody"></tbody>
</table>
<div id="paging"></div>
</body>
</html>