<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<body>
	<h2>
		<center>Application Leave Detail</center>
	</h2>

	<table style="cellspacing :2; cellpadding: 2; border: 1;">
	<tr class="listHeading">
	<th>Leave ID</th>
	<th>Employee ID</th>
	<th>Leave Type</th>
	<th>Start Date </th>
	<th>End Date </th>
	<th>Reason</th>
	<th>Status </th>
	</tr>
	<tr class="listRecord">
	<td><c:out value="${leaveHistory.leaveId }"></c:out></td>
	<td><c:out value="${leaveHistory.employeeId }"></c:out></td>
	<td><c:out value="${leaveHistory.leavetype }"></c:out></td>
	<td><fmt:formatDate type = "date" dateStyle = "long" pattern = "dd-MMM-yyyy" value = "${leaveHistory.startDate}" /></td>
	<td><fmt:formatDate type = "date" dateStyle = "long" pattern = "dd-MMM-yyyy" value = "${leaveHistory.endDate}" /></td>
	<td><c:out value="${leaveHistory.reason }"></c:out></td>
	<td><c:out value="${leaveHistory.status }"></c:out></td>
	</tr>
		</table>
	<form:form method="POST" modelAttribute="approve"
		action="${pageContext.request.contextPath}/manager/detail/edit/${leaveHistory.leaveId}.html">
		<table>
			<tr>
				<td><form:radiobutton path="decision" value="APPROVED" id="decision" name="group1" required="required"/> Approve : &nbsp;&nbsp; <form:radiobutton path="decision" value="REJECTED" id="decision" name="group1"/> Reject : </td>
			</tr>
			<tr>
				<td>Description<br>
					<form:textarea path="comment" cols="60" rows="4" id="comment"/></td>
			</tr>
		</table>
	<table style="cellspacing :2; cellpadding: 2; border: 1;">
		<form:button name="submit" type="submit" value="s">
		<input type="submit" value="Submit" name="submit" params="submit">
			
		</form:button>
		
		
	</form:form>
	
	<form:form method="POST" action="${pageContext.request.contextPath }/manager/approval">
	
		<input type="submit" value="Cancel" name="cancel" params="cancel">
	</form:form>
	
</table>
</body>

</html>