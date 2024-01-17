package Pegas;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebServlet("/start")
public class StartServlet extends HttpServlet {
    private String message;

    public void init(){
        message = "Hi mahi!";
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String header = request.getHeader("user-agent");
        Enumeration<String> headerNames = request.getHeaderNames();
        PrintWriter pw = response.getWriter();
        response.setHeader("Myheader","5");
        pw.write("<html><body>");
        pw.write("<p>Let's start this game!</p>");
        while(headerNames.hasMoreElements()){
            String s = headerNames.nextElement();
            pw.write("<p>"+s +request.getHeader(s) +" "+" "+"</p>");
        }
        pw.write("<p>"+message+"</p>");
        pw.write("<p>"+header+"</p>");
        pw.write("<body><html>");
        pw.write("<a href=\"/java_Servlet_repeat-1.0-SNAPSHOT/second\">second</a>");
        pw.write("</br>");
        pw.write("<a href=\"/java_Servlet_repeat-1.0-SNAPSHOT/first.html\">first</a>");
    }
    public void destroy(){}
}
