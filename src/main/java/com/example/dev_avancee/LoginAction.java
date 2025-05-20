package com.example.dev_avancee;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class LoginAction extends HttpServlet {

    private boolean isValidLogin(String username, String password) {
        return "admin".equals(username) && "admin".equals(password);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (isValidLogin(username, password)) {
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
