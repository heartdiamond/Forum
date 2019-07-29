function init () {
	newMessage();
	var age = document.getElementById("age").innerHTML;
	var sex = document.getElementById("sex").innerHTML;
	var home = document.getElementById("home").innerHTML;
	var phone = document.getElementById("phone").innerHTML;
	var qq = document.getElementById("qq").innerHTML;
	var wechat = document.getElementById("wechat").innerHTML;
	
	var ageInput = document.getElementById("input-age");
	var homeInput = document.getElementById("input-home");
	var phoneInput = document.getElementById("input-phone");
	var qqInput = document.getElementById("input-qq");
	var wechatInput = document.getElementById("input-wechat");
	
	ageInput.value = age;
	homeInput.value = home;
	phoneInput.value = phone;
	qqInput.value = qq;
	wechatInput.value = wechat;
	if(sex === "男"){
		document.getElementsByClassName("input-sex")[0].setAttribute("checked", true);
	}else{
		document.getElementsByClassName("input-sex")[1].setAttribute("checked", true);
	}
};
function alter(){
	var age = document.getElementById("input-age").value.trim();
	var home = document.getElementById("input-home").value.trim();
	var phone = document.getElementById("input-phone").value.trim();
	var qq = document.getElementById("input-qq").value.trim();
	var wechat = document.getElementById("input-wechat").value.trim();
	var sexarr = document.getElementsByClassName("input-sex");
	var sex = "男";
	for(k in sexarr){
		if(sexarr[1].checked){
			sex = "女";
		}
	}
	//1.创建一个异步对象
    var xhe;
    if(window.XMLHttpRequest){
       xhe = new XMLHttpRequest();
    }else{
       xhe = new ActiveXObject("Microsoft.XMLHTTP");
    }
    xhe.open("post","toAlter.do",true);
    xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
    xhe.send("age="+age+"&home="+home+"&phone="+phone+"&qq="+qq+"&wechat="+wechat+"&sex="+sex);
}
function newMessage(){
	var xhe;
    if(window.XMLHttpRequest){
       xhe = new XMLHttpRequest();
    }else{
       xhe = new ActiveXObject("Microsoft.XMLHTTP");
    }
     xhe.open("post","newMessage.do",true);
     xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
     xhe.send(""); 
     xhe.onreadystatechange = function () {
        if(xhe.readyState === 4){
            if(xhe.status >=200 && xhe.status < 300 || xhe.status === 304){
                //5.处理返回的结果
                var result = xhe.responseText;
                if(result === "yes"){
                	var obj = document.getElementById("my-message");
                	obj.innerHTML = "<a href='toMyMessage.do' class='newMessageClass'>新 的 消 息</a>"
                }else if(result === "no"){
                	
                }
            }else{
                //5.处理返回的结果
                alert("失败");
            }
        }
    };
}