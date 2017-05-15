				function check(){
			
				var acc = $("#userAccount").val();
				var pas =  $("#passWord").val();
				
				if(acc == "" || pas == "" || acc == null || pas == null){
					alert("账号或密码不能为空！");
					return false;
				}else{
					return true;
					}
			
			
			}	
		
		    
		