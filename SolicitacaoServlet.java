package java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet("/SolicitacaoServlet")

public class SolicitacaoServlet extends HttpServlet{

protected void doPost(HttpServletRequest request,
HttpServletResponse response)

throws ServletException,IOException{

int rota =
Integer.parseInt(
request.getParameter("rota")
);

try{

Connection con =
Conexao.conectar();

PreparedStatement ps =
con.prepareStatement(
"INSERT INTO solicitacoes(rota_id,passageiro_id,status) VALUES(?,?,?)"
);

ps.setInt(1,rota);

ps.setInt(2,2);

ps.setString(3,"PENDENTE");

ps.executeUpdate();

response.getWriter().println("Solicitação enviada!");

}catch(Exception e){

e.printStackTrace();

}

}

}
