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
import java.util.List;

public class DeletePerson extends HttpServlet {

    private final PersonService personService;

    public DeletePerson() {
        HibernateSessionFactory.buildSessionFactory();
        this.personService = new PersonService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        personService.delete(id);
        resp.sendRedirect("/airportwebapp/persons");
    }
}
