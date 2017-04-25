$(document).on("click","#button",function(){
	acount=1;
	while($(".bb-item").length>1){
	$(".bb-item")[1].remove();
	}

});

$(document).on("click",".saveQuiz",function(){
	var quizs = $(".createTable_List");
	var qs = [];
	for(var i=0;i<quizs.length;i++){
		var content = $(quizs[i]).children(".content-lxd");
		var cont = $(content).text();
		var result = $(quizs[i]).children(".result");
		var score = $(quizs[i]).children(".score");
		
		var option=[];
		var scores=[];
		var quizCont=[];
		for(var j=0;j<result.length;j++){
			var opt = $(result[j]).text();
			var sc = $(score[j]).text();
			option[j] = opt;
			scores[j] = sc;
			var quizContent = {"content":option[j],"quizCore":scores[j]};
			quizCont.push(quizContent); 
		}
		var quiz = {"quizTitle":cont,"quizContent":quizCont};
		qs.push(quiz);
	}
	var qsjson = JSON.stringify(qs);
	
	$.ajax({
		url: '/addQuizs',
		type : 'post',
		data: qsjson,
		contentType: 'application/json; charset=utf-8',
		success : function(){
			alert(1);
		},
		error : function(){
			alert(2);
		}
	})
	});