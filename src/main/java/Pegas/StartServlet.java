package Pegas;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.logging.Logger;

@WebServlet("/start")
public class StartServlet extends HttpServlet {
    private final static Logger log = Logger.getLogger(StartServlet.class.getName());
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log.info("Method init =)");
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String header = request.getHeader("user-agent");
        Enumeration<String> headerNames = request.getHeaderNames();
        PrintWriter pw = response.getWriter();
        response.setHeader("Myheader","5");
        pw.write("<html><body>");
        pw.write("<p>Let's start this game!</p>");
        pw.write("<p> GetContentType: "+request.getContentType()+"</p>");
        pw.write("<p> GetContentType: "+request.getContentLength()+"</p>");
        pw.write("<p> HEADERS!!!!!!!!!!!! </p>");
        while(headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            pw.write("<p>"+s +request.getHeader(s) +" "+" "+"</p>");
        }
        pw.write("<p>"+header+"</p>");
        pw.write("<a href=\"/java_Servlet_repeat/second\">second</a>");
        pw.write("</br>");
        pw.write("<a href=\"/java_Servlet_repeat/first.html\">first</a>");
        pw.write("</body></html>");
    }

    public void destroy(){
        log.info("Method destroy =)");
    }
}
