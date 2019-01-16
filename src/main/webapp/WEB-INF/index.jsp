<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    index page<hr>
    ${msg}<br>
    <a href="<c:url value="/units/populate/0"/>">populate units</a> |
    <a href="<c:url value="/units/populate/3"/>">populate units exceptional</a> |
    <a href="<c:url value="/units"/>">show units</a>
    <hr>
    ${sessionScope.attributes}

</body>
</html>