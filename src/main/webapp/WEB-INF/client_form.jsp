<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    user edit page<hr>
    <table cellpadding="4">
        <c:set var="action"><c:url value="/clients/save"/></c:set>
        <f:form action="${action}" modelAttribute="client">
            <tr>
                <td>
                    <label for="id">ID</label>
                </td>
                <td>
                    <f:input path="id" id="id" readonly="true"/>
                </td>
                <td></td>
            </tr>
            <tr>
                <td>
                    <f:label path="name">NAME</f:label>
                </td>
                <td>
                    <f:input path="name"/>
                </td>
                <td>
                    <f:errors path="name"/>
                </td>
            </tr>
            <tr>
                <td>
                    <f:label path="surname">SURNAME</f:label>
                </td>
                <td>
                    <f:input path="surname"/>
                </td>
                <td>
                    <f:errors path="surname"/>
                </td>
            </tr>
            <tr>
                <td>
                    <f:label path="phone">PHONE</f:label>
                </td>
                <td>
                    <f:input path="phone"/>
                </td>
                <td>
                    <f:errors path="phone"/>
                </td>
            </tr>
            <tr>
                <td><f:label path="email">EMAIL</f:label></td>
                <td>
                    <f:input path="email" />
                </td>
                <td>
                    <f:errors path="email"/>
                </td>
            </tr>
            <tr>
                <td>
                    <f:label path="level">LEVEL</f:label>
                </td>
                <td>
                    <f:select path="level.id" items="${levels}"/>
                        <%--<c:forEach items="${roles.values()}" var="r">--%>
                            <%--<option value="${r.id}" ${user.userRoles.contains(r) ? "selected" : ""}>--%>
                                <%--${r.value}--%>
                            <%--</option>--%>
                        <%--</c:forEach>--%>
                    <%--</f:select>--%>
                </td>
            </tr>
            <tr>
                <td>
                    <f:label path="state">STATE</f:label>
                </td>
                <td>
                    <f:select path="state.id" items="${states}"/>
                </td>
            </tr>
            <tr>
                <td>
                    <f:label path="balance">BALANCE</f:label>
                </td>
                <td>
                    <f:input path="balance"/>
                </td>
                <td>
                    <f:errors path="balance"/>
                </td>
            </tr>
            <tr>
                <td>
                    <f:label path="created">CREATED</f:label>
                </td>
                <td>
                    <input value="${client.created}"/>
                </td>
                <td></td>
            </tr>
            <tr>
                <td>
                    <f:label path="updated">UPDATED</f:label>
                </td>
                <td>
                    <input value="${client.updated}"/>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="3">
                    <input type="submit"/>
                </td>
            </tr>
        </f:form>
    </table>
    <hr>
    <c:import url="util/footer.jsp"/>
</body>
</html>