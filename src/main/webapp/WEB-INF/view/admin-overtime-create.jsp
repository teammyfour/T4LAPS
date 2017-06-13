<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>New Overtime Record</h3>
<form:form method="POST" commandName="overtime"
	action="${pageContext.request.contextPath}/admin/overtime/create.html">
	<div>${message}</div>
	<table>
		<tbody>
			<tr>
				<td>Employee ID</td>
				<td><form:input path="employeeId" /></td>
				<td><form:errors path="employeeId" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Date [dd-mm-yyyy]</td>
				<td><form:input path="date" /></td>
				<td><form:errors path="date" cssStyle="color: red;" /></td>
			</tr>
		<tr>
				<td>Extra Hours Performed</td>
				<td><form:input path="extraHours" /></td>
				<td><form:errors path="extraHours" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>