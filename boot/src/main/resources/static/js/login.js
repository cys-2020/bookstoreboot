function ajax(){
	var parameters="{\"phoneNumber\":"+document.getElementById("username").value+",\"pswd\":\""+document.getElementById("password").value+"\"}";
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../login",true);		//然后指定服务器url
	xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");//设置请求报文信息
	xhr.send(parameters);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				if(xhr.response=="1"){
					window.location.href="http://localhost:8001/htmls/index.html";
				}else{
					document.getElementById("password").value="";
					document.getElementById("prompt").innerHTML="您的密码或账号有误！请重新输入。";
				}
			}else
				alert("status error");
		}
	};
	
}