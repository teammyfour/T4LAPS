<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div>
	<h1 align="right">
	<spring:message code="LAPS" />
	</h1>
	<h2>
		<c:if test="${not empty sessionScope.USERSESSION}">
			<spring:message code="user" /> :
<c:out value="${sessionScope.USERSESSION.user.name}" /> ,
<spring:message code="role" /> :
<c:forEach var="role" items="${sessionScope.USERSESSION.user.roleSet}">
 ${role.name} 
</c:forEach>

		</c:if>
	</h2>
</div>




