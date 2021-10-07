function ReplyDelete(reply_no) {
	if (confirm("정말 삭제하시겠습니까??") == true) {
		$.ajax({
			url:"/replyDelete.do",
			type:"POST",
			data:{reply_no:reply_no},
			dateType:"JSON",
			success : function(result){
				alert("댓글 삭제");
				location.href = "/BoardDetail.do?board_no="+$("#board_no").val();
			}
		})
	}
}
