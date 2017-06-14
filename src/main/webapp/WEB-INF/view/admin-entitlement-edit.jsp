<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Edit Leave Entitlement page</h3>

<form:form method="POST" commandName="entitlement"
	action="${pageContext.request.contextPath}/admin/entitlement/edit/${entitlement.designation}.html">
	<div>${message}</div>
	<table>
		<tbody>
			<tr>
				<td>Designation</td>
				<td><form:input path="designation" readonly="true" /></td>
				<td><form:errors path="designation" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td> Annual leaves</td>
				<td><form:input path="annual_leave" /></td>
				<td><form:errors path="annual_leave" cssStyle="color: red;" /></td>
			</tr>
		<tr>
				<td>Medical Leaves</td>
				<td><form:input path="medical_leave" /></td>
				<td><form:errors path="medical_leave" cssStyle="color: red;" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
</form:form>