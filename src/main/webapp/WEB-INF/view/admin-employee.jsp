<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Manage Employee</title>
</head>
<body>
<h3>Admin Manage Employees Page</h3>
	<a href="${pageContext.request.contextPath}/admin/employee/create">Add
		Employee Record</a>
		<div><font color="green">${message}</font></div>
		<table style="cellspacing: 2; cellpadding: 2; border: 1;">
			<thead>
				<tr class="listHeading">
					<th>Employee ID</th>
					<th>Employee Name</th>
					<th>Email Address</th>
					<th>Mobile Number</th>
					<th>Designation</th>
					<th>Manager ID</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="employee" items="${employeeList}">
					<tr class="listHeading">
						<td>${employee.employeeId}</td>
						<td>${employee.emp_name}</td>
						<td>${employee.email_address}</td>
						<td>${employee.mobile_no}</td>
						<td>${employee.designation}</td>
						<td>${employee.managerId}</td>
						<td align="center"><a
							href="${pageContext.request.contextPath}/admin/employee/edit/${employee.employeeId}.html">Edit</a></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/employee/delete/${employee.employeeId}.html">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>