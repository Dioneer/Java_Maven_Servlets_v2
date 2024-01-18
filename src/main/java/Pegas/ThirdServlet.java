package Pegas;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = {"/third"})
@MultipartConfig(location = "D:\\backup\\4\\java_Servlet_repaet")
public class ThirdServlet extends HttpServlet {
    private final static Logger log = Logger.getLogger(ThirdServlet.class.getName());
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParts().forEach(i-> {
            if(i.getName().equals("author-name")){
                try(InputStream is = i.getInputStream();InputStreamReader isr= new InputStreamReader(is)){
                    String authorName=new BufferedReader(isr).lines().collect(Collectors.joining("\n"));
                    log.info(authorName);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else{
                try {
                    i.write(UUID.randomUUID() + i.getSubmittedFileName());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        resp.sendRedirect("/java_Servlet_repeat/second");
    }
}
