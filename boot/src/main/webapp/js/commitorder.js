var user;
var nowaddressid;
var good;
var postage;
var coupon;
var buyNowGoodInfo="";
var dejson={
	goodId:0,
	goodType:"",
	goodAmount:1
};
var orderjson={
	address:0,
	postage:0,
	shippingInsurance:null,
	coupon:null,
	note:"",
	invoice:0,
	finalMoney:0,
	createTime:null
};

var sciList;

function generateCell(len){
	for(var i=0;i<len;i++){
		$("#goodListArea").append("<tr><td id=\""+i+"\"></td></tr>");
	}
}
 
function getCurrentTime() {
    var date = new Date();//当前时间
    var year = date.getFullYear() //返回指定日期的年份
    var month = repair(date.getMonth() + 1);//月
    var day = repair(date.getDate());//日
    var hour = repair(date.getHours());//时
    var minute = repair(date.getMinutes());//分
    var second = repair(date.getSeconds());//秒
    
    //当前时间 
    var curTime = year + "-" + month + "-" + day
            + " " + hour + ":" + minute + ":" + second;
    return curTime;
}
 
//补0
 
function repair(i){
    if (i >= 0 && i <= 9) {
        return "0" + i;
    } else {
        return i;
    }
}

$(function(){
	var oldurl=window.location.href;
	var point=oldurl.indexOf("=");
	if(point<0){
		//展示购物车item
		var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
		xhr.open("POST","../getBuyNowJsonForPreOrderform",true);		//然后指定服务器url
		xhr.responseType="json";
		xhr.setRequestHeader(
			"Content-Type", "application/json;charset=utf-8");//设置post请求头
		xhr.send(param);
		xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
			if(xhr.readyState==4){
				if(xhr.status==200){
					good=xhr.response;
					
					generateCell(len);
					var totalMoney=0;
					for(var i=0;i<len;i++){
						totalMoney+=goodList[i].price;
						$("#"+i).html(goodList[i].store.storeName+"<br>"
							+goodList[i].title+"<br>"
							+goodList[i].topRef[0]+"<br>"
							+goodList[i].price);
					}
				}else{
					alert("status error");
				}
			}
		};
	}else{
		//展示buynow gooditem
		buyNowGoodInfo=decodeURIComponent(oldurl.substring(point+1));
		//id,amount,type
		var infoarr=buyNowGoodInfo.split(",");
		//构造dejson
		dejson.goodId=infoarr[0];
		dejson.goodAmount=infoarr[1];
		dejson.goodType=infoarr[2];
		//再次获取这个good用于展示
		var param=JSON.stringify(dejson);
		var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
		xhr.open("POST","../getBuyNowJsonForPreOrderform",true);		//然后指定服务器url
		xhr.responseType="json";
		xhr.setRequestHeader(
			"Content-Type", "application/json;charset=utf-8");//设置post请求头
		xhr.send(param);
		xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
			if(xhr.readyState==4){
				if(xhr.status==200){
					coupon=xhr.response.coupon;
					user=xhr.response.user;
					good=xhr.response.good;
					//构造orderjson, enum给后端code即可
					orderjson.coupon=coupon.flag;
					//展示
					for(var i=0;i<user.addresses.length;i++){
						if(user.addresses[i].flag==1){
							nowaddressid=user.addresses[i].id;
							$("#address").html("<b>"+user.addresses[i].address+"</b>");
							break;
						}
					}
					if($("#address").html()==""){
						$(this).html(user.addresses[0].address);
						nowaddressid=user.addresses[0].id;
					}
					
					$("#goodInfo").html(good.store.storeName+
						"<br>"+good.topRef[0]+"   "+
						good.title+"   "+good.price+"<br>"+
						dejson.goodType+"<br>"+
						dejson.goodAmount);
					$("#sipMoney").html(15);
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
							$("#postage").html("邮费："+rs.postage);
							postage=rs.postage;
							//有邮费才能往下算，不然先算undefined，然后AJAX才能收到邮费
							var shippingInsurance=good.shippingInsurance;
							$("#shippingInsurance").html(shippingInsurance.value)
								.click(function(){
									if(shippingInsurance.code==1){
									}else{//这里可能要传给后端计算运费险
										$(this).html(good.price*100/10000);
									}
								});
							$("#coupon").html("减"+coupon.decrement);
							$("#invoice").html("本次订单不开具发票").click(function(){
								
							});
							$("#note").html("无备注").click(function(){
								
							});
							//计算总价
							var totalMoney=0;
							if(shippingInsurance.code==1){
								totalMoney=parseInt(dejson.goodAmount)
									*(parseFloat(good.price))+parseFloat(postage)-coupon.decrement;
								alert(dejson.goodAmount+","+good.price+","+postage+","+coupon.decrement);
								alert("总价："+totalMoney);
							}
							else{
								totalMoney=dejson.goodAmount*(good.price)
								+parseFloat(postage)-coupon.decrement
								+parseInt($("#shippingInsurance").html());
							}
							//显示总价
							$("#goodNumber").html("共计1件宝贝  ");
							$("#totalMoneyArea").html(totalMoney);
							
							
					    },
					    error: function (e) {
					        alert("status error");
					    }
					});
				}else{
					alert("status error");
				}
			}
		};
		
	}
});

$("#address").click(function(){
	$("#addressesArea").show();
	for(var i=0;i<user.addresses.length;i++){
		$("#addressesArea").append("<div id=\"address"+i+"\">"+user.addresses[i].address+"</div>");
		$("#address"+i).click(function(){
			nowaddressid=user.addresses[i].id;
			$("#address").show().html($(this).html());
			$("#addressesArea").hide();
		});
	}
});

$("#commitButton").click(function(){
	if(buyNowGoodInfo!=""){//buynow
		//构造orderjson
		orderjson.postage=postage;
		orderjson.finalMoney=$("#totalMoneyArea").html();
		if($("#invoice").html()=="本次订单不开具发票"){
			orderjson.invoice=0;
		}else{
			orderjson.invoice=1;
		}
		orderjson.address=nowaddressid;
		orderjson.note=$("#note").html();
		orderjson.shippingInsurance=good.shippingInsurance.code;
		orderjson.createTime=getCurrentTime();
		var param="{\"dejson\":"+JSON.stringify(dejson)+",\"orderjson\":"+JSON.stringify(orderjson)+"}";
		alert(param);
		var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
		xhr.open("POST","../newOrderform",true);		//然后指定服务器url
		xhr.setRequestHeader(
			"Content-Type", "application/json;charset=utf-8");//设置post请求头
		xhr.send(param);
		xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
			if(xhr.readyState==4){
				if(xhr.status==200){
					var orderformId=xhr.response;
					alert("提交订单成功！将前往支付^_^");
					//转至cashier
					window.location.href="http://localhost:8001/boot/htmls/cashier1.html?param="+orderformId;
				}else{
					alert("status error");
				}
			}
		};	
	}else{
		//购物车狗毛的
	}
		
	
});