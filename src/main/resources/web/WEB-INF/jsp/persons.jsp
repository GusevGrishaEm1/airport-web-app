<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>First JSP App</title>
</head>
<body>
<h2> Persons: </h2>
<table>
    <tr>
        <th>Full name</th>
        <th>Role</th>
        <th>Address</th>
        <th>Birthday</th>
    </tr>
    <c:forEach var="person" items="${list}">
        <tr>
            <td><c:out value="${person.fullName}"/></td>
            <td><c:out value="${person.role}"/></td>
            <td><c:out value="${person.address}"/></td>
            <td><c:out value="${person.birthday}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>