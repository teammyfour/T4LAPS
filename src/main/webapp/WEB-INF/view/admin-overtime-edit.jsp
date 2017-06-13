<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit Overtime page</h3>

<form:form method="POST" commandName="overtime"
	action="${pageContext.request.contextPath}/admin/overtime/edit/${overtime.overtimeId}.html">
	<div>${message}</div>
	<table>
		<tbody>
			<tr>
				<td>Employee Id</td>
				<td><form:input path="employeeId" readonly="true" /></td>
				<td><form:errors path="employeeId" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Date [dd-mm-yyyy]</td>
				<td><form:input path="date" /></td>
				<td><form:errors path="date" cssStyle="color: red;" /></td>
			</tr>
		<tr>
				<td>Extra Hours</td>
				<td><form:input path="extraHours" /></td>
				<td><form:errors path="extraHours" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>

