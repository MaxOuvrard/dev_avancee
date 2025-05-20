package controller;

import action.*;
import com.example.dev_avancee3.UserBean;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "dispatcherServlet", urlPatterns = "*.do")
public class DispatcherServlet extends HttpServlet {
    private HashMap<String, Action> actions = new HashMap<>();

    @Override
    public void init() throws ServletException {
        actions.put("loginServlet.do", new LoginAction());
        actions.put("logoutServlet.do", new LogoutAction());
        actions.put("updateAttributesServlet.do",new ActionUn());
        actions.put("debut_servlet.do",new ActionDebut());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath().substring(1);
        try {
            actions.get(path).perform(request,response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath().substring(1);
        try {
            actions.get(path).perform(request,response);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
