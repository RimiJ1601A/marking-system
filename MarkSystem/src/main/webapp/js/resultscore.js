function selectMarkName() {
	var teacherId =$("#teacherName").val();
	$.ajax({
		url: '/getMarkTable',
		type : 'post',
		data: {teacherId:teacherId},	
		datatype:"json",  
		success : function(data){	
			if(data == "" || data == null){
				alert("该老师没有被考核过")
			}else{
				for(var i=0;i<data.length;i++){		
					$("#markName").append("<option value="+data[i].id+">"+data[i].name+"</option>");
				}
			}
			$("#markName").selectpicker("refresh");
			$("#markName").selectpicker('val', 'name')
		},
		error : function(){
			alert("Error!!");
		}
	})
}
/*function markName() {
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

*/
$("#select").on("click", function() {
	var teacherId =$("#teacherName").val();
	
	if(teacherId == "" || teacherId == null){
		alert("请选择完全");
		return;
	}
	$.ajax({
		url: '/getResultScore',
		type : 'post',
		data: {evalutionId:teacherId},	
		datatype:"json",  
		success : function(data){
			$("#tableresult").css("display","block");
			$("#markTableresult").children().remove();
			for(var i = 0;i<data.length;i++){
				var newDiv = "<tr class='row'>" +
								"<td class='evalutedId' abbr="+data[i].user.id+">"+data[i].user.userName+"</td>" +
								"<td class='martableId' abbr="+data[i].markTable.id+">"+data[i].markTable.name+"</td>" +
								"<td>"+data[i].markTable.endTime+"</td>" +
								"<td class='teamId' abbr="+data[i].team.id+">"+data[i].team.teamName+"</td>";
				
				var td1="";			
				for(var j=0;j<data[i].evaluationStudent.length;j++){
					td1 = td1+"<p value="+data[i].evaluationStudent[j].id+" class='evalutedUserName' style='float:left;padding:0px 5px;cursor:pointer'>"+data[i].evaluationStudent[j].userName+"</p>";
				}
				var td1content="<td>"+td1+"</td>";
				newDiv = newDiv + td1content ;				
				var td2="";
				for(var k=0;k<data[i].unevaluationStudent.length;k++){
					td2 = td2+"<p style='float:left;padding:0px 5px;'>"+data[i].unevaluationStudent[k].userName+"</p>";
				}
				var tdunevaluation="<td>"+td2+"</td>";
				newDiv = newDiv + tdunevaluation+"</tr>";
				$("#markTableresult").append(newDiv);

			}
			read();
		},
		error : function(){
			alert("Error!!"); 
		}
	})

	
});
function read(){
	$(".evalutedUserName").click(function(e){
		var evalutedId = $(e.target).parent().parent().find(".evalutedId").attr("abbr");
		var martableId = $(e.target).parent().parent().find(".martableId").attr("abbr");
		var teamId = $(e.target).parent().parent().find(".teamId").attr("abbr");
		var evalutionId = $(e.target).attr("value");
		
		$.ajax({
			url: '/getMarkResult',
			type : 'post',
			data: {teacherId:evalutedId,markNameId:martableId,teamId:teamId,evalutionId:evalutionId},	
			datatype:"json",
			success:function(data){
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
			}},
			error:function(){
				alert("error");
			}
		})
		
		
	});
}






function changeState(el) {
	if (el.readOnly)
		el.checked = el.readOnly = false;
	else if (!el.checked)
		el.readOnly = el.indeterminate = true;
};