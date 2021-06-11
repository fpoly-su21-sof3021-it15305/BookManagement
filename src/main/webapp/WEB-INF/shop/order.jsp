<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Order Info</title>
</head>
<body>
	<h2>Order Info ${order.orderId}</h2>
	<p>${order.createdDate}</p>
	<a href="/shop">back</a>
	<table border=1>
		<thead>
			<tr>
				<th>Book Id</th>
				<th>Quantity</th>
				<th>Price</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${order.orderDetails}" var="orderDetail">
				<tr>
					<td>${orderDetail.book.bookId}</td>
					<td>${orderDetail.quantity}</td>
					<td>${orderDetail.price}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>