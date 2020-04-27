import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// This is what the user will type into chrome
@WebServlet(name = "ShowAdsServlet", urlPatterns = "/ads")
public class ShowAdsServlet extends HttpServlet {

    // this is my magic: I am telling the browser what file to load
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Use the factory to get the dao object
        Ads adsDao = DaoFactory.getAdsDao();
        // Use a method on the dao to get all the products
        List<Ad> ads = adsDao.all();
        // Pass the data to the jsp
        request.setAttribute("ads", ads);

        request.getRequestDispatcher("WEB-INF/ads/index.jsp").forward(request, response); // send the updates request and response to the jsp page

    }
}