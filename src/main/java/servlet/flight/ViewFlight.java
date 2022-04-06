package servlet.flight;

import entity.Airplane;
import entity.Flight;
import entity.Person;
import service.AirplaneService;
import service.FlightService;
import service.PersonService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ViewFlight extends HttpServlet {

    private final FlightService flightService;
    private final PersonService personService;
    private final AirplaneService airplaneService;

    public ViewFlight() {
        this.flightService = new FlightService();
        this.personService = new PersonService();
        this.airplaneService = new AirplaneService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String from = req.getParameter("fromAirportName");
        String to = req.getParameter("toAirportName");
        if (id != null) {
            Flight flight = flightService.getById(Integer.parseInt(id));
            List<Person> persons = personService.getByFlightId(Integer.valueOf(id));
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("flight", flight);
            httpSession.setAttribute("list", persons);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/flight.jsp");
            requestDispatcher.forward(req, resp);
        } else if (from != null && to != null) {
            List<Flight> flights = flightService.getByFromAndTo(from, to);
            HttpSession session = req.getSession();
            List<Airplane> airplaneList = airplaneService.getAll();
            session.setAttribute("list", flights);
            session.setAttribute("airplaneList", airplaneList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/flights.jsp");
            requestDispatcher.forward(req, resp);
        } else {
            List<Flight> flights = flightService.getAll();
            List<Airplane> airplaneList = airplaneService.getAll();
            HttpSession session = req.getSession();
            session.setAttribute("airplaneList", airplaneList);
            session.setAttribute("list", flights);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/jsp/flights.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
