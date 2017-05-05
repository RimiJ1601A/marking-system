window.onload=function(){
/*	selectMarkName();
	markName();
	teamName();*/
}

function selectMarkName() {
	var teacherId =$("#teacherName").val();
	$.ajax({
		url: '/getMarkTable',
		type : 'post',
		data: {teacherId:teacherId},	
		datatype:"json",  
		success : function(data){	
			$("#markName").children().remove();
			$("#teamName").children().remove();
			$("#evaluateUserName").children().remove();
			if(data == "" || data == null){
				alert("该老师没有被考核过")
			}else{
				for(var i=0;i<data.length;i++){		
					$("#markName").append("<option value="+data[i].id+">"+data[i].name+"</option>");
				}
			}
			$("#markName").selectpicker("refresh");
			$("#teamName").selectpicker("refresh");
			$("#evaluateUserName").selectpicker("refresh");
			$("#markName").selectpicker('val', 'name')
			$("#teamName").selectpicker('val', 'name')
			$("#evaluateUserName").selectpicker('val', 'name')
		},
		error : function(){
			alert("Error!!");
		}
	})
}
function markName() {
	var teacherId =$("#teacherName").val();
	var markNameId =$("#markName").val();
	$.ajax({
		url: '/getMarkTeam',
		type : 'post',
		data: {markNameId:markNameId,teacherId:teacherId},	
		datatype:"json",  
		success : function(data){		
			$("#teamName").children().remove();
			$("#evaluateUserName").children().remove();
			if(data == "" || data == null){
				alert("这位老师这次考核还没有人评价");
			}else{
				for(var i=0;i<data.length;i++){		
					$("#teamName").append("<option value="+data[i].id+">"+data[i].teamName+"</option>");
				}
			}
			$("#teamName").selectpicker("refresh");
			$("#evaluateUserName").selectpicker("refresh");
			$("#teamName").selectpicker('val', 'name');
			$("#evaluateUserName").selectpicker('val', 'name');
			
		},
		error : function(){
			alert("Error!!");
		}
	})
}
function teamName() {
	var teacherId =$("#teacherName").val();
	var markNameId =$("#markName").val();
	var teamId =$("#teamName").val();
	$.ajax({
		url: '/getTeamStudent',
		type : 'post',
		data: {markNameId:markNameId,teacherId:teacherId,teamId:teamId},	
		datatype:"json",  
		success : function(data){
			$("#evaluateUserName").children().remove();
			if(data == "" || data == null){
				alert("这位老师这次考核还没有人评价");
			}else{
				for(var i=0;i<data.length;i++){		
					$("#evaluateUserName").append("<option value="+data[i].id+">"+data[i].userName+"</option>");
				}
			}
			$("#evaluateUserName").selectpicker("refresh");			
			$("#evaluateUserName").selectpicker('val', 'name');
		},
		error : function(){
			alert("Error!!");
		}
	})
}
function evaluateUserName() {
	
}
$("#select").on("click", function() {
	var teacherId =$("#teacherName").val();
	var markNameId =$("#markName").val();
	var teamId =$("#teamName").val();
	var evalutionId = $("#evaluateUserName").val();
	if(teacherId == "" || teacherId == null || markNameId == "" || markNameId == null || teamId == "" || teamId == null || evalutionId == "" || evalutionId == null){
		alert("请选择完全");
		return;
	}
	$.ajax({
		url: '/getMarkResult',
		type : 'post',
		data: {markNameId:markNameId,teacherId:teacherId,teamId:teamId,evalutionId:evalutionId},	
		datatype:"json",  
		success : function(data){
			$("#studentUserImg").attr("src",data[0].user.headPhotoUrl);
			$("#studentAddTime").html(data[0].user.bulidTime);
			$("#studentName").html(data[0].user.userName);
			$("#resultMark").children().remove();
			$("#resultScore").css("display","block");
			for(var i=0;i<data.length;i++){
				var newDiv="<div class='col-sm-10'>" +
						"<p/>"+data[i].quiz.quizTitle+
						"<div class='radio'>" +
								"<input type='radio' name="+"radio"+i+" id=radio"+i+"" +
										"value='option1' checked=''> <label for='radio'"+i+">" +
										data[i].rt.answer +"</label>" +
												"</div>" +
												"</div>";			
				$("#resultMark").append(newDiv);
			}
			
			
		},
		error : function(){
			alert("Error!!"); 
		}
	})
	
});
function changeState(el) {
	if (el.readOnly)
		el.checked = el.readOnly = false;
	else if (!el.checked)
		el.readOnly = el.indeterminate = true;
};