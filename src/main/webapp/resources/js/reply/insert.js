function InsertClose(){
	$("#textArea").val("");
	$("#popup").fadeOut();
}
function InsertOpen(reply_group,reply_depth){
	$("#reply_group").val(reply_group);
	$("#reply_depth").val(reply_depth);
	$("#popup").css('display','flex').hide().fadeIn();
}

function InsertReply(){
	var reply = $("#textArea").val();
	$("#reply_content").val(reply);
	$("#reply_Insert").submit();
	InsertClose();
}
