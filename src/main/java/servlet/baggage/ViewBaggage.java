package servlet.baggage;

import entity.Baggage;
import entity.Person;
import service.BaggageService;
import service.PersonService;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ViewBaggage extends HttpServlet {

    private final BaggageService baggageService;
    private final PersonService personService;

    public ViewBaggage() {
        this.baggageService = new BaggageService();
        this.personService = new PersonService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String personId = request.getParameter("personId");
        if (id != null) {
            Baggage baggage = baggageService.getById(Integer.parseInt(id));
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("baggage", baggage);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/baggage.jsp");
            requestDispatcher.forward(request, response);
        } else if (personId != null) {
            List<Baggage> baggagies = baggageService.getByPersonId(Integer.valueOf(personId));
            HttpSession session = request.getSession();
            List<Person> personList = personService.getAll();
            session.setAttribute("personList", personList);
            session.setAttribute("list", baggagies);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/baggagies.jsp");
            requestDispatcher.forward(request, response);
        } else {
            HttpSession session = request.getSession();
            List<Baggage> baggagies = baggageService.getAll();
            List<Person> personList = personService.getAll();
            session.setAttribute("personList", personList);
            session.setAttribute("list", baggagies);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/baggagies.jsp");
            requestDispatcher.forward(request, response);
        }
    }

}
