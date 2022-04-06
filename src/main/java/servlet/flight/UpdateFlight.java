package servlet.flight;

import entity.Flight;
import service.AirplaneService;
import service.FlightService;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;

public class UpdateFlight extends HttpServlet {

    private final FlightService flightService;
    private final AirplaneService airplaneService;

    public UpdateFlight() {
        this.flightService = new FlightService();
        this.airplaneService = new AirplaneService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String fromAirportName = request.getParameter("from_airport_name");
        String toAirportName = request.getParameter("to_airport_name");
        LocalDateTime arrivalTime = LocalDateTime.parse(request.getParameter("arrival_time"));
        LocalDateTime departureTime = LocalDateTime.parse(request.getParameter("departure_time"));
        Integer airplane_id = Integer.valueOf(request.getParameter("airplane_id"));
        flightService.update(new Flight(id, fromAirportName, toAirportName, arrivalTime, departureTime, airplaneService.getById(airplane_id)));
        response.sendRedirect("/airportwebapp/flights");
    }
}
