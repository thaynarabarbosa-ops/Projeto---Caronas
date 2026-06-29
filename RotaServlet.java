package java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/RotaServlet")

public class RotaServlet extends HttpServlet{

protected void doPost(HttpServletRequest request,
HttpServletResponse response)

throws ServletException,IOException{

String origem =
request.getParameter("origem");

String destino =
request.getParameter("destino");

String horario =
request.getParameter("horario");

int vagas =
Integer.parseInt(
request.getParameter("vagas")
);

try{

Connection con =
Conexao.conectar();

String sql =
"INSERT INTO rotas(motorista_id,origem,destino,horario,vagas) VALUES(1,?,?,?,?)";

PreparedStatement ps =
con.prepareStatement(sql);

ps.setString(1,origem);

ps.setString(2,destino);

ps.setString(3,horario);

ps.setInt(4,vagas);

ps.executeUpdate();

response.sendRedirect("html/busca.html");

}catch(Exception e){

e.printStackTrace();

}

}

}
