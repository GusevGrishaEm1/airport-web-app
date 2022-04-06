package servlet.baggage;

import service.BaggageService;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class DeleteBaggage extends HttpServlet {

    private final BaggageService baggageService;

    public DeleteBaggage() {
        this.baggageService = new BaggageService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        baggageService.delete(id);
        response.sendRedirect("/airportwebapp/baggagies");
    }
}
