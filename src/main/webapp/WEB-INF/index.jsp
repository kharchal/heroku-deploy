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
    login page<hr>
    <div style="color: red">${msg}</div>
    <c:set var="action"><c:url value="/login"/></c:set>
    <form action="${action}" method="post">
        <label for="login">LOGIN</label>
        <input name="login" id="login"/>
        <label for="password">LOGIN</label>
        <input name="password" id="password" type="password"/>
        <input type="submit" value="Login"/>
    </form>
    <c:import url="util/footer.jsp"/>
</body>
</html>