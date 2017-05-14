/*function formSubmit(){
	var email = $("#email").val();
	if(email == ""){
		alert("邮箱不能为空");
		return;
	};
	var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
	if(!myreg.test(email)){
		alert("邮箱格式不正确");
	}
	$("#formInfo").submit();
}*/

function passwordverify(){
	
	if($("#newPassword").val() == "" || $("#newPasswordconfirm").val() == "" ||　$("#inputOldpw").val() ==""){
		alert("输入不能为空");
		return false;
	}
	if( $("#newPassword").val() != $("#newPasswordconfirm").val()){
		alert("两次密码输入不一样");
		return false;
	}else{
		return true;
	}

}