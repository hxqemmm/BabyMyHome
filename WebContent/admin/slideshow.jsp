<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="zh-cn">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
		<meta name="renderer" content="webkit">
		<link rel="stylesheet" href="css/pintuer.css">
		<link rel="stylesheet" href="css/admin.css">
		<script src="js/jquery.js"></script>
		<script src="js/pintuer.js"></script>
		<link type="../image/x-icon" href="images/favicon.ico" rel="shortcut icon" />
	</head>

	<body>
		<form method="post">
			<div class="panel admin-panel">
				<div class="panel-head"><strong>轮播图片</strong>
				</div>
				<div class="padding border-bottom">
						<a href="admin/addshow.jsp" target="admin"><input type="button" class="button button-small border-green" value="添加轮播图" /></a>
				</div>
				
					<table class="table table-hover">
					<tr>
						<th width="250">ID</th>
						<th width="280">url</th>						
						<th width="250">操作</th>
					</tr>
				<c:forEach items="${list}" var="d">
		   			<tr  style='background: white'>
		   				<td>${d.id }</td>
		   				<td>${d.url }</td>
		   				<td >
		   					<a class="button border-blue button-little" href='images?method=delete&id=${d.id }'>删除</a>
		   				</td>
		   			</tr>
   			</c:forEach>
   				</table>
   				<div class="panel-foot text-center">
					<ul class="pagination">
						<li><a>共${count}条轮播图信息，当前第${currpage}/${totalpage}页</a></li>
					</ul>
					<ul class="pagination">
						<li><a href="images?method=list&currpage=1">首页</a></li>
					</ul>
					<ul class="pagination">
						<li><a href="images?method=list&currpage=${currpage-1}">上一页</a>  </li>
					</ul>
					<ul class="pagination">
						
							<c:forEach var="i" begin="1" end="${totalpage}" step="1">
			   					<li><a href='images?method=list&currpage=${i}'>${i} </a></li>
			   				</c:forEach>
						
					</ul>
					<ul class="pagination">
						<li><a href="images?method=list&currpage=${currpage+1}">下一页</a></li>
					</ul>
					<ul class="pagination">
						<li><a href="images?method=list&currpage=${totalpage}">末页</a> </li>
					</ul>
					
				</div>
			</div>
		</form>
	</body>
</html>