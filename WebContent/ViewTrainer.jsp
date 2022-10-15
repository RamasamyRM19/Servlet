<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ideas2it.model.Trainer"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Trainer</title>
</head>
<body>
	<div align="center">
		<input type="hidden" name="flag" value="viewTrainer">
		<table border="1">
			<h2>List of Trainers</h2>
			<tr>
				<th>Id</th>
				<th>FirstName</th>
				<th>lastName</th>
				<th>Designation</th>
				<th>Department</th>
				<th>Phone Number</th>
				<th>Email Id</th>
				<th>Date Of Birth</th>
				<th>Previous Experience</th>
				<th>Date Of Joining</th>
				<th>Salary</th>
			</tr>

			<%
			List<Trainer> trainers = (List<Trainer>) request.getAttribute("trainers");
			for (Trainer trainer : trainers) {
			%>
			<tr>
				<td><%=trainer.getId()%></td>
				<td><%=trainer.getFirstName()%></td>
				<td><%=trainer.getLastName()%></td>
				<td><%=trainer.getDesignation()%></td>
				<td><%=trainer.getDepartment()%></td>
				<td><%=trainer.getPhoneNumber()%></td>
				<td><%=trainer.getEmailId()%></td>
				<td><%=trainer.getDateOfBirth()%></td>
				<td><%=trainer.getPreviousExperience()%></td>
				<td><%=trainer.getDateOfJoining()%></td>
				<td><%=trainer.getSalary()%></td>
				<td><a
					href="add?flag=updateTrainer&id=<%=trainer.getId()%>">
						<input class="update" type="button" value="Update">
				</a></td>
				<td><a
					href="add?flag=deleteTrainer&id=<%=trainer.getId()%>">
						<input class="delete" type="button" value="Delete">
				</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>