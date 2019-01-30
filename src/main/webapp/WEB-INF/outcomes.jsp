<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <c:import url="util/hide.jsp"/>
</head>
<body>
    <c:import url="util/header.jsp"/>
    outcomes page<hr>
    <a href="<c:url value="/outcomes/new"/>">add new outcome</a>
    <table cellpadding="4">
        <tr>
            <th>ID</th>
            <th>CLIENT</th>
            <th>AMOUNT</th>
            <th>CHANNEL</th>
            <th>REASON</th>
            <th>COMMENT</th>
            <th>DATE</th>
            <th class="hide" id="tbl-1">CREATED</th>
            <th class="hide" id="tbl-2">UPDATED</th>
            <th><button id="trigger">expand</button></th>
        </tr>
    <c:forEach var="o" items="${outcomes}">
        <tr>
            <td>${o.id}</td>
            <td>
                <a href="<c:url value="/clients/show/${o.client.id}"/>">
                    ${o.client.name} ${o.client.surname}
                </a>
            </td>
            <td>${o.amount}</td>
            <td>${o.channel.value}</td>
            <td>${o.reason.value}</td>
            <td>${o.comment}</td>
            <td>
                <fmt:formatDate value="${o.date}" pattern="yyyy.MM.dd"/>
            </td>
            <td class="hide" id="tbl-3">
                <fmt:formatDate value="${o.created}" pattern="yyyy.MM.dd HH:mm:ss.SSS"/>
            </td>
            <td class="hide" id="tbl-4">
                <fmt:formatDate value="${o.updated}" pattern="yyyy.MM.dd HH:mm:ss.SSS"/>
            </td>
            <td>
                <a href="<c:url value="/outcomes/edit/${o.id}"/>">edit</a> |
                <%--<a href="<c:url value="/units/update/${u.id}"/>">update</a> |--%>
                <%--<a href="<c:url value="/units/delete/${u.id}"/>">delete</a>--%>
            </td>
        </tr>
    </c:forEach>
    </table>
    <c:import url="util/footer.jsp"/>
</body>
</html>