package Pegas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet("/fourth")
public class FourthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        String name = req.getParameter("name");
        resp.setContentType("text/html");
        pw.write("<html><body>");
        pw.write("<h1>Hello</h1>");
        pw.write("<p>"+req.getRequestURI()+"</p>");
        pw.write("<p>"+name+"</p>");
        String param = req.getParameterMap().entrySet().stream().map(i->{
            String parametr = String.join("plus", i.getValue());
            return i.getKey()+" -----> "+parametr;
        }).collect(Collectors.joining("\n"));
        pw.write("<p>"+param+"</p>");
        pw.write("</body></html>");
//        resp.sendRedirect("http://www.google.com");
        req.getRequestDispatcher("/second").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
