<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path2 = request.getContextPath();
String basePath2 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path2+"/";
%>
<%request.setAttribute("n","\n");%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath2%>">
    
    <title>莫提论坛-阅读</title>
    <link rel="icon" href="<%=request.getContextPath() %>/imges/logo.png" type="image/x-icon"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jquery.mCustomScrollbar.css" type="text/css"></link>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/read.css" type="text/css"></link>
	<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.mCustomScrollbar.concat.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/read.js"></script>
  	<script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>
  </head>
  
  <body onload="init()">
	<%@ include file="../../WEB-INF/view/header.jsp" %>
	<div id="main">
	
	    <div class="read-title">
	    	<h1><xmp id="title-xmp">${article.article_title}</xmp></h1>
	    </div>
	    <div class="read-content" id="test2">
	    	<xmp id="test1">${article.article_content}</xmp>
	    </div>
	    <div class="info">
	    	<span class="info-basic">作者:&nbsp;&nbsp;<a id="who_name">${article.user_name}</a><span id="who1"></span></span>
	    	<span class="info-basic">文章类型:&nbsp;&nbsp;<a id="who_kind">${article.article_kind}</a><span id="kind2"></span></span>
	    	<span class="info-basic">阅读数:&nbsp;&nbsp;${article.read_num}</span>
	    	<span class="info-basic">点赞数:&nbsp;<a id="like_num">${article.like_num}</a></span>
	    	<span class="info-basic">评论数:&nbsp;<a id="comment_num">${article.comment_num}</a></span>
	    	<span class="info-time">时间:&nbsp;&nbsp;<span id="real-time"></span><span id="time">${article.article_time}</span></span>
	    </div>
	    <div class="like">
	    	<img id="like_pic" src="<%=request.getContextPath() %>/imges/unlike.png" onclick="like()"><br>
	    	<span id="like_statu">点赞</span>
	    	<span id="who">${userOnline.user_id}</span>
	    </div>
	    <div class="comment">
	    	<h3>评论</h3><span id="user_name">${userOnline.user_name}</span>
	    	<ul id="comment-ul">
	    	</ul>
	    	<div class="publish-comment">
	    		<input autocomplete="off" type="text" id="comment-content" maxlength="100">
	    		<input type="submit" onclick="JavaScript:addComment()" value="发表" id="submit">
	    	</div>
	    </div>
    </div>
  </body>
</html>
