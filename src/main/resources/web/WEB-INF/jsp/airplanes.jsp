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
        <li><a href="/airportwebapp//baggagies">Baggagies</a></li>
        <li><a class="active" href="/airportwebapp/airplanes">Airplanes</a></li>
        <li><a  href="/airportwebapp/personsflights">Registration on flight</a></li>
    </ul>
    <div class="row">
        <div class="col-2-3">
            <table id="list">
                <tr>
                    <th>Tail number</th>
                    <th>Model name</th>
                    <th>Capacity</th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="airplane" items="${list}">
                    <tr>
                        <td><c:out value="${airplane.tailNumber}"/></td>
                        <td><c:out value="${airplane.modelName}"/></td>
                        <td><c:out value="${airplane.capacity}"/></td>
                        <td>
                            <button class="button" type="button"><a href="?id=${airplane.id}">Update</a></button>
                            <form class="button-delete"  action="airplanes/delete" method="POST">
                                <input type="hidden" name="id" value="${airplane.id}"/>
                                <button class="button" type="submit">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-1-3">
            <div class="row">
                <form class="form" action="airplanes/create" method="POST">
                    <label for="tail_number"> Tail number: </label>
                    <input type="text" id="tail_number" name="tail_number">
                    <br/>
                    <label for="model_name"> Model name: </label>
                    <input type="text" id="model_name" name="model_name"/>
                    <br/>
                    <label for="capacity"> Capacity: </label>
                    <input type="text" id="capacity" name="capacity"/>
                    <input type="submit" value="Submit"/>
                </form>
            </div>
        </div>
    </div>
</div>
<style>
    <%@include file="../css/style.css" %>
</style>
</body>
</html>