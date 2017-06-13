<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit Employee page</h3>

<form:form method="POST" commandName="employee"
	action="${pageContext.request.contextPath}/admin/employee/edit/${employee.employeeId}.html" onsubmit="return validateForm();">
	<div>${message}</div>
	<table>
		<tbody>
			<tr>
				<td>Employee Name</td>
				<td><form:input path="emp_name" /></td>
				<td><form:errors path="emp_name" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Email Address</td>
				<td><form:input path="email_address" type="email"/></td>
				<td><form:errors path="email_address" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><form:input path="mobile_no" /></td>
				<td><form:errors path="mobile_no" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><%-- <form:input path="designation" /> --%>
				<select name="designation">
				<option value="professional">Professional</option>
				<option value="administrative">Administrative</option>
				</select></td>
				<td><form:errors path="designation" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Manager ID</td>
				<td><%-- <form:input path="managerId" /> --%> 
				<form:select path="managerId">
    				 <form:options items="${managerList}"/>
 					</form:select></td>
				<td><form:errors path="managerId" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>