package servlet.person;

import entity.Person;
import service.PersonService;
import util.HibernateSessionFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class UpdatePerson extends HttpServlet {

    private final PersonService personService;

    public UpdatePerson() {
        HibernateSessionFactory.buildSessionFactory();
        this.personService = new PersonService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String fullName = req.getParameter("full_name");
        String role = req.getParameter("role");
        String address = req.getParameter("address");
        Date birthday = Date.valueOf(req.getParameter("birthday"));
        personService.update(new Person(id, fullName, role, address, birthday));
        resp.sendRedirect("/airportwebapp/persons");
    }
}
