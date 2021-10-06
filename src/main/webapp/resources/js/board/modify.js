function modify(){
	$.ajax({
		url:"/ModifyBoard.do",
		type:"POST",
		data:$("#modify").serialize(),
		dataType:"JSON",
		success : function(result){
			alert("수정성공");
			location.href = "/home.do";
		}
	})
}