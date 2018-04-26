<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.ht.bean.*"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="css/xw.css">
<title>个人中心</title>
<!-- Styles -->
<link rel="stylesheet" href="css/style.css" media="screen">
<link rel="stylesheet" href="css/style_blue.css" media="screen">
<link rel="stylesheet" href="css/nivo-slider.css" media="screen">
<link rel="stylesheet" href="css/jquery.fancybox-1.3.4.css" media="screen">
<link href='css/com.css?family=Cabin:400,500,600,700' rel='stylesheet'>
<link href='css/co.css?family=Oswald' rel='stylesheet'>
<link rel="shortcut icon" type="image/x-icon" href="assets/img/skin_blue/favicon.ico">
<!-- Scripts -->
<script src="js/min.js"></script>
<script src="js/jquery.nivo.slider.pack.js"></script>
<script src="js/jquery.fancybox-1.3.4.pack.js"></script>
<script src="js/jquery.cycle.all.js"></script>
<script src="js/custom.js"></script>
  <style type = "text/css">
	#input{
		border: 1px solid #C3CED9;
	    border-radius: 5px 5px 5px 5px;
	    font-size: 14px;
	    height: 25px;
	    line-height: 31px;
	    margin-right: 10px;
	    padding: 0;
	    width: 270px;
	}
  </style>

</head>

<body>
	
        <div class="row group" align="center">
        	<h1>个人中心</h1>  
        	<hr>         
            <div id="testimonials"> 
				<blockquote>
	            	<div class="testimonial-avatar"><img src="${sessionScope.userinfo[0].headimage}" alt="" /></div><!-- END testimonial-avatar -->
					<cite><h2>我的资料:</h2></cite>
					<br>
				<table align="center">
					<tr  align="left" >
						<td align="left">用户名:</td>
						<td><input type="text" name="username" value="${sessionScope.userinfo[0].username}" id="input" readonly="readonly"/></td>
					</tr>
					<tr>
						<td align="left">性别:</td>
						<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sex" value="女" disabled="disabled" 
							<c:if test="${sessionScope.userinfo[0].sex eq '女'}">checked</c:if>
						/>女
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="radio" name="sex"" value="男"  disabled="disabled"
							<c:if test="${sessionScope.userinfo[0].sex eq '男'}">checked</c:if>
						/>男</td>
					</tr>
					<tr>
						<td align="left">年龄:</td>
						<td><input type="text" name="age" value="${sessionScope.userinfo[0].age}" id="input"readonly="readonly"/></td>
					</tr>
					<tr>
						<td align="left">手机号:</td>
						<td><input type="text" name="phone" value="${sessionScope.userinfo[0].phone}" id="input"readonly="readonly"/></td>
					</tr>
					<tr>
						<td align="left">密码:</td>
						<td><input type="text"  name="time" value="${sessionScope.userinfo[0].password}" id="input"readonly="readonly"/></td>
					</tr>
					<tr>
						<td align="left">籍贯:</td>
						<td><input type="text" name="jiguan" id="input" value="${sessionScope.userinfo[0].natives}" readonly="readonly"/></td>
					</tr>
					<tr>
						<td align="left">QQ:</td>
						<td><input type="text" name="qq" value="${sessionScope.userinfo[0].QQ}" id="input" readonly="readonly"/></td>
					</tr>
					<tr>
						<td align="left">个性签名:</td>
						<td><textarea rows="3" name="shuoming"  cols="32" readonly="readonly"/>${sessionScope.userinfo[0].sdasd}</textarea></td>
					</tr>
				</table>
			</blockquote>		 		
</body>
</html>