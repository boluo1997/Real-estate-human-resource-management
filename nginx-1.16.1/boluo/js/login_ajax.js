
function loginbutton(){
	console.log(1231)
	//获取页面数据
	var salesmanName=$("div input[name=username]").val();
	var salesmanPassword=$("div input[name=password]").val(); 
	if(salesmanName==""){ 
		$("div table tr:eq(0) td span").html("用户名不能为空");
		return false;
	}
	if(salesmanPassword==""){ 
		$("div table tr:eq(1) td span").html("密码不能为空");
		return false;
	} 

	$.ajax({
		url:"http://www.boluo.com/login/login",
		type:"get",
		data:{"salesmanName":salesmanName,"salesmanPassword":salesmanPassword},
		dataType:"json",
		success:function(result){
			console.log("成功")
			console.log(result)
			console.log(typeof result)
			console.log(result.status)
			//result是服务端返回的数据
			if(result.status==200){
				//window.location.href="index.html";
				console.log("成功")
				window.location.href="index1.html";
			}else{
				alert("登录失败");
			}
		},
		error:function(result){
			console.log("失败")
			alert("请求失败!");
			if(result.status==200){
				//window.location.href="index.html";
				console.log()
				window.location.href="index1.html";
			}else{
				alert("登录失败");
			}
		}
	});
	 
}
