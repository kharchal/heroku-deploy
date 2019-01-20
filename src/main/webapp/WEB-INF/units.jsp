<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    units page<hr>
    <table cellpadding="4">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>QTY</th>
            <th>DATE</th>
            <th>CREATED</th>
            <th>UPDATED</th>
            <th></th>
        </tr>
    <c:forEach var="u" items="${units}">
        <tr>
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td>${u.qty}</td>
            <td>
                <fmt:formatDate value="${u.date}" pattern="yyyy.MM.dd"/>
            </td>
            <td>
                <fmt:formatDate value="${u.created}" pattern="yyyy.MM.dd HH:mm:ss.SSS"/>
            </td>
            <td>
                <fmt:formatDate value="${u.updated}" pattern="yyyy.MM.dd HH:mm:ss.SSS"/>
            </td>
            <td>
                <a href="<c:url value="/units/edit/${u.id}"/>">edit</a> |
                <a href="<c:url value="/units/update/${u.id}"/>">update</a> |
                <a href="<c:url value="/units/delete/${u.id}"/>">delete</a>
            </td>
        </tr>
    </c:forEach>
    </table>
    <c:import url="util/footer.jsp"/>
</body>
</html>