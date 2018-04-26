<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
  <head>
  		<!-- 编辑器引入 -->
 		 <link href="themes/default/css/umeditor.css" type="text/css" rel="stylesheet">
		<script type="text/javascript" src="third-party/jquery.min.js"></script>
		<script type="text/javascript" src="third-party/template.min.js"></script>
		<script type="text/javascript" charset="utf-8" src="umeditor.config.js"></script>
		<script type="text/javascript" charset="utf-8" src="umeditor.min.js"></script>
		<script type="text/javascript" src="lang/zh-cn/zh-cn.js"></script>  
  
  <style type = "text/css">
	#input{
		border: 1px solid #C3CED9;
	    border-radius: 5px 5px 5px 5px;
	    font-size: 14px;
	    height: 25px;
	    line-height: 31px;
	    margin-right: 10px;
	    padding: 0;
	    width: 400px;
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
		var b=document.getElementsByName("contact way")[0].value;
		if(b.length==0){
			document.getElementById("s2").style.display="";
		}else if(b.length!=0){
			document.getElementById("s2").style.display="none";
		}
	}
	function c(i){ 
		var c=document.getElementsByName("tickling")[0].value;
		if(c.length==0){
			document.getElementById("s3").style.display="";
		}else if(c.length!=0){
			document.getElementById("s3").style.display="none";
		}
	}

    }
  </script>
  </head>
  
    <%@ include file="include/head.jsp"%>
  <body>
  <h1 align="center">反馈内容</h1>
  <hr>
    <form action="tickling?method=add" method="post">
    	<table align="center">
    		<tr>
    			<td>反馈人姓名:</td>
    			<td>
    				<input type="text" id="input" name="username" value="${sessionScope.userinfo[0].username }" onblur="a(this)">
    			</td>
    		</tr>
    		<tr>
				<td colspan="2" align="center"><span style="display:none;color:red"  id="s1">*反馈人姓名不能为空</span></td>
			</tr>   		
    		<tr>
    			<td>联系方式:</td>
    			<td>
    				<input type="text" id="input" name="phone" value="${sessionScope.userinfo[0].phone }" onBlur="b(this)">
    			</td>
    		</tr> 
    		<tr>
				<td colspan="2" align="center"><span style="display:none;color:red"  id="s2">*联系方式不能为空</span></td>
			</tr>   		
    		<tr>
    			<td>反馈内容:</td>
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
				<td colspan="2" align="center"><span style="display:none;color:red"  id="s3">*反馈内容不能为空</span></td>
			</tr>   		    		
    		<tr>
    			<td colspan="2" align="center">
    			<input type="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    			<input type="reset"></td>
    		</tr>
    		
    	</table>
    </form>
    <%@ include file="include/tail.jsp"%>
  </body>
</html>
