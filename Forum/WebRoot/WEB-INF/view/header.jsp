<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'header.jsp' starting page</title>
    <link rel="icon" href="<%=request.getContextPath() %>/imges/logo.png" type="image/x-icon"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<style type="text/css">
		*{
			padding: 0;
			margin: 0;
		}
  		body{
  			overflow-x: hidden;
  		}
		a{
			text-decoration:none;
			color: #F0F0F0;
		}
		a:HOVER{
			color: #FFBB77;
		}
		#table1 {
			font-size:25px;
			width: 100%;
			height: 50px;
			background-color: #34495e;
			border-collapse: collapse;
		}
		.shouye{
			width: 15%;
		}
		.fatie{
			width: 15%;
		}
		.sousuo{
			width: 30%;
		}
		.liuyanban{
			width: 20%;
		}
		.four{
			width: 20%;
			color: #F0F0F0;
		}
		.four> ul{
			position: absolute;
			z-index: 999999;
		}
		.sub{
            background-color: #ADADAD;
            display: none;
            width: 20%;
            margin-top:9px; 
            border-bottom:1px solid #000;
            border-left: 1px solid #000;
            border-radius: 5px;
        }
        .sub>li{
        	font-size:18px;
            width: 100%;
            height: 40px;
            list-style: none;
            text-align: center;
            line-height: 40px;
        }
        .current{
            background-color: #34495e;
        }
        #search-content{
        	font-size:18px;
			padding-left:5px;
			padding-bottom:0px;
			width: 70%;
			border-bottom: 2px solid ;
			border-top:0px;
			border-left:0px;
			border-right:0px;		
			background-color:transparent;
			outline: none; 
			color: #f1f1f1;
        }
		#table1 th, #table1 td,#table1 tr {
		  border:0px;
		}
		#sub1{
			padding-left: 0px;
		}
		.newMessageClass{
			color: red;
		}  
	</style>
	<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.7.2/jquery.min.js">
	</script>
	<script>
	$(function () {
			who = $("#span_who").html();
			if(who == ""||who == null){
				$(".four").html("<span><a href='login2.jsp'>登录</span>");
			}else{
             /*
        		     在jQuery中如果想要执行动画,那么需要在之前调用动画元素的stop方法
              */
             $(".four").hover(function () {
                 $(this).addClass("current");
                 $(this).siblings().removeClass("current");
                 $(this).children("ul").stop();
                 $(this).children("ul").slideDown(100);
             },function () {
                 $(this).removeClass("current");
                 $(this).children("ul").stop();
                 $(this).children("ul").slideUp(100);
             });
             $(".sub>li").hover(function () {
                 $(this).addClass("current");
                 $(this).siblings().removeClass("current");
             },function () {
                 $(this).removeClass("current");
             });
             $('a').click(function(){
            		 $(this).parent().addClass("current");
                 $(this).parent().siblings().removeClass("current");
             });
            }
         });
	</script>
	<script type="text/javascript">
	function tip(){
		alert("暂未开放,敬请期待!");
	}
	function test(){
		var search = document.getElementById("search-content").value.trim();
		var searchSomething = document.getElementById("searchSomething");
		if(search == "" || search == null){
			document.getElementById("search-content").value = "输入搜索内容";
		}else{
			document.getElementById("search-content").value = "";
		}
		if(search == null || search == ""||search == "输入搜索内容"){
			searchSomething.setAttribute("href", "toMain.do");
		}else{
			searchSomething.setAttribute("href", "toSearch.do?content="+search);
		}
	}
	function input(){
		var search = document.getElementById("search-content").value.trim();
		if(search == "" || search == null){
			document.getElementById("search-content").value = "输入搜索内容";
		}else{
			document.getElementById("search-content").value = "";
		}
	}
	function ok(){
		var search = document.getElementById("search-content").value.trim();
		if(search == "" || search == null){
			document.getElementById("search-content").value = "输入搜索内容";
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
	</script>
  </head>
  
  <body onload="newMessage()">
    	<table id="table1">
		 	<tr id="table1-tr">
		 		<th class="shouye"><a href="toMain.do">
		 		<img height="50px" alt="首页图片不见了~" src="<%=request.getContextPath() %>/imges/logo1.png">
		 		</a></th>
		 		
		 		<th class="fatie"><a href="toPublish.do">发帖</a></th>
		 		<th class="sousuo">
		 		<input id="search-content" type="text" value="输入搜索内容" onclick="input()" onblur="ok()">
		 		<a id="searchSomething" href="toMain.do" onclick="return test()">搜索</a>
		 		</th>
		 		<th class="liuyanban"><a href="toMessage.do">班级留言板</a></th>
		 		<th class="four">用户:<span id="span_who">${userOnline.user_name}</span>
		 			        <ul class="sub" id="sub1">
					            <li>
					     			<a href="toMyHome.do">个 人 中 心</a>       
					            </li>
					            <li id="my-message">
					     			<a href="toMyMessage.do">我 的 消 息</a>        
					            </li>
					            <li>
					     			<a href="toFileStore.do">莫 提 网 盘</a>        
					            </li>
          			            <li>
					            	<a href="toAlterInfo.do">修 改 资 料</a>
					            </li>
					             <li>
					            	<a href="toAlterPassword.do">修 改 密 码</a>
					            </li>
					             <li>
					            	<a href="toLogout.do">退 出 登 录</a>
			            		</li>
		 		</th>
		 	</tr>
		 </table>
  </body>
</html>
