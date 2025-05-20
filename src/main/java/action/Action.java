package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Action {
    void perform(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
