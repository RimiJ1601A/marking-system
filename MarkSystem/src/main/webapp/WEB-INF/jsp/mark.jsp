<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>进行评教|Rimiedu_MSystem</title>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="/css/font-awesome.min.css">

<link rel="stylesheet"
	href="/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="/css/AdminLTE.min.css">
<!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect.
  -->
<link rel="stylesheet" href="/css/skin-black.min.css">
<link rel="stylesheet" href="/css/mystyle.css">
<link rel="stylesheet" href="/css/buttons.css">





<script type="text/javascript" src="/js/jquery-1.12.4.js"></script>
<script src="/js/html5shiv.js"></script>         
<script src="/js/respond.min.js"></script>
<script type="text/javascript" src="/js/studentQuizs.js"></script>
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
		<%-- 
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
		--%>
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
<c:if test="${fn:contains(functions,'评分表')}">

			<li class="active"><a href="#"><i class="fa fa-file-text"></i>
					<span>评分系统</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<c:if test="${fn:contains(functions,'创建评分表')}">
						<li><a href="/markTable">创建评分表</a></li>
					</c:if>
					
					<c:if test="${fn:contains(functions,'评分评分表')}">
						<li class="active"><a href="/mark">考评</a></li>
					</c:if>
					<c:if test="${fn:contains(functions,'查询评分表')}">
						<li><a href="/resultscore">评分考核结果</a></li>
					</c:if>	
					
				</ul></li>
					</c:if>	

		</ul>
		<!-- /.sidebar-menu --> </section> <!-- /.sidebar --> </aside>


		
		
		<div class="content-wrapper">
		<section class="content-header">
			<h1>
				进行评教
				<!-- 可以放上次登录时间 -->
				<small>请在此完成评教</small>
			</h1>
			<ol class="breadcrumb">
				<li><a href="/index"><i class="fa fa-dashboard"></i> 主页</a></li>
				<li >评分系统</li>
				<li class="active">评教</li>
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
														style="width: 40px;">评分表ID</th>
														<th class="sorting xsrq" tabindex="0"
														aria-controls="example1" rowspan="1" colspan="1"
														aria-label="Platform(s): activate to sort column ascending"
														style="width: 62px;">评教表名</th>
													<th class="sorting gnmc" tabindex="0"
														aria-controls="example1" rowspan="1" colspan="1"
														aria-label="Browser: activate to sort column ascending"
														style="width: 50px;">开始时间</th>
														<th class="sorting xsrq" tabindex="0"
														aria-controls="example1" rowspan="1" colspan="1"
														aria-label="Platform(s): activate to sort column ascending"
														style="width: 50px;">结束时间</th>
														<th class="sorting xsrq" tabindex="0"
														aria-controls="example1" rowspan="1" colspan="1"
														aria-label="Platform(s): activate to sort column ascending"
														style="width: 40px;">考评班级</th>
														<th class="sorting gnmc" tabindex="0"
														aria-controls="example1" rowspan="1" colspan="1"
														aria-label="Browser: activate to sort column ascending"
														style="width: 20px;display:none;">被评用户ID</th>
														<th class="sorting gnmc" tabindex="0"
														aria-controls="example1" rowspan="1" colspan="1"
														aria-label="Browser: activate to sort column ascending"
														style="width: 40px;">被评用户</th>
													<th class="sorting" tabindex="0" aria-controls="example1"
														rowspan="1" colspan="1"
														aria-label="Engine version: activate to sort column ascending"
														style="width: 46px; text-align: center;">操作</th>
												</tr>
											</thead>
											<tbody>
												<c:set  var="list" scope="session" value="${Listrmtq}"></c:set>
					<c:if test="${fn:length(list) == 0}">
						<tr >
							<td colspan=7 style="text-align:center;"><b>没有对应时间下需要评分的表</b></td>
						</tr>
					</c:if>
					<c:forEach var="Listrmtqs" items="${Listrmtq}">
						<tr >
							<td>${Listrmtqs.marktableId}</td>
							<td>${Listrmtqs.startTime}</td>
							<td>${Listrmtqs.endTime}</td>
							<td>${Listrmtqs.name}</td>
							<td>${Listrmtqs.teamName}</td>
							<td style="display:none;">${Listrmtqs.evalueateId}</td>
							<td>${Listrmtqs.evaluatedName}</td>
							<c:if test="${Listrmtqs.marked}">
							<td style="
    text-align: center;"><div id="goMarkTable_btn" class="btn btn-default"
									style="height: 30px;" data-toggle="modal" data-target="#student_quizs">点击进入答题</div>
							</td>
							</c:if>
							<c:if test="${!Listrmtqs.marked}">
							<td style="text-align:center"><div class="btn btn-default"
									style="height: 30px;">已被您评价过</div>
							</td>
							</c:if>
						</tr>
					</c:forEach>	
											</tbody>

										</table>
									</div>
								</div>
			<%-- <table class="table table-inverse"
				style="width: 80%; position: relative; left: 10%;">
				<thead>
					<tr class="bg-primary" style="background-color: #292b2c;">
						<th>评分表ID</th>
						<th>开始时间</th>
						<th>结束时间</th>
						<th>表名</th>
						<th>班级</th>
						<th style="display:none;">被评分人ID</th>
						<th>被评分人</th>
						<th>#</th>
					</tr>
				</thead>
				<tbody>
				<c:set  var="list" scope="session" value="${Listrmtq}"></c:set>
					<c:if test="${fn:length(list) == 0}">
						<tr class="bg-primary" style="background-color: #292b2c;">
							<td colspan=7 style="text-align:center;"><b>没有对应时间下需要评分的表</b></td>
						</tr>
					</c:if>
					<c:forEach var="Listrmtqs" items="${Listrmtq}">
						<tr class="bg-primary" style="background-color: #292b2c;">
							<td>${Listrmtqs.marktableId}</td>
							<td>${Listrmtqs.startTime}</td>
							<td>${Listrmtqs.endTime}</td>
							<td>${Listrmtqs.name}</td>
							<td>${Listrmtqs.teamName}</td>
							<td style="display:none;">${Listrmtqs.evalueateId}</td>
							<td>${Listrmtqs.evaluatedName}</td>
							<c:if test="${Listrmtqs.marked}">
							<td><div id="goMarkTable_btn" class="btn btn-default"
									style="height: 30px;" data-toggle="modal" data-target="#student_quizs">点击进入答题</div>
							</td>
							</c:if>
							<c:if test="${!Listrmtqs.marked}">
							<td><div class="btn btn-default"
									style="height: 30px;">已被您评价过</div>
							</td>
							</c:if>
						</tr>
					</c:forEach>
					
				</tbody>
			</table> --%>
			<div class="modal fade" id="student_quizs" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">答题板</h4>
						</div>
						<div class="modal-body" style="height: 300px;"></div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="button"  id="prevQuizs" class="btn btn-default">上一题</button>
							<button type="button"  id="nextQuizs" class="btn btn-default">下一题</button>
							<!-- <button type="button"  id="Save_result" class="btn btn-primary">提交</button> -->
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal -->
				</section>
			</div>


		</div>
		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<footer class="main-footer"> <!-- Default to the left --> <strong>Copyright
			&copy; 2017 <a href="#">Rimiedu</a>.
		</strong> All rights reserved. </footer>
	</div>
	<!-- ./wrapper -->

	<!-- REQUIRED JS SCRIPTS -->

	<!-- jQuery 2.2.3 -->
	<script src="/js/jquery-2.2.3.min.js"></script>
	<!-- Bootstrap 3.3.6 -->
	<script src="/js/bootstrap.min.js"></script>
	<!-- AdminLTE App -->
	<script src="/js/app.min.js"></script>

	<!-- Scrollslim js -->
	<script src="/js/jquery.slimscroll.min.js"></script>

	<!-- Chart js -->
	<script src="/js/Chart.min.js"></script>
	<%-- 	<script type="text/javascript">
	 $(function () {
		    /* ChartJS
		     * -------
		     * Here we will create a few charts using ChartJS
		     */

		    //--------------
		    //- AREA CHART -
		    //--------------

		    // Get context with jQuery - using jQuery's .get() method.
		    var salesChartCanvas = $("#salesChart").get(0).getContext("2d");
		    // This will get the first returned node in the jQuery collection.
		    var salesChart = new Chart(salesChartCanvas);

		    var salesChartData = {
		      labels: ["January", "February", "March", "April", "May", "June", "July"],
		      datasets: [
		        {
		          label: "Electronics",
		          fillColor: "rgba(210, 214, 222, 1)",
		          strokeColor: "rgba(210, 214, 222, 1)",
		          pointColor: "rgba(210, 214, 222, 1)",
		          pointStrokeColor: "#c1c7d1",
		          pointHighlightFill: "#fff",
		          pointHighlightStroke: "rgba(220,220,220,1)",
		          data: [65, 59, 80, 81, 56, 55, 40]
		        },
		        {
		          label: "Digital Goods",
		          fillColor: "rgba(60,141,188,0.9)",
		          strokeColor: "rgba(60,141,188,0.8)",
		          pointColor: "#3b8bba",
		          pointStrokeColor: "rgba(60,141,188,1)",
		          pointHighlightFill: "#fff",
		          pointHighlightStroke: "rgba(60,141,188,1)",
		          data: [28, 48, 40, 19, 86, 27, 90]
		        }
		      ]
		    };

		    var salesChartOptions = {
		      //Boolean - If we should show the scale at all
		      showScale: true,
		      //Boolean - Whether grid lines are shown across the chart
		      scaleShowGridLines: false,
		      //String - Colour of the grid lines
		      scaleGridLineColor: "rgba(0,0,0,.05)",
		      //Number - Width of the grid lines
		      scaleGridLineWidth: 1,
		      //Boolean - Whether to show horizontal lines (except X axis)
		      scaleShowHorizontalLines: true,
		      //Boolean - Whether to show vertical lines (except Y axis)
		      scaleShowVerticalLines: true,
		      //Boolean - Whether the line is curved between points
		      bezierCurve: true,
		      //Number - Tension of the bezier curve between points
		      bezierCurveTension: 0.3,
		      //Boolean - Whether to show a dot for each point
		      pointDot: false,
		      //Number - Radius of each point dot in pixels
		      pointDotRadius: 4,
		      //Number - Pixel width of point dot stroke
		      pointDotStrokeWidth: 1,
		      //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
		      pointHitDetectionRadius: 20,
		      //Boolean - Whether to show a stroke for datasets
		      datasetStroke: true,
		      //Number - Pixel width of dataset stroke
		      datasetStrokeWidth: 2,
		      //Boolean - Whether to fill the dataset with a color
		      datasetFill: true,
		      //String - A legend template
		      legendTemplate: "<ul class=\"<%=name.toLowerCase()%>-legend\"><% for (var i=0; i<datasets.length; i++){%><li><span style=\"background-color:<%=datasets[i].lineColor%>\"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>",
		      //Boolean - whether to maintain the starting aspect ratio or not when responsive, if set to false, will take up entire container
		      maintainAspectRatio: true,
		      //Boolean - whether to make the chart responsive to window resizing
		      responsive: true
		    };

		    //Create the line chart
		    salesChart.Line(salesChartData, salesChartOptions);

		  
		  });
	</script>
	<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. Slimscroll is required when using the
     fixed layout. -->

</body>

 --%>
</html>