<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html >
	<head>
		<title>个人中心</title>
		
		    <!-- 显示时间，天气 -->
		<script src="js/jquery.mins.js"></script>
		<script src="js/jquery.leoweather.min.js"></script>
		
	
		<link rel="stylesheet" href="css/pintuer.css">
		<link rel="stylesheet" href="css/admin.css">
		<script src="js/jquery.js"></script>
		<script src="js/pintuer.js"></script>
		<link type="image/x-icon" href="images/favicon.ico" rel="shortcut icon" />
		<link href="images/favicon.ico" rel="bookmark icon" />
	</head>

	<body>
		<div class="lefter">
			<div class="logo">
				<img src="${sessionScope.userinfo[0].headimage}" width="80" alt="个人中心" />
			</div>
		</div>
		<div class="righter nav-navicon" id="admin-nav">
			<div class="mainer">
				<div class="admin-navbar">
					
					<ul class="nav nav-inline admin-nav">
						<li class="active">
								<a href="index" class="icon-home">首页</a>							
							<ul><br><br>
								<li><a href="personal.jsp" target="admin">我的资料</a></li>
								<li><a href="details?method=list_record&issuer=${sessionScope.userinfo[0].username}" target="admin">我的发布</a></li>
								<li><a href="tickling?method=list_titckling&username=${sessionScope.userinfo[0].username}" target="admin">我的反馈</a></li>
								<li><a href="modify.jsp" target="admin">修改资料</a></li>
							</ul>  
						</li>
						<li class="active">
							<a href="MyTickling.jsp" class="icon-user" target="admin">反馈</a>
						</li>
						<li><a href="user?method=out" class="icon-user">退出登录</a></li>
					</ul>
				</div>  
				<div align="right" >
						<span style="color:red">
						${sessionScope.userinfo[0].username}，
						</span>
						<%@ include file="include/weather.jsp"%>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<ul class="bread">
						<li></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="admin">
			<iframe name="admin" width="100%" height="515" src="personal.jsp">
		</div>
	</body>
  
</html>
