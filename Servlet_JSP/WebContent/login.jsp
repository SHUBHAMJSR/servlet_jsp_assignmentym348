<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LOGIN PAGE</title>
</head>
<body>
	${param.status}
	<br>
	<form action="LoginController" method="post">
    <table>
        <tr>
            <td>Enter User Name:</td>
            <td><input type="text" name="uname" id="unameId" /></td>
            <td><label id="unamelabel"></label></td>
        </tr>

        <tr>
            <td>Enter Password:</td>
            <td><input type="text" name="pwd" id="upwd" /></td>
            <td><label id="pwdLabel"></label></td>
        </tr>
        <tr>
            <td><input type="submit" onclick="return validate();" /></td>
        </tr>
    </table>


</form>
</body>
</html>