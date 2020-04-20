import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// TODO: 5. Create a page view counter
//          a. Create a page that displays a number that goes up by one every time the /count page is viewed.
//          ------------BONUS------------
//          b. Allow the user to pass a parameter in the query string to reset the counter.

@WebServlet(name = "CounterServlet", urlPatterns = "/count")
public class CounterServlet extends HttpServlet {

    // --------- INITIALIZE ---------
    private int counter = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {


        // --------- RESPONSE TYPE ---------
        response.setContentType("text/html"); // set the response type

        // --------- RESPONSE ACTION ---------
        String reset = request.getParameter("reset"); // Allow user to reset the counter variable set

        PrintWriter out = response.getWriter(); // store the response.getWriter() in the variable out

        if (reset != null && reset.equalsIgnoreCase("reset"))
            counter = 0; // reset counter to zero

        counter++; // increment the counter for every request

        out.println("<h1>The current page count is: " + counter+ "</h1>");
    }

}

