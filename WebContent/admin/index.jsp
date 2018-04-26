<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<title>后台管理</title>
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
				<img src="http://localhost:8080/BabyMyHome/images/logo.jpg" alt="后台管理系统" />
			</div>
		</div>
		<div class="righter nav-navicon" id="admin-nav">
			<div class="mainer">
				<div class="admin-navbar">
					<span class="float-right">
                    <a class="button button-little bg-main" href="index">前台首页</a>
                    <a class="button button-little bg-yellow" href="http://localhost:8080/BabyMyHome/longin.jsp">登录</a>
                </span>
					<ul class="nav nav-inline admin-nav">
						<li class="active">
							<br>
							<br>
							<ul><br><br>
								<li><a href="admin?method=list" target="admin">用户管理<span class="badge bg-green">${sessionScope.sum6 }</span></a></li>
								<li><a href="tops?method=list" target="admin">公告管理<span class="badge bg-green">${sessionScope.sum5 }</span></a></li>
								<li><a href="details?method=list_details" target="admin">失踪信息管理<span class="badge bg-green">${sessionScope.sum3 }</span></a></li>
							</ul>  
						</li>
						<li class="active">
							<a href="images?method=list" class="icon-user" target="admin">上传轮播图<span class="badge bg-green">${sessionScope.sum4 }</span></a>
						</li>
						<li class="active">
							<a href="details?method=checkpending" class="icon-user" target="admin">审核发布信息<span class="badge bg-green">${sessionScope.sum }</span></a>
						</li>
						<li class="active">
							<a href="details?method=recovered_list" class="icon-user" target="admin">审核找回信息<span class="badge bg-green">${sessionScope.sum2 }</span></a>
						</li>
						<li class="active">
							<a href="tickling?method=admin_list" class="icon-user" target="admin">查看反馈<span class="badge bg-green">${sessionScope.sum7 }</span></a>
						</li>
					</ul>
				</div>  
				<div >
					<div align="right">
						<span style="color:red">
						${sessionScope.admins[0].username}，
						</span>
						<%@ include file="../include/weather.jsp"%>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</div>
					<ul class="bread">
						<li><a href="index" class="icon-home">首页</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="admin">
			<iframe name="admin" width="100%" height="515" src="admin/admin.jsp">
		</div>
	</body>
  
</html>
