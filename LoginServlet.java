package java;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException{

        String email = request.getParameter("email");
        String senha = request.getParameter("senha");

        try{

            Connection con = Conexao.conectar();

            String sql = "SELECT * FROM usuarios WHERE email=? AND senha=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1,email);
            ps.setString(2,senha);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                response.sendRedirect("html/rotas.html");
            }else{
                response.getWriter().println("Login inválido!");
            }

        }catch(Exception e){
            e.printStackTrace();
        }

    }

}
