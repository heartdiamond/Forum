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
    <link rel="icon" href="imges/logo.png" type="image/x-icon"/>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
		<title>登录页</title>
		<style>
			body {
				margin: 0;
				padding: 0;
				font-family: sans-serif;
				background: #34495e;
			}
			.box {
				width: 300px;
				padding: 40px;
				position: absolute;
				border-radius: 2rem;
				top: 50%;
				left: 50%;
				transform: translate(-50%, -50%);
				background: #191919;
				text-align: center;
			}
			.box h1 {
				color: white;
				text-transform: uppercase;
				font-weight: 500;
			}
			.box input[type='text'],
			.box input[type='password'] {
				border: 0;
				background: none;
				display: block;
				margin: 20px auto;
				text-align: center;
				border: 2px solid #3498db;
				padding: 14px 10px;
				width: 200px;
				outline: none;
				color: white;
				border-radius: 24px;
				transition: 0.25s;
			}
			.box input[type='text']:focus,
			.box input[type='password']:focus {
				width: 280px;
				border-color: #2ecc71;
			}
			.submit {
				border: 0;
				background: none;
				margin: 20px auto;
				margin-top: 0;
				display: inline-block;
				text-align: center;
				border: 2px solid #3498db;
				padding: 10px 40px;
				outline: none;
				color: white;
				border-radius: 24px;
				transition: 0.25s;
				cursor: pointer;
				text-decoration: none;
				font-size: 12px;
			}
			.submit:hover {
				background: #2ecc71;
				border-color: #2ecc71;
			}
			/* button style start */
			.login{
				position: relative;
				outline: none;
				border: 2px solid #3498db;
				width: 12rem;
				height: 5rem;
				border-radius: 5rem;
				background: none;
				color: #fff;
				font-weight: bold;
				font-size: 1.5rem;
				box-shadow: 0 8px 28px black;
				cursor: pointer;

				transition: .5s;
			}

			.active.login{
				width: 5rem;
				color:transparent;
			}

			/* button style end */

			/* loading style start */
			.loading{
				opacity: 0;
				transition: .5s;
			}

			.active .loading{
				position: absolute;
				left: 50%;
				top: 50%;
				transform: translate(-50%,-50%);

				width: 70%;
				height: 40%;

				display: flex;
				justify-content: space-around;
				align-items: flex-end;
				opacity: 1;
			}

			.active .loading div{
				width: .3rem;
				height: .3rem;
				border-radius: 50%;
				background-color: #fff;

				animation: .9s loading ease-in-out infinite alternate;
			}

			@keyframes loading{
				to{
					transform: translate(0, -1rem);
				}
			}

			.active .loading div:nth-child(2){
				animation-delay: .2s;
			}

			.active .loading div:nth-child(3){
				animation-delay: .4s;
			}

			.verity .loading{
				opacity: 0;
			}
			/* loading style end */

			/* checkmark style start */
			.checkmark{
				position: absolute;
				left: 50%;
				top: 56%;
				transform: translate(-50%,-50%);
				stroke-width: 2px;
				/* 利用stroke的虚线和偏移值达到加载的动画效果 */
				stroke-dasharray: 36px;
				stroke-dashoffset: 36px;
			}

			.verity .checkmark{
				animation: .6s show forwards;
				animation-delay: .4s;
			}

			@keyframes show{
				to{
					stroke-dashoffset: 0;
				}
			}
			/* checkmark style end */

		</style>
		<script type="text/javascript">
		function fun1() {
			var img = document.getElementById("one");
			img.src = "getCode.do?date"+new Date();
		}
		function error() {
			var error = document.getElementById("error").innerHTML;
			if(error == ""){
			
			}else if(error == "验证码错误!"){
				var code = document.getElementById("code");
				code.style.cssText = 'border: 2px solid red;';
			}else if(error == "请检查用户名和密码!"){
				var account = document.getElementById("account");
				var password = document.getElementById("password");
				account.style.cssText = 'border: 2px solid red;';
				password.style.cssText = 'border: 2px solid red;';
			}
		}
		function test1(){
			var account = document.getElementById("account");
			if(account.value == ""){
				account.style.cssText = 'border: 2px solid red;';
			}else{
				account.style.cssText = 'border: 2px solid #3498db;';
			}
		}
		function test2(){
			var password = document.getElementById("password");
			if(password.value == ""){
				password.style.cssText = 'border: 2px solid red;';
			}else{
				password.style.cssText = 'border: 2px solid #3498db;';
			}
		}
		function test3(){
			var code = document.getElementById("code");
			if(code.value == ""){
				code.style.cssText = 'border: 2px solid red;';
			}else{
				code.style.cssText = 'border: 2px solid #3498db;';
			}
		}
	</script>
	</head>
	<body onload="error()">
		<div class="box">
		<form id="login_form" action="login.do" method="post">

			<img width="180px" src="<%=request.getContextPath() %>/imges/logo1.png">
			<input id="account" autocomplete="off" type="text" placeholder="账号" name="stu_num" maxlength="16" onblur="JavaScript:test1()" />
			<input id="password" autocomplete="off" type="password" placeholder="密码" name="password" maxlength="16" onblur="JavaScript:test2()"/>
			<div class="codeSpace">
			 	<input id="code" autocomplete="off" placeholder="验证码" type="text" size="4" maxlength="4" name="inputCode" onblur="JavaScript:test3()"> 
       			<img id="one" style="border-radius: 3rem; border: 2px solid #3498db;" src="getCode.do" onclick="fun1();">
			</div>

		</form>
		<button class="login">
			<p>登录</p>
			<div class="loading ">
				<div></div>
				<div></div>
				<div></div>
			</div>

			<!-- 使用svg绘制 -->
			<svg class='checkmark' width='30px' height='30px' stroke='white' fill='none'>
				<polyline points='2,10 12,18 28,2'></polyline>
			</svg>
		</button>
		<font id="error" style="color: red; margin-left: 50px;display: none;">${error}</font>		
		<br>
		</div>
	</body>
	<script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.min.js"></script>
	<script>
		$($('.login').click(
			function () {
				if($("#account").val() == "" ||$("#password").val() == "" ||$("#code").val() == ""){
						if($("#account").val() == ""){
							$("#account").css("border","2px solid red");
						}else{
							$("#account").css("border","2px solid #3498db");
						}
						if($("#password").val() == ""){
							$("#password").css("border","2px solid red");
						}else{
							$("#password").css("border","2px solid #3498db");
						}
						if($("#code").val() == ""){
							$("#code").css("border","2px solid red");
						}else{
							$("#code").css("border","2px solid #3498db");
						}
						return;
				}
				if (!$(this).hasClass('active')) {
					$(this).toggleClass('active');
					var a = false;
					setTimeout(
						() => {
							$(this).addClass('verity');
							a = true;
								$("#login_form").submit();
						}, 1500
					)
				}
			}
		))
	</script>
</html>
