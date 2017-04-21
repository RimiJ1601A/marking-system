			$(function(){
				//分页
				var dqy="<a aria-controls='example1' data-dt-idx='1' tabindex='0' href=team?dangqianye="+dangqianye+">"+dangqianye+"</a>";	
				$("#dqy").append(dqy);
				for(var i=1;i<=yeshu;i++){
					if(i<dangqianye){
						var j = dangqianye-1;
						var yuan="<a aria-controls='example1' data-dt-idx='"+j+"' tabindex='0' href=team?dangqianye="+i+">"+j+"</a>";
						if(i<j){
							yuan="";
						}
						$("#qianmian").append(yuan);
					}
					if(i>dangqianye){
						var yuansu="<a aria-controls='example1' data-dt-idx='"+i+"' tabindex='0' href=team?dangqianye="+i+">"+i+"</a>";
						if(i>5+dangqianye){
							yuansu="";
						}
						$("#fyanniu").append(yuansu);
						
					}
					//$("#totalpage").html("共:"+yeshu+"页&nbsp;当前第:"+dangqianye+"页");
				}
				//checkbox的选择
				$("#glbjmc").change(function() { 
					if($('#glbjmc').is(':checked')) {
						$(".bjmc").show();
					}
					else{
						$(".bjmc").hide();
					}
				});
				$("#glxsrs").change(function() { 
					if($('#glxsrs').is(':checked')) {
						$(".xsrs").show();
					}
					else{
						$(".xsrs").hide();
					}
				});
				$("#glxsxm").change(function() { 
					if($('#glxsxm').is(':checked')) {
						$(".xsxm").show();
					}
					else{
						$(".xsxm").hide();
					}
				});
				$("#gljsxm").change(function() { 
					if($('#gljsxm').is(':checked')) {
						$(".jsxm").show();
					}
					else{
						$(".jsxm").hide();
					}
				});
				$("#glxsrq").change(function() { 
					if($('#glxsrq').is(':checked')) {
						$(".xsrq").show();
					}
					else{
						$(".xsrq").hide();
					}
				});
				
			});
			//管理图表
			function gltb(){
				
				$("#xsyuyc").slideToggle();
				
			}
			//添加班级弹出框
			function tjzw(){
				$( "#tjzwdialog" ).dialog({
				  resizable: false,
				  height: 300,
				  width: 600,
				  modal: true,
				  hide: {
					effect: "explode",
					duration: 1000
				  }
				});
				$( "#tjzwdialog" ).dialog( "open" );
			}
			//弹出框确认
			function tjqueren(){
				var nr = $("#teamName").val();
				$( "#tjzwdialog" ).dialog( "close" );
				location.href="teamadd?teamName="+nr;
			}
			//弹出框取消
			function tjquxiao(){
				$( "#tjzwdialog" ).dialog( "close" );
			}
			//查看
			function ck(teamName,studentCount,studentName,teacherName,rq){
				$("#ckbjmc").html(teamName);
				$("#ckxsrs").html(studentCount);
				$("#ckxsxm").html(studentName);
				$("#ckjsxm").html(teacherName);
				$("#ckcjrq").html(rq);
				$( "#ckzwdialog" ).dialog({
				  resizable: false,
				  height: 500,
				  width: 800,
				  modal: true,
				  hide: {
					effect: "explode",
					duration: 1000
				  }
				});
				$( "#ckzwdialog" ).dialog( "open" );
			}
			//弹出框确认
			function ckqueren(){
				$( "#ckzwdialog" ).dialog( "close" );
			}
			//弹出框取消
			function ckquxiao(){
				$( "#ckzwdialog" ).dialog( "close" );
			}
			//编辑
			function bj(teamId){
				$("#bjId").val(teamId);
				$( "#bjzwdialog" ).dialog({
				  resizable: false,
				  height: 400,
				  width: 500,
				  modal: true,
				  hide: {
					//effect: "explode",
					duration: 1000
				  }
				});
				$( "#bjzwdialog" ).dialog( "open" );
			}
			//班级编辑的相关操作
			//添加学生
			function tjxs(){
				$( "#bjzwdialog" ).dialog( "close" );
				
				$( "#tjxsdialog" ).dialog({
					  resizable: false,
					  height: 300,
					  width: 550,
					  modal: true,
					  hide: {
						effect: "explode",
						duration: 1000
					  }
					});
				$( "#tjxsdialog" ).dialog( "open" );
				
			}
			//删除学生
			function scxs(){
				
				$( "#bjzwdialog" ).dialog( "close" );
				$( "#scxsdialog" ).dialog({
					  resizable: false,
					  height: 300,
					  width: 550,
					  modal: true,
					  hide: {
						effect: "explode",
						duration: 1000
					  }
					});
				$( "#scxsdialog" ).dialog( "open" );
			}
			//批量导入学生
			function pldr(){
				
				$( "#bjzwdialog" ).dialog( "close" );
				$( "#pltjxsdialog" ).dialog({
					  resizable: false,
					  height: 300,
					  width: 550,
					  modal: true,
					  hide: {
						effect: "explode",
						duration: 1000
					  }
					});
				$( "#pltjxsdialog" ).dialog( "open" );
			}
			//添加教师
			function tjjs(){
				
				$( "#bjzwdialog" ).dialog( "close" );
				$( "#tjjsdialog" ).dialog({
					  resizable: false,
					  height: 300,
					  width: 550,
					  modal: true,
					  hide: {
						effect: "explode",
						duration: 1000
					  }
					});
				$( "#tjjsdialog" ).dialog( "open" );
			}
			//删除教师
			function scjs(){
				
				$( "#bjzwdialog" ).dialog( "close" );
				$( "#scjsdialog" ).dialog({
					  resizable: false,
					  height: 300,
					  width: 550,
					  modal: true,
					  hide: {
						effect: "explode",
						duration: 1000
					  }
					});
				$( "#scjsdialog" ).dialog( "open" );
			}
			//弹出框取消
			function bjquxiao(){
				$( "#bjzwdialog" ).dialog( "close" );
			}
			//添加学生弹出框
			function tjxsqueren(){
				teamId = $("#bjId").val();
				userAccount = $("#tjxsaccount").val();
				$( "#tjxsdialog" ).dialog( "close" );
				location.href="addstu?userAccount="+userAccount+"&teamId="+teamId;
			}
			function tjxsquxiao(){
				$( "#tjxsdialog" ).dialog( "close" );
			}
			//批量添加学生弹出框
			function pltjxsqueren(){
				teamId = $("#bjId").val();
				studentPref = $("#stuprif").val();
				studentCount = $("#stucount").val();
				$( "#pltjxsdialog" ).dialog( "close" );
				location.href="adddefaultstudent?teamId="+teamId+"&studentPref="+studentPref+"&studentCount="+studentCount;
			}
			function pltjxsquxiao(){
				$( "#pltjxsdialog" ).dialog( "close" );
			}
			//删除学生弹出框
			function scxsqueren(){
				teamId = $("#bjId").val();
				userAccount = $("#scxsaccount").val();
				$( "#scxsdialog" ).dialog( "close" );
				location.href="deletestu?userAccount="+userAccount+"&teamId="+teamId;
			}
			function scxsquxiao(){
				$( "#scxsdialog" ).dialog( "close" );
			}
			//添加教师弹出框
			function tjjsqueren(){
				teamId = $("#bjId").val();
				userAccount = $("#tjjszh").val();
				$( "#tjjsdialog" ).dialog( "close" );
				location.href="addteacher?userAccount="+userAccount+"&teamId="+teamId;
			}
			function tjjsquxiao(){
				$( "#tjjsdialog" ).dialog( "close" );
			}
			//删除教师弹出框
			function scjsqueren(){
				teamId = $("#bjId").val();
				userAccount = $("#scjszh").val();
				$( "#scjsdialog" ).dialog( "close" );
				location.href="deleteteacher?userAccount="+userAccount+"&teamId="+teamId;
			}
			function scjsquxiao(){
				$( "#scjsdialog" ).dialog( "close" );
			}
			//删除
			function sc(scId){
				$("#ycId").val(scId);
				$( "#scdialog" ).dialog({
				  resizable: false,
				  height: 250,
				  width: 400,
				  modal: true,
				  hide: {
					effect: "explode",
					duration: 1000
				  }
				});
				$( "#scdialog" ).dialog( "open" );
			}
			//弹出框确认
			function scqueren(){
				var teamId = $("#ycId").val();
				$( "#scdialog" ).dialog( "close" );
				//location.href="teamdelete?teamId="+teamId;
			}
			//弹出框取消
			function scquxiao(){
				$( "#scdialog" ).dialog( "close" );
			}
			
			
			//搜索
			function sousuo(){
				var sr = $("#sousuo").val();
				location.href="teamselect?selectName="+sr;
			}
			//刷新
			function shuaxin(){
				location.href="team";
			}
			//跳转
			function tz(){
				dangqianye=$("#tiaozhuan").val();
				location.href="team?dangqianye="+dangqianye;
			}
			//上一页
			function syy(){
				dangqianye-=1;
				if(dangqianye<1){
					dangqianye = 1;
				}
				location.href="team?dangqianye="+dangqianye;
			}
			//下一页
			function xyy(){
				dangqianye+=1;
				if(dangqianye>yeshu){
					dangqianye = yeshu;
				}
				location.href="team?dangqianye="+dangqianye;
			}