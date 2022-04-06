package servlet.person;

import entity.Gender;
import entity.Person;
import entity.Role;
import service.PersonService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class CreatePerson extends HttpServlet {

    private final PersonService personService;

    public CreatePerson() {
        this.personService = new PersonService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String fullName = req.getParameter("full_name");
        String role = req.getParameter("role");
        String gender = req.getParameter("gender");
        Date birthday = Date.valueOf(req.getParameter("birthday"));
        personService.create(new Person(fullName, Enum.valueOf(Gender.class, gender), Enum.valueOf(Role.class, role), birthday));
        resp.sendRedirect("/airportwebapp/persons");
    }
}
