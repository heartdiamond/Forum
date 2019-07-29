<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path1 = request.getContextPath();
String basePath1 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path1+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath1%>">
    
    <title>莫提论坛-网盘</title>
    <link rel="icon" href="<%=request.getContextPath() %>/imges/logo.png" type="image/x-icon"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		*{
			margin: 0;
			padding: 0;
	  	}
	  	body{
			font-size: 16px;
		    line-height: 25px;
		    font-family: 'Open Sans', sans-serif;
		    color: #444;
		    background-color: #fff;
		    overflow: hidden;
		}
		iframe{
			width: 100%;
			height: 100%;
		}
	</style>
  </head>
  
  <body>
    <%@ include file="../../WEB-INF/view/header.jsp" %>
    <iframe src="http://moti.work:8080/FileStore">
    
    </iframe>
  </body>
</html>
