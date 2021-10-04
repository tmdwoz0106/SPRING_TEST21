function insert(){
	$.ajax({
		url:"/userJoin.do",
		type:"POST",
		data:$("#insertForm").serialize(),
		dataType:"JSON",
		success : function(result){
			var msg = result.msg;
			var result = result.result;
			
			alert(msg);
			
			if(result == 1){
				location.href = "/login.do";
			}else{
				location.href = "/join.do";
			}
		}
	})
}