package action;

import com.example.dev_avancee4.UserBean;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class ActionUn implements Action{

    @Override
    public String perform(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");

        if (user != null) {
            String attribut1 = request.getParameter("attribut2");
            String attribut2 = request.getParameter("attribut3");

            if (attribut1 == null || attribut1.isEmpty() || attribut2 == null || attribut2.isEmpty()) {
                session.setAttribute("errorMessage", "Invalid attributes");
                return "vide.jsp";
            } else {
                user.setAttribut1(attribut1);
                user.setAttribut2(attribut2);
                session.setAttribute("user", user);
                return "Page1.jsp";
            }
        }

        return "vide.jsp";
    }
}
