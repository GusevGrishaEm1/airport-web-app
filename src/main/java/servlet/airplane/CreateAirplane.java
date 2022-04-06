package servlet.airplane;

import entity.Airplane;
import service.AirplaneService;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CreateAirplane extends HttpServlet {

    private final AirplaneService airplaneService;

    public CreateAirplane() {
        this.airplaneService = new AirplaneService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tailNumber = request.getParameter("tail_number");
        String modelName = request.getParameter("model_name");
        Integer capacity = Integer.valueOf(request.getParameter("capacity"));
        airplaneService.create(new Airplane(tailNumber, modelName, capacity));
        response.sendRedirect("/airportwebapp/airplanes");
    }
}
