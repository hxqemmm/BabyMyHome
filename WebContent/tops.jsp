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
		<script src="js/admin.js"></script>  
		<link type="../image/x-icon" href="images/favicon.ico" rel="shortcut icon" />
		<link href="../images/favicon.ico" rel="bookmark icon" />
		
		<script type="text/JavaScript">
			function goPage(){
    		 var c = document.getElementById("currPage").value;
    		location.href = "tops?method=tops&currpage="+c;
    	}
		</script>
	</head>
	
	<body>
			<form method="post">
				<div class="panel admin-panel">
					<div class="panel-head"><strong>公告列表</strong></div>
					<table class="table table-hover">
						<tr>
							<th width="180">发布人</th>
							<th width="*">内容</th>
							<th width="180">时间</th>
							<th width="180">操作</th>
						</tr>
						<c:forEach items="${list}" var="a">
			   			<tr  style='background: white'>
			   				<td>${a.username}</td>
			   				<td>${a.body}</td>
			   				<td>${a.time}</td>
			   				<td>
				   				<a class="button border-yellow button-little" href="tops?method=topsid&id=${a.id}">详情</a>
			   				</td>
			   			</tr>
 					</c:forEach>
					</table>
					<div class="panel-foot text-center">
					<ul class="pagination">
						<li><a>共${count}条公告，当前第${currpage}/${totalpage}页</a></li>
					</ul>
					<ul class="pagination">
						<li><a href="tops?method=tops&currpage=1">首页</a></li>
					</ul>
					<ul class="pagination">
						<li><a href="tops?method=tops&currpage=${currpage-1}">上一页</a>  </li>
					</ul>
					<ul class="pagination">
						<c:forEach var="i" begin="1" end="${totalpage}" step="1">
		   					<li><a href='tops?method=tops&currpage=${i}'>${i} </a></li>
		   				</c:forEach>
					</ul>
					<ul class="pagination">
						<li><a href="tops?method=tops&currpage=${currpage+1}">下一页</a></li>
					</ul>
					<ul class="pagination">
						<li><a href="tops?method=tops&currpage=${totalpage}">末页</a> </li>
					</ul>
					<ul class="pagination">
						<li>
							<input type="text" size="2" id="currpage" value="${currpage}"/>  
						</li>
						<li>
		   					<input type="button" value="Go" onclick="goPage();"/>
						</li>
					</ul>
				</div>
				</div>
			</form>
	</body>

</html>