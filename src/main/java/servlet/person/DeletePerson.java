package servlet.person;

import service.PersonService;
import util.HibernateSessionFactory;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeletePerson extends HttpServlet {

    private final PersonService personService;

    public DeletePerson() {
        HibernateSessionFactory.buildSessionFactory();
        this.personService = new PersonService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        personService.delete(id);
        resp.sendRedirect("/airportwebapp/persons");
    }
}
