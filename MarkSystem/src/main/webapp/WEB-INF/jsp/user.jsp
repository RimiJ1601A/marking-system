<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="/js/jquery-3.1.0.js"></script>
<script type="text/javascript">
	function add() {
		var a = [ {
			"quizTitle" : "________点击编辑内容________",
			"quizContent" : [ {
				"content" : "A",
				"quizCore" : "90"
			}, {
				"content" : "B",
				"quizCore" : "80"
			}, {
				"content" : "C",
				"quizCore" : "70"
			} ]
		}, {
			"quizTitle" : "__________    ༭  Ŀ    __________",
			"quizContent" : [ {
				"content" : "A",
				"quizCore" : "90"
			}, {
				"content" : "B",
				"quizCore" : "80"
			}, {
				"content" : "C",
				"quizCore" : "70"
			} ]
		}, {
			"quizTitle" : "__________    ༭  Ŀ    __________",
			"quizContent" : [ {
				"content" : "A",
				"quizCore" : "90"
			}, {
				"content" : "B",
				"quizCore" : "80"
			}, {
				"content" : "C",
				"quizCore" : "70"
			} ]
		}, {
			"quizTitle" : "__________    ༭  Ŀ    __________",
			"quizContent" : [ {
				"content" : "A",
				"quizCore" : "90"
			}, {
				"content" : "B",
				"quizCore" : "80"
			}, {
				"content" : "C",
				"quizCore" : "70"
			} ]
		}, {
			"quizTitle" : "__________    ༭  Ŀ    __________",
			"quizContent" : [ {
				"content" : "A",
				"quizCore" : "90"
			}, {
				"content" : "B",
				"quizCore" : "80"
			}, {
				"content" : "C",
				"quizCore" : "70"
			} ]
		} ];
		$.ajax({
			type : "POST",
			url : "/requestQuiz",
			dataType : "json",
			contentType : "application/json",
			data : JSON.stringify(a),
			success : function(data) {

			}
		});
	}
</script>
</head>
<body>
	this is user
	<button onclick="add()">add</button>
</body>
</html>