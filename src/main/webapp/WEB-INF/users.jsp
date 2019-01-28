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
            $("#trigger").click(function () {
                if (x) {
                    $("[id|=tbl]").hide();
                    $("#trigger").text("-->");
                } else {
                    $("[id|=tbl]").show();
                    $("#trigger").text("<--");
                }
                x = !x;
                // alert("123");
                // $("#tblh1").hide();
                // $("#tblh2").hide();
                // $("#tblctx-2").hide();
                // $("#tblctx").hide();
            })
        });
    </script>
</head>
<body>
    <c:import url="util/header.jsp"/>
    users page<hr>
    <a href="<c:url value="/users/new"/>">new user</a> <hr>
    <table cellpadding="4">
        <tr>
            <th>ID</th>
            <th>NAME</th>
            <th>LOGIN</th>
            <th>PASSWORD</th>
            <th>ACTIVE</th>
            <th>ROLES</th>
            <%--<div id="tblhd">--%>
            <th id="tbl-1">CREATED</th>
            <th id="tbl-2">UPDATED</th>
            <%--</div>--%>
            <th><div id="trigger">&lt;--</div></th>
            <%--<th></th>--%>
        </tr>
    <c:forEach var="u" items="${users}">
        <tr>
            <td>${u.id}</td>
            <td>${u.name}</td>
            <td>${u.login}</td>
            <td>${u.password}</td>
            <td>${u.active ? "+" : "-"}</td>
            <td>
                <c:forEach var="r" items="${u.userRoles}" varStatus="st">
                    ${r.value}
                    <c:if test="${not st.last}">
                        ,
                    </c:if>
                </c:forEach>
            </td>
            <%--<td/>--%>
            <%--<div id="tblctx">--%>
            <td id="tbl-3">
                <fmt:formatDate value="${u.created}" pattern="yyyy.MM.dd HH:mm:ss.SSS"/>
            </td>
            <td id="tbl-4">
                <fmt:formatDate value="${u.updated}" pattern="yyyy.MM.dd HH:mm:ss.SSS"/>
            </td>
            <%--</div>--%>
            <td>
                <a href="<c:url value="/users/edit/${u.id}"/>">edit</a> |
                <%--<a href="<c:url value="/units/update/${u.id}"/>">update</a> |--%>
                <%--<a href="<c:url value="/units/delete/${u.id}"/>">delete</a>--%>
            </td>
        </tr>
    </c:forEach>
    </table>
    <c:import url="util/footer.jsp"/>
</body>
</html>