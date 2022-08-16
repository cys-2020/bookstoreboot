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
function repair(i){
    if (i >= 0 && i <= 9) {
        return "0" + i;
    } else {
        return i;
    }
}

var money=0;
var phoneNumber=0;
var orderform={
		id:0,
		payTime:null
};


$(function(){
	var oldurl=window.location.href;
	var point=oldurl.indexOf("=");
	/*解码
	var newurl=decodeURIComponent(oldurl.substring(point+1));
	alert(newurl);
	var good=JSON.parse(newurl);
	*/
	orderform.id=oldurl.substring(point+1);	//将要支付的 orderform id已经获取
	var param=orderform.id;
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../getOrderform",true);		//然后指定服务器url
	xhr.responseType="json";
	xhr.setRequestHeader(
		"Content-Type", "application/json;charset=utf-8");//设置post请求头
	xhr.send(param);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				//获取金额，账号
				var orderform=xhr.response;
				money=orderform.finalMoney;
			}else{
				alert("status error");
			}
		}
	};
});


$("#zfb").click(function(){
	$("#cashierArea").show();
	$("#accountArea").html();
	$("#moneyArea").html(money);
	//$("#yesButton").show();
});


$("#yesButton").click(function(){
	orderform.payTime=getCurrentTime();
	var param=JSON.stringify(orderform);
	var xhr=new XMLHttpRequest();		//首先新建一个xmlhr对象
	xhr.open("POST","../payForOrderform",true);		//然后指定服务器url
	xhr.setRequestHeader(
		"Content-Type", "application/json;charset=utf-8");//设置post请求头
	xhr.send(param);
	xhr.onreadystatechange=function(){		//最后监测状态改变，进行服务器回应的处理
		if(xhr.readyState==4){
			if(xhr.status==200){
				alert("支付成功，谢谢你💖💖");
					window.location.href="http://localhost:8001/boot/htmls/index.html";
			}else{
				alert("status error");
			}
		}
	};
});