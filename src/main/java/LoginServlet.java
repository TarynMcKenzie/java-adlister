import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {


    // ------ GET IT -------
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // If the user is an admin --> send them to their profile page
        if (request.getSession().getAttribute("user") != null) {

            // Send the user here
            response.sendRedirect("/profile");
            return;
        }

        // If the user is not an admin --> send them to the login page
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }


    // ------ SEND IT -------
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt = username.equals("admin") && password.equals("password");

        if (validAttempt) {

            request.getSession().setAttribute("user", username);
            // Send the user here
            response.sendRedirect("/profile");

        } else {

            // Send the user here
            response.sendRedirect("/login");

        }

    }
}
