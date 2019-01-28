<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <c:import url="util/header.jsp"/>
    expenses page<hr>
    <a href="<c:url value="/expenses/new"/>">add new expense</a>
    <table cellpadding="4">
        <tr>
            <th>ID</th>
            <th>CLIENT</th>
            <th>AMOUNT</th>
            <th>COMMENT</th>
            <th>DATE</th>
            <th>CREATED</th>
            <th>UPDATED</th>
            <th></th>
        </tr>
    <c:forEach var="e" items="${expenses}">
        <tr>
            <td>${e.id}</td>
            <td>
                <a href="<c:url value="/clients/show/${e.client.id}"/>">
                    ${e.client.name} ${e.client.surname}
                </a>
            </td>
            <td>${e.amount}</td>
            <td>${e.comment}</td>
            <td>
                <fmt:formatDate value="${e.date}" pattern="yyyy.MM.dd"/>
            </td>
            <td>
                <fmt:formatDate value="${e.created}" pattern="yyyy.MM.dd HH:mm:ss.SSS"/>
            </td>
            <td>
                <fmt:formatDate value="${e.updated}" pattern="yyyy.MM.dd HH:mm:ss.SSS"/>
            </td>
            <td>
                <a href="<c:url value="/expenses/edit/${e.id}"/>">edit</a> |
                <%--<a href="<c:url value="/units/update/${u.id}"/>">update</a> |--%>
                <%--<a href="<c:url value="/units/delete/${u.id}"/>">delete</a>--%>
            </td>
        </tr>
    </c:forEach>
    </table>
    <c:import url="util/footer.jsp"/>
</body>
</html>