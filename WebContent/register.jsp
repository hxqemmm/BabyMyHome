<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>	
	<head><title>用户注册</title>
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
<!--main.css-->
<script>
	function killErrors(){
	return true;
	}
	window.onerror = killErrors;
</script>

	
	<script language="JavaScript">
			function a(){ 
				var a=document.form.input1.value;
				if(a.length==0){
					document.getElementById("a1").style.display="";
				}else if(a.length!=11){
					document.getElementById("a2").style.display="";
				}
				if(a.length!=0){
					document.getElementById("a1").style.display="none";
				}
				if(a.length==11){
					document.getElementById("a2").style.display="none";
					$.ajax({ 
		    			url: "user?method=user_register", 
		    			type:'POST',
						data:{
						        phone:a
						},
		    			success: function(data){
	        				if(data.trim() !="${flag}"){  
	        					document.getElementById("a3").style.display="";
	        				}else{
	        					document.getElementById("a3").style.display="none";
	        				}
		    				
	      				}
	      			});
				} 	
			}
			
			function b(){
				var b=document.form.input2.value;
				 if(b.length==0){
					document.getElementById("b1").style.display="";
				}
				if(b.length!=0){
					document.getElementById("b1").style.display="none";
					return;
				}
			}
			
			function c(){
				var b=document.form.input2.value;
				var c=document.form.input3.value;
				if(c.length==0){
					document.getElementById("c1").style.display="";
				}
				if(c.length!=0){
					document.getElementById("c1").style.display="none";
				}
				if(b!=c){
					document.getElementById("c2").style.display="";
				}
				if(b==c){
					document.getElementById("c2").style.display="none";
					return;
				}
			}
			
			function d(){
				var d=document.form.input4.value;
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
			
		$(function(){
		        $('#kaptchaImage').click(function () { 
		            $(this).attr('src', 'kaptcha.jpg?' + Math.floor(Math.random()*100) ); 
		        });
   		});
   		
   		function show(o){
	     		var i=true;
	     		var j=true;
	     		var k=true;
	     		var h=true;
				if(o.form.phone.value==""){
					document.getElementById("a1").style.display="";
					i=false;
				}else{
					document.getElementById("a1").style.display="none";
				}
				 if(o.form.password.value==""){
					document.getElementById("b1").style.display="";
					j=false;
				}else{
					document.getElementById("b1").style.display="none";
				}
				if(o.form.password.value==""){
					document.getElementById("c1").style.display="";
					h=false;
				}else{
					document.getElementById("c1").style.display="none";
				}
				 if(o.form.kaptcha.value==""){
					document.getElementById("d1").style.display="";
					k=false;
				}else{
					document.getElementById("d1").style.display="none";
				}
				if(i && j && k&&h){
					o.form.submit();
				}
			}
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
	<!-- 引入流星雨特效。。页面 -->
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
				<form name="form" action="user?method=user_register" method="post">
					<div>
						<input type="text" placeholder="手机号" id="input1" name ="phone" onblur="a()">
						<span style="display:none;color:red" id="a1">*手机号不能为空</span>
						<span style="display:none;color:red"  id="a2">*请输入有效的手机号</span>
						<span style="display:none;color:red" id="a3">*手机号已存在</span>
					</div>
					<br>
					<div>
						<input type="password" placeholder="输入密码" id="input2" name = "password" onblur="b()">
						<span style="display:none;color:red"  id="b1">*密码不能为空</span>
					</div>
					<br>
					<div>
						<input type="password" placeholder="确认密码" id="input3" name = "passwords" onblur="c()">
						<span style="display:none;color:red"  id="c1">*确认密码不能为空</span>
						<span style="display:none;color:red"  id="c2">*前后密码不一</span>
						
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
						<button type="button" onclick="show(this);">注册</button>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="longin.jsp">登入</a>
					</div>
				</form>
				</div>
			</div>
		</div>
	</body>
</html>

