package servlet.flight;

import entity.Flight;
import service.AirplaneService;
import service.FlightService;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDateTime;

public class CreateFlight extends HttpServlet {

    private final FlightService flightService;
    private final AirplaneService airplaneService;

    public CreateFlight() {
        this.flightService = new FlightService();
        this.airplaneService = new AirplaneService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fromAirportName = request.getParameter("from_airport_name");
        String toAirportName = request.getParameter("to_airport_name");
        LocalDateTime arrivalTime = LocalDateTime.parse(request.getParameter("arrival_time"));
        LocalDateTime departureTime = LocalDateTime.parse(request.getParameter("departure_time"));
        Integer airplaneId = Integer.valueOf(request.getParameter("airplane_id"));
        flightService.create(new Flight(fromAirportName, toAirportName, arrivalTime, departureTime, airplaneService.getById(airplaneId)));
        response.sendRedirect("/airportwebapp/flights");
    }
}
