package action;

import com.example.dev_avancee3.UserBean;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.jboss.weld.context.http.Http;

import java.io.IOException;

public class ActionUn implements Action{

    @Override
    public void perform(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        UserBean user = (UserBean) session.getAttribute("user");

        if (user != null) {
            String attribut1 = request.getParameter("attribut2");
            String attribut2 = request.getParameter("attribut3");

            user.setAttribut1(attribut1);
            user.setAttribut2(attribut2);

            session.setAttribute("user", user);
        }

        response.sendRedirect("Page1.jsp");
    }
}
