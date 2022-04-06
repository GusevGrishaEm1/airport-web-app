<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WebApp</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="edit-form">
            <form class="form" action="airplanes/update" method="POST">
                <input type="hidden" name="id" value="${airplane.id}"/>
                <label for="tail_number"> Tail number: </label>
                <input type="text" id="tail_number" name="tail_number" value="${airplane.tailNumber}">
                <br/>
                <label for="model_name"> Model name: </label>
                <input type="text" id="model_name" name="model_name" value="${airplane.modelName}"/>
                <br/>
                <label for="capacity"> Capacity: </label>
                <input min ="0" type="number" id="capacity" name="capacity" value="${airplane.capacity}"/>
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
