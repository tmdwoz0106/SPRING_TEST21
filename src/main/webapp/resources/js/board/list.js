$(function(){
	list();
})

function list(){
	$.ajax({
		url:"/main.do",
		type:"GET",
		dataType:"JSON",
		success : function(result){
			console.log(result.list);
		}
	})
}