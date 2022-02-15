<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DISPLAYING ALL TRAINEES</title>
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
<a href="logoutController">logout</a>
<br>
<table>

	<thead>
		<tr>
			<th>id</th>
			<th>Trainee id</th>
			<th>Trainee name</th>
			<th>Branch</th>
			<th>Percentage</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${trainees}" var="trainee">
			<tr>
				<td>${trainee.id}</td>
				<td>${trainee.trainee_id}</td>
				<td>${trainee.trainee_name}</td>
				<td>${trainee.branch}</td>
				<td>${trainee.percentage}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<br>
<a href="TraineeController.do?action=addtrainee">add new trainee</a>

</body>
</html>