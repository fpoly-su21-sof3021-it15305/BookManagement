<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<title>Book Detail</title>
</head>
<body>
	<a href="/book">Back to List</a>
	<h2>Detail of Book - ${book.id}</h2>
	<form:form method="PUT" action="/book/update" modelAttribute="book">
		<table>
			<form:input type="hidden" path="id" value="${book.id}" />
			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" value="${book.name}" /></td>
			</tr>
			<tr>
				<td><form:label path="author">Author</form:label></td>
				<td><form:input path="author" value="${book.author}" /></td>
			</tr>

			<tr>
				<td><form:label path="type">Type</form:label></td>
				<td><form:select path="type" items="${bookTypes}"/></td>
			</tr>

			<tr>
				<td><form:label path="publishedDate">Published Date</form:label></td>
				<td>
					<fmt:formatDate var="publishedDate"
								value="${book.publishedDate}"
								pattern="yyyy-MM-dd"/>
					<form:input path="publishedDate" type="date"
						value="${publishedDate}" />
				</td>
			</tr>

			<tr>
				<td><form:label path="quantity">Quantity</form:label></td>
				<td><form:input path="quantity" type="number"
						value="${book.quantity}" /></td>
			</tr>
			<tr>
				<td><form:label path="price">Price</form:label></td>
				<td><form:input path="price" type="number"
						value="${book.price}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>