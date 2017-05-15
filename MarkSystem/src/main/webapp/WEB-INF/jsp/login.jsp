<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<title>用户登录|Rimiedu_MSystem </title>
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
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">用户登录</p>
			<form id="loginForm" action="/login" method="post" onSubmit="return check()">
				<div class="form-group has-feedback">
					<input id="userAccount" type="text" name="userAccount" class="form-control" placeholder="账号"> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input id="passWord" type="password" name="password" class="form-control" placeholder="密码">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-12">
						<div class="checkbox icheck">
							<!-- <label> <input type="checkbox"> 请记住我
							</label> -->
							<a href="/forgetpassword">忘记密码</a><br>
							
						</div>
						
					</div>
					<!-- /.col -->
					<div class="col-xs-12">
						<button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
					</div>
					<!-- /.col -->
				</div>
			</form>
			<!-- 第三方登录链接 -->
			<!-- <div class="social-auth-links text-center">
				<p>— OR —</p>
				<a href="#" class="btn   btn-social-icon btn-info btn-flat"><i
					class="fa fa-qq"></i> </a> <a href="#"
					class="btn   btn-social-icon btn-danger btn-flat"><i
					class="fa fa-weibo"></i> </a> <a href="#"
					class="btn  btn-social-icon btn-success btn-flat"><i
					class="fa fa-wechat"></i></a>

			</div> -->
			<!-- /.social-auth-links -->

		</div>
		<!-- /.login-box-body -->
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