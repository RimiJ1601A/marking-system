$(function() {
	// 分页
	var xsys = 6;// 页面显示多少页
	var yuan;
	var dqy = "<a aria-controls='example1' data-dt-idx='1' tabindex='0' href=user?dangqianye="+ dangqianye + ">" + dangqianye + "</a>";
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
	
	
	// checkbox的选择
	$("#zh").change(function() {
		if ($('#zh').is(':checked')) {
			$(".xszh").show();
		} else {
			$(".xszh").hide();
		}
	});
	$("#rymc").change(function() {
		if ($('#rymc').is(':checked')) {
			$(".xsrymc").show();
		} else {
			$(".xsrymc").hide();
		}
	});
	$("#nl").change(function() {
		if ($('#nl').is(':checked')) {
			$(".xsnl").show();
		} else {
			$(".xsnl").hide();
		}
	});
	$("#xb").change(function() {
		if ($('#xb').is(':checked')) {
			$(".xsxb").show();
		} else {
			$(".xsxb").hide();
		}
	});
	$("#zw").change(function() {
		if ($('#zw').is(':checked')) {
			$(".xszw").show();
		} else {
			$(".xszw").hide();
		}
	});
	$("#cjrq").change(function() {
		if ($('#cjrq').is(':checked')) {
			$(".xscjrq").show();
		} else {
			$(".xscjrq").hide();
		}
	});
	
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
	}else{
		location.href="selectUser?value="+value;
	}
//	$.ajax({
//		type:"post",
//		url:"/selectUser",
//		dataType:"json",
//		contentType:"application/json",
//		data:{"value":value},
//		success:function(data){
//			alert(2222);
//		},
//		error:function(err){
//			
//		}
//	})
}
//
//$(document).on("cilick",".paginate_button",function(dat){
//	alert(1);
//})


$(".paginate_button").click(function(){
	$(".paginate_button.active")[0].className = "paginate_button";
	this.className = "paginate_button active";
})

// 刷新
function shuaxin() {
	location.href = "user";
}

//添加人员弹出框
function tjry() {
	$("#tjzwdialog").dialog({
		resizable : false,
		height : 500,
		width : 800,
		modal : true,
		hide : {
			effect : "explode",
			duration : 1000
		}
	});
	$("#tjzwdialog").dialog("open");
}
//弹出框确认
function tjqueren() {
	$("#tjzwdialog").dialog("close");

}
// 弹出框取消
function tjquxiao() {
	$("#tjzwdialog").dialog("close");
}
//查看

function ck(zh,rymc,nl,xb,zw,cjrq) {
	$("#ckzh").html(zh);
	$("#ckrymc").html(rymc);
	$("#cknl").html(nl);
	$("#ckxb").html(xb);
	$("#ckzw").html(zw);
	$("#ckcjrq").html(cjrq);
	$("#ckzwdialog").dialog({
		resizable : false,
		height : 500,
		width : 800,
		modal : true,
		hide : {
			effect : "explode",
			duration : 1000
		}
	});
	$("#ckzwdialog").dialog("open");
}
// 弹出框确认
function ckqueren() {
	$("#ckzwdialog").dialog("close");
}
// 弹出框取消
function ckquxiao() {
	$("#ckzwdialog").dialog("close");
}
function bj(zh,rymc,nl) {
	$("#zwbjzwmc").val(zh);
	$("#srxm").val(rymc);
	$("#srnl").val(nl);
	$("#bjzwdialog").dialog({
		resizable : false,
		height : 500,
		width : 800,
		modal : true,
		hide : {
			effect : "explode",
			duration : 1000
		}
	});
	$("#bjzwdialog").dialog("open");
}
// 弹出框确认
function bjqueren() {
	$("#bjzwdialog").dialog("close");
}
// 弹出框取消
function bjquxiao() {
	$("#bjzwdialog").dialog("close");
}
// 删除
function sc(zh) {
	$("#cuanId").val(zh);
	$("#scdialog").dialog({
		resizable : false,
		height : 250,
		width : 400,
		modal : true,
		hide : {
			effect : "explode",
			duration : 1000
		}
	});
	$("#scdialog").dialog("open");
}
// 弹出框确认
function scqueren() {
	$("#scdialog").dialog("close");
	//location.href = "deleteUser?userAccount=" + $("#cuanId").val();
}
// 弹出框取消
function scquxiao() {
	$("#scdialog").dialog("close");
}


//导出表格
function exportExel(){
	location.href="user_export";
}