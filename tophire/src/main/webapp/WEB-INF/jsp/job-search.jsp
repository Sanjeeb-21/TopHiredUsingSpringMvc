<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Search</title>
</head>
<body>
	<h2>Job Search</h2>
	<p style="color: red;">
	<form:errors path="jobSearchCriteriaForm.*"></form:errors>
	</p>
	<form action="${pageContext.request.contextPath}/search-jobs.htm"
		method="get">
		Experiance: <input type="text" name="experiance" /><br /> Designation:
		<select name="designation">
			<option value="">Select</option>
			<c:forEach items="${designation}" var="designation">
				<option value="${designation}">${designation}</option>
			</c:forEach>
		</select> <br /> Organization Name : <input type="text" name="organizationName" />
		Skills : <input type="text" name="requiredSkill"><br /> <input
			type="submit" value="search jobs"/ >

	</form>
</body>
</html>