package servlet.baggage;

import entity.Baggage;
import service.BaggageService;
import service.PersonService;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class CreateBaggage extends HttpServlet {

    private final BaggageService baggageService;
    private final PersonService personService;

    public CreateBaggage() {
        this.baggageService = new BaggageService();
        this.personService = new PersonService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type = request.getParameter("type");
        Integer weight = Integer.valueOf(request.getParameter("weight"));
        Integer personId = Integer.valueOf(request.getParameter("person_id"));
        baggageService.create(new Baggage(type, weight, personService.getById(personId)));
        response.sendRedirect("/airportwebapp/baggagies");
    }
}
