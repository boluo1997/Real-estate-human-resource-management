$(function() {
	//给验证码图片注册事件
	/*$("#vcode").click(
			function() {
				// $(this).attr("src","/VerifyCodeServlet?"+Math.random());
				$(this).attr("src",
						"user_ajax/verifyCode?" + new Date().toLocaleString());
			});*/
	
	$("input[name=salesmanname]").blur(
			function() {
				var salesmanName = $(this).val();
				if (!formObj.checkNull("salesmanname", "用户名不能为空")) {
					setMsg("salesmanname", "用户名不能为空");
				} else {

					$.ajax({
						url:"http://www.boluo.com/login/check/checkUserName",
						type:"post",
						data:{"salesmanName":salesmanName},
						dataType:"json",
						success:function(result){
							if (result.status!=200) {
								$("#salesmanname_msg").html("用户名已存在");
							} else{
								$("#salesmanname_msg").html("<font color='green'>用户名可用</font>");
							}
						},
						error:function(){
							alert("请求失败！");
						}
					});
				}
			});
	//给注册表单注册submit事件
	$("form").submit(function(){
		return register();
	});
});
function register(){
	var salesmanName=$("form input[name=salesmanname]").val();
	var salesmanPassword=$("form input[name=password]").val();
	var salesmanPassword2=$("form input[name=password2]").val();
	var salemanEmail=$("form input[name=email]").val();
	var salemanPhone=$("form input[name=phone]").val();
	//var vcode=$("form input[name=valistr]").val();
	var flag=formObj.checkForm();
	if(flag){
		$.ajax({
			url:"http://www.boluo.com/login/save",
			type:"post",
			data:{
				  "salesmanName":salesmanName,
				  "salesmanPassword":salesmanPassword,
				  "salesmanEmail":salemanEmail,
				  "salesmanPhone":salemanPhone,
				 },
			dataType:"json",
			success:function(result){
				if(result.status==200){
					alert("注册成功,转向登录页面")
					window.location.href="./index.html";
				}else{
					alert(result.message);
				}
			},
			error:function(){
				alert("请求失败！");
			}
		});
	}
	
	return false;
}
var formObj = {
	checkForm : function() {
		var flag = true;
		// 非空验证
		flag = this.checkNull("salesmanname", "用户名不能为空!");
		flag = this.checkNull("password", "密码不能为空") && flag;
		flag = this.checkNull("password2", "确认密码不能为空") && flag;
		flag = this.checkNull("email", "邮箱不能为空") && flag;
		flag = this.checkNull("phone", "手机号码不能为空") && flag;
		//flag = this.checkNull("valistr", "验证码不能为空") && flag;
		// 两次输入的密码是否相同
		flag = this.checkPassword("password", "两次密码不相同") && flag;
		// 邮箱格式
		flag = this.checkEmail("email", "邮箱格式不正确") && flag;
		// 返回flag
		return flag;
	},
	checkNull : function(name, msg) {
		var value = $("input[name=" + name + "]").val();
		if ($.trim(value) == "") {
			this.setMsg(name, msg);
			return false;
		}
		return true;
	},
	checkPassword : function(name, msg) {
		var pwd = $("input[name=" + name + "]").val();
		var pwd2 = $("input[name=" + name + "2]").val();
		if ($.trim(pwd) != "" && $.trim(pwd2) != "") {
			if (pwd != pwd2) {
				this.setMsg(name, msg);
				return false;
			}
		}
		return true;
	},
	checkEmail : function(name, msg) {
		var value = $("input[name=" + name + "]").val();
		var reg = /^\w+@\w+(\.\w+)+$/;
		if (!reg.test(value)) {
			this.setMsg(name, msg);
			return false;
		}
		return true;
	},
	setMsg : function(name, msg) {
		$("#" + name + "_msg").text(msg);
	}
};