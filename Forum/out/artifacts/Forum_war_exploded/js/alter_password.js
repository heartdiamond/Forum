function submit(){
	var password = document.getElementById("password").innerHTML;
	var tip = document.getElementById("error");
	var old = document.getElementsByClassName("old")[0].value;
	var new1 = document.getElementsByClassName("new")[0].value;
	var new2 = document.getElementsByClassName("new")[1].value;
	if(old == ""||new1 == ""||new2 == ""){
		tip.innerHTML = "内容不能为空!";
		return;
	}else{
		tip.innerHTML = "";
	}
	if(old != password){
		tip.innerHTML = "原密码不正确!";
		return;
	}else{
		tip.innerHTML = "";
	}
	if(new1 != new2){
		tip.innerHTML = "新密码不一致!";
		return;
	}else{
		tip.innerHTML = "";
	}
	//1.创建一个异步对象
    var xhe;
    if(window.XMLHttpRequest){
       xhe = new XMLHttpRequest();
    }else{
       xhe = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xhe.open("post","toAlterPassword1.do",true);
    xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhe.send("password="+new1);
    alert("修改成功!")
}