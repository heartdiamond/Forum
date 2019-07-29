<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path2 = request.getContextPath();
String basePath2 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path2+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath2%>">
    
    <title>莫提论坛-他的主页</title>
    <link rel="icon" href="<%=request.getContextPath() %>/imges/logo.png" type="image/x-icon"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/someone_home.css" type="text/css"></link>
	<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/someone_home.js"></script>
  </head>
  
  <body onload="init()">
  
  <%@ include file="../../WEB-INF/view/header.jsp" %>
  
  <div class="main">
  	<div class="one">
  		<div class="info">
  			<span class="ziliao">他的资料</span><br>
  			<div class="info-content">
	  			<span class="basic">姓名:</span><span class="basic1">${userOther.user_name }</span><br>
	  			<span class="basic">学号:</span><span class="basic1">${userOther.stu_num }</span><br>
	  			<span class="basic">性别:</span><span class="basic1">${userOther.sex }</span><br>
	  			<span class="basic">年龄:</span><span class="basic1">${userOther.age }</span><br>
	  			<span class="basic">地址:</span><span class="basic1">${userOther.province_home }</span><br>
	  			<span class="basic">电话:</span><span class="basic1">${userOtherContact.phone_num }</span><br>
	  			<span class="basic">Q Q:</span><span class="basic1">${userOtherContact.qq_num }</span><br>
	  			<span class="basic">微信:</span><span class="basic1">${userOtherContact.wechat_num }</span><br>
  			</div>
  		</div>
  		<div class="title">
  			<table class="content" id="articles-table">
  				<tr>
  					<th class='first-tr-title'>文章标题</th>
 					<th class='first-tr-other'>类别</th>
  					<th class='first-tr-other'>点赞数</th>
  					<th class='first-tr-other'>评论数</th>
  					<th class='first-tr-other'>阅读数</th>
  					<th class='first-tr-time'>发表时间</th>
  				</tr>
  				
  			</table>
  		</div>
  	</div>
  	<div class="two">
		<ul id="kind">
			<li class="current"><a href="refreshOtherHome.do">全部文章</a></li>
			<li><a href="JavaScript:getLearn()">学习类</a></li>
			<li><a href="JavaScript:getTech()">技术类</a></li>
			<li><a href="JavaScript:getLife()">生活类</a></li>
		</ul>
  	</div>
  </div>
  </body>
</html>
