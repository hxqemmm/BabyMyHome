<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	 <link type="image/x-icon" href="/wx/js/qqb.ico" rel="shortcut icon" />
  	<!-- 编辑器引入 -->
 		 <link href="themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
		<script type="text/javascript" src="third-party/jquery.min.js"></script>
		<script type="text/javascript" src="third-party/template.min.js"></script>
		<script type="text/javascript" charset="utf-8" src="umeditor.config.js"></script>
		<script type="text/javascript" charset="utf-8" src="umeditor.min.js"></script>
		<script type="text/javascript" src="lang/zh-cn/zh-cn.js"></script>  
  	
  
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
  	<script language="JavaScript">
	function c(i){ 
		var c=document.getElementsByName("tickling")[0].value;
		if(c.length==0){
			document.getElementById("s3").style.display="";
		}else if(c.length!=0){
			document.getElementById("s3").style.display="none";
		}
	}

  </script>
  </head>
  
  <body background="http://localhost:8080/BabyMyHome/images/bg.jpg">
  <h1 align="center">公告内容</h1>
  <hr>
    <form action="../tops?method=add" method="post">
    	<table align="center">
			<tr>
    			<td>公告内容:
    				<input type="hidden" name="id" value="${sessionScope.admins[0].id}"> 
    				<input type="hidden" name="username" value="${sessionScope.admins[0].username}"> 
    			</td>
    				<script type="text/plain" id="myEditor" style="width:450px;height:150px;">
						<p>请输入要反馈的内容</p>
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
    		<tr>
				<td colspan="2" align="center"><span style="display:none;color:red"  id="s3">*内容不能为空</span></td>
			</tr>   		    		
    		<tr>
    			<td colspan="2" align="center"><input type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="reset"></td>
    		</tr>
    		
    	</table>
    </form>
  </body>
</html>
