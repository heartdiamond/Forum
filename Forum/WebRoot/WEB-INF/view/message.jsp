 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String pathT = request.getContextPath();
String basePathT = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathT+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePathT%>">
    
    <title>莫提论坛-留言板</title>
    <link rel="icon" href="<%=request.getContextPath() %>/imges/logo.png" type="image/x-icon"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">			
		function getMsgs(){
			newMessage();
			var messages_ul = document.getElementById('messages_ul');
			messages_ul.innerHTML = "";
			//1.创建一个异步对象
              var xhe;
             if(window.XMLHttpRequest){
                xhe = new XMLHttpRequest();
             }else{
                 xhe = new ActiveXObject("Microsoft.XMLHTTP");
             }
              xhe.open("post","getAllMesssage.do",true);
              xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
              xhe.send(""); 
              xhe.onreadystatechange = function () {
                 if(xhe.readyState === 4){
                     if(xhe.status >=200 && xhe.status < 300 || xhe.status === 304){
                         //5.处理返回的结果
                         var objarr = eval("("+xhe.responseText+")");
                         for(var i = 0; i < objarr.length ;i++){
                         	var who = objarr[i].user_name; 
                         	var temp_date = new Date(objarr[i].message_time);
                         	var content = objarr[i].message_content;
                         	var date_time = temp_date.getFullYear()+"年"+(temp_date.getMonth()+1)+"月"+temp_date.getDate()+"日   "
                 					+temp_date.getHours()+":"+temp_date.getMinutes();
                        	var temp = "<div class='message'><p><xmp>"+content+"</xmp></p><table><tr ><td class='one'>留言者:<span class='publisher'>"+who+"</span></td><td class='two'>时间:<span class='publish-time'>"+date_time+"</span></td></tr></table></div>";
                         	var li = document.createElement('li');
                         	li.innerHTML = temp;
                         	document.getElementById('messages_ul').insertBefore(li, document.getElementById('messages_ul').firstChild);
                         }
                     }else{
                         //5.处理返回的结果
                         alert("失败");
                     }
                 }
             };
		
		}
	
	
		function send(){
			var text = document.getElementById('message_text').value.trim();
			if(text == ""||text =="请输入留言内容"){
				alert("请先输入留言内容!");
				return false;
			}
			var who = document.getElementById('span_who').innerHTML;
			var temp_date = new Date();
           	var date_time = temp_date.getFullYear()+"年"+(temp_date.getMonth()+1)+"月"+temp_date.getDate()+"日   "
                 			+temp_date.getHours()+":"+temp_date.getMinutes();
         	var temp = "<div class='message'><p><xmp>"+text+"</xmp></p><table><tr ><td class='one'>留言者:<span class='publisher'>"+who+"</span></td><td class='two'>时间:<span class='publish-time'>"+date_time+"</span></td></tr></table></div>";
           	var li = document.createElement('li');
           	li.innerHTML = temp;
          	document.getElementById('messages_ul').insertBefore(li, document.getElementById('messages_ul').firstChild);
			document.getElementById('message_text').value = "";
 			//1.创建一个异步对象
             var xhe;
             if(window.XMLHttpRequest){
                xhe = new XMLHttpRequest();
             }else{
                 xhe = new ActiveXObject("Microsoft.XMLHTTP");
             }
             xhe.open("post","addMessage.do",true);
             xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
             xhe.send("message="+text+"&who="+who);
			return false;
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
	</script>
  	<style type="text/css">
  		*{
  			margin: 0;
  			padding: 0;
  		}
  		body{
			font-size: 16px;
		    line-height: 27px;
		    font-family: 'Open Sans', sans-serif;
		    color: #444;
		    background-color: #fff;
			overflow-y: hidden;
  		}
		.message{
			width:640px;
			color:green;
			border-bottom:1px solid black; 
			padding:5px;
		}
		#message-content{
			width: 700px;
			margin: 0 auto;
			overflow-y: hidden;
		}
		#messages_ul{
			list-style: none;
			overflow-y: scroll;
			height: 500px;
			overflow-x: hidden;
		}
		#message_text{
		    border: 1px solid #ccc; 
		    border-radius: 3px;
		    width: 700px;
		    padding-left:5px;
		    padding-top:5px;
		    font-size: 14px;
		    font-weight: 600;
		    font-family: "Microsoft soft";
		    height:80px;
		    resize: none;
		}
		#message-input{
			width:700px;
			margin: 0 auto;
			line-height: 100px;
		}
		#who{
			display: none;
		}
		.publisher{
			color: green;
			margin-left: 10px;
		}
		.publish-time{
			color: green;
			margin-left: 10px;
		}
		table {
			width: 680px;
			height: 40px;
			background: #DDDDDD;
		}
		.one{
			width: 30%;
			padding-left:5%;
		}
		.two{
			width:300px;
			padding-left:20%;
			text-align: center;
			
		}
		xmp{
			width:650px;
			font-size: 20px;
		    font-weight: 500;
		    color: blue;
		    overflow-x: auto;
		    margin-bottom: 10px;
		    padding-left: 10px;
		}
		#sendMessage{
			background:#00CCFF;
			border: 1px solid #ccc;
		 	border-radius: 5px;
			width:60px;
			height:45px;
			font-size: 18px;
		    font-family: "Microsoft soft";
		    color: white;
		    margin-top: 5px;
		    margin-left: 640px;
		}
		#sendMessage:HOVER {
			background:#0066FF;
		}
  	</style>
  </head>
  
  <body onload="getMsgs()">
  		<%@ include file="../../WEB-INF/view/header.jsp" %>
		<div>
			<div id="header">
				<span id="who">${userOnline.user_name}</span><br><br>
			</div>
			<div id="message-input">
					<textarea id="message_text" onfocus="javascript:if(this.value=='请输入留言内容')this.value='';" onblur="javascript:if(this.value=='')this.value='请输入留言内容';">请输入留言内容</textarea>
					<br><input id="sendMessage" onclick="javascript:send()" type="submit" value="发布">
			</div>
			<div id="message-content" class="scroll-message">
				<ul id="messages_ul">
					<li>
					</li>
				</ul>
			</div>
		</div>
  </body>
</html>
