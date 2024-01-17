package Pegas;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");
        PrintWriter pw = response.getWriter();
        pw.write("<html><body>");
        Map<String, String[]> params = request.getParameterMap();
        params.forEach((key, value) ->  pw.write(key + " : " + Arrays.toString(value)));
        pw.write("<p>"+param1+"<p>");
        pw.write("<p>"+param2+"<p>");
        pw.write("<a href=\"/java_Servlet_repeat-1.0-SNAPSHOT/start\">start</a>");
        pw.write("</br>");
        pw.write("<a href=\"/java_Servlet_repeat-1.0-SNAPSHOT/first.html\">first</a>");
        pw.write("<body><html>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.write("<h1>"+request.getParameter("login")+"</h1>");
        pw.write("<h2>"+request.getParameter("password")+"</h2>");
        pw.write("<a href=\"/java_Servlet_repeat-1.0-SNAPSHOT/start\">start</a>");
        pw.write("</br>");
        pw.write("<a href=\"/java_Servlet_repeat-1.0-SNAPSHOT/first.html\">first</a>");
    }
}
