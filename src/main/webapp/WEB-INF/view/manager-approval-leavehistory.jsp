<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Approval For Leave Application</title>
</head>
<body>
	<h2>
		<center>Approval For Application Leave</center>
	</h2>
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<tr class="listHeading">
			<th>Leave ID</th>
			<th>Employee ID</th>
			<th>Leave Type</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Reason</th>
			<th>Status</th>
			<th>Leave Details</th>
		</tr>
		<c:forEach var="submittedLeave" items="${approvalhistory}">
			<c:if test="${fn:length(submittedLeave.value) gt 0}">

				<c:forEach var="appLeave" items="${submittedLeave.value}">
					<tr class="listRecord">
						<td>${appLeave.leaveId }</td>
						<td>${appLeave.employeeId }</td>
						<td>${appLeave.leavetype }</td>
						<td><fmt:formatDate type = "date" dateStyle = "long" pattern = "dd-MMM-yyyy" value = "${appLeave.startDate}" /></td>
						<td><fmt:formatDate type = "date" dateStyle = "long" pattern = "dd-MMM-yyyy" value = "${appLeave.endDate}" /></td>
						<td>${appLeave.reason }</td>
						<td>${appLeave.status }</td>
						<td><c:url
								value="/manager/detail/display/${appLeave.leaveId}.html" var="d" />
							<a href="${d}?empid=${appLeave.employeeId}">Detail</a></td>
					</tr>


				</c:forEach>

			</c:if>
		</c:forEach>
	</table>
</body>
</html>