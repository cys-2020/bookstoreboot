
$(function(){
	var oldurl=window.location.href;
	var point=oldurl.indexOf("=");
	var id=oldurl.substring(point+1);		//targetuser id已经获取
	
	
	
	
});





$("#mixedFormButton").click(function(){
	var formdata=new FormData();
	var files=$("#files")[0].files;
	for(var i=0;i<files.length;i++){
		formdata.append("files",files[i]);
	}
	formdata.append("text",$("#chatText").val());
	//formdata.append("targetUserid",)
	$.ajax({
	    url: "../chat",
	    type: "POST",
	    data: formdata,
	    processData: false,//告诉ajax不要处理和编码这些数据，直接提交
	    contentType: false,//使用默认的内容类型
	    success: function () {
	        alert("🆗");
	    },
	    error: function (e) {
	        alert("status error");
	    }
	});
});

$("#sendButton").click(function(){
	
});
$("#decre_amount").click(function(){
	if(goodAmount>1){
		goodAmount--;
		$("#amount").html(goodAmount);
	}
});
$("#into_cart_button").click(function(){
	hideButton();
	var type_amount=popSelectArea();
	$("#yes").click(function(){
		intoSC(type_amount[0],$("#amount").html());
		hideButtons();
		popButton();
		$(this).unbind();
	});
	$("#no").click(function(){
		hideButtons();
		popButton();
		$("#yes").unbind();//如果不解除绑定，取消后将会绑定多次事件
	});
});
$("#buynow_button").click(function(){//立即购买后，cashier页面需要设置type和amount事件
	hideButton();
	popSelectArea();//获取选择的type和amount传给commitorder,html
	$("#yes").click(function(){
		alert(JSON.stringify(good));
		goodId=good.id;
		goodAmount=$("#amount").html();
		if(goodType==""){
			alert("请选择类型！");
			return;
		}
		//URL传参有大小限制！！！
		var goodItem=goodId+","+goodAmount+","+goodType;
		window.location.href="http://localhost:8001/boot/htmls/commitorder.html?param="+goodItem;
	});
	$("#no").click(function(){
		hideButtons();
		popButton();
		$("#yes").unbind();//如果不解除绑定，取消后将会绑定多次事件
		$(this).unbind();
	});
});
$("#comment_button").click(function(){
	var comment=$("#comment_text").val();
	var param="id="+good+"&comment="+comment;
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../comment?"+param,true);		//然后指定服务器url
	xhr.responseType="json";
	xhr.send(null);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				var resp=xhr.response;
				alert(resp);
				if(resp=="has not paid"){
					alert("你没买过这个宝贝，无法评论");
				}else{
					$("#comments_area").append(resp.username+":<br>"+resp.comment);
				}
			}
			else{
				alert("status error");
			}
		}
	};
});