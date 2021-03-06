<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Rimiedu_MSystem | normal</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="/css/font-awesome.min.css">

<link rel="stylesheet"
	href="/css/ionicons.min.css">
<link rel="stylesheet" href="/css/AdminLTE.min.css">

<link rel="stylesheet" href="/css/skin-black.min.css">
<link rel="stylesheet" href="/css/mystyle.css">
<script type="text/javascript" src="/js/jquery-1.12.4.js"></script>
<script src="/js/html5shiv.js"></script>         
<script src="/js/respond.min.js"></script>

</head>
<body class="hold-transition skin-black sidebar-mini fixed">

	<div class="wrapper">
		<!-- Main Header -->
		<header class="main-header"> <!-- Logo --> <a href="#"
			class="logo"> <!-- mini logo for sidebar mini 50x50 pixels --> <span
			class="logo-mini"><b>R</b>I<b>m</b>I</span> <!-- logo for regular state and mobile devices -->
			<span class="logo-lg"><img src="images/Rimilogo.png" alt=""></span>
		</a> <!-- Header Navbar --> <nav class="navbar navbar-static-top"
			role="navigation"> <!-- Sidebar toggle button--> <a href="#"
			class="sidebar-toggle" data-toggle="offcanvas" role="button"> <span
			class="sr-only">Toggle navigation</span>
		</a> <!-- Navbar Right Menu -->
		<div class="navbar-custom-menu">
			<ul class="nav navbar-nav">
				
				<li class="dropdown user user-menu">
					<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <!-- The user image in the navbar--> <img
						src="${sessionScope.user.headPhotoUrl}" class="user-image"
						alt="User Image"> <!-- hidden-xs hides the username on small devices so only the image appears. -->
						<span class="hidden-xs">${sessionScope.user.userName}</span>
				</a>
					<ul class="dropdown-menu">
						<!-- The user image in the menu -->
						<li class="user-header"><img src="${sessionScope.user.headPhotoUrl}"
							class="img-circle" alt="User Image">

							<p>
								${sessionScope.user.userName} <small>${sessionScope.roleName}
									</small>
							</p></li>
						
						<li class="user-footer">
							<div class="pull-left">
								<a href="/profile" class="btn btn-default btn-flat">修改信息</a>
							</div>
							<div class="pull-right">
								<a href="/signOut" class="btn btn-default btn-flat">退出登录</a>
							</div>
						</li>
					</ul>
				</li>

				
          </li> 
			</ul>
		</div>
		</nav> </header>

		<!-- Left side column. contains the logo and sidebar -->
		<aside class="main-sidebar"> <!-- sidebar: style can be found in sidebar.less -->
		<section class="sidebar"> <!-- Sidebar user panel (optional) -->
		<div class="user-panel">
			<div class="image">
				<img src="${sessionScope.user.headPhotoUrl}" class="img-circle"
					alt="User Image">
			</div>
			<div class="info">
				<p>${sessionScope.user.userName}</p>
				<!-- Status -->
				<!-- 通过text-xxx来个更改颜色 -->
				<a href="#"><i class="fa fa-circle text-warning"></i>
					${sessionScope.roleName}</a>
			</div>
		</div>

		
		<ul class="sidebar-menu">
			<li class="header">睿峰评教系统</li>
			<!-- Optionally, you can add icons to the links -->
			<li class="active"><a href="/index"><i class="fa fa-home"></i>
					<span>个人主页</span></a></li>

			<c:set var="functions" value="${sessionScope.functions}" />
			<c:if test="${fn:contains(functions,'职位')}">
				<li><a href="/role"><i class="fa fa-briefcase"></i> <span>职位管理</span></a></li>
			</c:if>

			<c:if
				test="${fn:contains(functions,'用户') || fn:contains(functions,'班级')}">
				<li class="treeview"><a href="#"><i class="fa fa-user"></i>
						<span>用户管理</span> <span class="pull-right-container"> <i
							class="fa fa-angle-left pull-right"></i>
					</span> </a>

					<ul class="treeview-menu">
						<c:if test="${fn:contains(functions,'用户')}">
							<li><a href="/user">人员信息</a></li>
						</c:if>
						<c:if test="${fn:contains(functions,'班级')}">
							<li><a href="/team">班级信息</a></li>
						</c:if>
					</ul></li>
			</c:if>
<c:if test="${fn:contains(functions,'评分表')}">

			<li class="treeview"><a href="#"><i class="fa fa-file-text"></i>
					<span>评分系统</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<c:if test="${fn:contains(functions,'创建评分表')}">
						<li><a href="/markTable">创建评分表</a></li>
					</c:if>
					<c:if test="${fn:contains(functions,'评分评分表')}">
						<li><a href="/mark">考评</a></li>
					</c:if>
					<c:if test="${fn:contains(functions,'查询评分表')}">
						<li ><a href="/resultscore">评分考核结果</a></li>
					</c:if>	
				</ul></li>
					</c:if>	

		</ul>
		<!-- /.sidebar-menu --> </section> <!-- /.sidebar --> </aside>



		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<section class="content-header">
			<h1>
				欢迎来到个人首页
				<!-- 可以放上次登录时间 -->
				<small>新闻、个人看板</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="/index"><i class="fa fa-dashboard"></i> 主页</a></li>
				<li class="active">个人首页</li>
			</ol>
			</section>
			<section>
			<div class="box box-solid" id="news">
				<div class="box-header with-border">
					<h3 class="box-title">新闻</h3>

					<!-- /.box-header -->
					<div class="box-body">
						<div id="carousel-example-generic" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carousel-example-generic" data-slide-to="0"
									class="active"></li>
								<li data-target="#carousel-example-generic" data-slide-to="1"
									class=""></li>
								<li data-target="#carousel-example-generic" data-slide-to="2"
									class=""></li>
							</ol>
							<div class="carousel-inner">
								<div class="item active">
									<img src="http://placehold.it/1920x550/39CCCC/ffffff&text=学校公告"
										alt="First slide">
									<div class="carousel-caption">First Slide</div>
								</div>
								<div class="item">
									<img src="http://placehold.it/1920x550/3c8dbc/ffffff&text=明星教师"
										alt="Second slide">
									<div class="carousel-caption">Second Slide</div>
								</div>
								<div class="item">
									<img src="http://placehold.it/1920x550/f39c12/ffffff&text=优秀学员"
										alt="Third slide">
									<div class="carousel-caption">Third Slide</div>
								</div>
							</div>
							<a class="left carousel-control" href="#carousel-example-generic"
								data-slide="prev"> <span class="fa fa-angle-left"></span>
							</a> <a class="right carousel-control"
								href="#carousel-example-generic" data-slide="next"> <span
								class="fa fa-angle-right"></span>
							</a>
						</div>
					</div>
					<!-- /.box-body -->
				</div>
			</section>
			<!-- Main content -->
			<!-- 这里放个人看板信息 -->
			<!-- <section class="dashboard "> -->
			<div class="row dashboard">
			<div class="box box-solid ">
            <div class="box-header with-border">
              <i class="fa fa-warning"></i>

              <h3 class="box-title">️注意</h3>
            </div>
            <!-- /.box-header -->
            <div class="box-body">
              
              
              <div class="alert alert-warning alert-dismissible">
                <button type="button" class="close" data-dismiss="alert" aria-hidden="true">×</button>
                <h4><i class="icon fa fa-warning"></i> 非常抱歉!</h4>
                此处还没有任何数据.
              </div>
              
            </div>
            <!-- /.box-body -->
          </div>
          </div>
         <!--  </section> -->

</div>
		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<footer class="main-footer">
		<div class="pull-right hidden-xs">
			<b>Version</b> 3.1.0
		</div>
		<strong>Copyright &copy; 2017 <a href="#">Rimiedu</a>.
		</strong> All rights reserved. </footer>
		
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED JS SCRIPTS -->

	<!-- jQuery 3.1.0 -->
	<script type="text/javascript" src="/js/jquery-3.1.0.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="/js/bootstrap.min.js"></script>
	<!-- AdminLTE App -->
	<script src="/js/app.min.js"></script>

	<!-- Scrollslim js -->
	<script src="/js/jquery.slimscroll.min.js"></script>

	<!-- Chart js -->
	<script src="/js/Chart.min.js"></script>
	<!-- adminchartjs -->
	<script src="/js/studentchart.js"></script>
</html>