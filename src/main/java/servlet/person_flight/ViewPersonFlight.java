package servlet.person_flight;

import entity.Flight;
import entity.Person;
import entity.PersonFlight;
import service.FlightService;
import service.PersonFlightService;
import service.PersonService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ViewPersonFlight extends HttpServlet {

    private final PersonFlightService personFlightService;
    private final PersonService personService;
    private final FlightService flightService;

    public ViewPersonFlight() {
        this.personFlightService = new PersonFlightService();
        this.personService = new PersonService();
        this.flightService = new FlightService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String personId = req.getParameter("personId");
        if (personId != null) {
            List<PersonFlight> personFlightList = personFlightService.getByPersonId(Integer.valueOf(personId));
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("list", personFlightList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/person_flight_list.jsp");
            requestDispatcher.forward(req, resp);
        }
        List<PersonFlight> personFlightList = personFlightService.getAll();
        List<Person> personList = personService.getAll();
        List<Flight> flightList = flightService.getAll();
        HttpSession session = req.getSession();
        session.setAttribute("list", personFlightList);
        session.setAttribute("personList", personList);
        session.setAttribute("flightList", flightList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/person_flight_list.jsp");
        requestDispatcher.forward(req, resp);
    }
}
