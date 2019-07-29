<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path1 = request.getContextPath();
String basePath1 = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path1+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath1%>">
    
    <title>莫提论坛-修改资料</title>
    <link rel="icon" href="<%=request.getContextPath() %>/imges/logo.png" type="image/x-icon"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/alter_info.css" type="text/css"></link>
	<script type="text/javascript" src="http://lib.sinaapp.com/js/jquery/1.7.2/jquery.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/js/alter_info.js"></script>
 		<script type="text/javascript">
		$(document).ready(function(){
			$(function(){
				$(".input-sex").each(function(){
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
  
  <body onload="JavaScript:init()">
  <%@ include file="../../WEB-INF/view/header.jsp" %>
	  <div class="info">
	   	<div>
	   		<div class="basic-info">
	   			<span class="basic-font">姓名:</span><span class="name-info">${userOnline.user_name }</span><br>
	   			<span class="basic-font">学号:</span><span class="stu-num-info">${userOnline.stu_num }</span>
	   		</div>

	   		<div class="sex-info">
	   			<span class="basic-font">性别:</span>男<input class="input-sex" type="checkbox" value="男"/>
	   			女<input class="input-sex" type="checkbox" value="女"/><span id="sex">${userOnline.sex }</span>
	   		</div>
	   		<div class="age-info">
	   			<span class="basic-font">年龄:</span><input id="input-age" type="text"/>
	   			<span id="age">${userOnline.age }</span>
	   		</div>
	   		<div class="home-info">
	   			<span class="basic-font">地址:</span><input id="input-home" type="text"/>
	   			<span id="home">${userOnline.province_home }</span>
	   		</div>
	   		<div class="phone-info">
	   			<span class="basic-font">电话:</span><input id="input-phone" type="text"/>
	   			<span id="phone">${userContact.phone_num }</span>
	   		</div>
	   		<div class="qq-info">
	   			<span class="basic-font">Q Q:</span><input id="input-qq" type="text"/>
	   			<span id="qq">${userContact.qq_num }</span>
	   		</div>
	   		<div class="wechat-info">
	   			<span class="basic-font">微信:</span><input id="input-wechat" type="text"/>
	   			<span id="wechat">${userContact.wechat_num }</span>
	   		</div>
	   		<div class="submit">
				<form action="toAlterInfo.do">
					<input class="reset" type="submit" value="取消更改">
					<input class="alter" type="submit" value="保存更改" onclick="JavaScript:alter();">
				</form>
	   		</div>
	   	</div>
   	</div>
  </body>
</html>
