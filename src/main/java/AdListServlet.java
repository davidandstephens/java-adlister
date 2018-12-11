import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdListServlet", urlPatterns = "/ads")
public class AdListServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Ads adao = DaoFactory.getAdsDao();
        request.setAttribute("ads", adao.all());
        request.getRequestDispatcher("ads/index.jsp").forward(request, response);
    }
}