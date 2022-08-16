$("#register_button").click(function(){
	var username=$("#username").val();
	var email=$("#email").val();
	var password=$("#password").val();
	var password2=$("#password2").val();
	if(username==""||password==""||password2==""){
		$("#prompt_area").html("请完善信息！");
		reset();
		return;
	}
	if(password!=password2){
		$("#difference_area").html("两次密码不一样！");
		reset();
		return;
	}
	var user={
		phoneNumber:username,
		pswd:password,
		eMail:email
	};
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../register1",true);		//然后指定服务器url
	xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");//设置请求报文信息
	xhr.send(JSON.stringify(user));
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				var msg=xhr.response;
				if(msg=="1"){//可注册
					alert("该用户可以注册哦！");
					window.location.href="http://localhost:8001/boot/htmls/register2.html";
				}else{//已注册，不可
					alert("该用户已经注册了哦！");
				}
			}else
				alert("status error");
		}
	};
});
function reset(){
	$("#username").val("")
	$("#password").val("")
	$("#password2").val("")
}
