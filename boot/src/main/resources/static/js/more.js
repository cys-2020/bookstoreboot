$(function(){
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../initSellerAndCssInfo",true);		//然后指定服务器url
	xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");//设置post请求头
	xhr.send(null);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				
			}
			else{
				alert("status error");
			}
		}
	};
});