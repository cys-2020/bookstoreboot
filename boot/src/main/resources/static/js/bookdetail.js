var user;
var good;
var goodId=0;
var goodAmount=1;
var goodType="";
var nowaddressid;
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
				var toprefs=good.topRef;//[ref1,ref2]
				var bottomrefs=good.bottomRef;//[ref1...]
				var imgsparam={
					ts:toprefs,
					bs:bottomrefs
				};
				//get imgs
				$.ajax({
				    url: "../loadGoodResources",
				    type: "POST",
				    data: JSON.stringify(imgsparam),
				    processData: false,//告诉ajax不要处理和编码这些数据，直接提交
				    contentType: false,//使用默认的内容类型
				    success: function (rp) {
						var rs=JSON.parse(rp);
						//用这个拼接byte[]，然后作为src即可显示图片!!!!!!!!!!!!!!!!!
						var url = "data:image/jpeg;base64,";
						//topResources展示
						var tops=rs.topResources;//[bs,bs,bs...]
						for(var i=0;i<tops.length;i++){
							$("#topImgsArea").append("<img id=\"topimg"+i+"\" />");
							document.getElementById("topimg"+i).src = url+ tops[i];
						}
						//bottomResources展示
						var bottoms=rs.bottomResources;
						for(var i=0;i<tops.length;i++){
							$("#bottomImgsArea").append("<img id=\"bottomimg"+i+"\" />");
							document.getElementById("bottomimg"+i).src = url+ bottoms[i];
						}
				    },
				    error: function (e) {
				        alert("status error");
				    }
				});
				//$("#topImgs").html(good.topRef.toString());
				if(good.actFlag!=0){
					$("#actName").html(good.store.saleActivity.activityName);
					$("#actEndTime").html("全店打"+good.store.saleActivity.discount+"折 截止至"+good.store.saleActivity.endTime);
				}
				$("#book_name").html(good.title);
				$("#price").html(good.price);
				$("#goodParam").html(good.goodParam);
				$("#sale_amount").html(good.saleAmount);
				$("#shippingFrom").html(good.shippingFrom+"<b>To </b>");
				for(var i=0;i<user.addresses.length;i++){
					if(user.addresses[i].flag==1){
						$("#address").html(user.addresses[i].address);
						nowaddressid=user.addresses[i].id;
						break;
					}
				}
				if($("#address").html()==""){
					$(this).html(user.addresses[0].address);
					nowaddressid=user.addresses[0].id;
				}
				var postageParam={
					goodid:good.id,
					addresid:nowaddressid
				};
				$.ajax({
				    url: "../loadGoodPostage",
				    type: "POST",
				    data: JSON.stringify(postageParam),
				    processData: false,//告诉ajax不要处理和编码这些数据，直接提交
				    contentType: false,//使用默认的内容类型
				    success: function (rp) {
						var rs=JSON.parse(rp);//{postage}
						$("#postage").html(rs.postage);
				    },
				    error: function (e) {
				        alert("status error");
				    }
				});
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
$("#address").click(function(){
	$("#addressesArea").show();
	for(var i=0;i<user.addresses.length;i++){
		$("#addressesArea").append("<div id=\"address"+i+"\">"+user.addresses[i].address+"</div>");
		$("#address"+i).click(function(){
			$("#address").show().html($(this).html());
			$("#addressesArea").hide();
		});
	}
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
		if(goodType==""){
			alert("请选择类型！");
			return;
		}
		//初始化用户-店铺优惠券
		var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
		xhr.open("POST","../getCoupon",true);		//然后指定服务器url
		xhr.setRequestHeader(
			"Content-Type", "application/json;charset=utf-8");//设置post请求头
		xhr.send(good.storeId);
		xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
			if(xhr.readyState==4){
				if(xhr.status==200){
					goodId=good.id;
					goodAmount=$("#amount").html();
					//URL传参有大小限制！！！
					var goodItem=goodId+","+goodAmount+","+goodType;
					window.location.href="http://localhost:8001/htmls/commitorder.html?param="+goodItem;
				}
				else{
					alert("status error");
				}
			}
		};
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
