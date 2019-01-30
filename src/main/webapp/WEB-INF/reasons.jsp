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
    reasons page<hr>
    <a href="<c:url value="/reasons/new"/>">new reason</a> <hr>
    <table cellpadding="4">
        <tr>
            <th>ID</th>
            <th>VALUE</th>
            <th></th>
        </tr>
    <c:forEach var="r" items="${reasons}">
        <tr>
            <td>${r.id}</td>
            <td>${r.value}</td>
            <td>
                <a href="<c:url value="/reasons/edit/${r.id}"/>">edit</a> |
            </td>
        </tr>
    </c:forEach>
    </table>
    <c:import url="util/footer.jsp"/>
</body>
</html>