<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Public Holiday List page</h3>
	
	<c:if test="${fn:length(publicholidayList) gt 0}">
		<table style="cellspacing: 2; cellpadding: 2; border: 1;">
			<thead>
				<tr class="listHeading">
					<th>Holiday Date</th>
					<th>Occasion</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="holiday" items="${publicholidayList}">
					<tr class="listHeading">
						<td>${holiday.holiday_date}</td>
						<td>${holiday.occasion}</td>
						<td align="center"><a
							href="${pageContext.request.contextPath}/adminholiday/publicholiday/edit/${holiday.occasion}.html">Edit</a></td>
						<td><a
							href="${pageContext.request.contextPath}/adminholiday/publicholiday/delete/${holiday.occasion}.html">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<a href="${pageContext.request.contextPath}/adminholiday/publicholiday/create">Add
		Public Holiday</a>
</body>
</html>