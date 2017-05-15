/*var a = [];
var student1 = {"name":"lxd"};
var student2 = {"name":"cxh"};
var student3 = {"name":"ll"};
var student4 = {"name":"llb"};
a.push(student1);
a.push(student2);
a.push(student3);
a.push(student4);*/
var b = [];
/*
 * var class1 = {"classname":"J1601","student":a}; b.push(class1);
 * 
 * var c = []; var student5 = {"name":"zcv"}; var student6 = {"name":"asd"}; var
 * student7 = {"name":"aa"}; var student8 = {"name":"sds"}; c.push(student5);
 * c.push(student6); c.push(student7); c.push(student8); var class2 =
 * {"classname":"Web01","student":c}; b.push(class2);
 */
var clickteamcount = 0;
$(document).on("click","#addclass",function() {
	if(clickteamcount <1){
						$.ajax({
									url : '/getTeams',
									type : 'post',
									data : {},
									contentType : 'application/json; charset=utf-8',
									dataType : 'json',
									success : function(teams) {
										for (var j = 0; j < teams.length; j++) {
											var a = [];
											if(teams[j].users!=null){
											for (var i = 0; i < teams[j].users.length; i++) {
												var evaluatedName = {"name" : teams[j].users[i].userName,"id": teams[j].users[i].id,"roleId":teams[j].users[i].roleId};
												a.push(evaluatedName);
											}
											var team = {"classname" : teams[j].teamName,"classId": teams[j].teamId,"student" : a};
											b.push(team);
											}
										}
										clickteamcount++;
										var newdiv = $("<div></div>");
										var newselect = $("<select class='classList' onchange='optionChange(this)'></select>");
										var newbtn = $("<div class='btn btn-default' onclick='deletdiv(this)'>"
												+ '删' + "</div>")
										for (var i = 0; i < b.length; i++) {
											var newoption = $("<option>" + b[i].classname + "</option>");
											$(newoption).attr("value",b[i].classId);
											$(newselect).append(newoption);
										}
										$(newdiv).append(newselect);
										var newselect2 = $("<select class='studentList'></select>");
										for (var j = 0; j < b[0].student.length; j++) {
											if(b[0].student[j].roleId ==2){
												var newoption1 = $("<option>" + b[0].student[j].name+'(老师)'
														+ "</option>");
											}else{
											var newoption1 = $("<option>" + b[0].student[j].name
													+ "</option>");
											}
											$(newoption1).attr("value",b[0].student[j].id);
											$(newselect2).append(newoption1);
										}
										$(newdiv).append(newselect2);
										$(newdiv).append(newbtn);
										$("#c_nameAnds_name").append(newdiv);
									},
									error : function() {
										alert("error");
									}
								});
	}
						if(b.length>0){
						var newdiv = $("<div></div>");
						var newselect = $("<select class='classList' onchange='optionChange(this)'></select>");
						var newbtn = $("<div class='btn btn-default' onclick='deletdiv(this)'>"
								+ '删' + "</div>")
						for (var i = 0; i < b.length; i++) {
							var newoption = $("<option>" + b[i].classname
									+ "</option>");
							$(newoption).attr("value",b[i].classId);
							$(newselect).append(newoption);
						}
						$(newdiv).append(newselect);
						var newselect2 = $("<select class='studentList'></select>");
						for (var j = 0; j < b[0].student.length; j++) {
							if(b[0].student[j].roleId ==2){
								var newoption1 = $("<option>" + b[0].student[j].name+'(老师)'
										+ "</option>");
							}else{
							var newoption1 = $("<option>" + b[0].student[j].name
									+ "</option>");
							}
							$(newoption1).attr("value",b[0].student[j].id);
							$(newselect2).append(newoption1);
						}
						$(newdiv).append(newselect2);
						$(newdiv).append(newbtn);
						$("#c_nameAnds_name").append(newdiv);
					}	
				});

function optionChange(sd) {
	$(sd).next().remove();
	var className = $(sd).find("option:selected").text();
	for (var i = 0; i < b.length; i++) {
		if (className == b[i].classname) {
			var newselect4 = $("<select class='studentList'></select>'");
			for (var j = 0; j < b[i].student.length; j++) {
				if(b[i].student[j].roleId ==2){
					var newoption4 = $("<option>" + b[i].student[j].name+'(老师)'
							+ "</option>");
				}else{
				var newoption4 = $("<option>" + b[i].student[j].name
						+ "</option>");
				}
				$(newoption4).attr("value",b[i].student[j].id);
				$(newselect4).append(newoption4);
			}
			$(sd).after(newselect4);

		}
	}
}

function deletdiv(b) {
	$(b).parent().remove();
}

var question = [];
/*
 * var q1 = {"id":"1","quizTitle":"asdfaqwersdfsdf"}; var q2 =
 * {"id":"2","quizTitle":"的发生啥地方水电费"}; var q3 =
 * {"id":"3","quizTitle":"自行车asdf"}; var q4 =
 * {"id":"4","quizTitle":"我设计了肯定放假Wie"}; var q5 =
 * {"id":"5","quizTitle":"是水电费水电费"}; question.push(q1); question.push(q2);
 * question.push(q3); question.push(q4); question.push(q5);
 */
function getToday()
{
    var d=new Date();
    var str="";
    str+=d.getFullYear()+"-";
    
    var month=d.getMonth()+1;
    if(month<10)
        month="0"+month;
    var day=d.getDate();
    if(day<10)
        day="0"+day;
    
    str+=month;
    str+="-";
    str+=day;
    return str;
    
};
var clickcount = 1;
$(document)
		.on(
				"click",
				"#List_button",
				function() {
					var today=getToday();
					$("#date").datetimepicker({
						format : 'yyyy-mm-dd',
						startDate : today,
						startView : 4,
						minView : 2
					});

					$
							.ajax({
								url : '/getQuizs',
								type : 'post',
								data : {},
								contentType : 'application/json; charset=utf-8',
								dataType : 'json',
								success : function(quizs) {
									if(clickcount==1){
										for (var i = 0; i < quizs.length; i++) {
											var newcheck = $("<input type='checkbox' name='checkbox' value="
													+ quizs[i].id
													+ " data-labelauty='"
													+ quizs[i].quizTitle + "'>");
											$(".quiz_List").append(newcheck);
										}
										$(':input').labelauty();
									clickcount++;
									}
								},
								error : function() {
									alert(3);
								}
							});

				});

function submitmarkTable() {
	var name = $("#Title").val();
	var endTime = $("#date").val();
	var quizs = [];
	var qs = $('input[name="checkbox"]:checked');
	if(qs.length==0){
		alert("你还没有选择题目");
		return;
	}
	for (var i = 0; i < qs.length; i++) {
		var marktableQuiz = {
			"quizId" : $(qs)[i].value
		};
		quizs.push(marktableQuiz);
	}
	var usermarke = [];
	var lgth = $(".classList");
	if(lgth.length==0){
		alert("你没有选择班级以及被评分人！");
		return;
	}
	for (var j = 0; j < lgth.length; j++) {
		var usermarke_team = $(".classList")[j];
		var usermarke_user = $(".studentList")[j];
		var teamId = $(usermarke_team).find("option:selected").val();
		var studentId = $(usermarke_user).find("option:selected").val();
		
		var markeTableTeam = {"teamId":teamId,"evaluatedId":studentId};
		usermarke.push(markeTableTeam);
	}
	for(var i=0;i<usermarke.length;i++){
		//var team_id = usermark[i].teamId;
		for(var j=i+1;j<usermarke.length;j++){
			//var team_id2 = usermark[j].teamId;
			if(usermarke[i].teamId == usermarke[j].teamId && usermarke[i].evaluatedId == usermarke[j].evaluatedId){
				usermarke.splice(j,1);
				alert("有相同的班级和被评人存在");
				return;
			}
		}
	}

	var markTable = {
		"name" : name,
		"endTime" : endTime,
		"markTableQuiz" : quizs,
		"userMarke" : usermarke
	};

	$.ajax({
		url : '/submitmarketable',
		type : 'post',
		data : JSON.stringify(markTable),
		contentType : 'application/json; charset=utf-8',
		success : function() {
			alert("Save Success!!");
			$("#myTable").modal("hide");
			location.reload();
		},
		error : function() {
			alert("Save Error!!");
		}
	});
}
function closequizmodal(){
	$("#quizList").modal("hide");
}
$(document).on("click","#delete-btn-lxd",function(){
	var marktableId = $(this).prev().text();
	$.ajax({
		url : '/deleteMarkTable',
		type : 'post',
		data : {MarktableId:marktableId},
		success : function(){
			alert("DELETE SUCCESS!");
			location.reload();
		},
		error: function(){
			alert("DELETE ERROR!");
		}
	})
});