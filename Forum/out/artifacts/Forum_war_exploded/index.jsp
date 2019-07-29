<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String pathT = request.getContextPath();
String basePathT = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathT+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePathT%>">
    
    <title>莫提论坛-首页</title>
    <link rel="icon" href="imges/logo.png" type="image/x-icon"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jquery.mCustomScrollbar.css" type="text/css"></link>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css" type="text/css"></link>
	<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>
	<script type="text/javascript">
		 (function($){
     			  $(window).on("load",function(){
          			 $(".content-main").mCustomScrollbar();
      			 });
		 })(jQuery);
	</script>
	<script type="text/javascript">
	function init(){
		if(/Android|webOS|iPhone|iPod|BlackBerry/i.test(navigator.userAgent)) {
			alert("莫提论坛暂不支持手机访问,请使用电脑访问bia~");
  			window.location.href = "http://moti.work:8080";
		} else {
			getArticles();
		}
	}
	function tip(){
		alert("请登录");
	}
	function delHtmlTag(str){
		return str.replace(/<[^>]+>/g,"");//去掉所有的html标记
	}
	function getArticles(){
		var articles_ul = document.getElementById('articles-ul');
		articles_ul.innerHTML = "";
		//1.创建一个异步对象
	      var xhe;
	     if(window.XMLHttpRequest){
	        xhe = new XMLHttpRequest();
	     }else{
	         xhe = new ActiveXObject("Microsoft.XMLHTTP");
	     }
	      xhe.open("post","getAllArticle.do",true);
	      xhe.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	      xhe.send(""); 
	      xhe.onreadystatechange = function () {
	         if(xhe.readyState === 4){
	             if(xhe.status >=200 && xhe.status < 300 || xhe.status === 304){
	                 //5.处理返回的结果
	                 var objarr = eval("("+xhe.responseText+")");
	                 for(var i = 0; i < objarr.length ;i++){
	                 	var who = objarr[i].user_name; 
	                 	var temp_date = new Date(objarr[i].article_time);
	                 	var content = objarr[i].article_content;
   						var html = marked(content);
   						html = delHtmlTag(html);
	                 	var date_time = temp_date.getFullYear()+"年"+(temp_date.getMonth()+1)+"月"+temp_date.getDate()+"日   "
                 					+temp_date.getHours()+":"+temp_date.getMinutes();
                 		var title = objarr[i].article_title;
	                 	var kind = objarr[i].article_kind; 
	                 	var id = objarr[i].article_id; 
	                 	var path = "toReadTemp.do?id="+id;
	                 	var read_num = objarr[i].read_num; 
	                 	var comment_num = objarr[i].comment_num; 
	                 	var like_num = objarr[i].like_num; 
	                 	var temp = "<li class='article'><div class='article-title'><a href="+path+">"+title+"</a><span class='read'>阅读数(<span class='read_num'>"+read_num+"</span>)</span></div><div class='article-content'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
	                 				html+"<a href="+path+"><查看全文></a></div><div class='article-info'><span class='info'>作者:<span class='name'><a href='toOtherHome.do'>"+who+"</a></span></span><span class='info'>类别:&nbsp;<span class='kind'><a href='toOtherHome.do'>"+
	                 				kind+"</a></span></span><span class='info'>点赞数:&nbsp;<span class='like_num'>"+like_num+"</span></span><span class='info'>评论数:&nbsp;<span class='comment_num'>"+comment_num+"</span></span><span class='info-time'>时间:&nbsp;<span class='time'>"+
	                 				date_time+"</span></span></div></li>";
	                 	var li = document.createElement('li');
	                 	li.innerHTML = temp;
	                 	document.getElementById('articles-ul').insertBefore(li, document.getElementById('articles-ul').firstChild);
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
  <body onload="init()">
   		<%@ include file="../../WEB-INF/view/header.jsp" %>
		 <div class="content">

		 <div class="content-main" data-mcs-theme="dark-3">
	         <div class="articles">
	         	<ul id="articles-ul">
	         		<li class='article'>
		    		</li>
		    	</ul>
		    </div>
		 </div>
		 <div class="content-other">
		 	<div class="class-lessions">
		 		<div class="class-lessions-title">
		 			<h2>课程表</h2>
		 		</div>
		 		<div class="class-lessions-content">
		 		<table border="1" id="lession_table">
		 			<tr>
		 				<th class="lessions-title">课程</th>
		 				<td class="day">周一</td>
		 				<td class="day">周二</td>
		 				<td class="day">周三</td>
		 				<td class="day">周四</td>
		 				<td class="day">周五</td>
		 			</tr>
		 			<tr>
		 				<th>上午<br>第一节</th>
		 				<td></td>
		 				<td class="lession">会计学原理<br>主教-S304</td>
		 				<td></td>
		 				<td class="lession">会计学原理<br>主教-S304</td>
		 				<td class="lession">嵌入式系统体系结构<br>二教-西102</td>
		 			</tr>
		 			<tr>
		 				<th>上午<br>第二节</th>
		 				<td class="lession"></td>
		 				<td class="lession">专业英语<br>二教-西702</td>
		 				<td class="lession"></td>
		 				<td class="lession"></td>
		 				<td class="lession"></td>
		 			</tr>
		 			<tr>
		 				<th>下午<br>第一节</th>
		 				<td class="lession">Linux操作系统<br>实训楼-4楼</td>
		 				<td class="lession">网站与网页设计<br>实训楼-3楼</td>
		 				<td class="lession"></td>
		 				<td class="lession">软件设计模式实验<br>实训楼-4楼</td>
		 				<td class="lession">Web编程技术<br>实训楼-4楼</td>
		 			</tr>
		 			<tr>
		 				<th>下午<br>第二节</th>
		 				<td class="lession">软件设计模式<br>二教-西702</td>
		 				<td class="lession">嵌入式系统体系结构<br>二教-西102</td>
		 				<td class="lession"></td>
		 				<td class="lession">软件设计模式实验<br>实训楼-4楼</td>
		 				<td class="lession">Web编程技术<br>实训楼-4楼</td>
		 			</tr>
		 		</table>
		 		</div>
		 	</div>
		 	<div class="class-activity">
		 		<div class="class-activity-title">
		 			<h2>论坛公告</h2>
		 		</div>
		 		<div class="class-activity-content">
		 			<span>
		 				<p>欢迎来到莫提论坛</p>
		 				<p>论坛地址
		 					http://moti.work:8080/Forum
		 				</p>
		 				<p>测试期,欢迎提出您的宝贵意见(电脑登录,效果更佳)</p><br>
		 				<p  style="color: red">公测账号:public 密码:public</p><br>
		 				<p><a href="toReadTemp.do?id=170"  style="color: red">第一次来,请点击这里</a></p>
		 			</span>
		 		</div>
		 	</div>
		 </div>
		 </div>
  </body>
</html>
