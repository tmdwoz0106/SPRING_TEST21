<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/user/join.js"></script>
</head>
<body>
${max }
<form id="insertForm">
<input type="hidden" name="user_no" value="${max }" />
<table>

	<tr>
		<td>아이디</td>
		<td><input type="text" name="user_id"/></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="text" name="user_pw" /></td>
	</tr>
	<tr>
		<td>이메일</td>
		<td><input type="text" name="user_email" /></td>
	</tr>
	<tr>
		<td>별명</td>
		<td><input type="text" name="user_kinck" /></td>
	</tr>
	<tr>
		<td>이름</td>
		<td><input type="text" name="user_name" /></td>
	</tr>
</table>
</form>
<button type="button" onclick="insert()">회원가입</button>
<a href="/login.do">로그인</a>
</body>
</html>