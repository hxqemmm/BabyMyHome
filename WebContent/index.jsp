<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
	<title>宝贝回家_官网首页</title>
		<link rel="stylesheet" href="css/wx.css">
	    <script src="js/jquery.js"></script>
	    <script src="js/pintuer.js"></script>
	    <script src="js/respond.js"></script>

	<script>
	function killErrors(){
	return true;
	}
	window.onerror = killErrors;
	</script>

	<link rel="stylesheet" href="css/main.css">
</head>
	<body>
	
	
	<%@ include file="include/head.jsp"%>
	<span id="weather"></span>
    <!--banner-->
    <div class="banner" data-style="border-white">
      <div class="carousel">
		<center>
			<c:forEach items="${index}" var="i">
				<div class="item"><img src="${i.url}" width="90%" id="1"/></div>
	   		</c:forEach>
		</center>
      </div>
    </div>
  	<br />

    <div class="container">
      <div class="line-small  hidden-l">
        <c:forEach items="${record}" var="r">
			<div class="xl6 xm2"><a href="details?method=details&id=${r.id}"><img src="${r.photo }"  width="100%" height="200px" /></a></div>
	   	</c:forEach>
      </div>

      <div class="line-big">
        <div class="xl12 xm8">
        	<div class="line-small">
                <div class="xs6">
             	<h2 class="bg-blue text-white padding-small"><a href="uploading.jsp">寻找失踪宝贝</a></h2>
             	<c:forEach items="${drop}" var="d">
					 <li>● <a href="details?method=details&id=${d.id}">${d.headline }</a></li>
	   			</c:forEach>
                </div>
                <div class="xs6">
              	<h2 class="bg-blue text-white padding-small"><a href="index">已找回宝贝</a></h2>
              	<c:forEach items="${recoverd}" var="r">
					<li>● <a href="details?method=details&id=${r.id}">${r.headline }</a></li>
	   			</c:forEach>
                </div>
            </div>
        </div>
      	<div class="xl12 xm4">
            <h2 class="bg-blue text-white padding-small"><a href="tops?method=tops">公告</a></h2>
            <c:forEach items="${tops}" var="t">
              	<li>● <a href="tops?method=topsid&id=${t.id}">${t.body}----管理员：${t.username}</a></li>	
	   		</c:forEach>
		</div>
      </div>
    </div>
  
	<%@ include file="include/tail.jsp"%>
	</body>
</html>

