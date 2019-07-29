<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String pathT = request.getContextPath();
String basePathT = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+pathT+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePathT%>">
    
    <title>莫提论坛-重新编辑</title>
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
			margin: 0;
			padding: 0;
	  	}
	  	body{
			font-size: 16px;
		    line-height: 25px;
		    font-family: 'Open Sans', sans-serif;
		    color: #444;
		    background-color: #fff;
		    overflow-y: hidden;
		}
	  	#main-title{
	  		width: 80%;
	  		margin: 0 auto;
	  		text-align: center;
	  		font-size: 25px;
	  	}
	  	#main-title span{
	  		float: left;
	  	}
	  	#main-title input{
	  		width: 100%;
	  		height:35px;
	  		margin-bottom: 10px;
	  		font-size: 18px;
	  		padding-left: 2px;
	  	}
	  	.tip{
	  		color: red;
	  	}
	  	#main-content{
	  		width: 80%;
	  		margin: 0 auto;
	  		text-align: center;
	  		font-size: 25px;
	  	}
	  	#main-content textarea{
	  		width: 100%;
	  		height:400px;
	  		margin-bottom: 10px;
	  		font-size: 18px;
	  		padding-left: 2px;
	  		border-radius: 5px;
	  		resize: none;
	  	}
	  	#main-content span{
	  		float: left;
	  	}
	  	#main-kind{
	  		width: 80%;
	  		margin: 0 auto;
	  		text-align: center;
	  	}
	  	#main-kind .span{
	  		font-size: 25px;
	  		float: left;
	  	}
		#submit{
			float:right;
			background:#00CCFF;
			border: 1px solid #ccc;
		 	border-radius: 5px;
			width:150px;
			height:50px;
			font-size: 18px;
		    font-weight: 500;
		    font-family: "Microsoft soft";
		    color: white;
		    margin-bottom: 20px;
		}
		#kind{
	  		font-size: 20px;
	  		line-height: 20px;
	  		width: 30px;
	  	}
	  	#kind input{
	  		width: 80px;
	  		height: 20px;
	  		line-height: 30px;
	  	}
		#submit:HOVER {
			background:#0066FF;
		}
		#article_id{
			display: none;
		}
		#article_title{
			display: none;
		}
		#article_content{
			display: none;
		}
		#article_kind{
			display: none;
		}
		.content{
			padding-left: 2px;
			padding-top: 5px;
			margin-top: 10px;
		}
		.title{
			margin-top: 10px;
		}
	</style>
	<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.7.2/jquery.min.js">
	</script>
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
	<script type="text/javascript">
		function check(){
			
			var title = document.getElementsByClassName("title")[0].value.trim();
			var content = document.getElementsByClassName("content")[0].value.trim();
			var kindarr = document.getElementsByClassName("kind");
			var kind = false;
			for(k in kindarr){
				if(kindarr[k].checked){
					kind = true;
				}
			}
			//if(title != null && content != null && kind == true){
				if(title == ''){
					document.getElementsByTagName("span")[2].innerHTML = "请填写标题";
				}else{
					document.getElementsByTagName("span")[2].innerHTML = "";
				}
				if(content == ''){
					document.getElementsByTagName("span")[4].innerHTML = "请填写正文";
				}else{
					document.getElementsByTagName("span")[4].innerHTML = "";
				}
				if(kind == false){
					document.getElementsByTagName("span")[6].innerHTML = "请选择类型";
				}else{
					document.getElementsByTagName("span")[6].innerHTML = "";
				}
				
				if(title == '' || content == '' || kind == false){
					return false;
				}
				alert("编辑成功,即将跳转到个人中心!");
		}
		function init(){
			var title = document.getElementById("article_title").innerHTML;
			var content = document.getElementById("article_content").innerHTML;
			var kind = document.getElementById("article_kind").innerHTML;
			
			var titleInput = document.getElementsByClassName("title")[0];
			var contentInput = document.getElementsByClassName("content")[0];
			titleInput.value = title;
			contentInput.innerHTML = content;
			var kindarr = document.getElementsByClassName("kind");
			if(kind == "学习类"){
				kindarr[0].setAttribute("checked", true);
			}
			if(kind == "技术类"){
				kindarr[1].setAttribute("checked", true);
			}
			if(kind == "生活类"){
				kindarr[2].setAttribute("checked", true);
			}
		}
	</script>
  </head>
  
  <body onload="init()">
 		<%@ include file="../../WEB-INF/view/header.jsp" %>
 		<span id="article_title">${editArticle.article_title }</span>
 		<xmp id="article_content">${editArticle.article_content }</xmp>
 		<span id="article_kind">${editArticle.article_kind }</span>
 		<span id="article_id">${editArticle.article_id }</span><br>
    	<form action="rePublish.do" method="post" onsubmit="return check();">
    		<div id="main">
    			<div id="main-title">
    				<div><span>标题:&nbsp;</span><span class="tip"></span></div>
    				<input class="title" type="text" name="article_title" maxlength="40"><br>
    			</div>
    			<div id="main-content">
	    			<div><span>正文:&nbsp;</span><span class="tip"></span></div>
    				<textarea name="article_content" class="content"></textarea>
    			</div>
    			<div id="main-kind">
		    		<span class="span">类别:&nbsp;</span><span class="tip span"></span><br>
		    		<br>
		    		<span id="kind">
		    		学习类<input class="kind" name="article_kind" type="checkbox" value="1" >
		    		技术类<input class="kind" name="article_kind" type="checkbox" value="2" >
		    		生活类<input class="kind" name="article_kind" type="checkbox" value="3" >
		    		</span>
		    			<input id="submit" type="submit" value="编辑完成">
    			</div>
    		</div>
    	</form>
  </body>
</html>
