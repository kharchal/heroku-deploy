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
        <c:set var="action"><c:url value="/users/save"/></c:set>
        <f:form action="${action}" modelAttribute="user">
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
                    <f:label path="login">LOGIN</f:label>
                </td>
                <td>
                    <f:input path="login"/>
                </td>
                <td>
                    <f:errors path="login"/>
                </td>
            </tr>
            <tr>
                <td>
                    <f:label path="password">PASSWORD</f:label>
                </td>
                <td>
                    <f:input path="password"/>
                </td>
                <td>
                    <f:errors path="password"/>
                </td>
            </tr>
            <tr>
                <td><f:label path="active">ACTIVE</f:label></td>
                <td>
                    <f:checkbox path="active" />
                </td>
            </tr>
            <tr>
                <td>
                    <f:label path="userRoles">ROLES</f:label>
                </td>
                <td>${user.userRoles}
                    <select multiple size="5" name="userRoles">
                        <c:forEach items="${roles.values()}" var="r">
                            <option value="${r.id}" ${user.userRoles.contains(r) ? "selected" : ""}>
                                ${r.value}
                            </option>
                        </c:forEach>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <f:label path="created">CREATED</f:label>
                </td>
                <td>
                    <input value="${user.created}"/>
                </td>
                <td></td>
            </tr>
            <tr>
                <td>
                    <f:label path="updated">UPDATED</f:label>
                </td>
                <td>
                    <input value="${user.updated}"/>
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