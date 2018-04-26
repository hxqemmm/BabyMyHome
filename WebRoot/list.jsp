<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.ht.bean.Details" %>


<html>
<link rel="stylesheet" href="css/xw.css">
  <head>
<title>列表</title>

	<script type="text/javascript">
    	function goPage(){
    		var c = document.getElementById("currpage").value;
    		if(!isNaN(c)){
    			location.href = "details?method=list&name=${param.name}&currpage="+c;
    		}
    	}s
    </script>  
 </head>
 
  <body>
  	  	<%@ include file="include/head.jsp"%>
  			<h2 align="center" style="color:red">学生列表</h2>
   		<hr>
   		<table  width="70%" align="center" border="0" cellspacing="1" style="background: #00ff00">
   			<tr>
   				<th>ID</th>
	   			<th>姓名</th>  
	   			<th>性别</th>
	   			<th>生日</th>
	   			<th>失踪地点</th>
	   			<th>失踪时间</th>
	   			<th>特征</th>
   			</tr>
	
		<c:forEach items="${list}" var="d">
   			<tr align='center' style='background: white'>
   				<td>${d.id}</td>
   				<td>${d.name}</td>
   				<td>${d.sex}</td>
   				<td>${d.birthday}</td>
   				<td>${d.place}</td>
   				<td>${d.missday}</td>
   				<td>${d.feature}</td>
   				<td align='center'>
   					<a href='details?method=details&&id=${d.id}'>详情</a> 
   				</td>
   			</tr>
   		</c:forEach>
			<tr style='background: white'>
	   			<td colspan="8" align="center">
					共${count}条数据，当前第${currpage}/${totalpage}页
  					<a href="details?method=list&name=${param.name}&currpage=1">首页</a>
	   				<a href="details?method=list&name=${param.name}&currpage=${currpage-1}">上一页</a>  
	   				<c:forEach var="i" begin="1" end="${totalpage}" step="1">
	   					<a href='details?method=list&name=${param.name}&currpage=${i}'>${i} </a>
	   				</c:forEach>
	   				<a href="details?method=list&name=${param.name}&currpage=${currpage+1}">下一页</a> 
	   				<a href="details?method=list&name=${param.name}&currpage=${totalpage}">末页</a> 
  					<input type="text" size="2" id="currpage" value="${currpage}"/>  
   					<input type="button" value="Go" onclick="goPage();"/>
	   			</td>
   			</tr>  	
   		</table>
 			  <%@ include file="include/tail.jsp"%>
  </body>
</html>
