
$(function(){
	var oldurl=window.location.href;
	var point=oldurl.indexOf("=");
	var id=oldurl.substring(point+1);		//orderform id已经获取
	alert(id);
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../getOrderform",true);	//然后指定服务器url
	xhr.responseType="json";
	xhr.setRequestHeader(
		"Content-Type", "application/json;charset=utf-8");//设置post请求头
	xhr.send(id);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				var orderform=xhr.response;
				alert(JSON.stringify(orderform));
			}else{
				alert("status err");
			}
		}
	};
});