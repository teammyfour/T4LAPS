<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h3>New Employee Record</h3>
<form:form method="POST" commandName="combinedCommand"
	action="${pageContext.request.contextPath}/admin/employee/create.html">
	<div><font color="green">${message}</font></div>
	<table>
		<tbody>
			
			<%-- <tr>
			<tr>
				<td>Employee Id</td>
				<td><form:input path="employeeId" readonly="true" /></td>
				<td><form:errors path="employeeId" cssStyle="color: red;" /></td>
			</tr> --%>
			<tr>
				<td>Employee Name</td>
				<td><form:input path="employee.emp_name" /></td>
				<td><form:errors path="employee.emp_name" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>UserID</td>
				<td><form:input path="user.userId" /></td>
				<td><form:errors path="user.userId" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Email Address</td>
				<td><form:input path="employee.email_address"/></td>
				<td><form:errors path="employee.email_address" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><form:input path="employee.mobile_no" /></td>
				<td><form:errors path="employee.mobile_no" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td><%-- <form:input path="designation" /> --%>
				<form:select path="employee.designation">
    				 <form:option value="professional">Professional</form:option>
    				 <form:option value="professional">Administrative</form:option>
 				</form:select></td>
				<td><form:errors path="employee.designation" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Manager ID</td>
				<td><%-- <form:input path="managerId" /> --%>
				<form:select path="employee.managerId">
    				 <form:options items="${managerList}"/>
 					</form:select></td>
				<td><form:errors path="employee.managerId" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td>Role ID</td>
				<td><%-- <form:input path="managerId" /> --%>
				<form:select path="userRole.roleId">
    				 <form:options items="${roleList}"/>
 					</form:select></td>
				<td><form:errors path="userRole.roleId" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Create" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>