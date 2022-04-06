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
        <li><a class="active" href="/airportwebapp/persons">Persons</a></li>
        <li><a href="/airportwebapp/flights">Flights</a></li>
        <li><a href="/airportwebapp//baggagies">Baggagies</a></li>
        <li><a href="/airportwebapp/airplanes">Airplanes</a></li>
        <li><a  href="/airportwebapp/personsflights">Registration on flight</a></li>
    </ul>
    <div class="row">
        <div class="col-2-3">
            <table id="list">
                <tr>
                    <th>Full name</th>
                    <th>Role</th>
                    <th>Gender</th>
                    <th>Birthday</th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="person" items="${list}">
                    <tr>
                        <td><c:out value="${person.fullName}"/></td>
                        <td><c:out value="${person.role}"/></td>
                        <td><c:out value="${person.gender}"/></td>
                        <td><c:out value="${person.birthday}"/></td>
                        <td>
                            <button class="button" type="button"><a href="?id=${person.id}">Update</a></button>
                            <form class="button-delete" action="persons/delete" method="POST">
                                <input type="hidden" name="id" value="${person.id}"/>
                                <button class="button" type="submit">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="col-1-3">
            <div class="row">
                <form class="form" action="persons/create" method="POST">
                    <label for="full_name"> Full Name: </label>
                    <input type="text" id="full_name" name="full_name">
                    <br/>
                    <label for="gender"> Gender: </label>
                    <select id="gender" name="gender">
                        <option value="MALE">MALE</option>
                        <option value="FEMALE">FEMALE
                        </option>
                        <option value="X">X</option>
                    </select>
                    <br/>
                    <label for="role"> Role: </label>
                    <select id="role" name="role">
                        <option value="PILOT">PILOT</option>
                        <option value="PASSENGER">PASSENGER</option>
                        <option value="STEWARDESS">STEWARDESS</option>
                    </select>
                    <br/>
                    <label for="birthday"> Birthday: </label>
                    <input type="date" id="birthday" name="birthday"/>
                    <input type="submit" value="Submit"/>
                </form>
            </div>
            <div class="row">
            <form class="form" action="persons" method="GET">
                <label for="name"> Search by full name: </label>
                <input required type="text" id="name" name="name">
                <input type="submit" value="Search"/>
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