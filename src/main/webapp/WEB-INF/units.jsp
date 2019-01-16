<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    units page<hr>
    <c:forEach var="u" items="${units}">
        ${u}<br>
    </c:forEach>
    <hr>
    <a href="<c:url value="/"/>">home</a>
</body>
</html>