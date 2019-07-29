<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path1 = request.getContextPath();
String basePath1 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path1+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath1%>">
    
    <title>莫提论坛-修改密码</title>
    <link rel="icon" href="<%=request.getContextPath() %>/imges/logo.png" type="image/x-icon"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/alter_password.css" type="text/css"></link>
	<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/alter_password.js"></script>

  </head>
  
  <body>
  <%@ include file="../../WEB-INF/view/header.jsp" %>
  		<div class="main">
  			<table id="chage">
  				<tr>
  					<td class="title" colspan="2">
  					<font id="error" class="tip">${error }</font>
  					<span id='password'>${userOnline.password}</span>
  					</td>
  				</tr>
  				<tr>
  					<td class="one">原始密码:</td>
  					<td>
  					<input type="text" class="old">
  					</td>
  				</tr>
  				<tr>
  					<td>新密码:</td>
  					<td><input type="password" class="new">
  					</td>
  				</tr>
  				<tr>
  					<td>确认新密码:</td>
  					<td><input type="password" class="new">
  					</td>
  				</tr>
  				<tr>
  					<th colspan="2"><input id="submit" type="submit" value="确定" onclick="JavaScript:submit()"> </th>
  				</tr>
  			</table>
  		</div>
  </body>
</html>
