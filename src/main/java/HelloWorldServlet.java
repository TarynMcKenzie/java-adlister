// TODO: 1. Fork and clone the Adlister Repository

// TODO: 2. Checkout the servlets tag and branch off of it
//          a. git checkout servlets
//          b. git branch servlets-exercise
//          c. git checkout servlets-exercise

// TODO: 3. Configure IntelliJ for the project
//          a. See this section in the appendix for more details.


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


// TODO: 4. Finish up the Hello World Servlet
//          a. Create a page that displays "Hello World!" when a user visits /hello
//          ------------BONUS------------
//          b. Make the page say "Hello, <name>!" if name is passed as part of the query string (e.g. /hello?name=codeup), otherwise default to "Hello, World!".


@WebServlet(name = "HelloWorldServlet", urlPatterns = "/")
public class HelloWorldServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // --------- RESPONSE TYPE ---------
        response.setContentType("text/html"); // set the response type

        // --------- RESPONSE ACTION ---------
        String name = request.getParameter("name");

        PrintWriter out = response.getWriter(); // store the response.getWriter() in the variable out

        if (name != null)
            out.println("<h1>Hello, " + name + "!</h1>"); // use the out variable --> print to the html the Greeting --> "<h1>Hello, World!</h1>"
        else
            out.println("<h1>Hello, World!</h1>");


        // ---------------- INSTRUCTOR WALKTHROUGH --------------
//        String pageHtml = "<h1>Hello, World!</h1>";
//        //VERSION ONE
//        //checks to see if parameter of name exists
//
//        if (request.getParameterMap().containsKey("name")) {
//
//            //sets name to String name
//            String name = request.getParameter("name");
//
//            if (!name.equals("")) {
//                System.out.println(name);
//                pageHtml = "<h1>Hello, " + name + "!</h1>";
//            }
//        }
//
//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println(pageHtml);
    }


}
