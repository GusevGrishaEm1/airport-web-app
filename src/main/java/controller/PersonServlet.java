package controller;

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

public class PersonServlet extends HttpServlet {

    private final PersonService personService;

    public PersonServlet() {
        HibernateSessionFactory.buildSessionFactory();
        this.personService = new PersonService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("persons.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("persons.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("persons.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> persons = personService.getAll();
        HttpSession session = req.getSession();
        session.setAttribute("list", persons);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/persons.jsp");
        requestDispatcher.forward(req, resp);
    }

}
