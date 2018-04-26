<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">


<title>宝贝回家_官网首页</title>
	<link rel="stylesheet" href="css/wx.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script src="js/respond.js"></script>

	<script src="/wx/js/ajax.js"></script>
	
	<!-- 图片上传插件 -->
	 	<script src="uploadPreview.js" ></script>
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
	<style type = "text/css">
#input1{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 240px;
}
#input2{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 240px;
}
#input3{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 240px;
}
#input4{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 240px;
}
#input5{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 240px;
}
#input6{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 240px;
}
#input7{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 240px;
}
#input8{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 240px;
}
#input9{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 240px;
}
#input10{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 240px;
}
 #imgdiv {
  position: absolute;
  left: 300px;
  top: 160px;
	}
</style>
	<script language="JavaScript">
	function a(i){ 
		var a=document.getElementsByName("username")[0].value;
		if(a.length==0){
			document.getElementById("s1").style.display="";
		}else if(a.length!=0){
			document.getElementById("s1").style.display="none";
		}
	}
	function b(i){
		var b=document.getElementsByName("sex")[0].value;
		if(b.length==0){
			document.getElementById("s2").style.display="";
		}else if(b.length!=0){
			document.getElementById("s2").style.display="none";
		}
	}
		function c(i){
		var c=document.getElementsByName("password")[0].value;
		if(c.length==0){
			document.getElementById("s3").style.display="";
		}else if(c.length!=0){
			document.getElementById("s3").style.display="none";
		}
	}		
	
		function d(i){
		var d=document.getElementsByName("phone")[0].value;
		if(d.length==0){
			document.getElementById("s4").style.display="";
		}else if(d.length!=0){
			document.getElementById("s4").style.display="none";
		}
	}		
	
		function e(i){
		var e=document.getElementsByName("guanxi")[0].value;
		if(e.length==0){
			document.getElementById("s5").style.display="";
		}else if(e.length!=0){
			document.getElementById("s5").style.display="none";
		}
	}		
	
		function f(i){
		var f=document.getElementsByName("jiguan")[0].value;
		if(f.length==0){
			document.getElementById("s6").style.display="";
		}else if(f.length!=0){
			document.getElementById("s6").style.display="none";
		}
	}		
	
		function g(i){
		var g=document.getElementsByName("qq")[0].value;
		if(g.length==0){
			document.getElementById("s7").style.display="";
		}else if(g.length!=0){
			document.getElementById("s7").style.display="none";
		}
	}		
	
		function h(i){
		var h=document.getElementsByName("tez")[0].value;
		if(h.length==0){
			document.getElementById("s8").style.display="";
		}else if(h.length!=0){
			document.getElementById("s8").style.display="none";
		}
	}		
	
		function i(i){
		var i=document.getElementsByName("jingguo")[0].value;
		if(i.length==0){
			document.getElementById("s9").style.display="";
		}else if(i.length!=0){
			document.getElementById("s9").style.display="none";
		}
	}		
	
		function j(i){
		var j=document.getElementsByName("sdasd")[0].value;
		if(j.length==0){
			document.getElementById("s10").style.display="";
		}else if(j.length!=0){
			document.getElementById("s10").style.display="none";
		}
	}		
	
		function k(i){
		var k=document.getElementsByName("age")[0].value;
		if(k.length==0){
			document.getElementById("s11").style.display="";
		}else if(k.length!=0){
			document.getElementById("s11").style.display="none";
		}
	}		
	
	      function tijiao() {
        var a=document.getElementsByName("username")[0].value;
        var f=document.getElementsByName("jiguan")[0].value;
        var g=document.getElementsByName("qq")[0].value;
        var j=document.getElementsByName("sdasd")[0].value;
        var k=document.getElementsByName("age")[0].value;
        if(a.length!=0 &&  f.length!=0 && g.length!=0 &&  j.length!=0 && k.length!=0){
			this.form.action="userinfo?method=userinfo_add";
			this.form.submit();			
		}else {
		   alert("不允许有空!");
		}
      }
			
</script>
<script type="text/JavaScript" language="javascript">    
        function FileUpload_onselect()
        {
            var path;
            path=document.forms[0].FileUpload.value;      //C:\Documents and Settings\hud\桌面\AddFile.jpg
            var aa;
            aa=path.split('.');
            document.all('TbxName').value=aa[aa.length-1];  //jpg 结果

            var name;
            name=path.split('\\'); 
            var bb=name[name.length-1];             
            document.all('Tbx_FileName').value=bb.substr(0,bb.indexOf('.'));  //AddFile 结果
        }
    </script>


</head>
<body>
  	<%@ include file="include/head.jsp"%>
  	<h1 align="center">请填写详细资料</h1>
  	<hr>
  	<form  id="form" enctype="multipart/form-data" method="post">
  	<div id="imgdiv" >
  		<img id="imgShow" src="images/h4.jpg" width="150" height="150" id="img"/><br>
  		<input type="file" id="up_img" name="photo"/>
  	</div>
	<table align="center">
	
		<tr>
			<td align="left">用户名:</td>
			<td><input type="text" name="username" id="input1"  onBlur="a(this)" /></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><span style="display:none;color:red"  id="s1">*姓名不能为空</span></td>
		</tr>
		<tr>
			<td align="left">性别:</td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex" value="女"/>女&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="sex"" value="男" checked="checked"/>男</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><span style="display:none;color:red"  id="s2">*性别不能为空</span></td>
		</tr>
		<tr>
			<td align="left">年龄：</td>
			<td><input type="text" name="age" id="input4" onblur="k(this)"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><span style="display:none;color:red"  id="s11">*年龄不能为空</span></td>
		</tr>
		<tr>
			<td align="left">手机号:</td>
			<td><input type="text" name="phone" value="${sessionScope.material.phone }" id="input4" onblur="d(this)" readonly="readonly"/></td>
		</tr>
		<tr>
			<td align="left">密码:</td>
			<td><input type="password" name="password" value="${sessionScope.material.password }" id="input3" onblur="c(this)" readonly="readonly"/></td>
		</tr>
		<tr>
			<td align="left">籍贯:</td>
			<td><input type="text" name="jiguan" id="input6" onblur="f(this)"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><span style="display:none;color:red"  id="s6">*籍贯不能为空</span></td>
		</tr>
		<tr>
			<td align="left">QQ:</td>
			<td><input type="text" name="qq" id="input7" onblur="g(this)"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><span style="display:none;color:red"  id="s7">*QQ不能为空</span></td>
		</tr>
		<tr>
			<td align="left">个性签名:</td>
			<td><textarea rows="5" name="sdasd" cols="30"  onblur="j(this)"/></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><span style="display:none;color:red"  id="s10">*个性签名不能为空</span></td>
		</tr>
		<tr>
			<td align="center" colspan="2"><input type="button" value="确定" onclick="tijiao();">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset"></td>
		</tr>
	</table>
	</form>
     <%@ include file="include/tail.jsp"%>
  </body>
</html>
