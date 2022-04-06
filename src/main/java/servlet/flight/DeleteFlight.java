package servlet.flight;

import service.FlightService;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteFlight  extends HttpServlet {

    private final FlightService flightService;

    public DeleteFlight() {
        this.flightService = new FlightService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        flightService.delete(id);
        resp.sendRedirect("/airportwebapp/flights");
    }
}
