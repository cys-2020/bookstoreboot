var ok=0;
$("#okPaper").click(function(){
	$(this).html("OK").css("background","green");
	ok=1;
});



$("#commitButton").click(function(){
	if(ok==0){
		alert("你必须同意协议才可以提交申请!");
	}else{
		if(($("#phoneNumberText").val()!="")
			&&($("#idNumberText").val()!="")){
			var parameters="{\"phoneNumber\":"+$("#phoneNumberText").val()
				+",\"idNumber\":\""+$("#idNumberText").val()+"\"}";
			alert(parameters);
			var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
			xhr.open("POST","../registerToSeller",true);		//然后指定服务器url
			xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");//设置请求报文信息
			xhr.send(parameters);
			xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
				if(xhr.readyState==4){
					if(xhr.status==200){
						if(xhr.response=="1"){
							alert("好的，你现在可以开店了😍");
							window.location.href="http://localhost:8001/boot/htmls/index.html";
						}else{
							document.getElementById("phoneNumberText").value="";
							document.getElementById("prompt").innerHTML="手机号有误或者您已经是卖家了！";
						}
					}else
						alert("status error");
				}
			};	
		}
	}
});