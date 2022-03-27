package servlet.person;

import entity.Person;
import service.PersonService;
import util.HibernateSessionFactory;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class CreatePerson extends HttpServlet {

    private final PersonService personService;

    public CreatePerson() {
        HibernateSessionFactory.buildSessionFactory();
        this.personService = new PersonService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fullName = req.getParameter("full_name");
        String role = req.getParameter("role");
        String address = req.getParameter("address");
        Date birthday = Date.valueOf(req.getParameter("birthday"));
        personService.create(new Person(fullName, role, address, birthday));
        resp.sendRedirect("/airportwebapp/persons");
    }
}
