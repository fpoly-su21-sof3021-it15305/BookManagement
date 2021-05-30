<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>List of Books</title>
    </head>
    <body>
    	<h2>List of Books</h2> <a href="/book/new">New</a>
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
                <c:forEach items="${books}" var="book">
                    <tr>
                        <td>${book.id}</td>
                        <td>${book.type}</td>
                        <td>${book.name}</td>
                        <td>${book.author}</td>
                        <td>
                        	<fmt:formatDate var="publishedDate"
								value="${book.publishedDate}"
								pattern="dd/MM/yyyy"/>
							${publishedDate}
						</td>
                        <td>${book.quantity}</td>
                        <td>${book.price}</td>
                        <td>
                        	<a href="/book/${book.id}">Detail</a>
                        	<a href="/book/delete/${book.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>