<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Details</title>
</head>
<body>
	<h2>Job Details</h2>
	<table style="border: 1 bo; box-sizing: 2 ;">
		<tr>
			<td>Job Title:</td>
			<td>${job.jobTitle}</td>
		</tr>
		<tr>
			<td>Description:</td>
			<td>${job.description }</td>
		</tr>
		<tr>
			<td>Location:</td>
			<td>${job.location }</td>
		</tr>
		<tr>
			<td>Designation:</td>
			<td>${job.designation }</td>
		</tr>
		<tr>
			<td>OrganizationName:</td>
			<td>${job.organizationName }</td>
		</tr>
		<tr>
			<td>Experiance:</td>
			<td>${job.experiance }</td>
		</tr>
		<tr>
			<td>RequiredSkill:</td>
			<td>${job.requiredSkill }</td>
		</tr>
		<tr>
			<td>JobStatus:</td>
			<td>${job.jobStatus }</td>
		</tr>
	</table>
</body>
</html>