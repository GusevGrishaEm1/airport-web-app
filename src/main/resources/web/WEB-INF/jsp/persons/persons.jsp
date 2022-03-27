<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>First JSP App</title>
</head>
<body>
<form action="persons/create" method="POST">
    Full Name: <input type="text" name="full_name">
    <br/>
    Address: <input type="text" name="address"/>
    <br/>
    Role: <input type="text" name="role"/>
    <br/>
    Birthday: <input type="date" name="birthday"/>
    <input type="submit" value="Submit"/>
</form>
<h2> Persons: </h2>
<table>
    <tr>
        <th>Full name</th>
        <th>Role</th>
        <th>Address</th>
        <th>Birthday</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="person" items="${list}">
        <tr>
            <td><c:out value="${person.fullName}"/></td>
            <td><c:out value="${person.role}"/></td>
            <td><c:out value="${person.address}"/></td>
            <td><c:out value="${person.birthday}"/></td>
            <td>
                <button type="button"><a href="?id=${person.id}">Update</a></button>
                <form action="/airportwebapp/persons/delete" method="POST">
                    <input type="hidden" name="id" value="${person.id}"/>
                    <input type="submit" value="Delete"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
<style>
    <%@include file="/WEB-INF/jsp/persons/persons.css" %>
</style>
</body>
</html>