<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>WebApp</title>
</head>
<body>
<div class="container">
    <ul>
        <li><a href="/airportwebapp/persons">Persons</a></li>
        <li><a href="/airportwebapp/flights">Flights</a></li>
        <li><a class="active" href="/airportwebapp/baggagies">Baggagies</a></li>
        <li><a href="/airportwebapp/airplanes">Airplanes</a></li>
        <li><a href="/airportwebapp/personsflights">Registration on flight</a></li>
    </ul>
    <div class="row">
        <div class="col-2-3">
            <table id="list">
                <tr>
                    <th>Type</th>
                    <th>Weight</th>
                    <th>Person</th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="baggage" items="${list}">
                    <tr>
                        <td><c:out value="${baggage.type}"/></td>
                        <td><c:out value="${baggage.weight}"/></td>
                        <td><c:out value="${baggage.person.fullName}"/></td>
                        <td>
                            <button class="button" type="button"><a href="?id=${baggage.id}">Update</a></button>
                            <form class="button-delete" action="baggagies/delete" method="POST">
                                <input type="hidden" name="id" value="${baggage.id}"/>
                                <button class="button" type="submit">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-1-3">
            <div class="row">
                <form class="form" action="baggagies/create" method="POST">
                    <label for="type"> Type: </label>
                    <input type="text" id="type" name="type">
                    <br/>
                    <label for="weight"> Weight, kg: </label>
                    <input type="number" id="weight" name="weight"/>
                    <br/>
                    <label for="personFullName"> Person: </label>
                    <select id = "personFullName" name="person_id">
                        <c:forEach items="${personList}" var="person">
                            <option value="${person.id}"> ${person.fullName}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Submit"/>
                </form>
            </div>
            <form class="form" action="baggagies" method="GET">
                <label for="personId">Person Id: </label>
                <input required type="text" id="personId" name="personId">
                <input type="submit" value="Search"/>
            </form>
        </div>
    </div>
    <style>
        <%@include file="../css/style.css" %>
    </style>
</div>
</body>
</html>