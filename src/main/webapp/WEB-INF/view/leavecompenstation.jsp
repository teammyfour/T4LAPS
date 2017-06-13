<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="leavecompensationPage">
<table>
<tr><td>EmployeeId:</td><td><input type="text" name="txtEmpId" value="${empId}" disabled></td>
<tr><td>Name:</td><td><input type="text" name="txtname" value="${empName}" required></td></tr>
<tr><td>StartDate:</td><td><input type="date" name="sdate" required></td></tr>
<tr><td>EndDate:</td><td><input type="date" name="edate" required></td></tr>
<tr><td>Reason:</td><td><input type="text" name="txtreason" required></td></tr>
<tr><td><input type="submit" value="Submit"></td></tr>
</table>
</form>
</body>
</html>