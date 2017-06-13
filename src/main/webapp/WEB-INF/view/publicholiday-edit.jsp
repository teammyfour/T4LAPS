
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="STYLESHEET" type="text/css"
	href="${pageContext.request.contextPath}/js/jquery-ui.theme.css" />
<script src="${pageContext.request.contextPath}/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
<script>
	$(document).ready(function() {
		$("#datepicker1").datepicker({
			dateFormat : "dd/mm/yy"
		});
	});
</script>
<h3>Edit Public Holiday page</h3>

<form:form method="POST" commandName="publicholiday"	action="${pageContext.request.contextPath}/adminholiday/publicholiday/edit/${publicholiday.occasion}">
	<table>
		<tbody>
			<tr>
				<th>Holiday Date</th>
				<td><form:input size="16" path="holiday_date" readonly="true"/>
				<form:errors path="holiday_date" cssStyle="color: red;" />
				</td>	
			</tr>
			<tr>
				<th>Occasion</th>
				<td><form:input path="occasion" />
				<form:errors path="occasion" cssStyle="color: red;" /></td>
				
			</tr>
			<tr>
				<td><input type="submit" value="Update" /></td>
				<td></td>
				<td></td>
			</tr>
		</tbody>
	</table>
	</form:form>