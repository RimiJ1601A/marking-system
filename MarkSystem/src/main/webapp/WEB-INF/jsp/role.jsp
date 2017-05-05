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
	href="/css/font-awesome.min.css">
<link rel="stylesheet"
	href="/css/ionicons.min.css">
<link rel="stylesheet" href="/css/AdminLTE.min.css">
<link rel="stylesheet" href="/css/skin-black.min.css">
<link rel="stylesheet" href="/css/mystyle.css">
<link type="text/css" rel="stylesheet" href="/css/dialog.css">
<link rel="stylesheet" href="/css/zhiweiguanli.css">
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
				职位管理
				<!-- 可以放上次登录时间 -->
				<small>编辑用户职位</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
				<li class="active">职位管理</li>
			</ol>
			</section>
			<br> <br>
			<!-- Main content -->
			<section class="dashboard ">
			<div class="row">
				<div class="col-xs-12">
					<div class="box box-solid box-primary">
						<div class="box-header">
							<h3 class="box-title">职位管理列表</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<div id="example1_wrapper"
								class="dataTables_wrapper form-inline dt-bootstrap">
								<div class="row">
									<!-- 查询职位 -->
									<div id="example1_filter" class="dataTables_filter">
										<div class="col-sm-6">
											<div class="input-group margin">
												<input type="text" class="form-control"
													placeholder="请输入职位名称..." aria-controls="example1"
													id="sousuo"> <span class="input-group-btn">
													<button onclick="sousuo()" type="button"
														class="btn btn-info btn-flat">查询职位
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
														<li><input type="checkbox" checked="checked"
															name="gn" id="glname">&nbsp;职位名称</li>
														<li><input type="checkbox" checked="checked"
															name="gn" id="glgnmc">&nbsp;功能名称</li>
														<li><input type="checkbox" checked="checked"
															name="gn" id="glrq">&nbsp;日期</li>
													</ul>
												</div>
												<c:if test="${fn:contains(functions,'增加用户')}">
												<button type="button" class="btn btn-info " title="添加职位"
													onclick="tjzw()">
													<i class="fa fa-fw fa-plus"></i>
												</button>
												</c:if>
												<button type="button" class="btn btn-info " title="刷新"
													onclick="shuaxin()">
													<i class="fa fa-fw fa-refresh"></i>
												</button>

												<button type="button" class="btn btn-info btn-flat"
													title="导出表格" onclick="exportExel()">
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
													<th class="sorting_asc xsmc" tabindex="0"
														aria-controls="example1" rowspan="1" colspan="1"
														aria-sort="ascending"
														aria-label="Rendering engine: activate to sort column descending"
														style="width: 100px;">职位名称</th>
													<th class="sorting gnmc" tabindex="0"
														aria-controls="example1" rowspan="1" colspan="1"
														aria-label="Browser: activate to sort column ascending"
														style="width: 70px;">功能名称</th>
													<th class="sorting xsrq" tabindex="0"
														aria-controls="example1" rowspan="1" colspan="1"
														aria-label="Platform(s): activate to sort column ascending"
														style="width: 72px;">创建日期</th>
													<th class="sorting" tabindex="0" aria-controls="example1"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending"
														style="width: 46px; text-align: center;">操作</th>
												</tr>
											</thead>
											<tbody>
													<c:set var="list" scope="session" value="${rolePage}"></c:set>
												<c:if test="${fn:length(list)==0}">
													<tr role="row" class="odd">
														<td colspan="4" style="text-align:center"><b>查无此数据</b></td>
													</tr>
												</c:if>
												<c:forEach var="it" items="${rolePage}">
													<tr role="row" class="odd">
														<td class="xsmc">${it.roleName}</td>
														<td class="gnmc"><c:forEach var="fun"
																items="${it.function}">
                                                                    ${fun}
                                                                </c:forEach></td>
														<td class="xsrq">${it.buildTime }</td>
														<td style="vertical-align: middle; text-align: center;">
														<c:if test="${fn:contains(functions,'查看用户')}">
														<span
															class="glyphicon glyphicon-picture btsize-wz"
															aria-hidden="true" title="查看"
															onclick="ck('${it.roleName}','${it.function}','${it.buildTime }')"
															style="color: #00c0ef;"></span> 
															</c:if>
															<c:if test="${fn:contains(functions,'编辑用户')}">
															<span
															class="glyphicon glyphicon-list-alt btsize-wz" id="btbj"
															aria-hidden="true" title="编辑"
															onclick="bj('${it.roleName}')" style="color: #00c0ef;"></span>
															
															</c:if>
															<c:if test="${fn:contains(functions,'删除用户')}">
															<span class="glyphicon glyphicon-trash btsize-wz"
															id="btsc" aria-hidden="true" title="删除"
															onclick="sc(${it.id})" style="color: rgb(212, 106, 64);"></span>
															</c:if>
															</td>
													</tr>
												</c:forEach>
											</tbody>

										</table>
									</div>
								</div>
								<div class="row">
									<div class="col-sm-5">
										<div class="dataTables_info" id="example1_info" role="status"
											aria-live="polite">第${dangqianye}页,共${next}页</div>
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

		<%-- <div class="right_top">

				<div class="input_position zwgl">
					<label class="label-ziti"> 搜索职位:</label>
					<div class="input-group input_wz">
						<input type="text" class="form-control " placeholder="请输入职位名称"
							id="sousuo" aria-describedby="sizing-addon2">
					</div>
				</div>
				<button type="button" class="btn btn-info btn-wz zwgl"
					onclick="sousuo()">查询</button>
			</div>
			<div class="right_bottom">
			<div class="row">
			<div class="col-md-8">
				<button type="button" class="btn btn-info l"
					title="添加职位" onclick="tjzw()">
					<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
				</button>
				<button type="button" class="btn btn-info l" title="刷新"
					onclick="shuaxin()">
					<span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>
				</button>
				<button type="button" class="btn btn-info l"
					title="导出表格">
					<span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>
				</button>
				<button type="button" id="zhbt" class="btn btn-info l"
					title="管理图表" onclick="gltb()">
					<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>&nbsp;<b
						class="caret caret_but"></b>
				</button>
=======
                                                        <td class="xsrq">${it.buildTime }</td>
                                                        <td style="vertical-align: middle;text-align: center;"><span
                                                            class="glyphicon glyphicon-picture btsize-wz"
                                                            aria-hidden="true" title="查看"
                                                            onclick="ck('${it.roleName}','${it.function}','${it.buildTime }')" style="color:#00c0ef;"></span>
                                                            <span class="glyphicon glyphicon-list-alt btsize-wz"
                                                            id="btbj" aria-hidden="true" title="编辑"
                                                            onclick="bj('${it.roleName}')" style="color:#00c0ef;"></span> <span
                                                            class="glyphicon glyphicon-trash btsize-wz" id="btsc"
                                                            aria-hidden="true" title="删除" onclick="sc(${it.id})" style="color: rgb(212, 106, 64);"></span></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                          
                                        </table>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-sm-5">
                                        <div class="dataTables_info" id="example1_info" role="status"
                                            aria-live="polite">第${dangqianye}页,共${next}页</div>
                                    </div>
                                    <div class="col-sm-7">
                                        <div class="dataTables_paginate paging_simple_numbers"
                                            id="example1_paginate">
                                            <ul class="pagination">
                                                <li class="paginate_button previous"
                                                    id="example1_previous"><a onclick="syy()"
                                                    aria-controls="example1" data-dt-idx="0" tabindex="0">上一页</a></li>
                                               <li class="paginate_button " id="qianmian">
                                               <li class="paginate_button active" id="dqy">
                                               <li class="paginate_button " id="fyanniu">
                                               <%-- 
                                                <a 
                                                    aria-controls="example1" data-dt-idx="role?dangqianye=1" tabindex="0">1</a></li>
                                                <li class="paginate_button "><a href="role?dangqianye=2"
                                                    aria-controls="example1" data-dt-idx="2" tabindex="0">2</a></li>
                                                <li class="paginate_button "><a href="role?dangqianye=3"
                                                    aria-controls="example1" data-dt-idx="3" tabindex="0">3</a></li>
                                                <li class="paginate_button "><a href="role?dangqianye=4"
                                                    aria-controls="example1" data-dt-idx="4" tabindex="0">4</a></li>
                                                <li class="paginate_button "><a href="role?dangqianye=5"
                                                    aria-controls="example1" data-dt-idx="5" tabindex="0">5</a></li>
                                                <li class="paginate_button "><a href="role?dangqianye=6"
                                                    aria-controls="example1" data-dt-idx="6" tabindex="0">6</a>
                                                    --%>
		</li>
		<li class="paginate_button next" id="example1_next"><a
			onclick="xyy()" aria-controls="example1" data-dt-idx="7" tabindex="0">下一页</a></li>
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

	<%-- <div class="right_top">

                <div class="input_position zwgl">
                    <label class="label-ziti"> 搜索职位:</label>
                    <div class="input-group input_wz">
                        <input type="text" class="form-control " placeholder="请输入职位名称"
                            id="sousuo" aria-describedby="sizing-addon2">
                    </div>
                </div>
                <button type="button" class="btn btn-info btn-wz zwgl"
                    onclick="sousuo()">查询</button>
            </div>
            <div class="right_bottom">
            <div class="row">
            <div class="col-md-8">
                <button type="button" class="btn btn-info l"
                    title="添加职位" onclick="tjzw()">
                    <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                </button>
                <button type="button" class="btn btn-info l" title="刷新"
                    onclick="shuaxin()">
                    <span class="glyphicon glyphicon-repeat" aria-hidden="true"></span>
                </button>
                <button type="button" class="btn btn-info l"
                    title="导出表格">
                    <span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>
                </button>
                <button type="button" id="zhbt" class="btn btn-info l"
                    title="管理图表" onclick="gltb()">
                    <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>&nbsp;<b
                        class="caret caret_but"></b>
                </button>
>>>>>>> cb92a866177202d2c9b9b4431b2a93a7651fa405
</div>
</div>
<div class="row">
            <div class="col-md-8">
                <div class="table-responsive biao-position zwgl">
                    <table class="table table-bordered biao-daxiao">
                        <tr class="active">

                            <td class="xsmc">职位名称</td>
                            <td class="gnmc">功能名称</td>
                            <td class="xsrq">创建日期</td>
                            <td>操作</td>
                        </tr>
                        <c:forEach var="it" items="${rolePage}">
                            <tr class="active">


                                <td class="xsmc">${it.roleName}</td>
                                <td class="gnmc"><c:forEach var="fun"
                                        items="${it.function}">
                                ${fun}
                            </c:forEach></td>
                                <td class="xsrq">${it.buildTime }</td>
                                <td><span class="glyphicon glyphicon-picture btsize-wz"
                                    aria-hidden="true" title="查看"
                                    onclick="ck('${it.roleName}','${it.function}','${it.buildTime }')"></span>
                                    <span class="glyphicon glyphicon-list-alt btsize-wz" id="btbj"
                                    aria-hidden="true" title="编辑" onclick="bj('${it.roleName}')"></span>
                                    <span class="glyphicon glyphicon-trash btsize-wz" id="btsc"
                                    aria-hidden="true" title="删除" onclick="sc(${it.id})"></span></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
                </div>
                </div>
                <div class="fenyewz zwgl" style="width: 800px;">
                    <label class="bjglfy" id="totalpage">
                        共:yeshu页&nbsp;当前:dangqianye页</label>
                    <nav aria-label="Page navigation">
                    <ul class="pagination">
                        <li><button class="btn btn-info sxybt" onclick="syy()">上一页</button></li>
                        <li><button class="btn btn-info sxybt" onclick="xyy()">下一页</button></li>
                        <li><a href="role?dangqianye=1" aria-label="Previous"
                            title="首页"> <span aria-hidden="true">&laquo;</span>
                        </a></li>
                        <li id="fyanniu"></li>

                        <li><a href="role?dangqianye=${next}" aria-label="Next"
                            title="尾页"> <span aria-hidden="true">&raquo;</span>
                        </a></li>
                    </ul>
                    </nav>
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="1"
                            id="tiaozhuan">
                    </div>
                    <button type="button" class="btn btn-info tzwz" onclick="tz()">跳转</button>
                </div>
                --%>
	<div id="tjzwdialog" title="职位添加" style="display: none;">
		<form action="roleadd" method="get">
			<label class="label-ziti zwtjbq"> 职位名称:</label>
			<div class="input-group zwtjsrk">
				<input type="text" name="zwname" class="form-control"
					placeholder="请输入职位名称" aria-describedby="sizing-addon2" />
			</div>
			<label class="label-ziti zwtjbq"> 选择功能:</label>
			<div class="zwtjsrk">
				<p>
					<input type="checkbox" name="zwgn" value="1">&nbsp;<label>
						查看用户</label> <input type="checkbox" name="zwgn" value="2">&nbsp;<label>
						编辑用户</label> <input type="checkbox" name="zwgn" value="3">&nbsp;<label>
						增加用户</label> <input type="checkbox" name="zwgn" value="4">&nbsp;<label>
						删除用户</label>
				</p>
				<p>
					<input type="checkbox" name="zwgn" value="5">&nbsp;<label>
						创建班级</label> <input type="checkbox" name="zwgn" value="6">&nbsp;<label>
						查看班级</label> <input type="checkbox" name="zwgn" value="7">&nbsp;<label>
						编辑班级</label> <input type="checkbox" name="zwgn" value="8">&nbsp;<label>
						删除班级</label>
				</p>
				<p>
					<input type="checkbox" name="zwgn" value="9">&nbsp;<label>
						增加职位</label> <input type="checkbox" name="zwgn" value="10">&nbsp;<label>
						编辑职位</label> <input type="checkbox" name="zwgn" value="11">&nbsp;<label>
						查看职位</label> <input type="checkbox" name="zwgn" value="12">&nbsp;<label>
						删除职位</label>
				</p>
				<p>
					<input type="checkbox" name="zwgn" value="13">&nbsp;<label>
						创建评分表</label> <input type="checkbox" name="zwgn" value="14">&nbsp;<label>
						评分</label>

				</p>
			</div>
			<input type="submit" class="btn btn-info dhk-btwz" value="确认" />
			<button type="button" class="btn btn-info dhk-btwz"
				onclick="tjquxiao()">取消</button>
		</form>
	</div>
	<div id="ckzwdialog" title="职位查看" style="display: none;">

		<p>
			<label class="label-ziti zwtjbq"> 职位名称:</label><label
				class="label-ziti zwtjbq zwtjbq1" id="zwmc"> 老师</label>
		</p>
		<p>
			<label class="label-ziti zwtjbq"> 功能名称:</label><label
				class="label-ziti zwtjbq zwtjbq1" id="zwgn"> 很多</label>
		</p>
		<p>
			<label class="label-ziti zwtjbq"> 创建日期:</label><label
				class="label-ziti zwtjbq zwtjbq1" id="zwrq"> 2017年</label>
		</p>
		<button type="button" class="btn btn-info dhk-btwz"
			onclick="ckqueren()">确认</button>
		<button type="button" class="btn btn-info dhk-btwz"
			onclick="ckquxiao()">取消</button>
	</div>
	<div id="bjzwdialog" title="职位编辑" style="display: none;">
		<form action="rolemodify" method="get">
			<label class="label-ziti zwtjbq"> 职位名称:</label>
			<div class="input-group zwtjsrk">
				<input type="text" name="zwname" class="form-control" id="zwbjzwmc"
					value="请输入职位名称" aria-describedby="sizing-addon2" readonly="true" />
			</div>
			<label class="label-ziti zwtjbq"> 选择功能:</label>
			<div class="zwtjsrk">
				<p>
					<input type="checkbox" name="zwgn" value="1">&nbsp;<label>
						查看用户</label> <input type="checkbox" name="zwgn" value="2">&nbsp;<label>
						编辑用户</label> <input type="checkbox" name="zwgn" value="3">&nbsp;<label>
						增加用户</label> <input type="checkbox" name="zwgn" value="4">&nbsp;<label>
						删除用户</label>
				</p>
				<p>
					<input type="checkbox" name="zwgn" value="5">&nbsp;<label>
						创建班级</label> <input type="checkbox" name="zwgn" value="6">&nbsp;<label>
						查看班级</label> <input type="checkbox" name="zwgn" value="7">&nbsp;<label>
						编辑班级</label> <input type="checkbox" name="zwgn" value="8">&nbsp;<label>
						删除班级</label>
				</p>
				<p>
					<input type="checkbox" name="zwgn" value="9">&nbsp;<label>
						增加职位</label> <input type="checkbox" name="zwgn" value="10">&nbsp;<label>
						编辑职位</label> <input type="checkbox" name="zwgn" value="11">&nbsp;<label>
						查看职位</label> <input type="checkbox" name="zwgn" value="12">&nbsp;<label>
						删除职位</label>
				</p>
				<p>
					<input type="checkbox" name="zwgn" value="13">&nbsp;<label>
						创建评分表</label> <input type="checkbox" name="zwgn" value="14">&nbsp;<label>
						评分</label>

				</p>
			</div>
			<input type="submit" class="btn btn-info dhk-btwz" value="确认" />
			<button type="button" class="btn btn-info dhk-btwz"
				onclick="bjquxiao()">取消</button>
		</form>
	</div>
	<div id="scdialog" title="职位删除" style="display: none;">
		<h3>是否删除该职位?</h3>

		<button type="button" class="btn btn-info dhk-btwz scbt"
			onclick="scqueren()">确认</button>
		<button type="button" class="btn btn-info dhk-btwz scbt"
			onclick="scquxiao()">取消</button>
		<input type="text" id="cuanId" style="display: none" />
	</div>
	<div id="kongdialog" title="查询" style="display: none;">
		<h3>你搜索的职位不存在,请检查名称输入是否正确</h3>

		<button type="button" class="btn btn-info dhk-btwz scbt"
			onclick="kqueren()">确认</button>
		<button type="button" class="btn btn-info dhk-btwz scbt"
			onclick="kquxiao()">取消</button>
	</div>
	<%--
                <div class="gltbkuang" id="hdk">

                    <p>
                        <input type="checkbox" checked="checked" name="gn" class="glgnwz"
                            id="glname">&nbsp;<label class=" glgnwz"> 职位名称</label>
                    </p>
                    <p>
                        <input type="checkbox" checked="checked" name="gn" class="glgnwz"
                            id="glgnmc">&nbsp;<label class=" glgnwz"> 功能名称</label>
                    </p>
                    <p>
                        <input type="checkbox" checked="checked" name="gn" class="glgnwz"
                            id="glrq">&nbsp;<label class=" glgnwz"> 日期</label>
                    </p>

                </div>

            </div>
        </div> --%>

	<!-- /.content-wrapper -->

	<!-- Main Footer -->
	<footer class="main-footer"> <!-- Default to the left --> <strong>Copyright
		&copy; 2017 <a href="#">Rimiedu</a>.
	</strong> All rights reserved. </footer>
	</div>
	</div>


	<script src="/js/jquery-2.2.3.min.js"></script>
	<script type="text/javascript" src="/js/marke.js"></script>
	<script type="text/javascript" src="/js/buttons.js"></script>
	<script type="text/javascript" src="/js/dialog1.js"></script>
	<script type="text/javascript" src="/js/dialog2.js"></script>
	<script type="text/javascript" src="/js/zwgl.js"></script>
	<script type="text/javascript" src="/js/common.js"></script>
	<script src="/js/bootstrap.min.js"></script>
	<script src="/js/app.min.js"></script>
	<script src="/js/jquery.slimscroll.min.js"></script>
	<script type="text/javascript">
    //分页的总页数,当前页和总的记录数
    var yeshu=${next};
    var dangqianye=${dangqianye};
    var total = ${total};
    //职位查看的ID,名称,功能名称和创建日期
    var zwid;   
    var zwmc;
    var gnmc;
    var cjrq;
    //职位的list
    var kong = "${rolePage}";
    //功能ID
    var gongneng;
    //职位名称
    var roleName;
    //职位ID
    var zwid;
  //搜索框赋值
	if("${selectName}" == ""){
		
	}else{
		$("#sousuo").attr("placeholder","${selectName}");
	}
	// 分页
	var xsys = 6;// 页面显示多少页
	var yuan;
	var dqy = "<a aria-controls='example1' data-dt-idx='1' tabindex='0' href=role?dangqianye="+ dangqianye + "&value=${selectName}>" + dangqianye + "</a>";
	$("#dqy").append(dqy);
	for (var i = 1; i <= yeshu; i++) {
		if (yeshu < xsys) {
			if (i < dangqianye) {
				yuan = "<a aria-controls='example1' data-dt-idx='" + i
						+ "' tabindex='0' href=role?dangqianye=" + i + "&value=${selectName}>" + i
						+ "</a>";
				$("#qianmian").append(yuan);
			}
			if (i > dangqianye) {
				var yuansu = "<a aria-controls='example1' data-dt-idx='" + i
						+ "' tabindex='0' href=role?dangqianye=" + i + "&value=${selectName}>" + i
						+ "</a>";

				$("#fyanniu").append(yuansu);
			}
		} else {
			if (i < dangqianye) {
				yuan = "<a aria-controls='example1' data-dt-idx='" + i
						+ "' tabindex='0' href=role?dangqianye=" + i + "&value=${selectName}>" + i
						+ "</a>";
				if (i <=dangqianye-xsys) {
					yuan = "";
				}
				$("#qianmian").append(yuan);
			}
			if (i > dangqianye) {
				var yuansu = "<a aria-controls='example1' data-dt-idx='" + i
						+ "' tabindex='0' href=role?dangqianye=" + i + "&value=${selectName}>" + i
						+ "</a>";
				if (i > xsys) {
					yuansu = "";
				}
				$("#fyanniu").append(yuansu);

			}
		}
	}
	//上一页
	function syy() {
		dangqianye -= 1;
		if (dangqianye < 1) {
			dangqianye = 1;
		}
		location.href="role?value=${selectName}"+"&dangqianye="+ dangqianye;
	}
	// 下一页
	function xyy() {
		dangqianye += 1;
		if (dangqianye > yeshu) {
			dangqianye = yeshu;
		}
		location.href="role?value=${selectName}"+"&dangqianye="+ dangqianye;
	}
</script>
</html>