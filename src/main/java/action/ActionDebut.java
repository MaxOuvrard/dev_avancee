package action;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ActionDebut implements Action{
    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return("login.jsp");
    }
}
