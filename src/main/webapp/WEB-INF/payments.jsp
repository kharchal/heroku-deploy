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
    payments page<hr>
    <a href="<c:url value="/payments/new"/>">add new payment</a>
    <table cellpadding="4">
        <tr>
            <th>ID</th>
            <th>CLIENT</th>
            <th>AMOUNT</th>
            <th>CHANNEL</th>
            <th>DATE</th>
            <th>CREATED</th>
            <th>UPDATED</th>
            <th></th>
        </tr>
    <c:forEach var="p" items="${payments}">
        <tr>
            <td>${p.id}</td>
            <td>${p.client.name} ${p.client.surname}</td>
            <td>${p.amount}</td>
            <td>${p.channel.value}</td>
            <td>
                <fmt:formatDate value="${p.date}" pattern="yyyy.MM.dd"/>
            </td>
            <td>
                <fmt:formatDate value="${p.created}" pattern="yyyy.MM.dd HH:mm:ss.SSS"/>
            </td>
            <td>
                <fmt:formatDate value="${p.updated}" pattern="yyyy.MM.dd HH:mm:ss.SSS"/>
            </td>
            <td>
                <a href="<c:url value="/payments/edit/${p.id}"/>">edit</a> |
                <%--<a href="<c:url value="/units/update/${u.id}"/>">update</a> |--%>
                <%--<a href="<c:url value="/units/delete/${u.id}"/>">delete</a>--%>
            </td>
        </tr>
    </c:forEach>
    </table>
    <c:import url="util/footer.jsp"/>
</body>
</html>