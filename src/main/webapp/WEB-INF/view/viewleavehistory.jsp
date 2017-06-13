<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome to viewhistory!!
<h3>View Employee Leave History

<table>
<tr><td>LeaveID</td><td>EmployeeID</td><td>LeaveType</td><td>StartDate</td><td>EndDate</td><td>reason</td>
<td>Status</td>
<c:forEach items="${leavehistoryList }"  var="leave_history"  varStatus="i" >
<tr>

<td>${leave_history.leaveId}</td>
<td>${leave_history.employeeId}</td>
<td>${leave_history.leavetype}</td>
<td>${leave_history.startDate}</td>
<td>${leave_history.endDate}</td>
<td>${leave_history.reason}</td>
<td>${leave_history.status}</td>
<c:if test="${leave_history.status=='SUBMITTED' || leave_history.status=='UPDATED'}">
<td><c:url var="editUrl" value="/staff/applyleave_edit" /><a href="${editUrl}?id=${leave_history.leaveId}" onClick="EditRow()">edit</a></td>
<td><c:url var="cancelUrl" value="/staff/applyleave_cancel" /><a href="${cancelUrl}?leaveid=${leave_history.leaveId}&?empid=${leave_history.employeeId}">cancel</a></td>
</c:if>
</tr>
</c:forEach>

</table>
</h3>
<script>
function EditRow()
{   
    var row= $(this).closest('tr');  
    var Leaveid=$("td:eq(0)",row).text(); 
    Session["leaveId"]=Leaveid;
    alert(Leaveid);  
   
}
</script>

</body>
</html>