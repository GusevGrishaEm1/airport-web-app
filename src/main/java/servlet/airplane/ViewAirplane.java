package servlet.airplane;

import entity.Airplane;
import service.AirplaneService;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ViewAirplane extends HttpServlet {

    private final AirplaneService airplaneService;

    public ViewAirplane() {
        this.airplaneService = new AirplaneService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        if (id != null) {
            Airplane airplane = airplaneService.getById(Integer.parseInt(id));
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("airplane", airplane);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/airplane.jsp");
            requestDispatcher.forward(request, response);
        } else {
            List<Airplane> airplanes = airplaneService.getAll();
            HttpSession session = request.getSession();
            session.setAttribute("list", airplanes);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/jsp/airplanes.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}

