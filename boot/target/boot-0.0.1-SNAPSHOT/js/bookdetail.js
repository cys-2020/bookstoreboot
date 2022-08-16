var user;
var good;
var goodId=0;
var goodAmount=1;
var goodType="";
	
function popSelectArea(){
	popButtons();
	var typsLen=good.typs.length;
	if(typsLen>0){
		for(var i=0;i<typsLen;i++){
			$("#typsArea").append("<tr id=\"typ"+i+"\"></tr>");
			$("#typ"+i).html(good.typs[i]).click(function(){
				//good.typs[i]获取不到值，奇怪。最好用当前html()获取
				goodType=$(this).html();
				$(this).addClass("selectedType");
				$(this).siblings().removeClass("selectedType");
			});
		}
	}else{
		
	}
}
function intoSC(type,amount){
	var parameters="id="+good.id+"&type="+type+"&amount="+amount;
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../intoshoppingcart",true);
	xhr.setRequestHeader("Content-Type","application/json;charset=utf-8");
	xhr.send(parameters);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				if(xhr.response=="ok"){
					alert("已加入购物车");
				}
			}else{
				alert("status error");
			}
		}
	};
}
function popButtons(){
	$("#incre_amount").show();
	$("#decre_amount").show();
	$("#yes").show();
	$("#no").show();
	$("#amount").show();
}
function hideButtons(){
	$("#incre_amount").hide();
	$("#decre_amount").hide();
	$("#yes").hide();
	$("#no").hide();
	$("#amount").html("1");
	$("#amount").hide();
}
function popButton(){
	$("#into_cart_button").show();
	$("#buynow_button").show();
}
function hideButton(){
	$("#into_cart_button").hide();
	$("#buynow_button").hide();
}


$(function(){
	var oldurl=window.location.href;
	var point=oldurl.indexOf("=");
	/*解码
	var newurl=decodeURIComponent(oldurl.substring(point+1));
	alert(newurl);
	var good=JSON.parse(newurl);
	*/
	var id=oldurl.substring(point+1);		//货物id已经获取
	var param=id;
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../loadGood",true);		//然后指定服务器url
	xhr.responseType="json";
	xhr.setRequestHeader(
		"Content-Type", "application/json;charset=utf-8");//设置post请求头
	xhr.send(param);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				user=xhr.response.user;
				good=xhr.response.good;
				$("#topImgs").html(good.topRef.toString());
				if(good.actFlag!=0){
					$("#actEndTime").html("活动截止至 "+good.endTime);
					$("#actName").html(good.store.saleActivity);
				}
				$("#book_name").html(good.title);
				$("#price").html(good.price);
				$("#goodParam").html(good.goodParam);
				$("#sale_amount").html(good.saleAmount);
				$("#shippingFrom").html(good.shippingFrom);
				$("#address").html("<b>To </b>"+user.addresses[0]);
				$("#postage").html(good.postage);
				$("#sendTime").html(good.sendTime);
				$("#shippingInsurance").html(good.shippingInsurance);
				$("#store").html(good.store.storeName+"<br>"
					+good.store.goodScore+"<br>"
					+good.store.serviceScore+"<br>"
					+good.store.shippingScore);
			}else{
				alert("status error");
			}
		}
	};
});
$("#incre_amount").click(function(){
	$("#amount").html(++goodAmount);
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
