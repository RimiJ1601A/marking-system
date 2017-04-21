
function sousuo(){
	var value = $("#sousuo").val();
	if(value == null || value == ""){
		alert("查找不能为空")
		return;
	}
	$.ajax({
		type:"post",
		url:"/selectUser",
		dataType:"json",
		contentType:"application/json",
		data:{"value":value},
		success:function(data){
			
		},
		error:function(err){
			
		}
	})
}
//
//$(document).on("cilick",".paginate_button",function(dat){
//	alert(1);
//})


$(".paginate_button").click(function(){
	$(".paginate_button.active")[0].className = "paginate_button";
	this.className = "paginate_button active";
})


