package action;

import com.example.dev_avancee3.UserBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class LoginAction implements Action{
    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "admin".equals(password)) {
            UserBean user = new UserBean();
            user.setNom(username);
            user.setAttribut1("default1");
            user.setAttribut2("default2");

            HttpSession session = request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("Page1.jsp");
        } else {
            response.sendRedirect("erreur.jsp");
        }
    }
}