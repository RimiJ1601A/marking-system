<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>创建评教表|Rimiedu_MSystem</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="/css/font-awesome.min.css">

<link rel="stylesheet" href="/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="/css/AdminLTE.min.css">

<link rel="stylesheet" href="/css/skin-black.min.css">
<link rel="stylesheet" href="/css/mystyle.css">

<link type="text/css" rel="stylesheet" href="/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/css/common.css">
<link type="text/css" rel="stylesheet" href="/css/marke.css">
<link type="text/css" rel="stylesheet" href="/css/createTable.css">
<link rel="stylesheet" type="text/css" href="/css/bookblock.css" />
<!-- custom demo style -->
<link rel="stylesheet" type="text/css" href="/css/demo1.css" />
<link rel="stylesheet" href="/css/jquery-labelauty.css">
<link rel="stylesheet" href="/css/buttons.css">
<link rel="stylesheet" href="/css/datetimepicker.css">
<style>
label {
	width: 550px;
	overflow: hidden;
}

input {
	width: 550px;
	overflow: hidden;
}

input.labelauty+label {
	font: 12px "Microsoft Yahei";
}
</style>




<script type="text/javascript" src="/js/jquery-1.12.4.js"></script>
<script src="/js/html5shiv.js"></script>
<script src="/js/respond.min.js"></script>

<script type="text/javascript" src="/js/marke.js"></script>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="/js/modernizr.custom.js"></script>
<script src="/js/jquerypp.custom.js"></script>
<script src="/js/jquery.bookblock.js"></script>
<script src="/js/bootstrap-min.js"></script>
<script src="/js/modernizr.custom.js"></script>
<script src="/js/addResultAndSocre.js" charset="utf-8"></script>
<script src="/js/ChangeresultAndscore.js" charset="utf-8"></script>
<script src="/js/saveQuiz.js"></script>
<script src="/js/jquery-labelauty.js"></script>
<script src="/js/bootstrap-datetimepicker.min.js"></script>
<script>
	$(document).on("click", "#button a", function() {

		var Page = (function() {
			var config = {
				$bookBlock : $('#bb-bookblock'),
				$navNext : $('#bb-nav-next'),
				$navPrev : $('#bb-nav-prev'),
				$navFirst : $('#bb-nav-first'),
				$navLast : $('#bb-nav-last')
			}, init = function() {
				config.$bookBlock.bookblock({
					speed : 800,
					shadowSides : 0.8,
					shadowFlip : 0.7
				});
				initEvents();
			}, initEvents = function() {

				var $slides = config.$bookBlock.children();

				// add navigation events
				config.$navNext.on('click touchstart', function() {
					config.$bookBlock.bookblock('next');
					return false;
				});

				config.$navPrev.on('click touchstart', function() {
					config.$bookBlock.bookblock('prev');
					return false;
				});

				config.$navFirst.on('click touchstart', function() {
					config.$bookBlock.bookblock('first');
					return false;
				});

				config.$navLast.on('click touchstart', function() {
					config.$bookBlock.bookblock('last');
					return false;
				});

				// add swipe events
				$slides.on({
					'swipeleft' : function(event) {
						config.$bookBlock.bookblock('next');
						return false;
					},
					'swiperight' : function(event) {
						config.$bookBlock.bookblock('prev');
						return false;
					}
				});

				// add keyboard events
				$(document).keydown(function(e) {
					var keyCode = e.keyCode || e.which, arrow = {
						left : 37,
						up : 38,
						right : 39,
						down : 40
					};

					switch (keyCode) {
					case arrow.left:
						config.$bookBlock.bookblock('prev');
						break;
					case arrow.right:
						config.$bookBlock.bookblock('next');
						break;
					}
				});
			};

			return {
				init : init
			};

		})();
		Page.init();
	});
</script>
<script type="text/javascript" src="/js/createList.js" charset="utf-8"></script>
<script src="/js/Addclass.js" charset="utf-8"></script>

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
						<li class="user-header"><img
							src="${sessionScope.user.headPhotoUrl}" class="img-circle"
							alt="User Image">

							<p>
								${sessionScope.user.userName} <small>${sessionScope.roleName}
								</small>
							</p></li>
						<!-- Menu Body -->
						<%-- 
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
						--%>
						<!-- Menu Footer-->
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

		<!-- search form (Optional) --> <%-- 
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
		--%> <!-- /.search form --> <!-- Sidebar Menu -->
		<ul class="sidebar-menu">
			<li class="header">睿峰评教系统</li>
			<!-- Optionally, you can add icons to the links -->
			<li class="treeview"><a href="/index"><i class="fa fa-home"></i>
					<span>个人主页</span></a></li>

			<c:set var="functions" value="${sessionScope.functions}" />
			<c:if test="${fn:contains(functions,'职位')}">
				<li><a href="/role"><i class="fa fa-briefcase"></i> <span>职位管理</span></a></li>
			</c:if>

			<c:if test="${fn:contains(functions,'用户') || fn:contains(functions,'班级')}">
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

				<li class="active"><a href="#"><i class="fa fa-file-text"></i>
						<span>评分系统</span> <span class="pull-right-container"> <i
							class="fa fa-angle-left pull-right"></i>
					</span> </a>
					<ul class="treeview-menu">
						<c:if test="${fn:contains(functions,'创建评分表')}">
							<li class="active"><a href="/markTable">创建评分表</a></li>
						</c:if>
						<c:if test="${fn:contains(functions,'评分评分表')}">
							<li><a href="/mark">考评</a></li>
						</c:if>
						<c:if test="${fn:contains(functions,'查询评分表')}">
							<li><a href="/resultscore">评分考核结果</a></li>
						</c:if>
					</ul></li>
			</c:if>

		</ul>
		<!-- /.sidebar-menu --> </section> <!-- /.sidebar --> </aside>




		<!-- Content Wrapper. Contains page content -->

		<div class="content-wrapper">
			<!-- 			<div class="row">
				<div class="col-sm-4" id="List_button" data-toggle="modal"
					data-target="#myTable" style="text-align: center;">
					<a
						class="button button-glow button-border button-rounded button-primary "
						style="width: 60%;">创建评分表</a>
				</div>
				<div class="col-sm-4" id="button" data-toggle="modal"
					data-target="#myModal" style="text-align: center;">
					<a
						class="button button-glow button-border button-rounded button-primary "
						style="width: 60%;">自定义选择题</a>
				</div>
				<div class="col-sm-4" id="AddQuizType" data-toggle="modal"
					data-target="#quizType" style="text-align: center;">
					<a
						class="button button-glow button-border button-rounded button-primary"
						style="width: 60%;">自定义问答题</a>
				</div>
			</div> -->
			<section class="content-header">
			<h1>
				创建评教表
				<!-- 可以放上次登录时间 -->
				<small>新建用于评教的考评表</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
				<li>评分系统</li>
				<li class="active">创建评分表</li>
			</ol>
			</section>
			<br> <br>
			<section class="dashboard ">
			<div class="col-xs-12">
				<div class="box box-solid box-primary">
					<div class="box-header">
						<h3 class="box-title">考评创建列表</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body">
						<div id="example1_wrapper"
							class="dataTables_wrapper form-inline dt-bootstrap">
							<span>Step 1:创建评教题目</span>
							<div class="row" style="padding: 10px">

								<div class="col-sm-6 " id="button" data-toggle="modal"
									data-target="#myModal">
									<a
										class="button button-glow button-border button-rounded button-primary"
										style="width: 100%;">自定义选择题</a>
								</div>
								<div class="col-sm-6 pull-right" id="AddQuizType"
									data-toggle="modal" data-target="#quizType">
									<a
										class="button button-glow button-border button-rounded button-primary"
										style="width: 100%;">自定义问答题</a>
								</div>

							</div>
							<span>Step 2:创建评教表,选择评教用户</span>
							<div class="row" style="padding: 10px">
								<div class="col-sm-12 push-left" id="List_button"
									data-toggle="modal" data-target="#myTable">
									<a
										class="button button-glow button-border button-rounded button-primary "
										style="width: 100%;">创建评分表</a>
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
													style="width: 50px;">评教班级</th>
												<th class="sorting gnmc" tabindex="0"
													aria-controls="example1" rowspan="1" colspan="1"
													aria-label="Browser: activate to sort column ascending"
													style="width: 50px;">被评用户</th>
												<th class="sorting xsrq" tabindex="0"
													aria-controls="example1" rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 72px;">评教表名</th>
												<th class="sorting xsrq" tabindex="0"
													aria-controls="example1" rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 82px;">开始时间</th>
												<th class="sorting xsrq" tabindex="0"
													aria-controls="example1" rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 82px;">结束时间</th>
											</tr>
										</thead>
										<tbody>
											<c:set var="list" scope="session" value="${eightInfo}"></c:set>
											<c:if test="${fn:length(list) == 0}">
												<tr>
													<td colspan=5 style="text-align: center;"><b>最近没有发布评分表</b></td>
												</tr>
											</c:if>
											<c:forEach var="List" items="${eightInfo}">
												<tr>
													<td>${List.teamName }</td>
													<td style="display: none;">${List.evalueateId }</td>
													<td>${List.evaluatedName }</td>
													<td>${List.name }</td>
													<td>${List.startTime }</td>
													<td>${List.endTime }</td>
													<td style="display: none;">${List.marktableId }</td>
												</tr>
											</c:forEach>
										</tbody>

									</table>
								</div>
							</div>
						</div>
					</div>
				
					<div class="modal fade" id="quizType" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">自定义添加问答题</h4>
								</div>
								<div id="quiztypeBody" class="modal-body">
									<div id="Add_quizType">输入问题题目</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">关闭</button>
									<button type="button" class="btn btn-primary"
										onclick="saveEssayQuestion();">添加</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal -->
					</div>

					<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">自定义问题</h4>
								</div>
								<div class="modal-body">
									<div class="main clearfix">
										<div class="bb-custom-wrapper">
											<div id="bb-bookblock" class="bb-bookblock">
												<div class="bb-item">
													<!--<a href="http://drbl.in/bKVq">123</a>-->
													<div class="createTable_List">
														<span class="List_id">1.</span>
														<div class="content-lxd">________点击编辑内容________</div>
														<p class="Line"></p>
														</br> <span class="result">A</span><span class="font">.
															分数:</span><span class="score">10</span></br> </br> <span class="result">B</span><span
															class="font">. 分数:</span><span class="score">7</span></br> </br> <span
															class="result">C</span><span class="font">. 分数:</span><span
															class="score">4</span></br> </br>
													</div>
													<div id="add-result">
														<span class="glyphicon glyphicon-plus"></span>
													</div>
												</div>

											</div>

										</div>
									</div>
								</div>
								<div class="modal-footer">
									<nav> <a id="bb-nav-prev" href="#"
										class="bb-custom-icon bb-custom-icon-arrow-left">上一页</a> <a
										id="bb-nav-next" href="#"
										class="bb-custom-icon bb-custom-icon-arrow-right">下一页</a> <a
										id="bb-nav-last" href="#"
										class="bb-custom-icon bb-custom-icon-last">新建</a> <a
										id="saveQuiz" class="saveQuiz" style="cursor: pointer;">保存</a>
									</nav>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal -->
					</div>

					<div class="modal fade" id="myTable" tabindex="-1" role="dialog"
						aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal"
										aria-hidden="true">&times;</button>
									<h4 class="modal-title" id="myModalLabel">diy Table</h4>
								</div>
								<div class="modal-body" id="Table-body">
									<input type="text" id="Title" class="form-control"
										placeholder="请输入评分表名字...."> <input type="text"
										id="date" value="" readonly class="form-control"
										placeholder="选择开始和结束时间...">
									<div id="choosequiz" class="btn btn-default" type="button"
										data-toggle="modal" data-target="#quizList">选择需要的题目</div>
									<div id="addclass" class="btn btn-default" type="button">选择班级和被评人</div>
									<div id="c_nameAnds_name"></div>
									<div id="fengeLine"></div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default"
										data-dismiss="modal">关闭</button>
									<button type="button" class="btn btn-primary"
										onclick="submitmarkTable();">提交</button>
								</div>
							</div>
							<!-- /.modal-content -->
						</div>
						<!-- /.modal -->
					</div>
					<!--<select class="classList">
					
				</select>-->
				</div>
				<div class="modal fade" id="quizList" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">diy quizList</h4>
							</div>
							<div class="modal-body" style="overflow: scroll; height: 300px;">
								<div class="quiz_List">
									<!-- js生成-->
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">关闭</button>
								<button type="button" class="btn btn-primary"
									onclick="closequizmodal();">提交</button>
							</div>
						</div>
						<!-- /.modal-content -->
					</div>
					<!-- /.modal -->
			</section>
		</div>
		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<footer class="main-footer"> <!-- Default to the left --> <strong>Copyright
			&copy; 2017 <a href="#">Rimiedu</a>.
		</strong> All rights reserved. </footer>
	</div>
	<script src="/js/app.min.js"></script>

	<script src="/js/jquery.slimscroll.min.js"></script>

</body>

</html>