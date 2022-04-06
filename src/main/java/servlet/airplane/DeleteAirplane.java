package servlet.airplane;

import service.AirplaneService;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteAirplane extends HttpServlet {
    private final AirplaneService airplaneService;

    public DeleteAirplane() {
        this.airplaneService = new AirplaneService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        airplaneService.delete(id);
        resp.sendRedirect("/airportwebapp/airplanes");
    }
}
