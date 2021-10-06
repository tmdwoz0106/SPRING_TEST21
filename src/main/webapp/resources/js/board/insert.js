function insert(){
	$.ajax({
		url:"/BoardInsert.do",
		type:"POST",
		data:$("#insertForm").serialize(),
		dataType:"JSON",
		success : function(result){
			alert("등록 완료");
			location.href = "/home.do";
		}
	})
}
