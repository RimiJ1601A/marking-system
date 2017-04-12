<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/bootstrap.css" />
<link rel="stylesheet" href="/css/cropper.css" />
<link rel="stylesheet" href="/css/headphoto.css" />
</head>
<body>

	<button class="btn btn-primary btn-lg" data-toggle="modal"
		data-target="#myModal">开始演示模态框</button>

	
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">上传图片</h4>
				</div>
				<div class="modal-body">
					<button id="photoBtn" class="btn btn-primary"
						onclick="document.getElementById('inputImage').click();">选择照片</button>
					<input id="inputImage" type="file" accept="image/*"
						style="opacity: 0;" />

					<div class="row">
						<div class="container">
							<img class="img_bg" src="./images/headphoto.png">
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
	<script type="text/javascript" src="/js/jquery-3.1.0.js"></script>
	<script type="text/javascript" src="/js/bootstrap.js"></script>
	<script type="text/javascript" src="/js/cropper.js"></script>
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
</body>
</html>