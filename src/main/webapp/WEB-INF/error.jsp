<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <c:import url="util/header.jsp"/>
    Welcome to an Error page!<br>
    <div style="color: red">${msg}</div>
    <a href="#" onclick="window.history.back();">back</a>
    <c:import url="util/footer.jsp"/>
</body>
</html>