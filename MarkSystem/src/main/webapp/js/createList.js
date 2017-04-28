var acount = 1;
$(document).ready(function(){
		$("#bb-nav-last").click(function(){
		acount++;
		var bbitem = $("<div class='bb-item'></div>");
		var createTable_List = $("<div class='createTable_List'></div>");
		var List_id = $("<span class='List_id'>"+acount+'.'+"</span>");
		var content = $("<div class='content-lxd'>"+'__________点击编辑内容__________'+"</div>");
		var p = $("<p class='Line'></p>");
		var newResult = $("<span class='result'>"+'A'+"</span>");
		var newFont = $("<span class='font'>"+'.    Score:'+"</span>");
		var newScore = $("<span class='score'>"+'90'+"</span></br></br>");
		var newResult1 = $("<span class='result'>"+'B'+"</span>");
		var newFont1 = $("<span class='font'>"+'.    Score:'+"</span>");
		var newScore1 = $("<span class='score'>"+'80'+"</span></br></br>");
		var newResult2 = $("<span class='result'>"+'C'+"</span>");
		var newFont2 = $("<span class='font'>"+'.    Score:'+"</span>");
		var newScore2 = $("<span class='score'>"+'70'+"</span></br></br>");
		var add = $("<div id='add-result'></div>");
		var gly =	$("<span class='glyphicon glyphicon-plus'></span>");
		
		$("#bb-bookblock").append(bbitem);
		$(createTable_List).append(List_id).append(content).append(p).append(newResult).append(newFont).append(newScore).append(newResult1).append(newFont1).append(newScore1).append(newResult2).append(newFont2).append(newScore2);
		$(bbitem).append(createTable_List);
		$(add).append(gly);
		$(bbitem).append(add);
		
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
})