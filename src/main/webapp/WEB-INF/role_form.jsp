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
    <c:import url="util/header.jsp"/>
    role edit page<hr>
    <table cellpadding="4">
        <c:set var="action"><c:url value="/roles/save"/></c:set>
        <f:form action="${action}" modelAttribute="role">
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
                    <f:label path="value">VALUE</f:label>
                </td>
                <td>
                    <f:input path="value"/>
                </td>
                <td>
                    <f:errors path="value"/>
                </td>
            </tr>
            <tr>
                <td>
                    <f:label path="description">DESCRIPTION</f:label>
                </td>
                <td>
                    <f:input path="description"/>
                </td>
                <td>
                    <f:errors path="description"/>
                </td>
            </tr>
            <tr>
                <td align="center" colspan="3">
                    <input type="submit"/>
                </td>
            </tr>
        </f:form>
    </table>
    <c:import url="util/footer.jsp"/>
</body>
</html>