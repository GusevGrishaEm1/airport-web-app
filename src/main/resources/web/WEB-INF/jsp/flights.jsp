<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://example.com/functions" prefix="f" %>
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
        <li><a class="active" href="/airportwebapp/flights">Flights</a></li>
        <li><a href="/airportwebapp//baggagies">Baggagies</a></li>
        <li><a href="/airportwebapp/airplanes">Airplanes</a></li>
        <li><a  href="/airportwebapp/personsflights">Registration on flight</a></li>
    </ul>
    <div class="row">
        <div class="row">
            <div class="col-2-3">
                <table id="list">
                    <tr>
                        <th>From</th>
                        <th>To</th>
                        <th>Departure time</th>
                        <th>Arrival time</th>
                        <th>Airplane:</th>
                        <th>Actions</th>
                    </tr>
                    <c:forEach var="flight" items="${list}">
                        <tr>
                            <td><c:out value="${flight.fromAirportName}"/></td>
                            <td><c:out value="${flight.toAirportName}"/></td>
                            <td><c:out value="${f:formatLocalDateTime(flight.departureTime, 'dd.MM.yyyy HH:mm')}"/></td>
                            <td><c:out value="${f:formatLocalDateTime(flight.arrivalTime, 'dd.MM.yyyy HH:mm')}"/></td>
                            <td><c:out value="${flight.airplane.tailNumber}"/></td>
                            <td>
                                <button class="button" type="button"><a href="?id=${flight.id}">Update</a></button>
                                <form class="button-delete"  action="flights/delete" method="POST">
                                    <input type="hidden" name="id" value="${flight.id}"/>
                                    <button class="button" type="submit">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
            <div class="col-1-3">
                <div class="row">
                    <form class="form" action="flights/create" method="POST">
                        <label for="from_airport_name">From: </label>
                        <input type="text" id="from_airport_name" name="from_airport_name">
                        <br/>
                        <label for="to_airport_name">To: </label>
                        <input type="text" id="to_airport_name" name="to_airport_name">
                        <br/>
                        <label for="departure_time">Departure time: </label>
                        <input type="datetime-local" id="departure_time" name="departure_time">
                        <br/>
                        <label for="arrival_time">Arrival time: </label>
                        <input type="datetime-local" id="arrival_time" name="arrival_time">
                        <br/>
                        <label for="tailNumber"> Airplane: </label>
                        <select id = "tailNumber" name="airplane_id">
                            <c:forEach items="${airplaneList}" var="airplane">
                                <option value="${airplane.id}"> ${airplane.tailNumber}</option>
                            </c:forEach>
                        </select>
                        <input type="submit" value="Submit"/>
                    </form>
                </div>
                <div class="row">
                    <form class="form" action="flights" method="GET">
                        <label for="fromAirportName"> From: </label>
                        <input required type="text" id="fromAirportName" name="fromAirportName">
                        <label for="toAirportName"> To: </label>
                        <input required type="text" id="toAirportName" name="toAirportName">
                        <input type="submit" value="Search"/>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<style>
    <%@include file="../css/style.css" %>
</style>
</body>
</html>