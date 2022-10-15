<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.ideas2it.model.Trainee"%>
<%@page import="com.ideas2it.model.Skills"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Trainee</title>
</head>
<body>
	<div align="center">
		<input type="hidden" name="flag" value="viewTrainee">
		<table border="1">
			<h2>List of Trainees</h2>
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
				<th>Passed Out Year</th>
				<th>Skill</th>
				<th>Skill Version</th>
				<th>Last Used Year</th>
				<th>Skill Experience</th>
			</tr>

			<%
			List<Trainee> trainees = (List<Trainee>)request.getAttribute("trainees");
			for (Trainee trainee : trainees) {
			%>
			<tr>
				<td><%=trainee.getId()%></td>
				<td><%=trainee.getFirstName()%></td>
				<td><%=trainee.getLastName()%></td>
				<td><%=trainee.getDesignation()%></td>
				<td><%=trainee.getDepartment()%></td>
				<td><%=trainee.getPhoneNumber()%></td>
				<td><%=trainee.getEmailId()%></td>
				<td><%=trainee.getDateOfBirth()%></td>
				<td><%=trainee.getPreviousExperience()%></td>
				<td><%=trainee.getDateOfJoining()%></td>
				<td><%=trainee.getPassedOutYear()%></td>
				<%-- <td><%=trainee.getSkills()%></td> --%>
				<%for (Skills skill : trainee.getSkills()) { %>
				<td><%=skill.getSkillName()%></td>
				<td><%=skill.getSkillVersion()%></td>
				<td><%=skill.getLastUsedYear()%></td>
				<td><%=skill.getSkillExperience()%></td>
				<% } %>
				<td><a
					href="add?flag=updateTrainee&id=<%=trainee.getId()%>">
						<input class="update" type="button" value="Update">
				</a></td>
				<td><a
					href="add?flag=deleteTrainee&id=<%=trainee.getId()%>">
						<input class="delete" type="button" value="Delete">
				</a></td>
			</tr>
			<% } %>
		</table>
	</div>
</body>
</html>