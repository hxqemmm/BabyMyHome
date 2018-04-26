<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">


<title>宝贝回家_官网首页</title>
<!--pintu.css--><link rel="stylesheet" href="css/wx.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script src="js/respond.js"></script>
<!--main.css-->
<script src="/wx/js/ajax.js"></script>
<script>
function killErrors(){
return true;
}
window.onerror = killErrors;
</script>
<link rel="stylesheet" href="css/main.css">
<link type="image/x-icon" href="/wx/js/qqb.ico" rel="shortcut icon" />
<link href="/wx/js/qqb.ico" rel="bookmark icon" />
	<style type = "text/css">
		body{
			background-color:#ffffff	
		}
		#input{
			border: 1px solid #C3CED9;
            border-radius: 5px 5px 5px 5px;
            font-size: 14px;
            height: 25px;
            line-height: 31px;
            margin-right: 10px;
            padding: 0;
            width: 200px;
		}
		
		#box_relative {
  position: absolute;
  left: 130px;
  top: 80px;
	}
</style>
</head>
<body>
  	<div  id="box_relative"><img src="${details[0].photo } " width="150" height="200" alt="" /></div>
	<table align="center">
	
		<tr>
			<td align="left">姓名:</td>
			<td><input type="text" id="input" value="${details[0].name}" readonly="true"/></td>
		</tr>
		<tr>
			<td align="left">性别:</td>
			<td><input type="text" id="input" value="${details[0].sex}" readonly="true"/></td>
		</tr>
		<tr>
			<td align="left">出生时间:</td>
			<td><input type="text" id="input" value="${details[0].birthday}" readonly="true"/></td>
		</tr>
		<tr>
			<td align="left">失踪时间:</td>
			<td><input type="text" id="input" value="${details[0].missday}" readonly="true"/></td>
		</tr>
		<tr>
			<td align="left">与失踪人关系:</td>
			<td><input type="text" id="input" value="${details[0].relation}" readonly="true"/></td>
		</tr>
		<tr>
			<td align="left">失踪人籍贯:</td>
			<td><input type="text" id="input" value="${details[0].natives}" readonly="true"/></td>
		</tr>
		<tr>
			<td align="left">失踪地点:</td>
			<td><input type="text" id="input" value="${details[0].place}" readonly="true"/></td>
		</tr>
		<tr>
			<td align="left">失踪人特征:</td>
			<td><input type="text" id="input" value="${details[0].feature}" readonly="true"/></td>
		</tr>
		<tr>
			<td align="left">失踪经过:</td>
			<td><input type="text" id="input" value="${details[0].pass}" readonly="true"/></td>
		</tr>
		<tr>
			<td align="left">补充说明:</td>
			<td><input type="text" id="input" value="${details[0].replenish}" readonly="true"/></td>
		</tr>
		<tr>
			<td align="left">是否找回:</td>
			<td><input type="text" id="input" value="${details[0].state}" readonly="true"/></td>
		</tr>
	</table>
  </body>
</html>
