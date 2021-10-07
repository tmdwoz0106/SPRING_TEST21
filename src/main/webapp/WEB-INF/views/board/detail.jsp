<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>

.searchModal {
display: none; 
position: fixed; 
z-index: 10;
left: 0;
top: 0;
width: 100%;
height: 100%;
overflow: auto;
background-color: rgb(0,0,0); 
background-color: rgba(0,0,0,0.4); 
}

.search-modal-content {
background-color: #fefefe;
margin: 15% auto;
padding: 20px;
border: 1px solid #888;
width: 35%;
}
</style>

<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file="../layout/head.jsp" %>
<script type="text/javascript" src="/resources/js/board/delete.js"></script>
<script type="text/javascript" src="/resources/js/reply/insert.js"></script>
<script type="text/javascript" src="/resources/js/reply/delete.js"></script>
<script type="text/javascript" src="/resources/js/reply/modify.js"></script>
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
		<td><input type="text" value="${vo.BOARD_NO}" readonly="readonly" name="board_no" id="board_no"/></td>
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
<br />
<div>
<c:forEach var="reply" items="${list }">
 <div>
	<c:forEach end="${reply.REPLY_DEPTH }" begin="0">
		&nbsp;
	</c:forEach>
	<c:if test="${reply.REPLY_DEPTH != 0 }">
		ㄴ
	</c:if>
	${reply.USER_KINCK } | ${reply.REPLY_CONTENT } | ${reply.REPLY_DAY }
	<c:if test="${user_kinck eq reply.USER_KINCK }">
		<button type="button" onclick="OpenModify(${reply.REPLY_NO})">수정</button> | 
		<button type="button" onclick="ReplyDelete(${reply.REPLY_NO})">삭제</button> |
	</c:if>	
		<button type="button" onclick="InsertOpen(${reply.REPLY_NO},${reply.REPLY_DEPTH+1})">댓글 달기</button>
 </div>
</c:forEach>
</div>
<button onclick="InsertOpen(0,0)" type="button">댓글 달기</button>

  <div class="popup-wrap" id="popup">
    <div class="popup">
        <div class="body-content">
          <div class="body-contentbox">
           <textarea rows="5" cols="50" id="textArea"></textarea>
          </div>
        </div>
      <div class="popup-foot">
        <span class="pop-btn confirm" id="confirm" onclick="InsertReply()">확인</span>
        <span class="pop-btn close" id="close" onclick="InsertClose()">창 닫기</span>
      </div>
    </div>
</div>


<form action="/replyInsert.do" method="get" id="reply_Insert">
<input type="text" name="reply_no" value="${max}" id="reply_no"/>
<input type="text" name="reply_content" id="reply_content" />
<input type="text" name="reply_day" />
<input type="text" name="reply_group" value="0" id="reply_group"/>
<input type="text" name="reply_depth" value="0" id="reply_depth"/>
<input type="text" name="board_no" value="${vo.BOARD_NO}" />
<input type="text" name="user_no" value="${user_no}" />
</form>


<div id="modal" class="searchModal">
	<div class="search-modal-content">
		<div class="page-header">
			<h1>댓글 수정</h1>
		</div>
		<div class="row">
			<div class="col-sm-12">
				<div class="row">
					<div class="col-sm-12">
						<textarea rows="5" cols="62" id="textArea2"></textarea>
					</div>
				</div>
			</div>
		</div>
			<div style="cursor:pointer;background-color:#DDDDDD;text-align: center;padding-bottom: 10px;padding-top: 10px;" onClick="closeModal();">
				<button style="font-size: 13pt;" onclick= "AddModify()">수정</button>
				<button style="font-size: 13pt;" onclick="CloseModify()">닫기</button>
			</div>
	</div>
</div>

<form action="/replyModify.do" method="get" id="reply_Modify">
<input type="text" name="reply_no" id="reply_no2" value="${reply.REPLY_NO }"/>
<input type="text" name="board_no" value="${vo.BOARD_NO }" />
<input type="text" name="reply_content" id="reply_content2" />
</form>
</body>
</html>