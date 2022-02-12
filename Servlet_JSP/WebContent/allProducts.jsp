<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product details</title>

<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}
td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}
tr:nth-child(even) {
  background-color: #dddddd;
}
</style>

</head>
<body>
welcome ${user.username}
<br>
<a href="LogoutController">logout</a>
	<table>
		<thead>
			<th>id</th>
			<th>Product name</th>
			<th>Product price</th>
			<th>Product Quantity</th>
			<th>Manufactured Date</th>
			<th>Inspected Date</th>
			<th>Update</th>
			<th>Delete</th>
		</thead>
		
		<tbody>
			<c:forEach items="${products}" var="prod">
				<tr>
				<td>${prod.id}</td>
				<td>${prod.productName}</td>
				<td>${prod.productPrice}</td>
				<td>${prod.productQty}</td>
				<td>${prod.manufacturedDate}</td>
				<td>${prod.inspectedDate}</td>
				<td><a href="ProductController?action=deleteProduct&id=<c:out value="${prod.id}"/>">Delete</a></td>
				<td><a href="ProductController?action=updateProduct&id=<c:out value="${prod.id}"/>">Update</a></td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="ProductController?action=addProduct">Add Product</a>
</body>
</html>