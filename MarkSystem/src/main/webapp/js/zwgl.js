	
	$(function(){
		//分页
		if(total<10){
				yeshu =1;
			}else{
				yeshu=parseInt((total+10-1)/10);
			}
			
			for(var i=dangqianye;i<=yeshu;i++){
					var yuansu="<a href='role?dangqianye="+i+"'>"+i+"</a>";
							
					if(i>dangqianye+9){
						yuansu="";
					}
					$("#fyanniu").append(yuansu);
					$("#totalpage").html("共:"+yeshu+"页&nbsp;当前第:"+dangqianye+"页");
				}
			
				//checkbox的选择
				$("#gnid").change(function() { 
					if($('#gnid').is(':checked')) {
						$(".xsid").show();
					}
					else{
						$(".xsid").hide();
					}
				});
				$("#glname").change(function() { 
					if($('#glname').is(':checked')) {
						$(".xsmc").show();
					}
					else{
						$(".xsmc").hide();
					}
				});
				$("#glrq").change(function() { 
					if($('#glrq').is(':checked')) {
						$(".xsrq").show();
					}
					else{
						$(".xsrq").hide();
					}
				});
				
				$("#glgnmc").change(function() { 
					if($('#glgnmc').is(':checked')) {
						$(".gnmc").show();
					}
					else{
						$(".gnmc").hide();
					}
				});
			});
			//选择表显示的弹出框
			function gltb(){
				
				$("#hdk").slideToggle();
				
			}
			//刷新
			function shuaxin(){
				location.href="role";
			}
			//添加职位弹出框
			function tjzw(){
				$( "#tjzwdialog" ).dialog({
				  resizable: false,
				  height: 500,
				  width: 800,
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
				$( "#tjzwdialog" ).dialog( "close" );
				
			}
			//弹出框取消
			function tjquxiao(){
				$( "#tjzwdialog" ).dialog( "close" );
			}
			//查看
			
			function ck(zwmc,gnmc,cjrq){
				$("#zwmc").html(zwmc);
				$("#zwgn").html(gnmc);
				$("#zwrq").html(cjrq);
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
			function bj(roleName){
				$("#zwbjzwmc").val(roleName);
				$( "#bjzwdialog" ).dialog({
				  resizable: false,
				  height: 500,
				  width: 800,
				  modal: true,
				  hide: {
					effect: "explode",
					duration: 1000
				  }
				});
				$( "#bjzwdialog" ).dialog( "open" );
			}
			//弹出框确认
			function bjqueren(){
				$( "#bjzwdialog" ).dialog( "close" );
			}
			//弹出框取消
			function bjquxiao(){
				$( "#bjzwdialog" ).dialog( "close" );
			}
			//删除
			function sc(zwid){
				$("#cuanId").val(zwid);
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
				$( "#scdialog" ).dialog( "close" );
				location.href="roledelete?zwid="+$("#cuanId").val();
			}
			//弹出框取消
			function scquxiao(){
				$( "#scdialog" ).dialog( "close" );
			}
			//查询职位
			function sousuo(){
				var roleName = $("#sousuo").val();
				location.href="roleselect?roleName="+roleName;
			}
			//跳转
			function tz(){
				dangqianye=$("#tiaozhuan").val();
				location.href="role?dangqianye="+dangqianye;
			}
			//上一页
			function syy(){
				dangqianye-=1;
				if(dangqianye<1){
					dangqianye = 1;
				}
				location.href="role?dangqianye="+dangqianye;
			}
			//下一页
			function xyy(){
				dangqianye+=1;
				if(dangqianye>yeshu){
					dangqianye = yeshu;
				}
				location.href="role?dangqianye="+dangqianye;
			}