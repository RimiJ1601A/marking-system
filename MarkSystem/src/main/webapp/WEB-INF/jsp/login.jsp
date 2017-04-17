<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link type="text/css" rel="stylesheet" href="/css/login.css">
<link type="text/css" rel="stylesheet" href="/css/bootstrap.css">
<script type="text/javascript" src="/js/jquery-3.1.0.js"></script>
<script type="text/javascript" src="/js/login.js"></script>

</head>
<body>
	<div class="top">
		<img class="img-picture" src="/images/logo.png"/>
	</div>
	<div class="bg">
		<img class="bg-picture" src="/images/login_bg.png"/>
		<div class="bg-two">
			<form action="/login" method="post">
				<div class="font" style="color: #000033">
					<p>睿峰评教系统</p>
				</div>
				<div class="input-picture">
					<img class="user_logo" src="/images/user_logo.png"/>
				</div>
				<div class="input-logo">
					<img class="password_logo" src="/images/password.png"/>
				</div>
					<input type="text" class="input-field" name="userAccount"><br>
					<br> <input type="password" class="input-box" name="password">
				<div class="login">
					<button type="submit" class="login-button"
						style="background: #0099ff; color: #ffffff">登 录</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>