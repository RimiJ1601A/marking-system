$(function() {
	// 分页
//	var xsys = 6;// 页面显示多少页
//	var yuan;
//	var dqy = "<a aria-controls='example1' data-dt-idx='1' tabindex='0' href=role?dangqianye="
//			+ dangqianye + ">" + dangqianye + "</a>";
//	$("#dqy").append(dqy);
//	for (var i = 1; i <= yeshu; i++) {
//		if (yeshu < xsys) {
//			if (i < dangqianye) {
//				yuan = "<a aria-controls='example1' data-dt-idx='" + i
//						+ "' tabindex='0' href=role?dangqianye=" + i + ">" + i
//						+ "</a>";
//				$("#qianmian").append(yuan);
//			}
//			if (i > dangqianye) {
//				var yuansu = "<a aria-controls='example1' data-dt-idx='" + i
//						+ "' tabindex='0' href=role?dangqianye=" + i + ">" + i
//						+ "</a>";
//
//				$("#fyanniu").append(yuansu);
//			}
//		} else {
//			if (i < dangqianye) {
//				yuan = "<a aria-controls='example1' data-dt-idx='" + i
//						+ "' tabindex='0' href=role?dangqianye=" + i + ">" + i
//						+ "</a>";
//				if (i <=dangqianye-xsys) {
//					yuan = "";
//				}
//				$("#qianmian").append(yuan);
//			}
//			if (i > dangqianye) {
//				var yuansu = "<a aria-controls='example1' data-dt-idx='" + i
//						+ "' tabindex='0' href=role?dangqianye=" + i + ">" + i
//						+ "</a>";
//				if (i > xsys) {
//					yuansu = "";
//				}
//				$("#fyanniu").append(yuansu);
//
//			}
//		}
//	}

	// checkbox的选择
	$("#gnid").change(function() {
		if ($('#gnid').is(':checked')) {
			$(".xsid").show();
		} else {
			$(".xsid").hide();
		}
	});
	$("#glname").change(function() {
		if ($('#glname').is(':checked')) {
			$(".xsmc").show();
		} else {
			$(".xsmc").hide();
		}
	});
	$("#glrq").change(function() {
		if ($('#glrq').is(':checked')) {
			$(".xsrq").show();
		} else {
			$(".xsrq").hide();
		}
	});

	$("#glgnmc").change(function() {
		if ($('#glgnmc').is(':checked')) {
			$(".gnmc").show();
		} else {
			$(".gnmc").hide();
		}
	});
});
// 选择表显示的弹出框
function gltb() {

	$("#hdk").slideToggle();

}
// 刷新
function shuaxin() {
	location.href = "role";
}
// 添加职位弹出框
function tjzw() {
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
// 弹出框确认
function tjqueren() {
	$("#tjzwdialog").dialog("close");

}
// 弹出框取消
function tjquxiao() {
	$("#tjzwdialog").dialog("close");
}
// 查看

function ck(zwmc, gnmc, cjrq) {
	$("#zwmc").html(zwmc);
	$("#zwgn").html(gnmc);
	$("#zwrq").html(cjrq);
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
// 编辑
function bj(roleName) {
	$("#zwbjzwmc").val(roleName);
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
function sc(zwid) {
	$("#cuanId").val(zwid);
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
	location.href = "roledelete?roleId=" + $("#cuanId").val();
}
// 弹出框取消
function scquxiao() {
	$("#scdialog").dialog("close");
}
// 查询职位
function sousuo() {
	var roleName = $("#sousuo").val();
	location.href = "role?value=" + roleName+"&dangqianye=1";
}
// 跳转
function tz() {
	dangqianye = $("#tiaozhuan").val();
	location.href = "role?dangqianye=" + dangqianye;
}
// 上一页
//function syy() {
//	dangqianye -= 1;
//	if (dangqianye < 1) {
//		dangqianye = 1;
//	}
//	location.href = "role?dangqianye=" + dangqianye;
//}
// 下一页
//function xyy() {
//	dangqianye += 1;
//	if (dangqianye > yeshu) {
//		dangqianye = yeshu;
//	}
//	location.href = "role?dangqianye=" + dangqianye;
//}
// 导出表格
function exportExel() {
	location.href = "role_export";
}