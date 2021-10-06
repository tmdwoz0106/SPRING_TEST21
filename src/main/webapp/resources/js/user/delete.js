function remove() {
	if (confirm("탈퇴 하시겠습니까") == true) {
		$.ajax({
			url: "/UserDelete.do",
			type: "POST",
			data: $("#deleteForm").serialize(),
			dataType: "JSON",
			success : function(result){
				alert("탈퇴하셨습니다");
				location.href = "/login.do";
			}
		})
	}
}