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
 	<script src="uploadPreview.js" ></script>
	<script>
       window.onload = function () { 
            new uploadPreview({ UpBtn: "up_img", DivShow: "imgdiv", ImgShow: "imgShow" });
        }
    </script>
    
    <!-- 日期插件 -->
       <script language="javascript" src="js/YMDClass.js"></script>
    
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
    width: 400px;
}
#input2{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 400px;
}
#input3{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 400px;
}
#input4{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 400px;
}
#input5{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 400px;
}
#input6{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 400px;
}
#input7{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 400px;
}
#input8{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 400px;
}
#input9{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 400px;
}
#input10{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 400px;
}
#input11{
	border: 1px solid #C3CED9;
    border-radius: 5px 5px 5px 5px;
    font-size: 14px;
    height: 25px;
    line-height: 31px;
    margin-right: 10px;
    padding: 0;
    width: 400px;
}
 #imgdiv {
  position: absolute;
  left: 240px;
  top: 180px;
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
		var c=document.getElementsByName("time")[0].value;
		if(c.length==0){
			document.getElementById("s3").style.display="";
		}else if(c.length!=0){
			document.getElementById("s3").style.display="none";
		}
	}		
	
		function d(i){
		var d=document.getElementsByName("sztime")[0].value;
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
		var g=document.getElementsByName("didian")[0].value;
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
		var j=document.getElementsByName("shuoming")[0].value;
		if(j.length==0){
			document.getElementById("s10").style.display="";
		}else if(j.length!=0){
			document.getElementById("s10").style.display="none";
		}
	}		
	
		function k(i){
		var k=document.getElementsByName("shifuo")[0].value;
		if(k.length==0){
			document.getElementById("s11").style.display="";
		}else if(k.length!=0){
			document.getElementById("s11").style.display="none";
		}
	}		
	
	function l(i){
		var l=document.getElementsByName("biaoti")[0].value;
		if(l.length==0){
			document.getElementById("s12").style.display="";
		}else if(l.length!=0){
			document.getElementById("s12").style.display="none";
		}
	}	
	
	function show(){
		$.ajax({ 
		    url: "user?method=user_register", 
   			type:'POST',
			data:{
			        phone:a
			},
   			success: function(data){
				if(data.trim() !="${flag}"){  
					document.getElementById("a3").style.display="";
				}else{
				}
			}
    	});
	}
		
	function fabu(){
		var a=document.getElementsByName("username")[0].value;
		var e=document.getElementsByName("guanxi")[0].value;
		var f=document.getElementsByName("jiguan")[0].value;
		var g=document.getElementsByName("didian")[0].value;
		var h=document.getElementsByName("tez")[0].value;
		var i=document.getElementsByName("jingguo")[0].value;
		var j=document.getElementsByName("shuoming")[0].value;
		var l=document.getElementsByName("biaoti")[0].value;
		if(a.length!=0&&e.length!=0&&f.length!=0&&g.length!=0&&h.length!=0&&i.length!=0&&j.length!=0&&l.length!=0){
			this.form.action="details?method=add";
			this.form.submit();			
		}else {
		   alert("不允许有空！");
		}
	}	
			
</script>
</head>
<body>
  	<%@ include file="include/head.jsp"%>
  	<form  id="form" method="post" enctype="multipart/form-data">
  	<div id="imgdiv" >
  		<img id="imgShow" src="" width="150" height="150" id="img"/><br>
  		<input type="file" id="up_img" name="photo"/>
  	</div>
  	
    
    
	<table align="center">
		<tr>
			<td align="left" style="color:red">标题:</td>
			<td><input type="text" name="biaoti" id="input11" onblur="l(this)"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><span style="display:none;color:red"  id="s12">*好的标题是寻找的希望，确认不填吗？</span></td>
		</tr>
		<tr>
			<td align="left">姓名:</td>
			<td>
				<input type="text" name="username" id="input1"  onBlur="a(this)" />
				<input type="hidden" name="issuer" value="${sessionScope.userinfo[0].username }" />
				<input type="hidden" name="audit" value="待审" />
				<input type="hidden" name="shifuo" value="否" />
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><span style="display:none;color:red"  id="s1">*姓名不能为空</span></td>
		</tr>
		<tr>
			<td align="left">性别:</td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name="sex" value="女"/>女
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="radio" name="sex"" value="男" checked="checked"/>男</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><span style="display:none;color:red"  id="s2">*性别不能为空</span></td>
		</tr>
		<tr>
			<td align="left">出生时间:</td>
			<td>
				<select name="year1"></select>
				<select name="month1"></select>
				<select name="day1"></select>
				<script>
					new YMDselect('year1','month1','day1');	
				</script>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><span style="display:none;color:red"  id="s3">*出生时间不能为空</span></td>
		</tr>
		<tr>
			<td align="left">失踪时间:</td>
			<td>
				<select name="year2"></select>
				<select name="month2"></select>
				<select name="day2"></select>
				<script>
					new YMDselect('year2','month2','day2');	
				</script>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><span style="display:none;color:red"  id="s4">*失踪时间不能为空</span></td>
		</tr>
		<tr>
			<td align="left">与失踪人关系:</td>
			<td><input type="text" name="guanxi" id="input5" onblur="e(this)"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><span style="display:none;color:red"  id="s5">*与失踪人关系不能为空</span></td>
		</tr>
		<tr>
			<td align="left">失踪人籍贯:</td>
			<td><input type="text" name="jiguan" id="input6" onblur="f(this)"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><span style="display:none;color:red"  id="s6">*失踪人籍贯不能为空</span></td>
		</tr>
		<tr>
			<td align="left">失踪地点:</td>
			<td><input type="text" name="didian" id="input7" onblur="g(this)"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><span style="display:none;color:red"  id="s7">*失踪地点不能为空</span></td>
		</tr>
		<tr>
			<td align="left">失踪人特征:</td>
			<td><input type="text" name="tez" id="input8" onblur="h(this)"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><span style="display:none;color:red"  id="s8">*失踪人特征不能为空</span></td>
		</tr>
		<tr>
			<td align="left">失踪经过:</td>
			<td><input type="text" name="jingguo" id="input9" onblur="i(this)"/></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><span style="display:none;color:red"  id="s9">*失踪经过不能为空</span></td>
		</tr>
		<tr>
			<td align="left">补充说明:</td>
			<td><textarea rows="3" name="shuoming" cols="50"  onblur="j(this)"/></textarea></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><span style="display:none;color:red"  id="s10">*补充说明不能为空</span></td>
		</tr>
		<tr>
			<td align="center" colspan="2"><input type="button" value="发布" onclick="fabu();">
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset"></td>
		</tr>
		
	</table>
	</form>
     <%@ include file="include/tail.jsp"%>
  </body>
</html>
