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
        <li><a href="/airportwebapp/flights">Flights</a></li>
        <li><a href="/airportwebapp//baggagies">Baggagies</a></li>
        <li><a href="/airportwebapp/airplanes">Airplanes</a></li>
        <li><a class="active" href="/airportwebapp/personsflights">Registration on flight</a></li>
    </ul>
    <div class="row">
        <div class="col-2-3">
            <table id="list">
                <tr>
                    <th>Person</th>
                    <th>From</th>
                    <th>To</th>
                    <th>Departure time</th>
                    <th>Arrival time</th>
                    <th>Seat number</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="personFlight" items="${list}">
                    <tr>
                        <td><c:out value="${personFlight.person.fullName}"/></td>
                        <td><c:out value="${personFlight.flight.fromAirportName}"/></td>
                        <td><c:out value="${personFlight.flight.toAirportName}"/></td>
                        <td><c:out
                                value="${f:formatLocalDateTime(personFlight.flight.departureTime, 'dd.MM.yyyy HH:mm')}"/></td>
                        <td><c:out
                                value="${f:formatLocalDateTime(personFlight.flight.arrivalTime, 'dd.MM.yyyy HH:mm')}"/></td>
                        <td><c:out value="${personFlight.seatNumber}"/></td>
                        <td>
                            <form class="button-delete" action="personsflights/delete" method="POST">
                                <input type="hidden" name="person_id" value="${personFlight.person.id}"/>
                                <input type="hidden" name="flight_id" value="${personFlight.flight.id}"/>
                                <button class="button" type="submit">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-1-3">
            <div class="row">
                <form class="form" action="personsflights/create" method="POST">
                    <label for="personFullName"> Person: </label>
                    <select id="personFullName" name="person_id">
                        <c:forEach items="${personList}" var="person">
                            <option value="${person.id}"> ${person.fullName}</option>
                        </c:forEach>
                    </select>
                    <br/>
                    <br/>
                    <label for="flight"> Person: </label>
                    <select id="flight" name="flight_id">
                        <c:forEach items="${flightList}" var="flight">
                            <option value="${flight.id}"> ${flight.fromAirportName} - ${flight.toAirportName}
                                | ${f:formatLocalDateTime(flight.departureTime, 'dd.MM.yyyy HH:mm')}
                                - ${f:formatLocalDateTime(flight.arrivalTime, 'dd.MM.yyyy HH:mm')}</option>
                        </c:forEach>
                    </select>
                    <br/>
                    <label for="seat_number"> Seat number: </label>
                    <input type="number" min="1" id="seat_number" name="seat_number"/>
                    <input type="submit" value="Submit"/>
                </form>
            </div>
            <div class="row">
                <form class="form" action="personsflights" method="GET">
                    <label for="personName"> Filter by Person: </label>
                    <select id="personName" name="personId">
                        <c:forEach items="${personList}" var="person">
                            <option value="${person.id}"> ${person.fullName}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Filter"/>
                </form>
            </div>

        </div>
    </div>
    <style>
        <%@include file="../css/style.css" %>
    </style>
</div>
</body>
</html>