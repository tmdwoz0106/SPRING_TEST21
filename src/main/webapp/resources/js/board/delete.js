function remove() {
	if (confirm("정말 삭제하시겠습니까??") == true) {
		$.ajax({
			url:"/BoardDelete.do",
			type:"POST",
			data:$("#delete").serialize(),
			dataType:"JSON",
			success : function(result){
				alert("삭제 성공");
				location.href = "/home.do";
			}
		})
	}
}