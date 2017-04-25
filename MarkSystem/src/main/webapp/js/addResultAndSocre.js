
		$(document).on("click","#add-result",function(){
			var a = $(this).prev().children('.result').length;
			if(a<7){
			var newResult = "<span class='result'>"+'点击修改'+"</span>";
			var newFont = "<span class='font'>"+'.    Score:'+"</span>";
			var newScore = "<span class='score'>"+'点击修改'+"</span>'</br></br>";
			var a = $(this).prev();
			$(a).append(newResult);
			$(a).append(newFont);
			$(a).append(newScore);
		}
	});
