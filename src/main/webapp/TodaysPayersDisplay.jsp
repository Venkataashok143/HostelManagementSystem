<%@page language="java" contentType="text/html; charset=UTF-8"%>
<%@page
	import="java.util.ArrayList, hostelManagementSystem.HostelStudent"%>

<html>
<head>
<title>Today's Payers</title>
<style>
table {
	width: 70%;
	border-collapse: collapse;
	margin: auto;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: center;
}

th {
	background-color: #007bff;
	color: white;
}
</style>
</head>
<body>

	<h2 align="center">Today's Payers</h2>

	<table>
		<tr>
			<th>Name</th>
			<th>Room No</th>
			<th>Phone</th>
			<th>AAdhar</th>
			<th>joining-date</th>
		</tr>
		<% ArrayList<HostelStudent> students = (ArrayList<HostelStudent>) request.getAttribute("Studentslist"); %>
		<% if (students != null && !students.isEmpty()) { %>
		<% for (HostelStudent student : students) { %>
		<tr>
			<td><%= student.getName() %></td>
			<td><%= student.getRoomNo() %></td>
			<td><%= student.getPhone() %></td>
			<td><%=student.getAadharNo() %></td>
			<td><%=student.getJoiningDate()%></td>
		</tr>
		<% } %>
		<% } else { %>
		<tr>
			<td colspan="5">No students found</td>
		</tr>
		<% } %>
	</table>

</body>
</html>