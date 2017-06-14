<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<font size="2" font face="georgia">
<c:url value="/logout" var="logout" />
<ul>
	<c:if test="${sessionScope.USERSESSION.user.roleSet.size() gt 0}">
		<c:forEach var="role" items="${sessionScope.USERSESSION.user.roleSet}">
			<c:choose>
				<c:when test="${role.name eq 'admin' }">

				 <li><spring:url value="/admin/employee/general" var="memployee"
                         htmlEscape="true" /> <a href="${memployee}"> <spring:message
                            code="Maintain Employee" />
                 </a></li>
                                       
                 <li><spring:url value="/admin/entitlement/general" var="mentitlement"
                          htmlEscape="true" /> <a href="${mentitlement}"> <spring:message
                             code="Maintain Entitlement" />
                   </a></li>
					<li><a href="${pageContext.request.contextPath}/adminholiday/publicholiday/list">Maintain Public Holiday</a></li>
                <li><spring:url value="/admin/logout" var="logout"
							htmlEscape="true" /> <a href="${logout}"> <spring:message
								code="logout" />
					</a></li>
				</c:when>
				<c:when test="${role.name eq 'manager' }">
					<li><spring:url value="/manager/approval" var="pending"
							htmlEscape="true" /> <a href="${pending}"> <spring:message
								code="Leaves For Approval" />
					</a></li>
					<li><spring:url value="/manager/shistory" var="shistory"
							htmlEscape="true" /> <a href="${shistory}"> <spring:message
								code="Subordinate History" />
					</a></li>
					<li><spring:url value="/staff/viewleavehistoryPage" var="phistory"
							htmlEscape="true" /> <a href="${phistory}"> <spring:message
								code="Leave History" />
					</a></li>
					<li><spring:url value="/staff/applyleave" var="apply"
							htmlEscape="true" /> <a href="${apply}"> <spring:message
								code="Apply Leave" />
								</a></li>
					<li><spring:url value="/staff/logout" var="logout"
							htmlEscape="true" /> <a href="${logout}"> <spring:message
								code="logout" />
					</a></li>
					
				</c:when>
				<c:when test="${role.name eq 'staff' }">
					<li><spring:url value="/staff/viewleavehistoryPage" var="phistory"
							htmlEscape="true" /> <a href="${phistory}"> <spring:message
								code="Leave History" />
					</a></li>
					<li><spring:url value="/staff/applyleave" var="apply"
							htmlEscape="true" /> <a href="${apply}"> <spring:message
								code="Apply Leave" />
					</a></li>
					<li><spring:url value="/staff/logout" var="logout"
							htmlEscape="true" /> <a href="${logout}"> <spring:message
								code="logout" />
					</a></li>

				</c:when>
			</c:choose>

		</c:forEach>
	</c:if>
</ul>
</font>
