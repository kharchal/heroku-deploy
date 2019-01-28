<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<span>
    <%--<a href="<c:url value="/units"/>">units</a> |--%>
    <%--<a href="<c:url value="/users"/>">users</a> |--%>
    <%--<a href="<c:url value="/roles"/>">roles</a> |--%>
    <a href="<c:url value="/clients"/>">clients</a> |
    <%--<a href="<c:url value="/levels"/>">levels</a> |--%>
    <%--<a href="<c:url value="/states"/>">states</a> |--%>
    <%--<a href="<c:url value="/channels"/>">channels</a> |--%>
    <a href="<c:url value="/payments"/>">payments</a> |
    <a href="<c:url value="/expenses"/>">expenses</a> |
    <%--<a href="<c:url value="/cashflow"/>">cashflow</a> |--%>

    <c:choose>
        <c:when test="${not empty loggedUser}">
            logged as <b>${loggedUser.login}</b>
            <a href="<c:url value="/logout"/>">logout</a>
        </c:when>
        <c:otherwise>
            <a href="<c:url value="/"/>">login</a> |
        </c:otherwise>
    </c:choose>
    <hr>

</span>
