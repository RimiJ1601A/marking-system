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
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="/css/AdminLTE.min.css">
<!-- AdminLTE Skins. We have chosen the skin-blue for this starter
        page. However, you can choose any other skin. Make sure you
        apply the skin class to the body tag so the changes take effect.
  -->
<link rel="stylesheet" href="/css/skin-black.min.css">
<link rel="stylesheet" href="/css/mystyle.css">

<link type="text/css" rel="stylesheet" href="/css/bootstrap.css">
<link type="text/css" rel="stylesheet" href="/css/bootstrap-theme.css">
<link type="text/css" rel="stylesheet" href="/css/common.css">
<link type="text/css" rel="stylesheet" href="/css/marke.css">
<link type="text/css" rel="stylesheet" href="/css/createTable.css">

<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
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




<script type="text/javascript" src="/js/jquery-3.1.0.js"></script>

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




		<!-- Content Wrapper. Contains page content -->

		<div class="content-wrapper">
			<table class="table table-inverse">
				<thead>
					<tr class="bg-primary" style="background-color: #292b2c;">
						<th>班级</th>
						<th style="display:none;">被评人ID</th>
						<th>被评人</th>
						<th style="display:none;">表ID</th>
						<th>表名</th>
						<th>开始时间</th>
						<th>结束时间</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="List"  items="${eightInfo}">
					<tr class="bg-primary" style="background-color: #292b2c;">
						<td>${List.teamName }</th>
						<td style="display:none;">${List.evalueateId }</th>
						<td>${List.evaluatedName }</th>
						<td style="display:none;">${List.marktableId }</th>
						<td>${List.name }</th>
						<td>${List.startTime }</th>
						<td>${List.endTime }</th>
					</tr>
				</c:forEach>

				</tbody>
			</table>
			<div id="AddQuizType" data-toggle="modal" data-target="#quizType">
				<a
					class="button button-glow button-border button-rounded button-primary">Add
					essay question</a>
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
						<div id="quiztypeBody"class="modal-body">
							<div id="Add_quizType" >输入问题题目</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="button" class="btn btn-primary" onclick="saveEssayQuestion();">添加</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal -->
			</div>
			<div id="button" data-toggle="modal" data-target="#myModal">
				<a
					class="button button-glow button-border button-rounded button-primary">Diy
					your quesition</a>
			</div>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">diy question</h4>
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
													Score:</span><span class="score">90</span></br> </br> <span class="result">B</span><span
													class="font">. Score:</span><span class="score">80</span></br> </br>
												<span class="result">C</span><span class="font">.
													Score:</span><span class="score">70</span></br> </br>
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
								class="bb-custom-icon bb-custom-icon-arrow-left">Prev</a> <a
								id="bb-nav-next" href="#"
								class="bb-custom-icon bb-custom-icon-arrow-right">Next</a> <a
								id="bb-nav-last" href="#"
								class="bb-custom-icon bb-custom-icon-last">New</a> <a
								id="saveQuiz" class="saveQuiz" style="cursor: pointer;">Save</a>
							</nav>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal -->
			</div>
			<div id="List_button" data-toggle="modal" data-target="#myTable">
				<a
					class="button button-glow button-border button-rounded button-primary">Diy
					your Table</a>
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
								placeholder="Quiz Title...."> <input type="text"
								id="date" value="" readonly class="form-control"
								placeholder="Write end Time....">
							<div id="choosequiz" class="btn btn-default" type="button"
								data-toggle="modal" data-target="#quizList">Diy your List</div>
							<div id="addclass" class="btn btn-default" type="button">Add
								Class</div>
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
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭
						</button>
						<button type="button" class="btn btn-primary"
							onclick="closequizmodal();">提交</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
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
	<!-- Bootstrap 3.3.6 -->
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