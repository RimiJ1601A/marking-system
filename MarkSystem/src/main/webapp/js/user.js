$(function() {
	// 分页
	var xsys = 6;// 页面显示多少页
	var yuan;
	var dqy = "<a aria-controls='example1' data-dt-idx='1' tabindex='0' href=user?dangqianye="
			+ dangqianye + ">" + dangqianye + "</a>";
	$("#dqy").append(dqy);
	for (var i = 1; i <= yeshu; i++) {
		if (yeshu < xsys) {
			if (i < dangqianye) {
				yuan = "<a aria-controls='example1' data-dt-idx='" + i
						+ "' tabindex='0' href=user?dangqianye=" + i + ">" + i
						+ "</a>";
				$("#qianmian").append(yuan);
			}
			if (i > dangqianye) {
				var yuansu = "<a aria-controls='example1' data-dt-idx='" + i
						+ "' tabindex='0' href=user?dangqianye=" + i + ">" + i
						+ "</a>";

				$("#fyanniu").append(yuansu);
			}
		} else {
			if (i < dangqianye) {
				yuan = "<a aria-controls='example1' data-dt-idx='" + i
						+ "' tabindex='0' href=user?dangqianye=" + i + ">" + i
						+ "</a>";
				if (i <=dangqianye-xsys) {
					yuan = "";
				}
				$("#qianmian").append(yuan);
			}
			if (i > dangqianye) {
				var yuansu = "<a aria-controls='example1' data-dt-idx='" + i
						+ "' tabindex='0' href=user?dangqianye=" + i + ">" + i
						+ "</a>";
				if (i > xsys) {
					yuansu = "";
				}
				$("#fyanniu").append(yuansu);

			}
		}
	}
});
//上一页
function syy() {
	dangqianye -= 1;
	if (dangqianye < 1) {
		dangqianye = 1;
	}
	location.href = "user?dangqianye=" + dangqianye;
}
// 下一页
function xyy() {
	dangqianye += 1;
	if (dangqianye > yeshu) {
		dangqianye = yeshu;
	}
	location.href = "user?dangqianye=" + dangqianye;
}
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


