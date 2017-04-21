<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<title>Rimiedu_MSystem | admi</title>
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
 <!-- 处理头像上传的css -->
 <link rel="stylesheet" href="/css/cropper.css">

<link rel="stylesheet" href="/css/mystyle.css">


</head>
<body class="hold-transition skin-black sidebar-mini fixed">

	<div class="wrapper">
		<!-- Main Header -->
		<header class="main-header"> <!-- Logo --> <a href="#"
			class="logo"> <!-- mini logo for sidebar mini 50x50 pixels --> <span
			class="logo-mini"><b>R</b>I<b>m</b>I</span> <!-- logo for regular state and mobile devices -->
			<span class="logo-lg"><img src="/images/Rimilogo.png" alt=""></span>
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
											<img src="/images/user2-160x160.jpg" class="img-circle"
												alt="User Image">
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
						src="/images/user2-160x160.jpg" class="user-image"
						alt="User Image"> <!-- hidden-xs hides the username on small devices so only the image appears. -->
						<span class="hidden-xs">Alexander Pierce</span>
				</a>
					<ul class="dropdown-menu">
						<!-- The user image in the menu -->
						<li class="user-header"><img src="/images/user2-160x160.jpg"
							class="img-circle" alt="User Image">

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
								<a href="#" class="btn btn-default btn-flat">Profile</a>
							</div>
							<div class="pull-right">
								<a href="#" class="btn btn-default btn-flat">Sign out</a>
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
				<img src="/images/user2-160x160.jpg" class="img-circle"
					alt="User Image">
			</div>
			<div class="info">
				<p>User Name</p>
				<!-- Status -->
				<!-- 通过text-xxx来个更改颜色 -->
				<a href="#"><i class="fa fa-circle text-success"></i> User Role</a>
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
			<li><a href="/role"><i class="fa fa-briefcase"></i> <span>职位管理</span></a></li>
			<li class="treeview"><a href="#"><i class="fa fa-user"></i>
					<span>用户管理</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a href="#">人员信息</a></li>
					<li><a href="/team">班级信息</a></li>
				</ul></li>
			<li class="treeview"><a href="#"><i class="fa fa-file-text"></i>
					<span>评分系统</span> <span class="pull-right-container"> <i
						class="fa fa-angle-left pull-right"></i>
				</span> </a>
				<ul class="treeview-menu">
					<li><a href="#">创建评分表</a></li>
					<li><a href="#">考评</a></li>
				</ul></li>
		</ul>
		<!-- /.sidebar-menu --> </section> <!-- /.sidebar --> </aside>


		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
   		<section class="content-header">
                <h1>
        个人简介
      </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i>主页</a></li>
                    <li><a href="#">个人首页</a></li>
                    <li class="active">个人简介</li>
                </ol>
            </section>
            <!-- Main content -->
            <section class="content">
                <div class="row">
                    <div class="col-md-3">
                        <!-- Profile Image -->
                        <div class="box box-primary">
                            <div class="box-header with-border">
                                <h3 class="box-title">关于我</h3>
                            </div>
                            <div class="box-body box-profile">
                                <!-- 更改用户头像 -->
                                <button id="myuser-img" type="button" class="btn btn-default" data-target="#myModal" data-toggle="modal" data-placement="top" title="点击修改头像"><img class="profile-user-img img-responsive img-circle" src="/images/user2-160x160.jpg" alt="User profile picture"></button>

                                <!-- 模态框（Modal） -->
                                <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                    <div class="modal-dialog">
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                                                <h4 class="modal-title" id="myModalLabel">上传图片</h4>
                                            </div>
                                            <div class="modal-body">
                                                <button id="photoBtn" class="btn btn-primary" onclick="document.getElementById('inputImage').click();">选择照片</button>
                                                <input id="inputImage" type="file" accept="image/*" style="opacity: 0;" />
                                                <div class="row">
                                                    <div class="container">
                                                        <img class="img_bg" src="/images/user8-128x128.jpg">
                                                    </div>
                                                    <div id="face_image" class="image-preview preview-lg"></div>
                                                </div>
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                                <button id="image_save" type="button" class="btn btn-primary">
                                                    保存</button>
                                            </div>
                                        </div>
                                        <!-- /.modal-content -->
                                    </div>
                                    <!-- /.modal -->
                                </div>

                                <h3 class="profile-username text-center">Alexander Pierce</h3>
                                <p class="text-muted text-center">Web Developer</p>
                                <strong><i class="fa fa-book margin-r-5"></i> 你的经历</strong>
                                <p class="text-muted">
                                    作为xxx负责过xx项目xx的开发 ，同时参与过xx项目xxx的开发
                                </p>
                                <hr>
                                <strong><i class="fa fa-calendar-plus-o margin-r-5"></i>加入时间</strong>
                                <p class="text-muted">2016-10-01</p>
                                <hr>
                                <strong><i class="fa fa-pencil margin-r-5"></i> 主要技能</strong>
                                <p>
                                    <span class="label label-danger">UI Design</span>
                                    <span class="label label-success">Coding</span>
                                    <span class="label label-info">Javascript</span>
                                    <span class="label label-warning">PHP</span>
                                    <span class="label label-primary">Node.js</span>
                                </p>
                                <hr>
                                <strong><i class="fa fa-file-text-o margin-r-5"></i>座右铭</strong>
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam fermentum enim neque.</p>
                            </div>
                            <!-- /.box-body -->
                        </div>
                        <!-- /.box -->
                    </div>
                    <!-- /.col -->
                    <div class="col-md-9">
                        <div class="nav-tabs-custom">
                            <ul class="nav nav-tabs">
                                <li class="active"><a href="#timeline" data-toggle="tab">教育履历</a></li>
                                <li><a href="#setinfo" data-toggle="tab">修改信息</a></li>
                                <li><a href="#setpassword" data-toggle="tab">修改密码</a></li>
                            </ul>
                            <div class="tab-content">
                                <!-- /.tab-pane -->
                                <div class="tab-pane active" id="timeline">
                                    <!-- The timeline -->
                                    <ul class="timeline timeline-inverse">
                                        <!-- timeline time label -->
                                        <li class="time-label">
                                            <span class="bg-red">
                          10 Oct. 2016
                        </span>
                                        </li>
                                        <!-- /.timeline-label -->
                                        <!-- timeline item -->
                                        <li>
                                            <i class="fa fa-envelope bg-blue"></i>
                                            <div class="timeline-item">
                                                <span class="time"><i class="fa fa-clock-o"></i> 12:05</span>
                                                <h3 class="timeline-header"><a href="#">Java1601</a> 精彩评语</h3>
                                                <div class="timeline-body">
                                                    Etsy doostang zoodles disqus groupon greplin oooj voxy zoodles, weebly ning heekya handango imeem plugg dopplr jibjab, movity jajah plickers sifteo edmodo ifttt zimbra. Babblely odeo kaboodle quora plaxo ideeli hulu weebly balihoo...
                                                </div>
                                                <div class="timeline-footer">
                                                    <a class="btn btn-primary btn-xs">Read more</a>
                                                </div>
                                            </div>
                                        </li>
                                        <!-- END timeline item -->
                                        <li>
                                            <i class="fa fa-camera bg-purple"></i>
                                            <div class="timeline-item">
                                                <span class="time"><i class="fa fa-clock-o"></i> 2 days ago</span>
                                                <h3 class="timeline-header"><a href="#">Java1601</a> 班级留影</h3>
                                                <div class="timeline-body">
                                                    <img src="http://placehold.it/150x100" alt="..." class="margin">
                                                    <img src="http://placehold.it/150x100" alt="..." class="margin">
                                                    <img src="http://placehold.it/150x100" alt="..." class="margin">
                                                    <img src="http://placehold.it/150x100" alt="..." class="margin">
                                                </div>
                                            </div>
                                        </li>
                                        <!-- END timeline item -->
                                        <!-- timeline time label -->
                                        <li class="time-label">
                                            <span class="bg-green">
                          3 Jan. 2014
                        </span>
                                        </li>
                                        <!-- /.timeline-label -->
                                        <!-- timeline item -->
                                        <li>
                                            <i class="fa fa-camera bg-purple"></i>
                                            <div class="timeline-item">
                                                <span class="time"><i class="fa fa-clock-o"></i> 2 days ago</span>
                                                <h3 class="timeline-header"><a href="#">IOS1401</a> 班级留影</h3>
                                                <div class="timeline-body">
                                                    <img src="http://placehold.it/150x100" alt="..." class="margin">
                                                    <img src="http://placehold.it/150x100" alt="..." class="margin">
                                                    <img src="http://placehold.it/150x100" alt="..." class="margin">
                                                    <img src="http://placehold.it/150x100" alt="..." class="margin">
                                                </div>
                                            </div>
                                        </li>
                                        <!-- END timeline item -->
                                        <li>
                                            <i class="fa fa-clock-o bg-gray"></i>
                                        </li>
                                    </ul>
                                </div>
                                <!-- /.tab-pane -->
                                <div class="tab-pane" id="setinfo">
                                    <form action="/updateUser" method="post" class="form-horizontal">
                                    
                                        <div class="form-group">
                                            <label for="inputName" class="col-sm-2 control-label">姓名</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="userName" placeholder="修改你的姓名...">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputAge" class="col-sm-2 control-label">年龄</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" name="age" placeholder="修改你的年龄...">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputSex" class="col-sm-2 control-label">性别</label>
                                            <div class="col-sm-10">
                                              <!--   <input type="text" class="form-control" id="inputSex" placeholder="修改你的性别..."> -->
	                                            <label><input name="sex" type="radio" value="1" />男</label> 
												<label><input name="sex" type="radio" value="2" />女</label>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputExperience" class="col-sm-2 control-label">你的经历</label>
                                            <div class="col-sm-10">
                                                <textarea class="form-control" id="inputExperience" placeholder="修改你的经历..."></textarea>
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputSkills" class="col-sm-2 control-label">主要技能</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="inputSkills" placeholder="修改你的主要技能...">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputMotto" class="col-sm-2 control-label">座右铭</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="inputMotto" placeholder="修改你的座右铭...">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button type="submit" class="btn btn-danger">提交修改</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <!-- /.tab-pane -->


                                 <div class="tab-pane" id="setpassword">
                                    <form class="form-horizontal">
                                        <div class="form-group">
                                            <label for="inputOldpw" class="col-sm-2 control-label">旧密码</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="inputOldpw" placeholder="请输入你的旧密码...">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label for="inputNewpw" class="col-sm-2 control-label">新密码</label>
                                            <div class="col-sm-10">
                                                <input type="text" class="form-control" id="inputNewpw" placeholder="请输入你的新密码...">
                                            </div>
                                        </div>
                                        
                                        <div class="form-group">
                                            <div class="col-sm-offset-2 col-sm-10">
                                                <button type="submit" class="btn btn-danger">确认修改</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <!-- /.tab-pane -->
                            </div>
                            <!-- /.tab-content -->
                        </div>
                        <!-- /.nav-tabs-custom -->
                    </div>
                    <!-- /.col -->
                </div>
                <!-- /.row -->
            </section>
            <!-- /.content -->


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
	<!-- 处理头像上传的js -->
	<script src="/js/cropper.js"></script>
	<script type="text/javascript">
		$image = $('.container > img');
		$('.container > img').cropper({
			zoomable : false,
			preview : '.image-preview',
			autoCropArea : 0.5,
			aspectRatio : 1 / 1,
			viewMode : 1,
			crop : function(e) {
				// 出来裁切后的图片数据.
			},
		});
		var fileName = $(".img_bg")[0].src.split("/")[$(".img_bg")[0].src.split("/").length-1]; //选择上传的文件名
		$('#inputImage').change(function() {
			var file = this.files[0];
			fileName = file.name;
			var reader = new FileReader();
			//reader回调，重新初始裁剪区
			reader.onload = function() {
				// 通过 reader.result 来访问生成的 DataURL
				var url = reader.result;
				//选择图片后重新初始裁剪区
				$image.cropper('reset', true).cropper('replace', url);
			};
			reader.readAsDataURL(file);
		});

		$('#image_save').click(function() {
			var type = $image.attr('src').split(';')[0].split(':')[1]; //获取上传文件后缀，jpeg/png

			$image.cropper('getCroppedCanvas').toBlob(function(blob) {
				var formData = new FormData();
				formData.append("file", blob, fileName);
				$.ajax({
					type : "POST",
					url : '/uploadphoto',
					data : formData,
					contentType : false, //必须
					processData : false, //必须
					dataType : "json",
					success : function(data) {
						alert(data.msg);
						$(".btn-default").click();
					},
					error : function(error) {
						alert(error.msg);
					}
				});
			}, type);
		});

	</script>
</html>