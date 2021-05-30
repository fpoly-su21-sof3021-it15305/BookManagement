<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>New Book</title>
</head>
<body>
	<a href="/book">Back to List</a>
	<h2>Add a new Book</h2>
	<form:form method="POST" 
		action="/book/insert" modelAttribute="book">
		<table>
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name"/></td>
			</tr>
			<tr>
				<td><form:label path="author">Author</form:label></td>
				<td><form:input path="author"/></td>
			</tr>

			<tr>
				<td><form:label path="type">Type</form:label></td>
				<td><form:select path="type" items="${bookTypes}"/></td>
			</tr>

			<tr>
				<td><form:label path="publishedDate">Published Date</form:label></td>
				<td><form:input path="publishedDate" type="date"/></td>
			</tr>

			<tr>
				<td><form:label path="quantity">Quantity</form:label></td>
				<td><form:input path="quantity" type="number"/></td>
			</tr>
			<tr>
				<td><form:label path="price">Price</form:label></td>
				<td><form:input path="price" type="number"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Insert" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>