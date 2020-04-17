<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/defs/taglibs.jsp"%>

<%-- ${view} --%>

<h3>menu.jsp</h3>		
<p>

	<%-- HOME --%>

	<c:choose>
		<c:when test="${view == 'home'}"><spring:message code="view.home" /></c:when>
		<c:otherwise><a href="${ctx}/home.html"><spring:message code="view.home" /></a></c:otherwise>
	</c:choose>
	--

	<%-- JSTL y sus LIBRERIAS TEST --%>
	<c:choose>
		<c:when test="${view == 'jstlLibTest'}"><spring:message code="view.jstlLibTest" /></c:when>
		<c:otherwise><a href="${ctx}/jstlLibTest.html"><spring:message code="view.jstlLibTest" /></a></c:otherwise>
	</c:choose>
	--

	<%-- HTML CSS TEST --%>
	<c:choose>
		<c:when test="${view == 'htmlCssTest'}"><spring:message code="view.htmlCssTest" /></c:when>
		<c:otherwise><a href="${ctx}/htmlCssTest.html"><spring:message code="view.htmlCssTest" /></a></c:otherwise>
	</c:choose>
	--

	<%-- PRUEBAS VARIAS DE JAVA Y LA VISTA --%>
	<c:choose>
		<c:when test="${view == 'javaVariosTest'}"><spring:message code="view.javaVariosTest" /></c:when>
		<c:otherwise><a href="${ctx}/javaVariosTest.html"><spring:message code="view.javaVariosTest" /></a></c:otherwise>
	</c:choose>
	--
</p>