$(function(){
	list(1);
})

function list(page){
	$.ajax({
		url:"/main.do",
		type:"GET",
		data:{page:page ,type:$("#type option:selected").val(), keyword:$("#keyword").val()},
		dataType:"JSON",
		success : function(result){
			console.log(result.list);
			$("#tbody").empty();
			$("#paging").empty();
			var list = result.list;
			for(var i = 0; i < list.length; i++){
				var html = "<tr>"
				    html += "<td><a href=/BoardDetail.do?board_no="+list[i].BOARD_NO+">"+list[i].BOARD_TITLE+"</a></td>"
				    html += "<td>"+list[i].BOARD_DAY+"</td>"
				    html += "<td>"+list[i].USER_KINCK+"</td>"
				    html += "<td>"+list[i].BOARD_VIEW+"</td>"
					html += "</tr>"
					$("#tbody").append(html)
			}
			if(result.prev){
				$("#paging").append("<button onclick = list("+Number(page-1)+")>이전</button>")
			}
			for(var i = result.startPage; i <= result.endPage; i++){
				$("#paging").append("<button onclick = list("+i+")>"+i+"</button>")
			}
			if(result.next){
				$("#paging").append("<button onclick = list("+Number(page+1)+")>다음</button>")
			}
		}
	})
}
function logout(){
	if (confirm("로그아웃 하시겠습니까??") == true){
		$.ajax({
			url:"/logout.do",
			type:"POST",
			dataType:"JSON",
			success:function(result){
				alert("로그아웃");
				location.href = "/login.do";
			}
		})
	}
}