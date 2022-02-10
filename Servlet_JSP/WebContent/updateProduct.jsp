<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE PRODUCT</title>
</head>
<body>
	<form action="ProductController" method="post">
	<input type="hidden" name="id" value="${product.id}"/>
    <table>
        <tr>
            <td>Enter Product Name:</td>
            <td><input type="text" name="pname" id="pnameId" value="${product.productName}"/></td>
            <td><label id="pnamelabel"></label></td>
        </tr>

        <tr>
            <td>Enter Product Price:</td>
            <td><input type="number" name="price" id="pprice" value="${product.productPrice}"/></td>
            <td><label id="priceProd"></label></td>
        </tr>


        <tr>
            <td>Enter Product Quantity:</td>
            <td><input type="number" name="qty" id="qtyid" value="${product.productQty}"/></td>
            <td><label id="qtylabel"></label></td>
        </tr>


        <tr>
            <td>Enter Manufactured Date:</td>
            <td><input type="date" name="manudate" id="manudateid" value="${product.manufacturedDate}"/></td>
            <td><label id="manulabel"></label></td>
        </tr>
        
        <tr>
            <td>Enter Inspection Date:</td>
            <td><input type="date" name="inpdate" id="inpdateid" value="${product.inspectedDate}"/></td>
            <td><label id="inplabel"></label></td>
        </tr>

        <tr>
            <td><input type="submit" onclick="return validate();" /></td>
        </tr>
    </table>


</form>
</body>
</html>