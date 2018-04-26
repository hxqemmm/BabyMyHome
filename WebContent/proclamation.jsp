<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
  	<!-- 编辑器引入 -->
 		 <link href="themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
		<script type="text/javascript" src="third-party/jquery.min.js"></script>
		<script type="text/javascript" src="third-party/template.min.js"></script>
		<script type="text/javascript" charset="utf-8" src="umeditor.config.js"></script>
		<script type="text/javascript" charset="utf-8" src="umeditor.min.js"></script>
		<script type="text/javascript" src="lang/zh-cn/zh-cn.js"></script>  
  <link type="image/x-icon" href="/wx/js/qqb.ico" rel="shortcut icon" />
  <style type = "text/css">
textarea {
	-moz-border-radius:4px;
	-webkit-border-radius:4px;
	-o-border-radius:4px;
	border-radius:4px;
	border:none;
	font-size:11px;
	padding:10px;
}
input[type="text"],
textarea {
	border:1px solid #d4d4d4;
}
  </style>
  </head>
  
  <body background="images/bg.jpg">
  <h1 align="center">公告内容</h1>
  <hr>
    <form action="../tops?method=add" method="post">
    	<table align="center">
    		<br><br><br><br><br><br>
    		<tr>
    			<td>发布人:</td>
    			<td><input type="text" value="${sessionScope.tops[0].username }" readonly></td>
    		</tr>
    		<tr>
    			<td>发布时间:</td>
    			<td><input type="text" value="${sessionScope.tops[0].time }" readonly></td>
    		</tr>
			<tr>
    			<td>公告内容:</td>
    			<script type="text/plain" id="myEditor" style="width:450px;height:150px;">
					<p>${sessionScope.tops[0].body }</p>
				</script>
				<div>
					<h3 id="focush2"></h3>
				</div>
				<script type="text/javascript">
					//实例化编辑器
					var um = UM.getEditor('myEditor');
					 um.addListener('focus',function(){
				        $('#focush2').html('')
				    });
				</script>
    			
    		</tr>
    	</table>
    </form>
  </body>
</html>
