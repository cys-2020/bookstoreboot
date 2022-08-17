var orderformlist;
var dfkList=[];
var dfhList=[];
var dshList=[];
var dtkList=[];
var yjjList=[];
var ytkList=[];
var ywcList=[];


$(function(){
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.responseType="json";
	xhr.open("POST","../getUserOrderformList",true);	//然后指定服务器url
	xhr.responseType="json";
	xhr.setRequestHeader(
		"Content-Type", "application/json;charset=utf-8");//设置post请求头
	xhr.send(null);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				orderformlist=xhr.response;//[]
				alert(JSON.stringify(orderformlist));
				if(orderformlist.length==0){
					$("table").html("你还没买过东西诶ಠಿ_ಠ");
				}else{
					var status=0;
					for(var i=0;i<orderformlist.length;i++){
						status=orderformlist[i].orderformStatus;
						if(status==0){
							dfkList.push(orderformlist[i]);
						}else if(status==1){
							dfhList.push(orderformlist[i]);
						}else if(status==2){
							dshList.push(orderformlist[i]);
						}else if(status==3){
							ywcList.push(orderformlist[i]);
						}else if(status==-1){
							dtkList.push(orderformlist[i]);
						}else if(status==-2){
							yjjList.push(orderformlist[i]);
						}else{
							ytkList.push(orderformlist[i]);
						}
					}
					if(dfkList.length>0){
						$("#dfk span").addClass("prompt").html(dfkList.length);
					}
					if(dfhList.length>0){
						$("#dfh span").addClass("prompt").html(dfhList.length);
					}
					if(dshList.length>0){
						$("#dsh span").addClass("prompt").html(dshList.length);
					}
					if(dtkList.length>0){
						$("#dtk span").addClass("prompt").html(dtkList.length);
					}
					if(yjjList.length>0){
						$("#yjj span").addClass("prompt").html(yjjList.length);
					}
					if(ytkList.length>0){
						$("#ytk span").addClass("prompt").html(ytkList.length);
					}
					if(ywcList.length>0){
						$("#ywc span").addClass("prompt").html(ywcList.length);
					}
				}
			}else{
				alert("status err");
			}
		}
	};
});

$("#dfk").click(function(){
	$("#showArea").html("");
	for(var i=0;i<dfkList.length;i++){
		var orderformId=dfkList[i].id;
		$("#showArea").append("<div id=\""+orderformId+"\">"+
			dfkList[i].de.topRef[0]+"<br>"+dfkList[i].de.goodTitle
			+"</div>");
		$("#"+orderformId).click(function(){
			window.location.href="http://localhost:8001/dispatcher/htmls/orderform.html?param="+orderformId;
		});
	}
});
$("#dfh").click(function(){
	$("#showArea").html("");
	for(var i=0;i<dfhList.length;i++){
		var orderformId=dfhList[i].id;
		$("#showArea").append("<div id=\""+orderformId+"\">"+
			dfhList[i].de.topRef[0]+"<br>"+dfhList[i].de.goodTitle
			+"</div>");
		$("#"+orderformId).click(function(){
			window.location.href="http://localhost:8001/dispatcher/htmls/orderform.html?param="+orderformId;
		});
	}
});
$("#dsh").click(function(){
	$("#showArea").html("");
	for(var i=0;i<dshList.length;i++){
		var orderformId=dshList[i].id;
		$("#showArea").append("<div id=\""+orderformId+"\">"+
			dshList[i].de.topRef[0]+"<br>"+dshList[i].de.goodTitle
			+"</div>");
		$("#"+orderformId).click(function(){
			window.location.href="http://localhost:8001/dispatcher/htmls/orderform.html?param="+orderformId;
		});
	}
});
$("#dtk").click(function(){
	$("#showArea").html("");
	for(var i=0;i<dtkList.length;i++){
		var orderformId=dtkList[i].id;
		$("#showArea").append("<div id=\""+orderformId+"\">"+
			dtkList[i].de.topRef[0]+"<br>"+dtkList[i].de.goodTitle
			+"</div>");
		$("#"+orderformId).click(function(){
			window.location.href="http://localhost:8001/dispatcher/htmls/orderform.html?param="+orderformId;
		});
	}
});
$("#yjj").click(function(){
	$("#showArea").html("");
	for(var i=0;i<yjjList.length;i++){
		var orderformId=yjjList[i].id;
		$("#showArea").append("<div id=\""+orderformId+"\">"+
			yjjList[i].de.topRef[0]+"<br>"+yjjList[i].de.goodTitle
			+"</div>");
		$("#"+orderformId).click(function(){
			window.location.href="http://localhost:8001/dispatcher/htmls/orderform.html?param="+orderformId;
		});
	}
});
$("#ytk").click(function(){
	$("#showArea").html("");
	for(var i=0;i<ytkList.length;i++){
		var orderformId=ytkList[i].id;
		$("#showArea").append("<div id=\""+orderformId+"\">"+
			ytkList[i].de.topRef[0]+"<br>"+ytkList[i].de.goodTitle
			+"</div>");
		$("#"+orderformId).click(function(){
			window.location.href="http://localhost:8001/dispatcher/htmls/orderform.html?param="+orderformId;
		});
	}
});
$("#ywc").click(function(){
	$("#showArea").html("");
	for(var i=0;i<ywcList.length;i++){
		var orderformId=ywcList[i].id;
		$("#showArea").append("<div id=\""+orderformId+"\">"+
			ywcList[i].de.topRef[0]+"<br>"+ywcList[i].de.goodTitle
			+"</div>");
		$("#"+orderformId).click(function(){
			window.location.href="http://localhost:8001/dispatcher/htmls/orderform.html?param="+orderformId;
		});
	}
});