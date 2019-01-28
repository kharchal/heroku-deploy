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
    roles page<hr>
    <a href="<c:url value="/roles/new"/>">new role</a> <hr>
    <table cellpadding="4">
        <tr>
            <th>ID</th>
            <th>VALUE</th>
            <th>DESCRIPTION</th>
            <th></th>
        </tr>
    <c:forEach var="r" items="${roles}">
        <tr>
            <td>${r.id}</td>
            <td>${r.value}</td>
            <td>${r.description}</td>
            <td>
                <a href="<c:url value="/roles/edit/${r.id}"/>">edit</a> |
            </td>
        </tr>
    </c:forEach>
    </table>
    <c:import url="util/footer.jsp"/>
</body>
</html>