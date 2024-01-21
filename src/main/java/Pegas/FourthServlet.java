package Pegas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet("/fourth")
public class FourthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        HttpSession session = req.getSession();
        Cookie cookie = new Cookie("some_id", "123");
        cookie.setMaxAge(24*60*60);
        resp.addCookie(cookie);
        Cart cart = (Cart)session.getAttribute("cart");
        cart = cart==null ? new Cart() : cart;
        Map<String, String[]> params = req.getParameterMap();
        String brand = "";
        String quantity = "";
        for(Map.Entry<String, String[]> item: params.entrySet()){
            if(item.getKey().equals("name")){
                brand = Arrays.toString(item.getValue());
                cart.setName(brand);
            }
            if(item.getKey().equals("quantity")){
                quantity = Arrays.toString(item.getValue());
                cart.setQuantity(quantity);
            }
        }
        session.setAttribute("cart",cart);
        Integer count = (Integer) session.getAttribute("count");
        count = count == null ? 1 : ++count;
        session.setAttribute("count", count);
        String name = req.getParameter("name");
        session.setAttribute("count", count);
        resp.setContentType("text/html");
        pw.write("<html><body>");
        pw.write("<h1>Hello</h1>");
        pw.write("<h2>Your count is:"+count+"</h2>");
        pw.write("<h2>Your count is:"+session.getAttribute("cart")+"</h2>");
        pw.write("<p>"+req.getRequestURI()+"</p>");
//        pw.write("<p>"+name+"</p>");
        String param = req.getParameterMap().entrySet().stream().map(i->{
            String parametr = String.join("plus", i.getValue());
            return i.getKey()+" -----> "+parametr;
        }).collect(Collectors.joining("\n"));
        pw.write("<p>"+param+"</p>");
        pw.write("</body></html>");
//        resp.sendRedirect("http://www.google.com");
//        req.getRequestDispatcher("/second").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
