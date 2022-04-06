package servlet.person_flight;

import entity.PersonFlight;
import service.FlightService;
import service.PersonFlightService;
import service.PersonService;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CreatePersonFlight extends HttpServlet {

    private final PersonFlightService personFlightService;
    private final PersonService personService;
    private final FlightService flightService;

    public CreatePersonFlight() {
        this.personFlightService = new PersonFlightService();
        this.personService = new PersonService();
        this.flightService = new FlightService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer personId = Integer.valueOf(request.getParameter("person_id"));
        Integer flightId = Integer.valueOf(request.getParameter("flight_id"));
        Integer seatNumber = Integer.valueOf(request.getParameter("seat_number"));
        personFlightService.create(new PersonFlight(personService.getById(personId),flightService.getById(flightId), seatNumber));
        response.sendRedirect("/airportwebapp/personsflights");
    }

}
