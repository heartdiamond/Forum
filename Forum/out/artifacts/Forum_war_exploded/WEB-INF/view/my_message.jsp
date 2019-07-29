<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path1 = request.getContextPath();
String basePath1 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path1+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath1%>">
    
    <title>莫提论坛-我的消息</title>
    <link rel="icon" href="<%=request.getContextPath() %>/imges/logo.png" type="image/x-icon"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/my_message.css" type="text/css"></link>
	<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/my_message.js"></script>

  </head>
  
  <body onload="init()">
   <%@ include file="../../WEB-INF/view/header.jsp" %>
   <div class="main">
   		<div class="op" id="op">
   			<span><a href="readALLDynamic.do">全部已读</a></span>
   			<span><a href="deleteAllDynamics.do">删除全部消息</a></span>
   		</div>
   		<div id="content">
   			<div id="messages">
   				<div class="new">
   					<span class="new_message">新的消息</span>
   					<ul id="new_ul">
   						<li>
	   					</li>
   					</ul>
	   			</div>
	   			<div class="old">
	   				<span class="old_message">已读消息</span>
	   				<ul id="old_ul">
	   					<li>
			   			</li>
		   			</ul>
   			</div>
   		</div>
   </div>
  </body>
</html>
