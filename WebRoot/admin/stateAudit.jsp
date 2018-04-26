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
				<div class="panel-head"><strong>审核列表</strong>
				</div>
				<div class="padding border-bottom">
				</div>
					<table class="table table-hover">
					<tr>
						<th width="150">ID</th>
						<th width="150">发布人</th>
						<th width="150">寻找</th>
						<th width="*">标题</th>	
						<th width="180">时间</th>						
						<th width="150">操作</th>
					</tr>
				<c:forEach items="${list}" var="d">
		   			<tr  style='background: white'>
		   				<td>${d.id}</td>
		   				<td>${d.issuer}</td>
		   				<td>${d.name}</td>
		   				<td>${d.headline}</td>
		   				<td>${d.times}</td>
		   				<td >
		   					<a class="button border-blue button-little" href='details?method=details_personal&&id=${d.id}'>详情</a>
		   					<a class="button border-green button-little" href='details?method=pass&id=${d.id}'>通过</a> 
		   					<a class="button border-red button-little" href='details?method=recall&id=${d.id}'>撤回</a>  
		   				</td>
		   			</tr>
   			</c:forEach>
   				</table>
   				<div class="panel-foot text-center">
					<ul class="pagination">
						<li><a>共${count}条审核信息，当前第${currpage}/${totalpage}页</a></li>
					</ul>
					<ul class="pagination">
						<li><a href="details?method=checkpending&currpage=1">首页</a></li>
					</ul>
					<ul class="pagination">
						<li><a href="details?method=checkpending&currpage=${currpage-1}">上一页</a>  </li>
					</ul>
					<ul class="pagination">
						<li>
							<c:forEach var="i" begin="1" end="${totalpage}" step="1">
			   					<a href='details?method=checkpending&currpage=${i}'>${i} </a>
			   				</c:forEach>
						</li>
					</ul>
					<ul class="pagination">
						<li><a href="details?method=checkpending&currpage=${currpage+1}">下一页</a></li>
					</ul>
					<ul class="pagination">
						<li><a href="details?method=checkpending&currpage=${totalpage}">末页</a> </li>
					</ul>
					
				</div>
			</div>
		</form>
	</body>
</html>