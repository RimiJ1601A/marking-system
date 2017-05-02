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
			var input =  $("<textarea class='txt_input' id='remark' rows='2' cols='45' onkeyup='ta(this)'  maxlength='50' title='最多可输入50个字符'></textarea>");
		}
		else{
			var input =  $("<textarea class='txt_input' id='remark' rows='2' cols='45' onkeyup='ta(this)'  maxlength='50' title='最多可输入50个字符'>"+txt+"</textarea>");
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
function ta(obj){
	var val=$(obj).val().length;
	if(val>50){
		alert("至多输入50个字符！");
		$(obj).val($(obj).val().substring(0,50))
		}
};
$(document).on("click","#Add_quizType",function(){
	var td = $(this);
	var txt = td.text();
	if(txt == "输入不能为空！" || txt =="输入问题题目"){
		var input =  $("<textarea class='txt_input' id='remark' rows='2' cols='50' onkeyup='ta(this)'  maxlength='50' title='最多可输入50个字符'></textarea>");
	}
	else{
		var input =  $("<textarea class='txt_input' id='remark' rows='2' cols='50' onkeyup='ta(this)'  maxlength='50' title='最多可输入50个字符'>"+txt+"</textarea>");
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
$(document).on("click","#AddQuizType",function(){
	$("#Add_quizType").remove();
	var newTag = $("<div id='Add_quizType' >输入问题题目</div>");
	$("#quiztypeBody").append(newTag);
});