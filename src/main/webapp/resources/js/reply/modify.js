function OpenModify(reply_no){
	$("#reply_no2").val(reply_no);
	$("#modal").show();
}

function CloseModify(){
	$("#textArea2").val("");
	$("#modal").hide();
}

function AddModify(){
	var reply = $("#textArea2").val();
	$("#reply_content2").val(reply);
	$("#reply_Modify").submit();
	modifyAlert();
	CloseModify();
}
function modifyAlert(){
	alert("수정 성공");
}