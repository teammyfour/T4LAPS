<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<form name="applyleaveForm" action="leavehistory_edit" >
	<table>

		<tr>
			<td>Name:</td>
			<td><input type="text" name="txtname" value="${empName}" required></td>
		</tr>
		<tr>
			<td>EmployeeId:</td>
			<td><input type="text" name="txtId" value="${leavehistoryedit.employeeId}" disabled></td>
		</tr>
		<tr>
			<td>Leave Type:</td>
			<td><select name="leavetype" required>
					<option value="Annual">${leavehistoryedit.leavetype}</option>
					<option value="Medical">Medical</option>
					<option value="Annual">Annual</option>
					
			</select></td>
		</tr>
		<tr>
			<td>StartDate:</td>
			<td><fmt:formatDate pattern="dd/MM/YYYY" value="${leavehistoryedit.startDate}" var="sDate" /><input type="date" id="StartDate" name="startDate" value="${sDate}" required
				></td>
		</tr>
		<tr>
			<td>EndDate:</td>
			<td><fmt:formatDate pattern="dd/MM/YYYY" value="${leavehistoryedit.endDate}" var="eDate" /><input type="date" id="EndDate" name="endDate" value="${eDate}" required
				></td>
		</tr>
		
		<tr>
			<td>Reason:</td>
			<td><input type="text" name="txtreason" value="${leavehistoryedit.reason }" required></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit"></td>
		</tr>

	</table>
	<!--  Returns 2017-06-05T14:48:00.000Z -->
	</form>
	<script type="text/javascript">
		var today = new Date().toISOString().split('T')[0];
		document.getElementsByName("startDate")[0].setAttribute('min', today);
				
	</script>
	
</body>
</html>