<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <title>Cart Info</title>
    </head>
    <body>
    	<h2>Cart Info</h2> 
    	<a href="/shop">back</a>
    	<%-- <form:form method="POST" action="/shop/buy" 
    		modelAttribute="cartDetails"> --%>
    		<table border=1>
            <thead>
                <tr>
                    <th>Book Id</th>
                    <th>Quantity</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${cartDetails}" 
                	var="cartDetail">
                    <tr>
                        <td>${cartDetail.key}</td>
                        <td>${cartDetail.value}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <a href="/shop/buy">Buy</a>
<%--         <input type="submit" value="Buy" />
    	</form:form> --%>
    </body>
</html>