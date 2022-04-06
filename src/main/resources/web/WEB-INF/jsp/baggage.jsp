<html>
<body>
<div class="container">
    <div class="row">
        <div class="edit-form">
            <form class="form" action="baggagies/update" method="POST">
                <input type="hidden" name="id" value="${baggage.id}"/>
                <label for="type">Type: </label>
                <input type="text" id="type" name="type" value="${baggage.type}"/>
                <br/>
                <label for="weight">Weight: </label>
                <input type="number" id="weight" name="weight" value="${baggage.weight}"/>
                <input type="hidden" id="person_id" name="person_id" value="${baggage.person.id}"/>
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