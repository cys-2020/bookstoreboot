function generateGoodCell(len){
	for(var i=0;i<len;i+=2){
		$("#allGoodArea").append("<tr><td id=\""+i+"\"></td>   <td id=\""+(i+1)+"\"></td></tr>");
	}
}
$(function(){
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../initIndex",true);		//然后指定服务器url
	xhr.setRequestHeader("Content-Type", "application/json;charset=utf-8");//设置post请求头
	xhr.send(null);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				
			}
			else{
				alert("status error");
			}
		}
	};
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../loadAllGood",true);		//然后指定服务器url
	xhr.responseType="json";
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");//设置post请求头
	xhr.send(null);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				var goodlist=xhr.response;
				var len=goodlist.length;
				generateGoodCell(len);
				for(var i=0;i<len;i++){
					$("#"+i).html(goodlist[i].topRef+"<br>"+goodlist[i].title
					+"<br>"+goodlist[i].price+"<br>"+goodlist[i].store.storeName);
				}
			}
			else{
				alert("status error");
			}
		}
	};
});
$("#searchButton").click(function(){
	window.location.href=
	"http://localhost:8001/boot/htmls/search.html?param="+$("#searchText").val();
});