<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%
	Integer counter = new Integer(1);  
	if(application.getAttribute("counter")==null){
		application.setAttribute("counter", counter);
	}else{
		counter=(Integer) application.getAttribute("counter");
		application.setAttribute("counter", new Integer(counter.intValue()+1));
	}
	out.println(application.getAttribute("counter"));
%>




