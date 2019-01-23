<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    roles page<hr>
    <a href="<c:url value="/levels/new"/>">new level</a> <hr>
    <table cellpadding="4">
        <tr>
            <th>ID</th>
            <th>VALUE</th>
            <th></th>
        </tr>
    <c:forEach var="l" items="${levels}">
        <tr>
            <td>${l.id}</td>
            <td>${l.value}</td>
            <td>
                <a href="<c:url value="/levels/edit/${l.id}"/>">edit</a> |
            </td>
        </tr>
    </c:forEach>
    </table>
    <c:import url="util/footer.jsp"/>
</body>
</html>