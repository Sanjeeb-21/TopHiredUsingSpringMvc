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
	<table>
		<tr>
			<td align="left"><a
				href="${pageContext.request.contextPath}/job-search.htm">Search
					Jobs</a></td>
			<td align="right"><a
				href="${pageContext.request.contextPath}/job/new.htm">Post Jobs</a></td>
		</tr>
		<c:if test="${param.postjob eq 'success' }">
			<tr>
				<td colspan="2" align="center"><span
					style="color: white; border-style: solid; margin: 3px; background: blue;">
						Your Job has been Posted Successfully </span></td>
			</tr>
		</c:if>
		<c:if test="${param.editjob eq 'success' }">
			<tr>
				<td colspan="2" align="center"><span
					style="color: white; border-style: solid; margin: 3px; background: blue;">
						Your Job has been Updated Successfully </span></td>
			</tr>
		</c:if>
		<tr>

			<td colspan="2">

				<table
					style="border-style: solid; border-width: 1px; border-collapse: collapse; padding: 4x; margin: 1px;">
					<tr>
						<th>Job Title</th>
						<th>Organization Name</th>
						<th>Experiance</th>
						<th>Required Skill</th>
						<th>&nbsp;</th>
					</tr>
					<c:forEach items="${jobs }" var="job">
						<tr>
							<td><a
								href="${pageContext.request.contextPath }/job/${job.jobId}/details.htm">${job.jobTitle }</a></td>
							<td>${job.organizationName }</td>
							<td>${job.experiance }</td>
							<td>${job.requiredSkill }</td>
							<td>
							<a
								href="${pageContext.request.contextPath }/job/${job.jobId}/edit.htm">Edit</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>