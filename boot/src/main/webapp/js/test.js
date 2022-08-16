
alert($("#text").val()=="");








//普通Map遍历
for(var key in data){
	addressesList.push(new address(key,data[key]));
}
//formdata添加json（没成功）
formdata.append(
	"goodPAL",
	new Blob([JSON.stringify(goodPAL)], { type: "application/json" })
);