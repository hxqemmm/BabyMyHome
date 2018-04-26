<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="zh-CN" xmlns="http://www.w3.org/1999/xhtml">
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
	
	<!-- 图片上传插件 -->
 	<script src="../uploadPreview.js" ></script>
	<script>
       window.onload = function () { 
            new uploadPreview({ UpBtn: "up_img", DivShow: "imgdiv", ImgShow: "imgShow" });
        }
    </script>
    
    <script>
		function killErrors(){
			return true;
		}
		window.onerror = killErrors;
	</script>
	<link rel="stylesheet" href="css/main.css">
	<link rel="stylesheet" type="text/css" href="input.css"/>
	<link type="image/x-icon" href="/wx/js/qqb.ico" rel="shortcut icon" />
	<link href="/wx/js/qqb.ico" rel="bookmark icon" />
</head>
<body>
  	<form action="../images?method=add"  name="form" method="post" enctype="multipart/form-data">
  	<div id="imgdiv" >
  		<input type="file" id="up_img" name="photo"/>
  		<input type="submit" value="确定"/>
  		<input type="reset" value="取消"/>
  	</div>
   <div class="banner">
      <div class="carousel">
       	 	<div class="item"><img id="imgShow" src="" width="90%"  id="img"/><br></div>
      </div>
    </div>
  	<br />
  	
	</form>
  </body>
</html>
