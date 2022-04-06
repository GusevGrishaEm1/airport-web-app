package servlet.baggage;

import entity.Baggage;
import service.BaggageService;
import service.PersonService;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class UpdateBaggage extends HttpServlet {

    private final BaggageService baggageService;
    private final PersonService personService;

    public UpdateBaggage() {
        this.baggageService = new BaggageService();
        this.personService = new PersonService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.valueOf(request.getParameter("id"));
        String type = request.getParameter("type");
        Integer weight = Integer.valueOf(request.getParameter("weight"));
        Integer personId = Integer.valueOf(request.getParameter("person_id"));
        baggageService.update(new Baggage(id, type, weight, personService.getById(personId)));
        response.sendRedirect("/airportwebapp/baggagies");
    }
}
