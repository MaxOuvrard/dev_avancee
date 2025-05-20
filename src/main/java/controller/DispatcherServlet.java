package controller;

import action.Action;
import factory.Factory;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class DispatcherServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath().substring(1);
        try {
            Action action = Factory.get(path);
            if (action != null) {
                String nextPage = action.perform(request, response);
                if (nextPage != null) {
                    request.getRequestDispatcher("/" + nextPage).forward(request, response);
                }
            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Action non trouvée");
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
