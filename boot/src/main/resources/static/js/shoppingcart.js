var values;
var ids=[];
var totalMoney=0;
//var exe=getTotalMoney();
$(function(){
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.responseType="json";
	xhr.open("GET","../loadshoppingcart",true);		//然后指定服务器url
	xhr.send(null);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				values=xhr.response.sciList;//sci数组
				if(values.length==0){
					$("#area").html("购物车空空如也~");
				}else{
					for(var i=0;i<values.length;i++){
						var theitem=values[i];
						var good=theitem.item;
						ids.push(good.id);
						$("#"+i+" .title").html(good.title);
						$("#"+i+" .price").html(good.price);
						$("#"+i+" .amount").html(theitem.amount);
						if(theitem.type!="")
							$("#"+i+" .type").html(theitem.type);
						else{
							$("#"+i+" .type").html("无").css("background-color","").unbind();
						}
						$("#"+i+" .goodInfo_area").click(function(){
							window.location.href="http://localhost:8001/bookstore/htmls/bookdetail.html?id="+good.id;
						});
					}
				}
			}else{
				alert("status error");
			}
		}
	};
});
$(".select_button").toggle(function(){
	var tr=$(this).parent().parent().attr("id");
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../selectitem?id="+ids[tr]+"&selected=select",true);		//然后指定服务器url
	xhr.send(null);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				$("#"+tr+" .select_button").addClass("selected");
				//exe(getMoney(values[tr].item.price,values[tr].amount),0);
				totalMoney+=getMoney($("#"+tr+" .price").html(),$("#"+tr+" .amount").html());
				$("#money_area").html(totalMoney);
			}else{
				alert("status error");
			}
		}
	};
},							function(){
	var tr=$(this).parent().parent().attr("id");
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../selectitem?id="+ids[tr]+"&selected=cancel",true);		//然后指定服务器url
	xhr.send(null);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				$("#"+tr+" .select_button").removeClass("selected");
				//exe(0,getMoney(values[tr].item.price,values[tr].amount));
				totalMoney-=getMoney($("#"+tr+" .price").html(),$("#"+tr+" .amount").html());
				$("#money_area").html(totalMoney);
			}else{
				alert("status error");
			}
		}
	};
});
$(".delete_button").click(function(){
	var tr=$(this).parent().parent().attr("id");
	var id=ids[tr];
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../deletefromshoppingcart?id="+ids[tr],true);		//然后指定服务器url
	xhr.send(null);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				deleteGood(tr);
			}else{
				alert("status error");
			}
		}
	};
});
$(".amount").click(function(){
	var tr=$(this).parent().parent().attr("id");
	$("#"+tr+" .incre_amount").show();
	$("#"+tr+" .decre_amount").show();
});
$(".type").click(function(){
	var tr=$(this).parent().parent().attr("id");
	popTypesArea(tr);
});
$(".incre_amount").click(function(){
	var tr=$(this).parent().parent().attr("id");
		var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
		xhr.open("POST","../setitemamount?id="+ids[tr]+"&param=incre",true);		//然后指定服务器url
		xhr.send(null);
		xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
			if(xhr.readyState==4){
				if(xhr.status==200){
					var old=parseInt($("#"+tr+" .amount").html().toString());
					$("#"+tr+" .amount").html(old+1);
					if($("#"+tr+" .select_button").hasClass("selected")){//如果选中状态，要实时更新总价
						totalMoney+=parseFloat($("#"+tr+" .price").html())  ;
						$("#money_area").html(totalMoney);
					}
				}else{
					alert("status error");
				}
			}
		};
});
$(".decre_amount").click(function(){
	var tr=$(this).parent().parent().attr("id");
	var old=parseInt($("#"+tr+" .amount").html().toString());
	if(old>1){
		var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
		xhr.open("POST","../setitemamount?id="+ids[tr]+"&param=decre",true);		//然后指定服务器url
		xhr.send(null);
		xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
			if(xhr.readyState==4){
				if(xhr.status==200){
					$("#"+tr+" .amount").html(old-1);
					if($("#"+tr+" .select_button").hasClass("selected")){//如果选中状态，要实时更新总价
						totalMoney-=parseFloat($("#"+tr+" .price").html())  ;
						$("#money_area").html(totalMoney);
					}
				}else{
					alert("status error");
				}
			}
		};
	}
});

$("#buy_allinshoppingcart_button").click(function(){//购物车已在后端更新过了，传个cashierway直接让后端处理
		var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
		xhr.open("POST","../selectallitem",true);		//然后指定服务器url
		xhr.send(null);
		xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
			if(xhr.readyState==4){
				if(xhr.status==200){
					window.location.href="http://localhost:8001/bookstore/htmls/cashier.html?cashierway=all_of_shoppingCart";
				}else{
					alert("status error");
				}
			}
		};
		window.location.href="http://localhost:8001/bookstore/htmls/cashier.html?cashierway=all_of_shoppingCart";
});
$("#buy_selectedinshoppingcart_button").click(function(){
	if($("#money_area").html()!="0"&&$("#money_area").html()!="")
		window.location.href="http://localhost:8001/bookstore/htmls/cashier.html?cashierway=selected_in_shoppingCart";
});


function popTypesArea(i){
	//不同类型改变价格.price.html()（后端没写！）
	$("#"+i+" .types_area").show();
	var types;
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("GET","../loaditemtypes?id="+ids[i],true);		//然后指定服务器url
	xhr.responseType="json";
	xhr.send(null);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				types=xhr.response.types;//后端null即为null
				if(types!=null){
					for(var k=0;k<types.length;k++){
						$("#"+i+" .types_area").appendChild("<tr id='type"+k+"'>"+types[k]+"</tr>");
						$("#type"+k).click(function(){
							$(this).addClass("selectType");
							$("#"+i+" .types_area").hide();
							var newtype=types[k];
							var xhr1=new XMLHttpRequest();		//首先新建一个xmlhr对象
							xhr1.open("POST","../setitemtype?id="+ids[i]+"&type="+newtype,true);		//然后指定服务器url
							xhr1.send(null);
							xhr1.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
								if(xhr1.readyState==4){
									if(xhr1.status==200){
										$("#"+i+" .type").html(newtype);
									}else{
										alert("status error");
									}
								}
							};
						});
					}
				}else{
					alert("types为null!");
				}
			}else{
				alert("status error");
			}
		}
	};
}
function deleteGood(tr){
	$("#"+tr+" .title").html("");
	$("#"+tr+" .price").html("");
	$("#"+tr+" .type").html("").unbind();
	$("#"+tr+" .amount").html("").unbind();
	$("#"+tr+" .incre_amount").unbind();
	$("#"+tr+" .decre_amount").unbind();
	$("#"+tr).hide();
}
function getMoney(price,amount){//获取该货物的总价
	return parseFloat(price)*parseInt(amount);
}
function moneyChange(tr){//每个货物的实时价格,（只有在选中时更改数量才会调用这个方法）
	if($("#"+tr+" .select_button").hasClass("selected")){
		var price=$("#"+tr+" .price").html();
		var amount=$("#"+tr+" .amount").html();
		return getMoney(price,amount);
	}
	return 0;
}
/*闭包存钱失败
function getTotalMoney(){
	var now=0;
	return function(incre,decre){//有一个必须为0
		if(incre!=0){
			$("#money_area").html(now+incre);
		}else{
			$("#money_area").html(now-decre);
		}
	};
}*/