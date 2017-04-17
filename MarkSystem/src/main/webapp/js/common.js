/**
 * 
 */
	/**
	$(function(){
		
		//如果查询结果为空
		if(kong == "" || kong == null || kong.length == 0){
			$( "#kongdialog" ).dialog({
				 resizable: false,
				 height: 250,
				 width: 400,
				 modal: true,
				 hide: {
				effect: "explode",
				duration: 1000
				 }
			});
			$( "#kongdialog" ).dialog( "open" );
		}		
	});
	//弹出框确认
	function kqueren(){
		$( "#kongdialog" ).dialog( "close" );
	}
	//弹出框取消
	function kquxiao(){
		$( "#kongdialog" ).dialog( "close" );
	}	
	*/