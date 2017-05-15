<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<title>密码找回</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="/css/blue.css">
<script type="text/javascript" src="/js/jquery-1.12.4.js"></script>
<script src="/js/html5shiv.js"></script>         
<script src="/js/respond.min.js"></script>
</head>
<body class="hold-transition login-page">
<div class="wrapper">
	<div class="login-box">
	<div class="login-logo">
			<a href="javascript:void(0)"><b>睿峰</b>评教系统</a>
		</div>
      <div class="box box-solid box-primary">
        <div class="box-header">
          <h3 class="box-title">用户帮助中心</h3>
          
        </div><!-- /.box-header -->
        <div class="box-body">
        <p>请尝试使用你的<b>初始密码登录</b>
        <p>若你已经<b>修改密码</b>
          <p>请联系你的<b>系统管理员</b>找回密码！</p>
          
        </div><!-- /.box-body -->
       <div class="box-footer" style="text-align:center">
                 <a href="/loginpage" class="btn btn-primary"><i class="fa fa-map-signs"></i> 返回登录页面</a>
       </div>
      </div><!-- /.box -->
   
		</div>
		
 <footer style="text-align:center;position:relative;">
           
                  
		<strong>Copyright &copy; 2017 <a href="#">睿峰教育</a>.
		</strong> 版权所有.
           
            </footer>
	
	</div>
	
 	<script type="text/javascript" src="/js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/js/icheck.min.js"></script> 
	<script type="text/javascript" src="/js/login.js"></script>


	
	
	<script>
 		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		}); 
		
		window.onload=function(){
			var err = "${error}";
			if(err == ""){
				
			}else{
				alert(err);
			}
		};
	</script>
</body>
</html>