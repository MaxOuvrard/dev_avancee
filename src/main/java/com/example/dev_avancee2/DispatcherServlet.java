package com.example.dev_avancee2;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "dispatcherServlet", urlPatterns = "*.do")
public class DispatcherServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath().substring(1);
        switch (path) {
            case "debut_servlet.do":
                response.sendRedirect("login.jsp");
                break;
            case "logoutServlet.do":
                HttpSession session = request.getSession();
                session.invalidate();
                response.sendRedirect("GoodBye.jsp");
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath().substring(1);
        switch (path) {
            case "loginServlet.do":
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
                break;
            case "updateAttributesServlet.do":
                HttpSession session = request.getSession();
                UserBean user = (UserBean) session.getAttribute("user");

                if (user != null) {
                    String attribut1 = request.getParameter("attribut1");
                    String attribut2 = request.getParameter("attribut2");

                    user.setAttribut1(attribut1);
                    user.setAttribut2(attribut2);

                    session.setAttribute("user", user);
                }

                response.sendRedirect("Page1.jsp");
                break;
        }
    }
}
