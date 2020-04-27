import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewProfileServlet", urlPatterns = "/profile")
public class ViewProfileServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //If the user is not logged in --> Send them to the login page
        if (request.getSession().getAttribute("user") == null) {

            // This is were we are sending them
            response.sendRedirect("/login");
            return;

        }

        // This is where the request is coming from
        request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);

    }
}
