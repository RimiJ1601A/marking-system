<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<link rel="stylesheet" href="/css/AdminLTE.min.css">
<link rel="stylesheet" href="/css/skin-black.min.css">
<link rel="stylesheet" href="/css/mystyle.css">

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

				<!--  应该将control替换为登入登出 -->
				<!-- Control Sidebar Toggle Button -->
				<!-- <li>
            <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
          </li> -->
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

			<li class="treeview"><a href="#"><i class="fa fa-file-text"></i>
					<span>评分系统</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<c:if test="${fn:contains(functions,'创建评分表')}">
						<li><a href="/markTable">创建评分表</a></li>
					</c:if>
					<li><a href="#">考评</a></li>
				</ul></li>

		</ul>
		<!-- /.sidebar-menu --> </section> <!-- /.sidebar --> </aside>


		<div class="content-wrapper">

			<section class="content-header">
			<h1>
				人员管理
				<!-- 可以放上次登录时间 -->
				<small>编辑用户人员</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
				<li class="active">人员管理</li>
			</ol>
			</section>
			<br> <br>
			<!-- Main content -->
			<section class="dashboard ">
			<div class="row">
				<div class="col-xs-12">
					<div class="box box-solid box-primary">
						<div class="box-header">
							<h3 class="box-title">人员管理列表</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<div id="example1_wrapper"
								class="dataTables_wrapper form-inline dt-bootstrap">
								<div class="row">
									<!-- 查询人员 -->
									<div id="example1_filter" class="dataTables_filter">
										<div class="col-sm-6">
											<div class="input-group margin">
												<input type="text" class="form-control"
													placeholder="请输入人员名称..." aria-controls="example1"
													id="sousuo"> <span class="input-group-btn">
													<button onclick="sousuo()" type="button"
														class="btn btn-info btn-flat">查询人员
												</span>
												</button>
												</span>
											</div>
										</div>
										<!-- 表单功能按钮：增加、刷新、下载、查看选项 -->
										<div class="col-sm-6"
											style="text-align: right; padding-top: 10px">
											<div class="btn-group">
												<div class="btn-group">
													<button type="button"
														class="btn btn-info btn-flat dropdown-toggle"
														data-toggle="dropdown" aria-expanded="false" title="管理图表">
														<i class="fa fa-fw fa-list-ul"></i>
													</button>
													<ul class="dropdown-menu ">
														<li><a href="#">Dropdown link</a></li>
														<li><a href="#">Dropdown link</a></li>
													</ul>
												</div>
												<button type="button" class="btn btn-info " title="添加人员"
													onclick="tjzw()">
													<i class="fa fa-fw fa-plus"></i>
												</button>
												<button type="button" class="btn btn-info " title="刷新"
													onclick="shuaxin()">
													<i class="fa fa-fw fa-refresh"></i>
												</button>

												<button type="button" class="btn btn-info btn-flat"
													title="导出表格">
													<i class="fa fa-fw fa-download"></i>
												</button>


											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-12">
										<table id="example1"
											class="table table-bordered table-striped dataTable"
											role="grid" aria-describedby="example1_info">
											<thead>
												<tr role="row">
													<th class="sorting_asc" tabindex="0"
														aria-controls="example1" rowspan="1" colspan="1"
														aria-sort="ascending"
														aria-label="Rendering engine: activate to sort column descending"
														style="width: 100px;">人员名称</th>
													<th class="sorting" tabindex="0" aria-controls="example1"
														rowspan="1" colspan="1"
														aria-label="Browser: activate to sort column ascending"
														style="width: 70px;">年龄</th>
													<th class="sorting" tabindex="0" aria-controls="example1"
														rowspan="1" colspan="1"
														aria-label="Browser: activate to sort column ascending"
														style="width: 70px;">性别</th>
													<th class="sorting" tabindex="0" aria-controls="example1"
														rowspan="1" colspan="1"
														aria-label="Browser: activate to sort column ascending"
														style="width: 70px;">职位</th>
													<th class="sorting" tabindex="0" aria-controls="example1"
														rowspan="1" colspan="1"
														aria-label="Platform(s): activate to sort column ascending"
														style="width: 72px;">创建日期</th>
													<th class="sorting" tabindex="0" aria-controls="example1"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending"
														style="width: 46px; text-align: center;">操作</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="it" items="${userlist}">
													<tr role="row" class="odd">
														<td class="sorting_1">${it.userName}</td>
														<td>${it.age}</td>
														<td>${it.sex.sex}</td>
														<td>${it.roleName}</td>
														<td>${it.bulidTime}</td>
														<td style="vertical-align: middle; text-align: center;"><span
															class="glyphicon glyphicon-picture btsize-wz"
															aria-hidden="true" title="查看" onclick=""
															style="color: #00c0ef;"></span> <span
															class="glyphicon glyphicon-list-alt btsize-wz" id="btbj"
															aria-hidden="true" title="编辑" onclick=""
															style="color: #00c0ef;"></span> <span
															class="glyphicon glyphicon-trash btsize-wz" id="btsc"
															aria-hidden="true" title="删除" onclick=""
															style="color: rgb(212, 106, 64);"></span></td>
													</tr>
												</c:forEach>

											</tbody>
											<tfoot>
												<tr>
													<th rowspan="1" colspan="1">人员名称</th>
													<th rowspan="1" colspan="1">年龄</th>
													<th rowspan="1" colspan="1">性别</th>
													<th rowspan="1" colspan="1">职位</th>
													<th rowspan="1" colspan="1">创建时间</th>
													<th rowspan="1" colspan="1" style="text-align: center;">操作</th>
												</tr>
											</tfoot>
										</table>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-5">
										<div class="dataTables_info" id="example1_info" role="status"
											aria-live="polite">第${dangqianye}页,共${totalPage}页</div>
									</div>
									<div class="col-sm-7">
										<div class="dataTables_paginate paging_simple_numbers"
											id="example1_paginate">
											<ul class="pagination">
												<li class="paginate_button previous" id="example1_previous"><a
													onclick="syy()" aria-controls="example1" data-dt-idx="0"
													tabindex="0">上一页</a></li>
												<li class="paginate_button " id="qianmian">
												<li class="paginate_button active" id="dqy">
												<li class="paginate_button " id="fyanniu"></li>
												<li class="paginate_button next" id="example1_next"><a
													onclick="xyy()" aria-controls="example1" data-dt-idx="7"
													tabindex="0">下一页</a></li>
											</ul>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- /.box-body -->
					</div>
				</div>
			</div>
			</section>

		</div>

		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<footer class="main-footer"> <!-- Default to the left --> <strong>Copyright
			&copy; 2017 <a href="#">Rimiedu</a>.
		</strong> All rights reserved. </footer>
	</div>
	</div>


	<script src="/js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript">
		//分页的总页数,当前页和总的记录数
		var yeshu = $
		{
			totalPage
		};
		var dangqianye = $
		{
			dangqianye
		};
	</script>
	<script type="text/javascript" src="/js/marke.js"></script>
	<script type="text/javascript" src="/js/buttons.js"></script>
	<script type="text/javascript" src="/js/user.js"></script>
	<!-- 	<script type="text/javascript" src="/js/dialog1.js"></script>
	<script type="text/javascript" src="/js/dialog2.js"></script>
	<script type="text/javascript" src="/js/zwgl.js"></script>
	<script type="text/javascript" src="/js/common.js"></script> -->
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/app.min.js"></script>
	<script src="/js/jquery.slimscroll.min.js"></script>
</html>