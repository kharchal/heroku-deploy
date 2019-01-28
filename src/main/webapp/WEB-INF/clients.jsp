<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        var x = true;
        $(document).ready(function () {
            x = false;
            $("#trigger").click(function () {
                $("#trigger").text(x ? "expand" : "hide");
                $("[id|=tbl]").toggleClass("hide");
                x = !x;
            });
        });
    </script>
    <style>
        .hide {
            display: none;
        }
    </style>
</head>
<body>
    <c:import url="util/header.jsp"/>
    clients page<hr>
    <a href="<c:url value="/clients/new"/>">new client</a>
    <c:set var="action"><c:url value="/clients/filterbylevel"/></c:set>
    <form action="${action}">
    filter by group:
        <select name="level_id">
            <c:forEach var="l" items="${levels.keySet()}">
                <option value="${l}" ${l eq level_id ? "selected" : ""}>${levels.get(l)}</option>
            </c:forEach>
        </select>
        <input type="submit"/>
    </form>
    <a href="<c:url value="/clients"/>">all</a>
    <table cellpadding="4">
        <tr>
            <th>#</th>
            <th>ID</th>
            <th>NAME</th>
            <th>SURNAME</th>
            <%--<th>PHONE</th>--%>
            <%--<th>EMAIL</th>--%>
            <%--<th>LEVEL</th>--%>
            <th>GROUP</th>
            <th>STATE</th>
            <th>INITIAL BALANCE</th>
            <th>BALANCE</th>
            <th id="tbl-1" class="hide">CREATED</th>
            <th id="tbl-2" class="hide">UPDATED</th>
            <th><button id="trigger">expand</button></th>
        </tr>
    <c:forEach var="c" items="${clients}" varStatus="s">
        <tr>
            <td>${s.count}</td>
            <td>${c.id}</td>
            <td>${c.name}</td>
            <td>${c.surname}</td>
            <%--<td>${c.phone}</td>--%>
            <%--<td>${c.email}</td>--%>
            <td>${c.level.value}</td>
            <td>${c.state.value}</td>
            <td align="right">
                <span ${c.initialBalance < 0 ? "style='color: red;'" : ""}>
                    <fmt:formatNumber value="${c.initialBalance}" maxFractionDigits="3"/>
                </span>
            </td>
            <td align="right">
                <span ${c.balance < 0 ? "style='color: red;'" : ""}>
                    <fmt:formatNumber value="${c.balance}" maxFractionDigits="3"/>
                </span>
            </td>
            <td id="tbl-3" class="hide">
                <fmt:formatDate value="${c.created}" pattern="yyyy.MM.dd HH:mm:ss.SSS"/>
            </td>
            <td id="tbl-4" class="hide">
                <fmt:formatDate value="${c.updated}" pattern="yyyy.MM.dd HH:mm:ss.SSS"/>
            </td>
            <td>
                <a href="<c:url value="/clients/edit/${c.id}"/>">edit</a> |
                <a href="<c:url value="/clients/show/${c.id}"/>">show</a> |
                <%--<a href="<c:url value="/units/update/${u.id}"/>">update</a> |--%>
                <%--<a href="<c:url value="/units/delete/${u.id}"/>">delete</a>--%>
            </td>
        </tr>
    </c:forEach>
    </table>
    <c:import url="util/footer.jsp"/>
</body>
</html>