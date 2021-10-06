<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/user/delete.js"></script>
</head>
<body>
<h1>회원 정보</h1>
<form id="deleteForm">
<input type="hidden" name="user_no" value="${vo.USER_NO }" readonly="readonly" />
<table border="1">
	<tr>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>이메일</td>
		<td>이름</td>
		<td>닉네임</td>
	</tr>
	<tr>
		<td><input type="text" name="user_id" value="${vo.USER_ID }" readonly="readonly" /></td>
		<td><input type="text" name="user_pw" value="${vo.USER_PW }" readonly="readonly" /></td>
		<td><input type="text" name="user_email" value="${vo.USER_EMAIL }" readonly="readonly" /></td>
		<td><input type="text" name="user_name" value="${vo.USER_NAME }" readonly="readonly" /></td>
		<td><input type="text" name="user_kinck" value="${vo.USER_KINCK }" readonly="readonly" /></td>
	</tr>
</table>
</form>
<a href="/UserModify.do?user_no=${vo.USER_NO }"><button>회원수정</button></a>
<button onclick="remove()" type="button">탈퇴</button>
<a href="/home.do"><button>홈으로</button></a>
</body>
</html>