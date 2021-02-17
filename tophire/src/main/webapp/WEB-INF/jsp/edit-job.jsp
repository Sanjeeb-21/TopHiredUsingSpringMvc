<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Job</title>
<style type="text/css">
error {
	color: red;
	font-family: fantasy;
	font-size: 18px;
}

body {
	font-family: fantasy;
	font-size: 18px;
}
</style>
</head>
<body>
	<h2>Edit Jobs</h2>
	<!-- To retain the data dispaly the validation errors use form tag library -->
	<form:form action="${pageContext.request.contextPath}/job/edit.htm" modelAttribute="editJobForm">
		<table style="border-style: solid; padding: 5px; border-collapse: collapse;">
             
             <tr>
             <td>Job Id:</td>
             <td>
                <%-- <form:input path="jobId" readonly="true"/> --%>
                <form:hidden path="jobId"/>
               <b><c:out value="${editJobForm.jobId}"></c:out></b>
             </td>
             <td>&nbsp;</td>
             </tr>
             
             
              <tr>
                 <td>Job Title</td>
                 <td><form:input path="jobTitle" size="30" /></td>
                 <td class="error"><form:errors path="jobTitle"/></td>
              </tr>
 <tr>
                 <td>Description</td>
                 <td><form:textarea path="description" cols="120" rows="5"/></td>
                 <td class="error"><form:errors path="description"/></td>
              </tr>
               <tr>
                 <td>Organization Name</td>
                 <td><form:input path="organizationName"/></td>
                 <td class="error"><form:errors path="organizationName"/></td>
              </tr>
               <tr>
                 <td>Designation</td>
                 <td>
                 <form:select path="designation">
                 <form:option value="">select</form:option>
                 <c:forEach items="${designation}" var="designation">
                 <form:option value="${designation}">${designation}</form:option>
                 </c:forEach>
                 </form:select>
                 </td>
                 <td class="error"><form:errors path="designation"/></td>
              </tr>
               <tr>
                 <td>Experiance</td>
                 <td><form:input path="experiance"/></td>
                 <td class="error"><form:errors path="experiance"/></td>
              </tr>
               <tr>
                 <td>Location</td>
                 <td><form:input path="location"/></td>
                 <td class="error"><form:errors path="location"/></td>
              </tr>
               <tr>
                 <td>Required Skill</td>
                 <td><form:input path="requiredSkill" /></td>
                 
                 
                <!--  <input type="hidden" name="jobStatus" value="new"/> -->
                 
                 <td class="error"><form:errors path="requiredSkill"/></td>
              </tr>
               <tr>
                 <td>Job Status</td>
                 <td><form:input path="jobStatus"/></td>
                 <td class="error"><form:errors path="jobStatus"/></td>
              </tr>
              <tr>
              <td colspan="4" align="center">
              <input type="submit" value="update job"/>
              </td>
              </tr>
            


		</table>
	</form:form>
</body>
</html>