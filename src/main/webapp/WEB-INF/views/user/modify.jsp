<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/user/modify.js"></script>
</head>
<body>
<form id="modifyForm">
<input type="hidden" name="user_no" value="${vo.USER_NO }" readonly="readonly" id="user_NO"/>
	<table>
		<tr>
			<td>아이디</td>
			<td>비밀번호</td>
			<td>이메일</td>
			<td>이름</td>
			<td>별명</td>
		</tr>
		<tr>
			<td><input type="text" name="user_id" value="${vo.USER_ID }" readonly="readonly"/></td>
			<td><input type="text" name="user_pw" /></td>
			<td><input type="text" name="user_email" /></td>
			<td><input type="text" name="user_name" /></td>
			<td><input type="text" name="user_kinck" /></td>
		</tr>
	</table>
</form>
<button type="button" onclick="modify()">수정하기</button>
</body>
</html>