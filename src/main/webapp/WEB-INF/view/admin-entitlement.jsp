<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Leave Entitlement</title>
</head>
<body>
<h3>Admin Leave Entitlement page</h3>
	<a href="${pageContext.request.contextPath}/admin/entitlement/create">Add
		Entitlement Type</a>
		<div><font color="green">${message}</font></div>
		<table style="cellspacing: 2; cellpadding: 2; border: 1;">
			<thead>
				<tr class="listHeading">
					<th>Designation</th>
					<th>No. of days of annual leave</th>
					<th>No. of days of medical leave</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="entitlement" items="${entitlementList}">
					<tr class="listHeading">
						<td>${entitlement.designation}</td>
						<td>${entitlement.annual_leave}</td>
						<td>${entitlement.medical_leave}</td>
						<td align="center"><a
							href="${pageContext.request.contextPath}/admin/entitlement/edit/${entitlement.designation}.html">Edit</a></td>
						<td><a
							href="${pageContext.request.contextPath}/admin/entitlement/delete/${entitlement.designation}.html">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
</body>
</html>