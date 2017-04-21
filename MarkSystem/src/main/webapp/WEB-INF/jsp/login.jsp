<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="/css/blue.css">
<script type="text/javascript" src="/js/jquery-3.1.0.js"></script>
</head>
<body class="hold-transition login-page">
	<div class="login-box">

		<div class="login-logo">
			<a href="index2.html"><b>睿峰</b>评教系统</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">用户登录</p>
			<form action="/login" method="post">
				<div class="form-group has-feedback">
					<input type="text" name="userAccount" class="form-control" placeholder="账号"> <span
						class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="password" class="form-control" placeholder="密码">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label> <input type="checkbox"> 请记住我
							</label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">登录</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

			<div class="social-auth-links text-center">
				<p>— OR —</p>
				<a href="#" class="btn   btn-social-icon btn-info btn-flat"><i
					class="fa fa-qq"></i> </a> <a href="#"
					class="btn   btn-social-icon btn-danger btn-flat"><i
					class="fa fa-weibo"></i> </a> <a href="#"
					class="btn  btn-social-icon btn-success btn-flat"><i
					class="fa fa-wechat"></i></a>

			</div>
			<!-- /.social-auth-links -->

			<a href="#">忘记密码</a><br>
			<!-- <a href="register.html" class="text-center">Register a new membership</a> -->

		</div>
		<!-- /.login-box-body -->
	</div>
	
	<script type="text/javascript" src="/js/jquery-2.2.3.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script type="text/javascript" src="/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script type="text/javascript" src="/js/icheck.min.js"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
	</script>
</body>
</html>