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
    <link rel="icon" href="<%=request.getContextPath() %>/imges/logo.png" type="image/x-icon"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jquery.mCustomScrollbar.css" type="text/css"></link>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/main.css" type="text/css"></link>
	<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/main.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>
	<script type="text/javascript">
		 (function($){
     			  $(window).on("load",function(){
          			 $(".content-main").mCustomScrollbar();
      			 });
		 })(jQuery);
	</script>
  	</head>
  <body onload="getArticles()">
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
		 				<p>测试期,欢迎提出您的宝贵意见</p><br>
		 				<p><a href="toRead.do?id=170" style="color: red">第一次来,请点击这里</a></p>
		 			</span>
		 		</div>
		 	</div>
		 </div>
		 </div>
  </body>
</html>
