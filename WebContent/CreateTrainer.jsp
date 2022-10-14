<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ideas2it.model.Trainer"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Trainer</title>
</head>
<body>
<% String operation = request.getParameter("action");
	Trainer trainer = null;
	String firstName = "";
	String lastName = "";
	String designation = "";
	String department = "";
	String phoneNumber = "";
	String emailId = "";
	String dateOfBirth = "";
	String previousExperience = "";
	String dateOfJoining = "";
	String salary = "";
	if (operation.equals("updateTrainer")) {
	    trainer = (Trainer) request.getAttribute("trainer");
	    firstName = trainer.getFirstName();
	    lastName = trainer.getLastName();
	    designation = trainer.getDesignation();
	    department = trainer.getDepartment();
	    phoneNumber = String.valueOf(trainer.getPhoneNumber());
	    emailId = trainer.getEmailId();
	    dateOfBirth = String.valueOf(trainer.getDateOfBirth());
	    previousExperience = String.valueOf(trainer.getPreviousExperience());
	    dateOfJoining = String.valueOf(trainer.getDateOfJoining());
	    salary = String.valueOf(trainer.getSalary());
	}	
	session.setAttribute("trainer", trainer);
  %>
	<div align="center">
		<h1>Employee Register Form</h1>
		<form action="add?action=insertTrainer&operation=<%=operation%>" method="post">
			<input type="hidden" name="flag" value="insertTrainer">
			<table style="with: 80%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" /></td>
				</tr>
				<tr>
					<td>Designation</td>
					<td><input type="text" name="designation" /></td>
				</tr>
				<tr>
					<td>Department</td>
					<td><input type="text" name="department" /></td>
				</tr>
				<tr>
					<td>Phone Number</td>
					<td><input type="number" name="phoneNumber" /></td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td><input type="email" name="emailId" /></td>
				</tr>
				<tr>
					<td>Date Of Birth</td>
					<td><input type="date" name="dateOfBirth" /></td>
				</tr>
				<tr>
					<td>Previous Experience</td>
					<td><input type="number" name="previousExperience" /></td>
				</tr>
				<tr>
					<td>Date Of Joining</td>
					<td><input type="date" name="dateOfJoining" /></td>
				</tr>
				<tr>
					<td>Salary</td>
					<td><input type="number" name="salary" /></td>
				</tr>
			</table>
			<input type="submit" value="Submit" /> 
			<input type="reset">
		</form>
	</div>
</body>
</html>
  