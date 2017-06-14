<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<body>

	<h2>
		<center>Subordinates Leave History</center>
	</h2>
	<table style="cellspacing: 2; cellpadding: 2; border: 1;">
		<tr class="listHeading">
			<th>LeaveId</th>
			<th>Employee Id</th>
			<th>Leave Type</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Reason</th>
			<th>Status</th>
		</tr>
		<c:forEach var="subordinate" items="${submap}">

			<c:if test="${fn:length(subordinate.value) gt 0}">



				<c:forEach var="sleave" items="${subordinate.value}">
					<tr class="listRecord">
						<td>${sleave.leaveId}</td>
						<td>${sleave.employeeId}</td>
						<td>${sleave.leavetype}</td>
						<td><fmt:formatDate type = "date" dateStyle = "long" pattern = "dd-MMM-yyyy" value = "${sleave.startDate}" /></td>
						<td><fmt:formatDate type = "date" dateStyle = "long" pattern = "dd-MMM-yyyy" value = "${sleave.endDate}" /></td>
						<td>${sleave.reason}</td>
						<td>${sleave.status}</td>
					</tr>
				</c:forEach>

			</c:if>

		</c:forEach>
	</table>

</body>
</html>