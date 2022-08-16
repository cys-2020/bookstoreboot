var key;
var goodlist;
var storelist;
function generateGoodCell(len){
	for(var i=0;i<len;i+=2){
		$("#allGoodArea").append("<tr><td id=\"good"+i+"\"></td>   <td id=\"good"+(i+1)+"\"></td></tr>");
	}
}

function generateStoreCell(len){
	for(var i=0;i<len;i++){
		$("#allStoreArea").append("<tr><td id=\"store"+i+"\"></td></tr>");
	}
}

$(function(){
	var oldurl=window.location.href;
	var point=oldurl.indexOf("=");
	//解当前url码（可获取中文参数）
	key=decodeURIComponent(oldurl.substring(point+1));
	var param=key;
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../searchGoodInAll",true);		//然后指定服务器url
	xhr.responseType="json";
	xhr.setRequestHeader(
		"Content-Type", "application/json;charset=utf-8");//设置post请求头
	xhr.send(param);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				goodlist=xhr.response;//[{},{}]
				var len=goodlist.length;
				generateGoodCell(len);
				for(var i=0;i<len;i++){
					$("#good"+i).html("<a href=\"http://localhost:8001/boot/htmls/bookdetail.html?param="+goodlist[i].id+"\">"
					+goodlist[i].topRef+"<br>"+goodlist[i].title
					+"<br>"+goodlist[i].price+"<br>"+goodlist[i].store.storeName)
					+"</a>";
				}
			}
			else{
				alert("status error");
			}
		}
	};
});
$("#searchButton").click(function(){
	
});
$("#getAllGood").click(function(){
	$("#allStoreArea").hide();
	$("#allGoodArea").show();
});
$("#getAllStore").click(function(){
	$("#allStoreArea").show();
	$("#allGoodArea").hide();
	var param=key;
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../searchStore",true);		//然后指定服务器url
	xhr.responseType="json";
	xhr.setRequestHeader(
		"Content-Type", "application/json;charset=utf-8");//设置post请求头
	xhr.send(param);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				storelist=xhr.response;
				var len=storelist.length;
				generateStoreCell(len);
				for(var i=0;i<len;i++){
					$("#store"+i).html("<a href=\"http://localhost:8001/boot/htmls/bookdetail.html?param="+storelist[i].id+"\">"
					+storelist[i].storeName+"<br>"
					+storelist[i].lv+"<br>粉丝数"+storelist[i].fans)
					+"</a>";
				}
			}
			else{
				alert("status error");
			}
		}
	};
});
