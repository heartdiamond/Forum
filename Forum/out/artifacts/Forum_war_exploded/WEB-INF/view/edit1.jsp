<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path1 = request.getContextPath();
String basePath1 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path1+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath1%>">
    
    <title>莫提论坛-重新编辑</title>
    <link rel="icon" href="<%=request.getContextPath() %>/imges/logo.png" type="image/x-icon"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/plug-ins/EditorMD/lib/codemirror/codemirror.min.css" />
	<script type="text/javascript" src="<%=request.getContextPath() %>/plug-ins/JQuery/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/plug-ins/EditorMD/editormd.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/plug-ins/EditorMD/css/editormd.css" />
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/publish.css" type="text/css"></link>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/publish.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			$(function(){
				$(".kind").each(function(){
					$(this).click(function(){
						if($(this).is(':checked')){ 
						$(this).attr('checked',true).siblings().attr('checked',false);
						}else{
							$(this).attr('checked',false).siblings().attr('checked',false);
						}
					});
				});
			});
		});
	</script>
  </head>
  <body onload="init()">
 	  <%@ include file="../../WEB-INF/view/header.jsp" %>
	  <form action="rePublish.do"  method="post" onsubmit="return check();">
	  	<div class="one">
	  		<span>标题:&nbsp;</span>
    		<input autocomplete="off" id="title" type="text" name="article_title" maxlength="40">
	  	</div>
	  	<div class="two">
	  		<div id="editormd">
				<textarea id="content1" name="article_content" style="display:none;">${editArticle.article_content }</textarea>
			</div>
	  	</div>
	  	<div class="three">
 			<span class="span">类别:&nbsp;</span>
    		<span id="kind">
    			学习类 <input class="kind" name="article_kind" type="checkbox" value="1" >
    			技术类 <input class="kind" name="article_kind" type="checkbox" value="2" >
    			生活类 <input class="kind" name="article_kind" type="checkbox" value="3" >
    			<input id="submit" type="submit" value="编辑完成">
    		</span>
	  	</div>
	  </form>
	  <span id="article_title1">${editArticle.article_title }</span>
 	  <xmp id="article_content1">${editArticle.article_content }</xmp>
 	  <span id="article_kind1">${editArticle.article_kind }</span>
 	  <span id="article_id1">${editArticle.article_id }</span><br>
	  <script type="text/javascript">
			$(function() {
				var editor = editormd("editormd", {
					path: 'plug-ins/EditorMD/lib/'
				});

				/*
				// or
				var editor = editormd({
				    id   : "editormd",
				    path : "../lib/"
				});
				*/
			});
		</script>
  </body>
</html>
