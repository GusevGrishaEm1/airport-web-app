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

public class ViewPerson extends HttpServlet {

    private final PersonService personService;

    public ViewPerson() {
        HibernateSessionFactory.buildSessionFactory();
        this.personService = new PersonService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            Person person = personService.getById(Integer.parseInt(id));
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("person", person);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/person/person.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            List<Person> persons = personService.getAll();
            HttpSession session = req.getSession();
            session.setAttribute("list", persons);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/persons/persons.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
