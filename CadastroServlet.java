package java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException{

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String tipo = request.getParameter("tipo");

        try{

            Connection con = Conexao.conectar();

            String sql = "INSERT INTO usuarios(nome,email,senha,tipo) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,nome);
            ps.setString(2,email);
            ps.setString(3,senha);
            ps.setString(4,tipo);

            ps.executeUpdate();

            response.sendRedirect("html/login.html");

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
