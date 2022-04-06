<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div class="container">
    <div class="row">
        <div class="edit-form">
            <form class="form" action="flights/update" method="POST">
                <input type="hidden" name="id" value="${flight.id}"/>
                <label for="from_airport_name">From:</label>
                <input type="text" id="from_airport_name" name="from_airport_name" value="${flight.fromAirportName}"/>
                <br/>
                <label for="to_airport_name">To:</label>
                <input type="text" id="to_airport_name" name="to_airport_name" value="${flight.toAirportName}"/>
                <br/>
                <label for="departure_time">Departure time:</label>
                <input type="datetime-local" id="departure_time" name="departure_time" value="${flight.departureTime}"/>
                <br/>
                <label for="arrival_time">Arrival time:</label>
                <input type="datetime-local" id="arrival_time" name="arrival_time" value="${flight.arrivalTime}"/>
                <input type="hidden" id="airplane_id" name="airplane_id" value="${flight.airplane.id}"/>
                <input type="submit" value="Submit"/>
            </form>
        </div>
    </div>
</div>
<style>
    <%@include file="../css/style.css" %>
</style>
</body>
</html>