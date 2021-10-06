function modify() {
	if (confirm("정말 변경하시겠습니까??") == true) {
		$.ajax({
			url: "/ModifyUser.do",
			type: "POST",
			data: $("#modifyForm").serialize(),
			dataType: "JSON",
			success: function(result) {
				alert("수정 완료");
				location.href = "/UserDetail.do?user_no="+$("#user_NO").val();
			}
		})
	}
}