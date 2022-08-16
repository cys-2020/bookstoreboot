var store;

$(function(){
	var oldurl=window.location.href;
	var point=oldurl.indexOf("=");
	/*解码
	var newurl=decodeURIComponent(oldurl.substring(point+1));
	alert(newurl);
	var good=JSON.parse(newurl);
	*/
	var id=oldurl.substring(point+1);		
	var param="storeId="+id;
	var xhr=new XMLHttpRequest();		
	xhr.open("POST","../loadStoreAndAllGood",true);		
	xhr.responseType="json";
	xhr.setRequestHeader(
		"Content-Type", "application/x-www-form-urlencoded;charset=utf-8");//设置post请求头
	xhr.send(param);
	xhr.onreadystatechange=function(){		
		if(xhr.readyState==4){
			if(xhr.status==200){
				store=JSON.parse(xhr.response);
				for(var i=0;i<store.goods.length;i++){
					$("#goodsArea").append("<a href=\"goodManager.html?param="+store.goods[i].id+"\">"+store.goods[i].title+"</a><br>");
				}
			}else{
				alert("status error");
			}
		}
	};
});
$("#addGoodButton").click(function(){
	$("#addGoodArea").show();
	$("#yesAddGoodButton").show();
});
$("#yesAddGoodButton").click(function(){
	var refsarr=[];
	var toprefs,bottomrefs;
	var formdata=new FormData();
	var topRefsFiles=$("#topRefsFiles")[0].files;
	for(var i=0;i<topRefsFiles.length;i++){
		formdata.append("topRefsFiles",topRefsFiles[i]);
	}
	var bottomRefsFiles=$("#bottomRefsFiles")[0].files;
	for(var i=0;i<bottomRefsFiles.length;i++){
		formdata.append("bottomRefsFiles",bottomRefsFiles[i]);
	}
	$.ajax({
	    url: "../getGoodResourceRefs",
	    type: "POST",
		dataType:"json",
	    data: formdata,
	    processData: false,//告诉ajax不要处理和编码这些数据，直接提交
	    contentType: false,//使用默认的内容类型
	    success: function (tworefs) {
	        alert("🆗得到了两组refs");
			for(var key in tworefs){
				refsarr.push(tworefs[key]);
			}
			toprefs=refsarr[0];
			bottomrefs=refsarr[1];
			alert(toprefs);alert(bottomrefs);
			var goodParam={
				pName:$("#pNameText").val(),
				srcPlace:$("#srcPlaceText").val(),
				comName:$("#comNameText").val(),
				shelfLife:$("#shelfLifeText").val(),
				pId:$("#pIdText").val(),
				pStandard:$("#pStandardText").val(),
				material:$("#materialText").val(),
				size:$("#sizeText").val(),
				surface:$("#surfaceText").val()
			};
			var gpalarr=$("#postageAndLvText").val().split("，");
			var goodPAL={
				lv1:gpalarr[0],
				lv2:gpalarr[1],
				lv3:gpalarr[2]
			};
			var addedGood={
				storeId:store.id,
				title:$("#titleText").val(),
				price:$("#priceText").val(),
				shippingCompany:$("#shippingCompanyText").val(),
				shippingFrom:$("#shippingFromText").val(),
				shippingInsurance:$("#shippingInsuranceText").val(),
				sendTime:$("#sendTimeText").val(),
				repoNumber:$("#repoNumberText").val(),
			};
			//arr 在json中另起字段 typs,toprefs,bottomrefs
			var typs=$("#typesText").val().split("，");
			
			//send 3 json
			var param={
				good:addedGood,
				//good's arr field另起
				tR:toprefs,
				t:typs,
				bR:bottomrefs,
				gp:goodParam,
				gpal:goodPAL
			};
			var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
			xhr.open("POST","../addGood",true);		//然后指定服务器url
			xhr.setRequestHeader(
				"Content-Type", "application/json;charset=utf-8");//设置post请求头
			xhr.send(JSON.stringify(param));
			xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
				if(xhr.readyState==4){
					if(xhr.status==200){
						alert("🆗 add good");
					}else{
						alert("status error");
					}
				}
			};
	    },
	    error: function (e) {
	        alert("status error");
	    }
	});
});
$("#decreGoodButton").click(function(){
	$("#yesDecreGoodButton").show();
});
$("#yesDecreGoodButton").click(function(){
	
});