var quizsOnclick_count = 0;
$(document).on("click","#goMarkTable_btn",function(){
	quizsOnclick_count = 0;
	var markTable_id = $(this).parent().parent().find("td").get(0).innerHTML;
	$.ajax({
		url : '/stuGetQuiz',
		type : 'post',
		data : {"markTableId":markTable_id},
		dataType : 'json',
		success : function(Quizs){
			$(".initQuizsContent").remove();
			var newInit = $("<div class='initQuizsContent'></div>");
			for(var i = 0;i<Quizs.length;i++){
				if(i == Quizs.length-1){
					
				}
				if(i == 0){
					var quiz_title = $("<div class='quiz_title"+i+"' style='position:absolute;display:block;'>"+Quizs[i].quizTitle+"</br></div>");
				}else{
					var quiz_title = $("<div class='quiz_title"+i+"' style='position:absolute;display:none;'>"+Quizs[i].quizTitle+"</br></div>");
				}
				for(var j=0;j<Quizs[i].quizContent.length;j++){
					var student_quizs = $("<input type='radio' name='student_quizContent"+i+"' value='"+Quizs[i].quizContent[j].quizCore+"'>"+Quizs[i].quizContent[j].content+" : "+Quizs[i].quizContent[j].quizCore+"</br>");
					$(quiz_title).append(student_quizs);
				}
				$(newInit).append(quiz_title);
				
			}
			$(".modal-body").append(newInit);
		},
		error : function(){
			alert(2);
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
		
	}else{
		$(".quiz_title"+quizsOnclick_count+"").css("display","none");
		$(".quiz_title"+(quizsOnclick_count+1)+"").css("display","block");
		quizsOnclick_count++;		
	}
});
