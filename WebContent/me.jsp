<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<script src="js/admin.js"></script>  
		<link type="image/x-icon" href="images/favicon.ico" rel="shortcut icon" />
		<link href="images/favicon.ico" rel="bookmark icon" />
	</head>
	
		 <%@ include file="include/head.jsp"%>
	<body>
		<div class="admin">
			<div class="line-big">
				<div class="xm9">
					<div class="panel">
						<div class="panel-head"><strong>系统信息</strong></div>
						<table class="table">
							<tr>
								<th colspan="2">服务器信息</th>
								<th colspan="2">系统信息</th>
							</tr>
							<tr>
								<td width="110" align="right">操作系统：</td>
								<td>Windows 7</td>
								<td width="90" align="right">系统开发：</td>
								<td>宝贝回家</td>
							</tr>
							<tr>
								<td align="right">Web服务器：</td>
								<td>tomcat</td>
								<td align="right">主页：</td>
								<td><a href="index.jsp" target="_blank">http://localhost:8080/badyMyHome</a></td>
							</tr>
							<tr>
								<td align="right">程序语言：</td>
								<td>JSP+java</td>
								<td align="right">演示：</td>
								<td><a href="longin.jsp" target="_blank">效果</a></td>
							</tr>
							<tr>
								<td align="right">数据库：</td>
								<td>SQLServer2005</td>
								<td align="right">QQ：</td>
								<td>1252018521&nbsp; 2031773544</td>
							</tr>
							<tr>
								<td align="right">联系方式：</td>
								<td>11111111111</td>
								<td align="right">赞助：</td>
								<td>国家政府</td>
							</tr>
							<tr>
								<td align="right">网站简介：</td>
								<td>寻找失踪宝贝</td>
								<td align="right">介绍：</td>
								<td>本网站纯属免费，不收取任何费用，请不要被欺骗，</td>
							</tr>

						</table>
					</div>
				</div>
			</div>

	</body>

</html>