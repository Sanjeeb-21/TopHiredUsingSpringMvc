<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Top Hire job</title>
</head>
<body>
	<h2>Top Hire job</h2>
	<c:choose>
	<c:when test="${matchingJobs ne null and not empty matchingJobs}">

	<table>
		<tr>
			<th>Job Title</th>
			<th>Organization Name</th>
			<th>Experiance</th>
			<th>Required Skill</th>
		</tr>
		<c:forEach items="${matchingJobs }" var="job">
			<tr>
				<td><a
					href="${pageContext.request.contextPath }/job/${job.jobId}/details.htm">${job.jobTitle }</a></td>
				<td>${job.organizationName }</td>
				<td>${job.experiance }</td>
				<td>${job.requiredSkill }</td>
			</tr>
		</c:forEach>
	</table>
	</c:when>
	<c:otherwise>
	No matching jobs found for your search criteria, please<a href="${pageContext.request.contextPath}/job-search.htm">try again</a>
	</c:otherwise>
	</c:choose>
</body>
</html>