<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>List of Books</title>
</head>
<body>
	<h2>List of Books</h2>
	<a href="/book/new">New</a>
	<table border=1>
		<thead>
			<tr>
				<th>Id</th>
				<th>BookType</th>
				<th>Name</th>
				<th>Author</th>
				<th>PublishedDate</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${page.getContent()}" var="book">
				<tr>
					<td>${book.bookId}</td>
					<td>${book.type}</td>
					<td>${book.name}</td>
					<td>${book.author}</td>
					<td><fmt:formatDate var="publishedDate"
							value="${book.publishedDate}" pattern="dd/MM/yyyy" />
						${publishedDate}</td>
					<td>${book.quantity}</td>
					<td>${book.price}</td>
					<td><a href="/book/${book.bookId}">Detail</a> <a
						href="/book/delete/${book.bookId}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:if test="${page.getNumber() > 0 }">
		<a href="/book/pagination?currentPage=${page.getNumber()}">Prev</a>
	</c:if>
	<p>Current page: ${page.getNumber() + 1}</p>
	<p>Total pages: ${page.getTotalPages()}</p>
	<c:if test="${page.getNumber() + 1 < page.getTotalPages() }">
		<a href="/book/pagination?currentPage=${page.getNumber() + 2}">Next</a>
	</c:if>
</body>
</html>