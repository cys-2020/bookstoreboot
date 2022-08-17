
function getMVC(){
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../register2",true);		//然后指定服务器url
	xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");//设置请求报文信息
	xhr.send(null);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				
				$("#getmvc_button").hide();
				alert("验证码已发送！");
			}else
				alert("status error");
		}
	};
}


$("#getmvc_button").click(function(){
	getMVC();
});

$("#register_button").click(function(){
	var param=$("#usermvc").val();
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../register3",true);		//然后指定服务器url
	xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");//设置请求报文信息
	xhr.send(param);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				var resp=xhr.response;
				if(resp=="1"){
					alert("注册成功！将前往登录...");
					window.location.href="http://localhost:8001/htmls/login.html";
				}else{
					alert("手机验证码有误！请重新获取！");
				}
			}else
				alert("status error");
		}
	};
});