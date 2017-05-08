<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<title>Rimiedu_MSystem | admi</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">

<!-- Theme style -->
<link rel="stylesheet" href="/css/AdminLTE.min.css">
<link rel="stylesheet" href="/css/skin-black.min.css">
<link rel="stylesheet" href="/css/mystyle.css">
<link rel="stylesheet" href="/css/buttons.css">
<link
	href="http://cdn.bootcss.com/font-awesome/4.6.3/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="/css/build.css">
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
				<!-- Messages: style can be found in dropdown.less-->
				<li class="dropdown messages-menu">
					<!-- Menu toggle button --> <a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i class="fa fa-envelope-o"></i> <span
						class="label label-success">4</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">You have 4 messages</li>
						<li>
							<!-- inner menu: contains the messages -->
							<ul class="menu">
								<li>
									<!-- start message --> <a href="#">
										<div class="pull-left">
											<!-- User Image -->
											<img src="${sessionScope.user.headPhotoUrl}"
												class="img-circle" alt="User Image">
										</div> <!-- Message title and timestamp -->
										<h4>
											Support Team <small><i class="fa fa-clock-o"></i> 5
												mins</small>
										</h4> <!-- The message -->
										<p>Why not buy a new awesome theme?</p>
								</a>
								</li>
								<!-- end message -->
							</ul> <!-- /.menu -->
						</li>
						<li class="footer"><a href="#">See All Messages</a></li>
					</ul>
				</li>
				<!-- /.messages-menu -->

				<!-- Notifications Menu -->
				<li class="dropdown notifications-menu">
					<!-- Menu toggle button --> <a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i class="fa fa-bell-o"></i> <span
						class="label label-warning">10</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">You have 10 notifications</li>
						<li>
							<!-- Inner Menu: contains the notifications -->
							<ul class="menu">
								<li>
									<!-- start notification --> <a href="#"> <i
										class="fa fa-users text-aqua"></i> 5 new members joined today
								</a>
								</li>
								<!-- end notification -->
							</ul>
						</li>
						<li class="footer"><a href="#">View all</a></li>
					</ul>
				</li>

				<!-- Tasks Menu -->
				<li class="dropdown tasks-menu">
					<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <i class="fa fa-flag-o"></i> <span
						class="label label-danger">9</span>
				</a>
					<ul class="dropdown-menu">
						<li class="header">You have 9 tasks</li>
						<li>
							<!-- Inner menu: contains the tasks -->
							<ul class="menu">
								<li>
									<!-- Task item --> <a href="#"> <!-- Task title and progress text -->
										<h3>
											Design some buttons <small class="pull-right">20%</small>
										</h3> <!-- The progress bar -->
										<div class="progress xs">
											<!-- Change the css width attribute to simulate progress -->
											<div class="progress-bar progress-bar-aqua"
												style="width: 20%" role="progressbar" aria-valuenow="20"
												aria-valuemin="0" aria-valuemax="100">
												<span class="sr-only">20% Complete</span>
											</div>
										</div>
								</a>
								</li>
								<!-- end task item -->
							</ul>
						</li>
						<li class="footer"><a href="#">View all tasks</a></li>
					</ul>
				</li>


				<!-- User Account Menu -->
				<li class="dropdown user user-menu">
					<!-- Menu Toggle Button --> <a href="#" class="dropdown-toggle"
					data-toggle="dropdown"> <!-- The user image in the navbar--> <img
						src="${sessionScope.user.headPhotoUrl}" class="user-image"
						alt="User Image"> <!-- hidden-xs hides the username on small devices so only the image appears. -->
						<span class="hidden-xs">Alexander Pierce</span>
				</a>
					<ul class="dropdown-menu">
						<!-- The user image in the menu -->
						<li class="user-header"><img
							src="${sessionScope.user.headPhotoUrl}" class="img-circle"
							alt="User Image">

							<p>
								Alexander Pierce - Web Developer <small>Member since
									Nov. 2012</small>
							</p></li>
						<!-- Menu Body -->
						<li class="user-body">
							<div class="row">
								<div class="col-xs-4 text-center">
									<a href="#">Followers</a>
								</div>
								<div class="col-xs-4 text-center">
									<a href="#">Sales</a>
								</div>
								<div class="col-xs-4 text-center">
									<a href="#">Friends</a>
								</div>
							</div> <!-- /.row -->
						</li>
						<!-- Menu Footer-->
						<li class="user-footer">
							<div class="pull-left">
								<a href="/profile" class="btn btn-default btn-flat">Profile</a>
							</div>
							<div class="pull-right">
								<a href="/signOut" class="btn btn-default btn-flat">Sign out</a>
							</div>
						</li>
					</ul>
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
				<a href="#"><i class="fa fa-circle text-success"></i>
					${sessionScope.roleName}</a>
			</div>
		</div>

		<!-- search form (Optional) -->
		<form action="#" method="get" class="sidebar-form">
			<div class="input-group">
				<input type="text" name="q" class="form-control"
					placeholder="Search..."> <span class="input-group-btn">
					<button type="submit" name="search" id="search-btn"
						class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</form>
		<!-- /.search form --> <!-- Sidebar Menu -->
		<ul class="sidebar-menu">
			<li class="header">睿峰评教系统</li>
			<!-- Optionally, you can add icons to the links -->
			<li class="treeview"><a href="/index"><i class="fa fa-home"></i>
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

			<li class="active"><a href="#"><i class="fa fa-file-text"></i>
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
						<li class="active"><a href="/resultscore">评分考核结果</a></li>
					</c:if>			
				</ul></li>

		</ul>
		<!-- /.sidebar-menu --> </section> <!-- /.sidebar --> </aside>
		<div class="content-wrapper">
			<section class="content-header">
			<h1>个人简介</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i>主页</a></li>
				<li><a href="#">个人首页</a></li>
				<li class="active">个人简介</li>
			</ol>
			</section>
			<!-- Main content -->
			<section class="content">
			<div class="row">
				<div class="col-md-12">
					<div class="nav-tabs-custom">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#timeline" data-toggle="tab">评分总览</a></li>
							<li><a href="#setinfo" data-toggle="tab">评分详细信息</a></li>
						</ul>
						<div class="tab-content">
							<!-- /.tab-pane -->
							<div class="tab-pane active" id="timeline">
								<div class="row">

									<div class="col-md-3">
										<div class="box box-primary">
											<div class="box-header with-border">
												<h3 class="box-title">关于我</h3>
											</div>
											<div class="box-body box-profile">
												<button id="myuser-img" type="button"
													class="btn btn-default" data-target="#myModal"
													data-toggle="modal" data-placement="top">
													<img id="profileUserImg"
														class="profile-user-img img-responsive img-circle"
														src="${TeacherResults.user.headPhotoUrl}"
														alt="User profile picture">
												</button>
												<h3 class="profile-username text-center">${TeacherResults.user.userName}</h3>
												<p class="text-muted text-center">${TeacherResults.user.roleName}</p>
												<!-- <strong><i class="fa fa-book margin-r-5"></i>所属班级</strong>
												<p class="text-muted">java1601</p> -->
												<hr>
												<strong><i class="fa fa-calendar-plus-o margin-r-5"></i>加入时间</strong>
												<p class="text-muted">${TeacherResults.user.bulidTime}</p>
												<hr>
											</div>
											<!-- /.box-body -->
										</div>
										<!-- /.box -->
									</div>

									<div class="col-md-9">
										<div class="box box-solid">
											<div class="box-header with-border">
												<h3 class="box-title">个人总览</h3>

											</div>
											<!-- /.box-header -->
											<div class="box-body" style="display: block;">
												<p class="text-center">
													<strong id="time_strong">班级教学质量:</strong>
												</p>
												<div class="chart">
													<!-- 被评次数 Chart Canvas -->
													<!-- 显示从系统启用到查询时的统计数据 -->
													<canvas id="teacherChart" style="height: 285px;"></canvas>
												</div>
												<!-- /.chart-responsive -->
											</div>
											<!-- /.box -->

										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="col-lg-12">
											<div class="box box-solid">
												<div class="box-header with-border">
													<i class="fa fa-bullhorn"></i>

													<h3 class="box-title">学生评语</h3>
												</div>
												<!-- /.box-header -->
												<div class="box-body">

													<c:forEach var="comment"
														items="${TeacherResults.contentmap}">
														<c:forEach var="content" items="${comment.value}">
															<div class="callout callout-info">
																<h4>${comment.key}</h4>
																<p>${content}</p>
															</div>
														</c:forEach>
													</c:forEach>
												</div>
												<!-- /.box-body -->

												<div class="box-footer text-center">
													<a id="more-content" href="javascript:void(0)"
														class="uppercase">查看更多评语</a>
												</div>
											</div>
										</div>
									</div>
								</div>
							</div>


							<div class="tab-pane" id="setinfo">

								<div class="row">

									<div>
										<label class="col-sm-1 control-label">老师名字：</label>
	
										<div class="col-sm-1">
											<select id="teacherName" name="teacherName"
												class="selectpicker show-tick form-control"
												data-live-search="false" onchange="selectMarkName()">
												<c:forEach var="teac" items="${teacherlist}" >
													<option value="${teac.id}">${teac.userName}</option>
												</c:forEach>
											</select>
										</div>
									</div>

									<div>
										<label class="col-sm-1 control-label">考核名字：</label>
										<div class="col-sm-1">
											<select id="markName" name="markName"
												class="selectpicker show-tick form-control"
												data-live-search="false" onchange="markName()">
<!-- 												<option value="0">第一次</option>
												<option value="1">第二次</option>
												<option value="2">第三次</option> -->
											</select>
										</div>
									</div>

									<div>
										<label class="col-sm-1 control-label">考核班级：</label>
										<div class="col-sm-1">
											<select id="teamName" name="teamName"
												class="selectpicker show-tick form-control"
												data-live-search="false" onchange="teamName()">
<!-- 												<option value="0">java1601</option>
												<option value="1">ios1601</option>
												<option value="2">web1601</option> -->
											</select>
										</div>
									</div>

									<div>
										<label class="col-sm-1 control-label">已评价学生：</label>
										<div class="col-sm-1">
											<select id="evaluateUserName" name="evaluateUserName"
												class="selectpicker show-tick form-control"
												data-live-search="false" onchange="evaluateUserName()">
<!-- 												<option value="0">张三</option>
												<option value="1">李四</option>
												<option value="2">王五</option> -->
											</select>
										</div>
									</div>

									<button id="select" type="button" class="btn btn-primary btn-sm">确定</button>

								</div>


								<div id="resultScore" class="row" style="display:none">

									<div class="col-md-3">
										<div class="box box-primary">
											<div class="box-header with-border">
												<h3 class="box-title">关于此人</h3>
											</div>
											<div class="box-body box-profile">
												<button id="myuser-img" type="button"
													class="btn btn-default" data-target="#myModal"
													data-toggle="modal" data-placement="top">
													<img id="studentUserImg"
														class="profile-user-img img-responsive img-circle"
														src="${sessionScope.user.headPhotoUrl}"
														alt="User profile picture">
												</button>
												<h3 id="studentName" class="profile-username text-center">Alexander
													Pierce</h3>
												<p class="text-muted text-center">学生</p>
												<!-- 												<strong><i class="fa fa-book margin-r-5"></i>所属班级</strong>
												<p class="text-muted">java1601</p> -->
												<hr>
												<strong><i class="fa fa-calendar-plus-o margin-r-5"></i>加入时间</strong>
												<p id="studentAddTime" class="text-muted">${sessionScope.user.bulidTime}</p>
												<hr>
											</div>

										</div>
									</div>

									<div class="col-md-5">
										<div id="resultMark" class="row">
<!-- 										
										<div class="col-sm-10">
											<p/>这是第一道题
											<div class="radio">
												<input type="radio" name="radio1" id="radio1"
													value="option1" checked=""> <label for="radio1">
													Small </label>
											</div>
										</div>
										
										<div class="col-sm-10">
											<p/>这是第二道题
											<div class="radio">
												<input type="radio" name="radio2" id="radio1"
													value="option1" checked=""> <label for="radio1">
													Small </label>
											</div>
										</div>
										 -->
										</div>
									</div>

								</div>
							</div>

							<!-- /.tab-pane -->
						</div>
						<!-- /.tab-content -->
					</div>
					<!-- /.nav-tabs-custom -->
				</div>
				<!-- /.col -->
			</div>
			<!-- /.row --> </section>

		</div>
		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<footer class="main-footer"> <!-- Default to the left -->
		<div class="pull-right hidden-xs">
			<b>Version</b> 3.1.0
		</div>
		<strong>Copyright &copy; 2017 <a href="#">Rimiedu</a>.
		</strong> All rights reserved. </footer>
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED JS SCRIPTS -->
	<!-- Latest compiled and minified CSS -->

	<!-- Latest compiled and minified JavaScript -->
	<!-- jQuery 3.1.0 -->
	<script type="text/javascript" src="/js/jquery-3.1.0.js"></script>
	<script type="text/javascript">
		
		window.onload=function(){
			var msg="${msg}";
			if(msg=="" || msg==null){
				
			}else{
				alert(msg);
			}
		}
		var XendTime = "${TeacherResults.xEndTime}";
		var a = XendTime.split(",");
		for(var i=0;i<a.length;i++){
			a[i]=a[i].replace("[","");
			a[i]=a[i].replace("]","");
		}
		var recentlist  = "${TeacherResults.recentlist}".split(",");
		var avragelist = "${TeacherResults.averagelist}".split(",");
		var recent=[];
		var avrage=[];
		for(var i=0;i<recentlist.length;i++){
			recentlist[i]=recentlist[i].replace("[","");
			recentlist[i]=recentlist[i].replace("]","");
			recent.push(recentlist[i]);
		}
		for(var i=0;i<avragelist.length;i++){
			avragelist[i]=avragelist[i].replace("[","");
			avragelist[i]=avragelist[i].replace("]","");
			avrage.push(avragelist[i]);
		}
		var lss=$(".callout");
		for(var i=0;i<lss.length;i++){
			var color = i%4;
			if(color==0){
				lss[i].className="callout callout-info";
			}else if(color==1){
				lss[i].className="callout callout-danger";
			}else if(color==2){
				lss[i].className="callout callout-success";
			}else{
				lss[i].className="callout callout-warning";
			}
			if(i>3){
				$(lss[i]).css("display","none");
			}
		}
		$("#more-content").on("click",function(){
			var hiddendiv = $(".callout:hidden");
			if(hiddendiv[0]==null){
				alert("没有数据了");
			}
			for(var i =0;i<3;i++){
				$(hiddendiv[i]).css("display","block");
			}
		});
		

 		$(window).on('load', function () {
 			$(".selectpicker").selectpicker({noneSelectedText:'请选择'});
 			$('.selectpicker').selectpicker('val', 'name');//单选
/* 		    $('#teacherName').selectpicker({
		        'selectedText': 'cat'
		    }); 
		    $('#teacherName').selectpicker();  */
		}); 
	</script>
	<script type="text/javascript" src="/js/resultscore.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/js/bootstrap-select.min.js"></script>

	<!-- Bootstrap 3.3.6 -->
	<script src="/js/bootstrap.min.js"></script>
	<!-- AdminLTE App -->
	<script src="/js/app.min.js"></script>

	<!-- Scrollslim js -->
	<script src="/js/jquery.slimscroll.min.js"></script>

	<!-- Chart js -->
	<script src="/js/Chart.min.js"></script>
	<script src="/js/teacherchart.js"></script>
</html>