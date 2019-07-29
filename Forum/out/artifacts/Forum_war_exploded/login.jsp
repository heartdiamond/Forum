<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>莫提论坛-登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function fun1() {
			var img = document.getElementById("one");
			img.src = "getCode.do?date"+new Date();
		}
	</script>
	<script type="text/javascript" src="js/jquery-1.12.4.js"></script>
	<script type="text/javascript">
		$(function (){
			$("#btn").attr("disabled", true); 
        });
		function check() {
			var acc = $('#account').val().trim();
			var pwd = $('#password').val().trim();
			if(acc != "" && pwd != ""){
				$("#btn").attr("disabled", false); 
			}
		}
	</script>
	</head>
  
  <body>
		<div class = "container">

		<!--右侧登录界面-->
		<div class = "sideright">
			<div class = "index">
				 <form action = "login.do" method = "post">
					 <p class = "headline">莫提论坛</p>
					 <p class = "astyle">账号：</p>
					 <input id="account" type="text" name="stu_num" maxlength="16" onchange="javaScript:check()">
					 <p class = "astyle">密码：</p>
					 <input id="password" type="password" name="password" maxlength="16" onchange="javaScript:check()">
					 <p class = "astyle">验证码</p>
					 <div class="codeSpace">
					 	<input id="code" type="text" size="4" maxlength="4" name="inputCode" onchange="javaScript:check()"> <a class="change" href="javaScript:Void(0)" onclick="fun1();">看不清</a>
       					<img id="one" style="border-radius: 3rem;" src="getCode.do">
					 </div>
					 <input id="btn" type="submit" value="登录">
					 </br>
					 </form>
					 <font style="color: red; margin-left: 50px;">${error}</font>
				</div>
				</div>
				
		<div class = "footer">
			<ul>
				
			</ul>
		</div>
		
	    </div>
	</body>
	</html>
				
<style>
*{margin: 0;padding: 0;list-style: none;}
th{
	width: 60%;
}
table{
	font-size: 20px;
}
body{
	background-color: rgb(51,50,49);
    }
.container{
	width: 1200px;
	/*height: 870px;*/
	margin: 0 auto;
/* 	background: #ccc; */
}
/* 导航 */
.nav{
	margin-top: 10px;
	height: 50px;
	line-height: 50px;
}
.nav ul li{
	float: right;
	font-size: 15px;
}
.nav ul li a{
	text-decoration: none;
	color: #152b3c;
	padding:15px 30px;
}
.nav ul li a:hover{
	border: 1px solid white;
	border-radius:5%;
	color: white;
} 
/* 主题内容 */
.main{
	width:1200px;
	height: 450px;
}
.sideleft{
	margin-top:100px;
	margin-left:100px;
	width:460px;
	height: 300px;                                  /*高度*/  
	float: left;
	padding:85px 130px;
	color: #ffffff;                                   /*颜色*/  
	font-size: 22px;
	padding-left: 20px;                             /*层内左边距*/  
	padding-right: 10px;                            /*层内右边距*/  
	padding-top: 10px;                              /*层内上边距*/  
	padding-bottom: 10px;                           /*层内下边距*/  
	overflow-y: auto;                             /*竖向滚动条*/  
	display: none;
}
.sideleft p{
	padding: 8px 0;
	font-size: 16px;
}
.sideright{
	width: 480px;
	height: 450px;
	float: right;
}
.sideright .index{
	width: 330px;
	height: 450px;
	background-color:rgba(255,255,255,0.75);
	margin: 50px 90px;
}
.headline{
	font-size: 22px;
	text-align: center;
	padding: 20px;
}

.astyle{
	margin: 5px 0 5px 42px;
	font-size:17px; 
	color: #6a6f77;
}
.bstyle{
	display: block;
	float: left;
	margin-left: 46px;
	font-size: 15px;
}
.cstyle{
	display: block;
	float: right;
	margin-right: 46px;
	font-size: 15px;
}
.cstyle a{
	text-decoration: none;
}
.footer{
	width: 1000px;
	margin:60px auto;
}
.footer ul{
	margin-left: 100px;
}
.footer ul li{
	float: left;
 
}
.footer ul li a{
	text-decoration: none;
	color: black;
	border-left: 2px solid black;
	padding:0 10px;
}
.change{
	font-size: 14px;
}
#one{
	margin-left: 30%;
}
#password{
	width: 250px;
	height: 35px;
	padding-left: 10px;
	margin-left: 10%;
}
#account{
	width: 250px;
	height: 35px;
	padding-left: 10px;
	margin-left: 10%;
}
#code{
	width: 80px;
	height: 35px;
	padding-left: 10px;
	margin-left: 10%;
	float: left;
}
#btn{
	margin-top: 40px;
}
input[type="submit"]{
	-web-kit-appearance:none;
  	-moz-appearance: none;
  	display: block;
  	margin: 0 auto;
  	font-size:15px;
  	width: 240px;
}
input[type="submit"]{
	margin-top: 15px;
	height: 35px;
	background: #357eb8;
	color: #bcedff;
	font-weight: bold;
	font-size: 16px;
}
input[type="submit"]:hover{
	background: #0e62a3;
	cursor: pointer;
}
.codeSpace{
}
#one{
	margin-left:10px;
}
#change{
}
</style>
