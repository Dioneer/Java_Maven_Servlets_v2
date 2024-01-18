package Pegas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/temp-serv")
public class JspServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User>users = new ArrayList<User>(){{
            add(new User("Igor", "Iran", 25));
            add(new User("Dima", "Vietnam", 35));
            add(new User("Domna", "Thailand", 15));
        }};
        req.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/").forward(req,resp);
    }
}
