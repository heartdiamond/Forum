function check(){
	var title = document.getElementById("title").value.trim();
	var content = document.getElementById("content").value.trim();
	var kind1 = document.getElementsByClassName("kind")[0];
	var kind2 = document.getElementsByClassName("kind")[1];
	var kind3 = document.getElementsByClassName("kind")[2];
	var kind = false;
	if(kind1.checked){
		kind = true;
	}
	if(kind2.checked){
		kind = true;
	}
	if(kind3.checked){
		kind = true;
	}
	if(title === ""){
		alert("标题不能为空哦!");
		return false;
	}
	if(content === ""){
		alert("正文不能为空哦!");
		return false;
	}
	if(kind == false){
		alert("您还没有选择文章类型哦!");
		return false;
	}
	alert("发表成功,即将跳转到首页!");
}
function init(){
	newMessage();
	var title = document.getElementById("article_title1").innerHTML;
	var content = document.getElementById("article_content1").innerHTML;
	var kind = document.getElementById("article_kind1").innerHTML;
	var titleInput = document.getElementById("title");
	var contentInput = document.getElementById("content1");
	titleInput.value = title;
	contentInput.innerHTML = content;
	var kindarr = document.getElementsByClassName("kind");
	if(kind == "学习类"){
		kindarr[0].setAttribute("checked", true);
	}
	if(kind == "技术类"){
		kindarr[1].setAttribute("checked", true);
	}
	if(kind == "生活类"){
		kindarr[2].setAttribute("checked", true);
	}
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