<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path1 = request.getContextPath();
String basePath1 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path1+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath1%>">
    
    <title>莫提论坛-搜索</title>
    <link rel="icon" href="<%=request.getContextPath() %>/imges/logo.png" type="image/x-icon"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/search.css" type="text/css"></link>
	<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.7.2/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/marked/marked.min.js"></script>
	<script type="text/javascript">
	function init() {
		newMessage();
		var temp = document.getElementById("result").innerHTML;
		var objarr = eval("("+temp+")");
		if(objarr.length == 0){
				var temp = "<h3>未找到结果</h3>";
                var li = document.createElement('li');
                li.innerHTML = temp;
                document.getElementById('articles-ul').insertBefore(li, document.getElementById('articles-ul').firstChild);
		}else{
			for(var i = 0; i < objarr.length ;i++){
                 	var who = objarr[i].user_name; 
                 	var temp_date = new Date(objarr[i].article_time);
                 	var content = objarr[i].article_content;
                 	var html = marked(content);
                 	html = delHtmlTag(html);
                 	var date_time = temp_date.getFullYear()+"年"+(temp_date.getMonth()+1)+"月"+temp_date.getDate()+"日 ";
                 	var title = objarr[i].article_title;
                 	var kind = objarr[i].article_kind; 
                 	var id = objarr[i].article_id; 
                 	var path = "toRead.do?id="+id;
                 	var home_path = "toOtherHome.do?who="+who;
                 	var kind_path = "toSearch.do?content="+kind;
                 	var read_num = objarr[i].read_num; 
                 	var comment_num = objarr[i].comment_num; 
                 	var like_num = objarr[i].like_num; 
                 	var temp = "<li class='article'><div class='article-title'><a href="+path+">"+title+"</a><span class='read'>阅读数(<span class='read_num'>"+read_num+"</span>)</span></div><div class='article-info'><span class='info'>作者:<span class='name'><a href='"+home_path+"'>"+who+"</a></span></span><span class='info'>类别:&nbsp;<span class='kind'><a href='"+kind_path+"'>"+
                 				kind+"</a></span></span><span class='info'>点赞数:&nbsp;<span class='like_num'>"+like_num+"</span></span><span class='info'>评论数:&nbsp;<span class='comment_num'>"+comment_num+"</span></span><span class='info'>时间:&nbsp;<span class='time'>"+
                 				date_time+"</span></span></div></li>";
                 	var li = document.createElement('li');
                 	li.innerHTML = temp;
                 	document.getElementById('articles-ul').insertBefore(li, document.getElementById('articles-ul').firstChild);
                 }
           }
	}
	function delHtmlTag(str){
		return str.replace(/<[^>]+>/g,"");//去掉所有的html标记
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
  
  <body onload="init()">
  <%@ include file="../../WEB-INF/view/header.jsp" %>
  <span id="result">${search_result}</span>
  <h2>搜索结果</h2>
  <div class="articles">
	         	<ul id="articles-ul">
	         		<li class='article'>
		    		</li>
		    	</ul>
  </div>
  </body>
</html>
