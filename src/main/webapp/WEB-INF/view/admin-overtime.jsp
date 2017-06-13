<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Overtime</title>
</head>
<body>
<h3>Admin Overtime page</h3>
	<a href="${pageContext.request.contextPath}/admin/overtime/create">Add
		Overtime Record</a>
		<div>${message}</div>
		<table style="cellspacing: 2; cellpadding: 2; border: 1;">
			<thead>
				<tr class="listHeading">
					<th>Employee ID</th>
					<th>Date Overtime Performed</th>
					<th>Extra Hours</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="overtime" items="${overtimeList}">
					<tr class="listHeading">
						<td>${overtime.employeeId}</td>
						<td>${overtime.date}</td>
						<td>${overtime.extraHours}</td>
						<td align="center"><a
							href="${pageContext.request.contextPath}/admin/overtime/edit/${overtime.overtimeId}.html">Edit</a></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/overtime/delete/${overtime.overtimeId}.html">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>