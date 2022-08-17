var storeList=[];
var seller;


function flushStoreListArea(){
	$("#storeListArea").html("");
	for(var i=0;i<storeList.length;i++){
		$("#storeListArea").append("<a href=\"store.html?param="+storeList[i].id+"\"><div id=\"store"+i+"\">"+storeList[i].storeName+"</div></a>");
	}
}
$(function(){
	var xhr=new XMLHttpRequest();		
	xhr.open("POST","../loadAllStore",true);		
	xhr.responseType="json";
	xhr.setRequestHeader(
		"Content-Type", "application/json;charset=utf-8");//设置post请求头
	xhr.send(null);
	xhr.onreadystatechange=function(){		
		if(xhr.readyState==4){
			if(xhr.status==200){
				storeList=xhr.response;
				if(storeList==null){
					alert("你还不是卖家，请返回并申请！");
					return;
				}
				flushStoreListArea();
			}else{
				alert("status error");
			}
		}
	};
});

	

$("#yesAddStoreButton").click(function(){
	if(storeList.length>=5){
		alert("你已经开够了五个店铺，不能开了");
		return;
	}
	var willstore={
		storeName:$("#storeNameText").val(),
		classes:$("#classesText").val().split("，")
	};
	var xhr=new XMLHttpRequest();
	xhr.open("POST","../openStore",true);		
	xhr.responseType="json";
	xhr.setRequestHeader(
		"Content-Type", "application/json;charset=utf-8");//设置post请求头
	xhr.send(JSON.stringify(willstore));
	xhr.onreadystatechange=function(){		
		if(xhr.readyState==4){
			if(xhr.status==200){
				var storeGot=xhr.response;
				storeList.push(storeGot);
				var nowlen=storeList.length;
				flushStoreListArea();
				$("#store"+(nowlen-1)).click(function(){
					window.location.href="http://localhost:8001/htmls/commitorder.html?param="+storeList[i].id;
				});
			}else{
				alert("status error");
			}
		}
	};
});
$("#deleteStoreButton").click(function(){
	var removedIndex=[];
	var storeIds=[];
	for(var i=0;i<storeList.length;i++){
		if($("#"+i).hasClass("selected")){//i==>list index
			storeIds.push(storeList[i].id);
			removedIndex.push(i);
		}
	}
	var param=JSON.stringify(storeIds);
	alert(param);
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../removeStores",true);		//然后指定服务器url
	xhr.responseType="json";
	xhr.setRequestHeader(
		"Content-Type", "application/json;charset=utf-8");//设置post请求头
	xhr.send(param);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				//显示删除后的list
				$("#storeListArea").html("");
				for(var i=0;i<removedIndex.length;i++){
					storeList.splice(removedIndex[i],1);
				}
				var len=storeList.length;
				flushStoreListArea();
			}else{
				alert("status error");
			}
		}
	};
});