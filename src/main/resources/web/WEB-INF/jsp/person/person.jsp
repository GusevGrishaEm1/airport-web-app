<html>
<body>
<form action="persons/update" method="POST">
    <input type="hidden" name="id" value="${person.id}"/>
    Full Name: <input type="text" name="full_name" value="${person.fullName}"/>
    <br/>
    Address: <input type="text" name="address" value="${person.address}"/>
    <br/>
    Role: <input type="text" name="role" value="${person.role}"/>
    <br/>
    Birthday: <input type="date" name="birthday" value="${person.birthday}"/>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>