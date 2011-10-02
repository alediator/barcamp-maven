<%@page import="com.emergya.barcamp2011.HelloWorld"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%  
	String name = HelloWorld.showHello();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	<!--
	function nameForm(name){
		document.getElementById('name').innerHTML = name;
	}
	-->
</script>
<style type="text/css">

	#name{
		font-weight: bolder;
	}

</style>
</head>
<body>

	<div>Hello <span id="name"><%= name%></span></div>
	
	<form action="javascript:nameForm(document.getElementById('nameForm').value)">
		<label for="name">Name</label>
		<input type="text" id="nameForm" name="name" value="<%= name%>"/>
		<input type="submit" value="Enviar">
	</form>
	
</body>
</html>