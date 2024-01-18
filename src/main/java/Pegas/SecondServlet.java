package Pegas;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(urlPatterns={"/second","/second/*"})
public class SecondServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        StringBuffer url= request.getRequestURL();
        String uri = request.getRequestURI();
        String param1 = request.getParameter("param1");
        String param2 = request.getParameter("param2");
        PrintWriter pw = response.getWriter();
        pw.write("<html><body>");
        Map<String, String[]> params = request.getParameterMap();
        params.forEach((key, value) ->  pw.write(key + " : " + Arrays.toString(value)));
        String str = formatParams(request);
        pw.write("<p>Method GET</br>URI: "+uri+ "</br>Params:</br>"+str+"</p>");
        pw.write("<p>"+param1+"</p>");
        pw.write("<p>"+param2+"</p>");
        pw.write("<p>"+url.toString()+"</p>");
        pw.write("<a href=\"/java_Servlet_repeat/start\">start</a>");
        pw.write("</br>");
        pw.write("<a href=\"/java_Servlet_repeat/first.html\">first</a>");
        pw.write("</body></html>");
    }

    private String formatParams(HttpServletRequest request) {
        return request.getParameterMap().entrySet()
                .stream()
                .map(entry-> {
                    String param = String.join(" and ", entry.getValue());
                    return entry.getKey() + " => " + param;
                })
                .collect(Collectors.joining("\n"));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        pw.write("<h1>"+request.getParameter("login")+"</h1>");
        pw.write("<h2>"+request.getParameter("password")+"</h2>");
        pw.write("<a href=\"/java_Servlet_repeat/start\">start</a>");
        pw.write("</br>");
        pw.write("<a href=\"/java_Servlet_repeat/first.html\">first</a>");
    }
}
