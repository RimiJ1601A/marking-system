$(document).on("click",".result",function(){
		var td = $(this);
		var txt = td.text();
		var input =  $("<input type='text'value='自定义编写选项'/>");
		input.css("width","200px");
		td.html(input);
		input.click(function() { return false; });
		input.trigger("focus");
		input.blur(function(){
				var newtxt = $(this).val();
				if (newtxt != txt) {
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
		var input =  $("<input type='text'value='自定义编写分数'/>");
		input.css("width","200px");
		td.html(input);
		input.click(function() { return false; });
		input.trigger("focus");
		input.blur(function(){
				var newtxt = $(this).val();
				if (newtxt != txt) {
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
		var input =  $("<input type='text'value='自定义编写题目'/>");
		input.css("width","500px");
		input.css("white-space","normal");
		input.css("word-wrap","break-word");
		td.html(input);
		input.click(function() { return false; });
		input.trigger("focus");
		input.blur(function(){
				var newtxt = $(this).val();
				if (newtxt != txt) {
				td.html(newtxt);
			}
			 else{
 						td.html(newtxt);
 				}
		});
	});