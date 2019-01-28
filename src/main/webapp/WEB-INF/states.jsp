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
    states page<hr>
    <a href="<c:url value="/states/new"/>">new state</a> <hr>
    <table cellpadding="4">
        <tr>
            <th>ID</th>
            <th>VALUE</th>
            <th></th>
        </tr>
    <c:forEach var="s" items="${states}">
        <tr>
            <td>${s.id}</td>
            <td>${s.value}</td>
            <td>
                <a href="<c:url value="/states/edit/${s.id}"/>">edit</a> |
            </td>
        </tr>
    </c:forEach>
    </table>
    <c:import url="util/footer.jsp"/>
</body>
</html>