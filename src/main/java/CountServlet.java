import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/count")
public class CountServlet extends HttpServlet {
    private int count = 1;

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String numPassed = req.getParameter("num");
        if (numPassed == null) {
            res.getWriter().print("<h1>This page done went been seent: " + count + " times.</h1>");
        } else {
            count = Integer.parseInt(numPassed);
            res.getWriter().print("<h1>This page done went been seent: " + count + " times.</h1>");
        }
        count++;
    }
}
