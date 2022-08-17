
$(function(){
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../getTargetsAndLatestMessageStoreToUser",true);		//然后指定服务器url
	xhr.responseType="json";
	xhr.send(null);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				var data=xhr.response;//{targetStoreNames:[],crs:[]}
				var targetStoreNames=data.targetStoreNames;//[]
				var crs=data.crs;//[]
				var len=targetStoreNames.length;
				var str="";
				for(var i=0;i<len;i++){
					var textmap=crs[i].chatText,
						refsMap=crs[i].chatRefs;
					if(textmap==undefined && refsMap==undefined){
						break;
					}
					for(var j=0;j<10;j++){
						var text=textmap[j];
						var ref=refsMap[j];
						if(text==undefined&&ref==undefined){
							break;
						}
						if(text!=undefined){
							str+=text;
						}else{
							str+="[图片]";
						}
					}
					$("#allMessageArea").append("<tr id=\""+i+"\"></tr>");
					if(crs[i].readFlag==0){
						$("#"+i).html(targetStoreNames[i]+"<br>"
						+str+crs[i].chatTime+"<b>未读</b><br>=====================================================");
					}else{
						$("#"+i).html(targetStoreNames[i]+"<br>"
						+str+crs[i].chatTime);
					}
				}
			}else{
				alert("status error");
			}
		}
	};
});