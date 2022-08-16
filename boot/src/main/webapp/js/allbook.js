//普通Map遍历
				for(var key in data){
					
					addressesList.push(new address(key,data[key]));
				}
$(function(){		
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.responseType="json";
	xhr.open("GET","../loadallbook",true);		//然后指定服务器url
	xhr.send(null);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				var data=xhr.response;
				//var str=JSON.stringify(xhr.response);		//json对象(或对象数组{key,[]})->json字符串
				//alert(str);
				//var data=JSON.parse(str);			//json字符串->json对象(或对象数组{key,[]})
				var keys=Object.keys(data);
				var values=Object.values(data);			//values数组存放所有good对象
				for(var i=0;i<keys.length;i++){	
									//把相应id传给点击后的页面
					$("#"+(i+1)).html('<a href="http://localhost:8001/bookstore/htmls/bookdetail.html?id='
					+values[i].id+'">'+values[i].title+"<br>"+values[i].price+"<br>"+values[i].saleamount+'</a>');
				}
				
			}
		}
	};
});
