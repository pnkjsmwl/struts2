<%@ page language="java" contentType="text/html; charset=US-ASCII"
	pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Dracarys</title>
</head>
<body>
	<h4>Welcome to QuickBuy</h4>
	<hr>
	<table>
	<caption><b>Inventory</b></caption>
		<tr>
			<th align="left">Name</th>
			<th align="left">Description</th>
			<th align="left">Price</th>
			<th align="left">Available Count</th>
		</tr>
		<s:iterator value="products" var="prod">
			<tr>
				<td><s:property value="%{#prod.name}" /></td>
				<td><s:property value="%{#prod.description}" /></td>
				<td><s:property value="%{#prod.price}" /></td>
				<td><s:property value="%{#prod.availableCount}" /></td>
			</tr>
		</s:iterator>
	</table>
	<%-- <a href="<s:url namespace='/app/validation' action='login'/>">Login here.(here directly calling 'login' action)</a> --%>
	<hr>
	<s:include value="/WEB-INF/content/app/validation/login.jsp"></s:include>
	<%-- <h2>
		<s:select label="What's your favor search engine" headerKey="-1"
			headerValue="Select Search Engines" list="searchEngine"
			name="yourSearchEngine" value="defaultSearchEngine" />
	</h2> --%>
</body>
</html>