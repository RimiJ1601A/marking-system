$(document).on("click",".result",function(){
		var td = $(this);
		var txt = td.text();
		if(txt == "输入不能为空！" || txt =="点击修改"){
			var input =  $("<input type='text'value=''/>");
		}
		else{
			var input =  $("<input type='text'value='"+txt+"'/>");
		}
		input.css("width","200px");
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
$(document).on("click",".score",function(){
		var td = $(this);
		var txt = td.text();
		if(txt == "输入不能为空！" || txt =="点击修改"){
			var input =  $("<input type='text'value=''/>");
		}
		else{
			var input =  $("<input type='text'value='"+txt+"'/>");
		}
		input.css("width","200px");
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
	
	$(document).on("click",".content-lxd",function(){
		var td = $(this);
		var txt = td.text();
		if(txt == "输入不能为空！" || txt =="__________点击编辑内容__________"){
			var input =  $("<input type='text'value=''/>");
		}
		else{
			var input =  $("<input type='text'value='"+txt+"'/>");
		}
		input.css("width","500px");
		input.css("white-space","normal");
		input.css("word-wrap","break-word");
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
$(document).on("click","#Add_quizType",function(){
	var td = $(this);
	var txt = td.text();
	if(txt == "输入不能为空！" || txt =="输入问题题目"){
		var input =  $("<input type='text'value=''/>");
	}
	else{
		var input =  $("<input type='text'value='"+txt+"'/>");
	}
	input.css("width","500px");
	input.css("white-space","normal");
	input.css("word-wrap","break-word");
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