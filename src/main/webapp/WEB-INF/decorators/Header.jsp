<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<div >
<h1 align="left">
<img  src="${pageContext.request.contextPath}/image/NUS.png" height = "125" width = "125" >
<font size="7" font face="Papyrus">
<spring:message code="Leave Application Processing System" />

</font>
</h1>
	<h2>
	<font color= #000000>
		<c:if test="${not empty sessionScope.USERSESSION}">
			<spring:message code="user" />
<c:out value="${sessionScope.USERSESSION.user.name}" /> ,
<spring:message code="role" /> :
<c:forEach var="role" items="${sessionScope.USERSESSION.user.roleSet}">
 ${role.name} 
 
</c:forEach>
		</c:if>
		</font>
	</h2>
</div>




