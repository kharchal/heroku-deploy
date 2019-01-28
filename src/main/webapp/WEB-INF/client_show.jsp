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
    user show page<hr>
    <table cellpadding="15" cellspacing="0" border="1">
        <tr>
            <td>

    <table cellpadding="4">
        <%--<c:set var="action"><c:url value="/clients/save"/></c:set>--%>
        <%--<f:form action="${action}" modelAttribute="client">--%>
            <tr>
                <td>
                    <label>ID</label>
                </td>
                <td>
                    ${client.id}
                    <%--<f:input path="id" id="id" readonly="true"/>--%>
                </td>
            </tr>
            <tr>
                <td>
                    <label>NAME</label>
                </td>
                <td>
                    ${client.name}
                </td>
            </tr>
            <tr>
                <td>
                    <label>SURNAME</label>
                </td>
                <td>
                    ${client.surname}
                </td>
            </tr>
            <tr>
                <td>
                    <label>PHONE</label>
                </td>
                <td>
                    ${client.phone}
                </td>
            </tr>
            <tr>
                <td><label>EMAIL</label></td>
                <td>
                    ${client.email}
                </td>
            </tr>
            <tr>
                <td>
                    <label>LEVEL</label>
                </td>
                <td>
                    ${client.level.value}
                </td>
            </tr>
            <tr>
                <td>
                    <label>STATE</label>
                </td>
                <td>
                    ${client.state.value}
                </td>
            </tr>
            <tr>
                <td>
                    <label>INITIAL BALANCE</label>
                </td>
                <td>
                    ${client.initialBalance}
                </td>
            </tr>
            <tr>
                <td>
                    <label>BALANCE</label>
                </td>
                <td>
                    ${client.balance}
                </td>
            </tr>
            <tr>
                <td>
                    <label>CREATED</label>
                </td>
                <td>
                    ${client.created}
                </td>
            </tr>
            <tr>
                <td>
                    <label>UPDATED</label>
                </td>
                <td>
                    ${client.updated}
                </td>
            </tr>
    </table>
            </td>
            <td valign="top">
                <table cellpadding="4">

                    <tr>
                        <th>ID</th>
                        <th>DATE</th>
                        <th>AMOUNT</th>
                    </tr>
                    <c:set var="p_total" value="${0}"/>
                    <c:forEach var="p" items="${payments}">
                        <tr>
                            <td>${p.id}</td>
                            <td>${p.date}</td>
                            <td align="right"><fmt:formatNumber value="${p.amount}" maxFractionDigits="3"/></td>
                        </tr>
                        <c:set var="p_total" value="${p_total + p.amount}"/>
                    </c:forEach>
                    <tr>
                        <th colspan="2" align="right">PAYMENTS TOTAL:</th>
                        <th align="right"><fmt:formatNumber value="${p_total}" maxFractionDigits="3"/></th>
                    </tr>
                    <tr>
                        <td colspan="3"><a href="<c:url value="/payments/new/${client.id}"/>">add new payment</a></td>
                    </tr>
                </table>
            </td>
            <td valign="top">
                <table cellpadding="4">

                    <tr>
                        <th>ID</th>
                        <th>DATE</th>
                        <th>AMOUNT</th>
                    </tr>
                    <c:set var="e_total" value="${0}"/>
                    <c:forEach var="e" items="${expenses}">
                        <tr>
                            <td>${e.id}</td>
                            <td>${e.date}</td>
                            <td align="right"><fmt:formatNumber value="${e.amount}" maxFractionDigits="3"/></td>
                        </tr>
                        <c:set var="e_total" value="${e_total + e.amount}"/>
                    </c:forEach>
                    <tr>
                        <th colspan="2"align="right">EXPENSES TOTAL:</th>
                        <th align="right"><fmt:formatNumber value="${e_total}" maxFractionDigits="3"/></th>
                    </tr>
                    <tr>
                        <td colspan="3"><a href="<c:url value="/expenses/new/${client.id}"/>">add new expense</a></td>
                    </tr>
                    <tr>
                        <th colspan="2" align="right">balance:</th>
                        <th align="right">
                            <c:set var="total" value="${p_total - e_total + client.initialBalance}"/>
                            <span ${total lt 0 ? "style='color: red;'" : ""}>
                                <fmt:formatNumber value="${total}" maxFractionDigits="3"/>
                            </span>
                        </th>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <c:import url="util/footer.jsp"/>
</body>
</html>