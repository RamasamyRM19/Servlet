<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ideas2it.model.Trainer"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Trainer</title>
</head>
<body>
	<div align="center">
		<%
		Trainer trainer = (Trainer) request.getAttribute("trainer");
		Integer employeeId = Integer.parseInt(request.getParameter("id"));
		String firstName = trainer.getFirstName();
		String lastName = trainer.getLastName();
		String designation = trainer.getDesignation();
		String department = trainer.getDepartment();
		String phoneNumber = String.valueOf(trainer.getPhoneNumber());
		String emailId = trainer.getEmailId();
		String dateOfBirth = trainer.getDateOfBirth();
		String previousExperience = String.valueOf(trainer.getPreviousExperience());
		String dateOfJoining = trainer.getDateOfJoining();
		String salary = String.valueOf(trainer.getSalary());
		session.setAttribute("trainer", trainer);
		%>
		<h1>Employee Register Form</h1>
		<form action="add" method="post">
			<input type="hidden" name="flag" value="insertTrainer">
			<input type="hidden" name="action" value="updateTrainer">
			<table style="with: 80%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName"
						value="<%=firstName%>" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" value="<%=lastName%>" /></td>
				</tr>
				<tr>
					<td>Designation</td>
					<td><input type="text" name="designation"
						value="<%=designation%>" /></td>
				</tr>
				<tr>
					<td>Department</td>
					<td><input type="text" name="department"
						value="<%=department%>" /></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input type="number" name="phoneNumber"
						value="<%=phoneNumber%>" /></td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td><input type="email" name="emailId" value="<%=emailId%>" /></td>
				</tr>
				<tr>
					<td>Date Of Birth</td>
					<td><input type="date" name="dateOfBirth"
						value="<%=dateOfBirth%>" /></td>
				</tr>
				<tr>
					<td>Previous Experience</td>
					<td><input type="number" name="previousExperience"
						value="<%=previousExperience%>" /></td>
				</tr>
				<tr>
					<td>Date Of Joining</td>
					<td><input type="date" name="dateOfJoining"
						value="<%=dateOfJoining%>" /></td>
				</tr>
				<tr>
					<td>Salary</td>
					<td><input type="number" name="salary" value="<%=salary%>" /></td>
				</tr>
			</table>
			<%=employeeId %>
			<input type="hidden" name="id" value="<%=employeeId%>">
			<input type="submit" value="Submit" /> <a href="ViewTrainer.jsp"> </a><input type="reset">
		</form>
	</div>
</body>
</html>
