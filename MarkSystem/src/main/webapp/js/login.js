		$("form").submit(function(e){
			var acc = $("#userAccount").val();
			var pas =  $("#passWord").val();
			
			if(acc == "" || pas == "" || acc == null || pas == null){
				alert("不能为空");
				return;
			}else{
				$("#loginForm").submit();
			}	
		});