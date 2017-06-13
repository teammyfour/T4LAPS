<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
YOUR MENU
<li><spring:url value="/staff/viewleavehistoryPage" var="phistory"
							htmlEscape="true" /> <a href="${phistory}"> <spring:message
								code="Leave History" />
					</a></li>
					<li><spring:url value="/staff/applyleave" var="apply"
							htmlEscape="true" /> <a href="${apply}"> <spring:message
								code="Apply Leave" />
								</a></li>
					<li><spring:url value="/staff/applycompensationleave" var="applycompensation"
							htmlEscape="true" /> <a href="${applycompensation}"> <spring:message
								code="Claim compensation" />
					<li><spring:url value="/adminholiday/publicholiday/list" var="publicholiday"
							htmlEscape="true" /> <a href="${publicholiday}"> <spring:message
								code="Public holiday List" />
					</a></li>
					<li><spring:url value="/staff/logout" var="logout"
							htmlEscape="true" /> <a href="${logout}"> <spring:message
								code="Logout" />