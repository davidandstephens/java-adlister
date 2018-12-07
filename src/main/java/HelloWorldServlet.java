import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String output = "<h1>Hello World!</h1>";
        String namePassed = req.getParameter("name");
        if (namePassed == null) {
            res.getWriter().print(output);
        } else {
            res.getWriter().print("<h1>Hello " + namePassed + "</h1>");
        }
    }
}
