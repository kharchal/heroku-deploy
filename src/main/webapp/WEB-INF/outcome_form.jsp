<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=utf-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <c:import url="util/import.jsp"/>
</head>
<body>
    <c:import url="util/header.jsp"/>
    outcome edit page<hr>
    <table cellpadding="4">
        <c:set var="action"><c:url value="/outcomes/save"/></c:set>
        <f:form action="${action}" modelAttribute="outcome">
            <%--<input name="mapping" type="hidden" value="${mapping}"/>--%>
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
                    <f:label path="client">CLIENT</f:label>
                </td>
                <td>
                    <f:select path="client.id" items="${clients}"/>
                </td>
                <td>
                    <f:errors path="client"/>
                </td>
            </tr>
            <tr>
                <td>
                    <f:label path="channel">CHANNEL</f:label>
                </td>
                <td>
                    <f:select path="channel.id" items="${channels}"/>
                </td>
                <td>
                    <f:errors path="channel"/>
                </td>
            </tr>
            <tr>
                <td>
                    <f:label path="reason">REASON</f:label>
                </td>
                <td>
                    <f:select path="reason.id" items="${reasons}"/>
                </td>
                <td>
                    <f:errors path="reason"/>
                </td>
            </tr>
            <tr>
                <td>
                    <f:label path="amount">AMOUNT</f:label>
                </td>
                <td>
                    <f:input path="amount"/>
                </td>
                <td>
                    <f:errors path="amount"/>
                </td>
            </tr>
            <tr>
                <td>
                    <f:label path="comment">COMMENT</f:label>
                </td>
                <td>
                    <f:input path="comment"/>
                </td>
                <td>
                    <f:errors path="comment"/>
                </td>
            </tr>
            <tr>
                <td>
                    <f:label path="date">DATE</f:label>
                </td>
                <td>
                    <f:input path="xdate" id="datepicker" readonly="true"/>
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
                    <input value="${outcome.created}" readonly/>
                </td>
                <td></td>
            </tr>
            <tr>
                <td>
                    <f:label path="updated">UPDATED</f:label>
                </td>
                <td>
                    <input value="${outcome.updated}" readonly/>
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