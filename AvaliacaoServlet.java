package java;

import java.io.IOException;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/AvaliacaoServlet")

public class AvaliacaoServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)

    throws ServletException, IOException{

        response.getWriter().println("Avaliação registrada com sucesso!");

    }

}
