var good;
$(function(){
	var oldurl=window.location.href;
	var point=oldurl.indexOf("=");
	/*解码
	var newurl=decodeURIComponent(oldurl.substring(point+1));
	alert(newurl);
	var good=JSON.parse(newurl);
	*/
	var id=oldurl.substring(point+1);		
	var param=id;
	var xhr=new XMLHttpRequest();		
	xhr.open("POST","../loadGood",true);		
	xhr.responseType="json";
	xhr.setRequestHeader(
		"Content-Type", "application/json;charset=utf-8");//设置post请求头
	xhr.send(param);
	xhr.onreadystatechange=function(){		
		if(xhr.readyState==4){
			if(xhr.status==200){
				good=JSON.parse(xhr.response);
				$("#goodArea").html(good.title);
			}else{
				alert("status error");
			}
		}
	};
});