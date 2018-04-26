<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>	
	<head><title>用户登入</title>
	<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
<meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>登入</title>

<script src="js/ban.js"></script>

<link rel="stylesheet" type="text/css" href="css/defaurt.css">
<link rel="stylesheet" type="text/css" href="css/account.css" />
<link href="images/favicon.ico" rel="bookmark icon" />
<link rel="stylesheet" href="css/tabris.css">
<link rel="stylesheet" href="css/lib.css">
<!--pintu.css-->
<link rel="stylesheet" href="css/wx.css">
<link rel="stylesheet" href="css/pintuer.css">

 <script src="js/jquery.js"></script>
 <script src="js/pintuer.js"></script>
 <script src="js/respond.js"></script>
<!--main.css-->
<link rel="stylesheet" href="css/main.css">
<script>
	function killErrors(){
	return true;
	}
	window.onerror = killErrors;
</script>

	
	<script language="JavaScript">
			function a(){ 
				var a=document.form1.input1.value;
				if(a.length==0){
					document.getElementById("a1").style.display="";
				}
				if(a.length!=0){
					document.getElementById("a1").style.display="none";
				}
			}
			
			function b(){
				var b=document.form1.input2.value;
				 if(b.length==0){
					document.getElementById("b1").style.display="";
				}
				if(b.length!=0){
					document.getElementById("b1").style.display="none";
					return;
				}
			}
			
			
			function d(){
				var d=document.form1.input4.value;
				if(d.length==0){
					document.getElementById("d1").style.display="";
				}
				if(d.length>0){
					document.getElementById("d1").style.display="none";
					$.ajax({ 
		    			url: "user?method=verify", 
		    			type:'POST',
						data:{
						        kaptcha:d
						},
		    			success: function(data){
	        				if(data.trim() !="${verify}"){  
	        					document.getElementById("d2").style.display="";
	        				}else{
	        					document.getElementById("d2").style.display="none";
	        				}
	      				}
		      		});
		      	}
			}
			
			function show(o){
	     		var i=true;
	     		var j=true;
	     		var k=true;
				if(o.form.phone.value==""){
					document.getElementById("a1").style.display="";
					i=false;
				}else{
					i=true;
				}
				 if(o.form.password.value==""){
					document.getElementById("b1").style.display="";
					j=false;
				}else{
					j=true;
				}
				 if(o.form.kaptcha.value==""){
					document.getElementById("d1").style.display="";
					k=false;
				}else{
					k=true;
				}
				if(i && j && k){
					o.form.submit();
				}
			}
			
			
		$(function(){
		        $('#kaptchaImage').click(function () { 
		            $(this).attr('src', 'kaptcha.jpg?' + Math.floor(Math.random()*100) ); 
		        });
   		});
		</script>
	<style type = "text/css">
		body{
			background-color:#ffffff	
		}
		#input1{
			border: 1px solid #C3CED9;
            border-radius: 5px 5px 5px 5px;
            font-size: 14px;
            height: 31px;
            line-height: 31px;
            margin-right: 10px;
            padding: 0;
            width: 327px;
		}
				#input2{
			border: 1px solid #C3CED9;
            border-radius: 5px 5px 5px 5px;
            font-size: 14px;
            height: 31px;
            line-height: 31px;
            margin-right: 10px;
            padding: 0;
            width: 327px;
		}
		
				#input3{
			border: 1px solid #C3CED9;
            border-radius: 5px 5px 5px 5px;
            font-size: 14px;
            height: 31px;
            line-height: 31px;
            margin-right: 10px;
            padding: 0;
            width: 327px;
		}
				#input4{
			border: 1px solid #C3CED9;
            border-radius: 5px 5px 5px 5px;
            font-size: 14px;
            height: 31px;
            line-height: 31px;
            margin-right: 10px;
            padding: 0;
            width: 200px;
		}
	</style>
	</head>
<body>
	<canvas></canvas>
	<%@ include file="include/meteor.jsp"%>

	<div class="bg0 pa">
	<div class="bg1"></div>
</div>
<div class="hx-box pa">
	<ul class="pr">
		<li class="hx-k1 pa0">
			<span></span>
		</li>
		<li class="hx-k2 pa0">
			<span></span>
		</li>
		<li class="hx-k3 pa0">
			<span></span>
		</li>
	</ul>
</div>
		<div id="ks">
			<div id="tb">
			<div class="login">
			<div class="photo">
			</div>
				<form name="form1" action="user?method=user_login" method="post">
					<div>
						<input type="text" placeholder="手机号" id="input1" name ="phone" onblur="a()">
						<span style="display:none;color:red" id="a1">*手机号不能为空</span>
						
					</div>
					<br>
					<div>
						<input type="password" placeholder="输入密码" id="input2" name = "password" onblur="b()">
						<span style="display:none;color:red"  id="b1">*密码不能为空</span>
					</div>
					<br>
					<div>
						<input type="text" placeholder="填写下面的验证码" id="input4" name = "kaptcha" onblur="d()">
						
						<img src="kaptcha.jpg" id="kaptchaImage"  id="abc" /><br>
					</div>
					<div>
						<sapn style="display:none;color:red"  id="d1">*验证码不能为空</sapn>
						<sapn style="display:none;color:red"  id="d2">*验证码有误</sapn>
						<span style="color:red">${message}</span>
					</div>
					<br>
					<br>
					<div>
						<button type="button" onclick="show(this);">登入</button>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="register.jsp">注册</a>
					</div>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>

