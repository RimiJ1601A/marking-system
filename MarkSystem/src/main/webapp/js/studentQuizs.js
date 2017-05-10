var quizsOnclick_count = 0;
$(document).on("click","#goMarkTable_btn",function(){
	$("#Save_result").remove();
	quizsOnclick_count = 0;
	var markTable_id = $(this).parent().parent().find("td").get(0).innerHTML;
	var evaluated_id = $(this).parent().parent().find("td").get(5).innerHTML;
	var teamName = $(this).parent().parent().find("td").get(4).innerHTML;
	$.ajax({
		url : '/stuGetQuiz',
		type : 'post',
		data : {"markTableId":markTable_id},
		dataType : 'json',
		success : function(Quizs){
			$(".initQuizsContent").remove();
			var newInit = $("<div class='initQuizsContent'></div>");
			$(newInit).attr("value",markTable_id);
			$(newInit).attr("value1",evaluated_id);
			$(newInit).attr("value2",teamName);
			for(var i = 0;i<Quizs.length;i++){
				if(i == Quizs.length-1){
					
				}
				if(i == 0){
					var quiz_title = $("<div class='quiz_title"+i+"' style='position:absolute;display:block;font-size: 20px;'>"+Quizs[i].quizTitle+"</br></div>");
					$(quiz_title).attr("value",Quizs[i].id);
					$(quiz_title).attr("value1",Quizs[i].quizTitle);
				}else{
					var quiz_title = $("<div class='quiz_title"+i+"' style='position:absolute;display:none;font-size: 20px;'>"+Quizs[i].quizTitle+"</br></div>");
					$(quiz_title).attr("value",Quizs[i].id);
					$(quiz_title).attr("value1",Quizs[i].quizTitle);
				}
				if(Quizs[i].quizContent.length==0){
					var essayQuiz = $("<div class='essayQuizValue' style='width:870px;font-size: 16px;'>点击在这里输入你的问题答案!</div>");
					$(quiz_title).append(essayQuiz);
				}else{
				for(var j=0;j<Quizs[i].quizContent.length;j++){
					var student_quizs = $("<input type='radio' name='student_quizContent"+i+"' value='"+Quizs[i].quizContent[j].quizCore+"'>"+Quizs[i].quizContent[j].content+" : "+Quizs[i].quizContent[j].quizCore+"</br>");
					$(student_quizs).attr("value1",Quizs[i].quizContent[j].content);
					$(quiz_title).append(student_quizs);
				}
				}
				$(newInit).append(quiz_title);
				
			}
			$(".modal-body").append(newInit);
		},
		error : function(){
			alert(ERROR);
		}
	});
});
$(document).on("click","#prevQuizs",function(){
	if(quizsOnclick_count == 0){
		
	}else{
		$(".quiz_title"+quizsOnclick_count+"").css("display","none");
		$(".quiz_title"+(quizsOnclick_count-1)+"").css("display","block");
		quizsOnclick_count--;		
	}
});

$(document).on("click","#nextQuizs",function(){
	var index = $(".initQuizsContent").children().length;
	if(quizsOnclick_count == index-1){

	}else if(quizsOnclick_count == index-2){
		$("#Save_result").remove();
		var Tagbtn = $("<button type='button'  id='Save_result' class='btn btn-primary'>提交</button>")
		$("#nextQuizs").after(Tagbtn);
		if($('input[type="radio"][name="student_quizContent'+quizsOnclick_count+'"]:checked').length!=0||($(".quiz_title"+quizsOnclick_count+"").children().text())!="点击在这里输入你的问题答案!"&&($(".quiz_title"+quizsOnclick_count+"").children().text())!="输入不能为空！"&&($(".quiz_title"+quizsOnclick_count+"").children().text())!=""){
			$(".quiz_title"+quizsOnclick_count+"").css("display","none");
			$(".quiz_title"+(quizsOnclick_count+1)+"").css("display","block");
			quizsOnclick_count++;
		}else{
			alert("你还没有完成当前的题");
		}			
	}
	else{
		if($('input[type="radio"][name="student_quizContent'+quizsOnclick_count+'"]:checked').length!=0||($(".quiz_title"+quizsOnclick_count+"").children().text())!="点击在这里输入你的问题答案!"&&($(".quiz_title"+quizsOnclick_count+"").children().text())!="输入不能为空！"&&($(".quiz_title"+quizsOnclick_count+"").children().text())!=""){
			$(".quiz_title"+quizsOnclick_count+"").css("display","none");
			$(".quiz_title"+(quizsOnclick_count+1)+"").css("display","block");
			quizsOnclick_count++;
		}else{
			alert("你还没有完成当前的题");
		}
	}
});

$(document).on("click","#Save_result",function(){
	var AllQuiz = $(".initQuizsContent").children();
	var requestTable = [];
	for(var i=0;i<AllQuiz.length;i++){
		var quizId = $($(AllQuiz).get(i)).attr("value");
		var answer;
		var answerScore;
		var evaluatedId = $(".initQuizsContent").attr("value1");
		var marktableId = $(".initQuizsContent").attr("value");
		var teamName = $(".initQuizsContent").attr("value2");
		var inputName;
		
		
		if($($(AllQuiz).get(i)).find("input").length == 0){
			answer = $($(AllQuiz).get(i)).find(".essayQuizValue").text();
			answerScore = 0;
		}else{
			inputName = $($(AllQuiz).get(i)).find("input").attr("name");
			answer = $('input[type="radio"][name='+inputName+']:checked').attr("value1");
			answerScore = $('input[type="radio"][name='+inputName+']:checked').attr("value");
		}
		var requestQuiz = {"quizId":quizId,"answer":answer,"answerScore":answerScore,"evaluatedId":evaluatedId,"marktableId":marktableId,"teamName":teamName};
		requestTable.push(requestQuiz);
	}
	
	$.ajax({
		url: '/result',
		type : 'post',
		data: JSON.stringify(requestTable),
		contentType : 'application/json; charset=utf-8',
		success : function(){
			alert("Save Success!!");
			$("#student_quizs").modal("hide");
			location.reload();
		},
		error : function(){
			alert("Save Error!!");
		}
	})
	
});
function ta(obj){
	var val=$(obj).val().length;
	if(val>200){
		alert("至多输入200个字符！");
		$(obj).val($(obj).val().substring(0,200))
		}
};
$(document).on("click",".essayQuizValue",function(){
	var td = $(this);
	var txt = td.text();
	if(txt == "输入不能为空！" || txt =="点击在这里输入你的问题答案!"){
		var input =  $("<textarea class='txt_input' id='remark' rows='10' cols='120' onkeyup='ta(this)'  maxlength='200' title='最多可输入200个字符'></textarea>");
	}
	else{
		var input =  $("<textarea class='txt_input' id='remark' rows='10' cols='120' onkeyup='ta(this)'  maxlength='200' title='最多可输入200个字符'>"+txt+"</textarea>");
	}
	td.html(input);
	input.click(function() { return false; });
	input.trigger("focus");
	input.blur(function(){
			var newtxt = $(this).val();
			if(newtxt == ""){
				td.html("输入不能为空！");
			}
			else if (newtxt != txt) {
			td.html(newtxt);
			}
			else{
						td.html(newtxt);
				}
	});
});
