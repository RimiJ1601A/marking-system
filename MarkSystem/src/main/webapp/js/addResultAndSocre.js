
		$(document).on("click","#add-result",function(){
			var a = $(this).prev().children('.result').length;
			if(a<7){
			if(a ==3){
				var choice = "<span style='font-size:20px;'>D:</span>";
			}
			if(a ==4){
				var choice = "<span style='font-size:20px;'>E:</span>";
			}
			if(a ==5){
				var choice = "<span style='font-size:20px;'>F:</span>";
			}
			if(a ==6){
				var choice = "<span style='font-size:20px;'>G:</span>";
			}
			var newResult = "<span class='result'>"+'点击修改'+"</span>";
			var newFont = "<span class='font'>"+'.    分数:'+"</span>";
			var newScore = "<span class='score'>"+'点击修改'+"</span>'</br></br>";
			var a = $(this).prev();
			$(a).append(choice);
			$(a).append(newResult);
			$(a).append(newFont);
			$(a).append(newScore);
		}
	});
