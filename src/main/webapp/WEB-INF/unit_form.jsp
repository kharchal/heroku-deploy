<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    unit edit page<hr>
    <table cellpadding="4">
        <c:set var="action"><c:url value="/units/save"/></c:set>
        <f:form action="${action}" modelAttribute="unit">
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
                    <f:label path="qty">QTY</f:label>
                </td>
                <td>
                    <f:input path="qty"/>
                </td>
                <td>
                    <f:errors path="qty"/>
                </td>
            </tr>
            <tr>
                <td>
                    <f:label path="date">DATE</f:label>
                </td>
                <td>
                    <%--<input name="xdate" value="${unit.xdate}"/>--%>
                    <f:input path="xdate"/>
                </td>
                <td>
                    <f:errors path="date"/>
                </td>
            </tr>
            <tr>
                <td>
                    <f:label path="created">CREATED</f:label>
                </td>
                <td>
                    <input value="${unit.created}"/>
                </td>
                <td></td>
            </tr>
            <tr>
                <td>
                    <f:label path="updated">UPDATED</f:label>
                </td>
                <td>
                    <input value="${unit.updated}"/>
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
    <a href="<c:url value="/"/>">home</a> |
</body>
</html>