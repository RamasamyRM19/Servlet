<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ideas2it.model.Trainee"%>
<%@page import="com.ideas2it.model.Skills"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.LinkedHashSet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Trainee</title>
</head>
<body>
	<div align="center">
		<%
		Trainee trainee = (Trainee) request.getAttribute("trainee");
		Integer employeeId = Integer.parseInt(request.getParameter("id"));
		String firstName = trainee.getFirstName();
		String lastName = trainee.getLastName();
		String designation = trainee.getDesignation();
		String department = trainee.getDepartment();
		String phoneNumber = String.valueOf(trainee.getPhoneNumber());
		String emailId = trainee.getEmailId();
		String dateOfBirth = String.valueOf(trainee.getDateOfBirth());
		String previousExperience = String.valueOf(trainee.getPreviousExperience());
		String dateOfJoining = String.valueOf(trainee.getDateOfJoining());
		String passedOutYear = String.valueOf(trainee.getPassedOutYear());
		session.setAttribute("trainee", trainee);
		%>
		<h1>Employee Register Form</h1>
		<form action="add" method="post">
			<input type="hidden" name="flag" value="insertTrainee"> <input
				type="hidden" name="action" value="updateTrainee">
			<table style="with: 80%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" value="<%=firstName%>" /></td>
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
					<td>Passed Out year</td>
					<td><input type="number" min="1900" max="2099" step="1"
						value="2016" name="passedOutYear" value="<%=passedOutYear%>" /></td>
				</tr>
				<tr>
				<tr>
					<th>Skill Name</th>
					<th>Version</th>
					<th>Last Used Year</th>
					<th>Experience</th>
				</tr>
				<tr>
					<%
					for (Skills skill : trainee.getSkills()) { %>
							<!-- String skillName = skill.getSkillName();
							String version = skill.getSkillVersion();
							String lastUsedYear = String.valueOf(skill.getLastUsedYear());
							String experience = String.valueOf(skill.getSkillExperience()); -->
					<%-- <%=skill.getSkillId() %>
					<%=skill.getSkillName() %>
					<%=skill.getSkillVersion() %>
					<%=skill.getLastUsedYear() %>
					<%=skill.getSkillExperience() %> --%>
					<input type="hidden" name="skillId" value="<%=skill.getSkillId()%>">
					<td><input type="text" name="skillName"
						value="<%=skill.getSkillName()%>" /></td>
					<td><input type="text" name="version" value="<%=skill.getSkillVersion()%>" /></td>
					<td><input type="number" name="lastUsedYear"
						value="<%=skill.getLastUsedYear()%>" /></td>
					<td><input type="number" name="experience"
						value="<%=skill.getSkillExperience()%>" /></td>
					<%
					}
					%>
				</tr>
			</table>
			<input type="hidden" name="id" value="<%=employeeId%>">
			<input type="hidden" name="traineeId" value="<%=employeeId%>"> 
			<input type="submit" value="Submit" /> <a href="ViewTrainee.jsp"> </a>
			<input type="reset">
		</form>
	</div>
</body>
</html>
