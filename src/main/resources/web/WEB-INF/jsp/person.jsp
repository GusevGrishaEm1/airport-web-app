<html>
<body>
<div class="container">
    <div class="row">
        <div class="edit-form">
            <form class="form" action="persons/update" method="POST">
                <input type="hidden" name="id" value="${person.id}"/>
                <label for="full_name">Full Name:</label>
                <input type="text" id="full_name" name="full_name" value="${person.fullName}"/>
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
                    <option value="PASSENGER">PASSENGER
                    </option>
                    <option value="STEWARDESS">STEWARDESS</option>
                </select>
                <br/>
                <label for="birthday">Birthday:</label>
                <input type="date" id="birthday" name="birthday" value="${person.birthday}"/>
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