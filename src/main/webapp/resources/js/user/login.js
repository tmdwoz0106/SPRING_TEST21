function login(){
	$.ajax({
		url:"/loginPost.do",
		type:"POST",
		data:$("#loginForm").serialize(),
		dataType:"JSON",
		success : function(result){
			var vo =result.vo;
			if(vo.msg != null){
				alert(vo.msg);
				location.href = "/login.do";
			}else {
				alert("환영합니다 회원님");
				location.href = "/home.do";
			}
			
		}
	})
	
}