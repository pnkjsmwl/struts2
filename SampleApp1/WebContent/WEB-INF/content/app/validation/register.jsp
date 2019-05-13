<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- Using Struts2 Tags in JSP --%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Register Page</title>
</head>
<body>
	<h3>Welcome !! Please register below</h3>
	<s:form action="register">
		<s:textfield name="name" label="Your Name"></s:textfield>
		<s:textfield name="username" label="Select user name"></s:textfield>
		<s:textfield name="pwd" label="Password" type="password"></s:textfield>
		<s:select label="Select Role" list="roles" headerKey="-1" headerValue="Select" name="selectedRole" />
		<s:submit value="register"></s:submit>
	</s:form>
</body>
</html>