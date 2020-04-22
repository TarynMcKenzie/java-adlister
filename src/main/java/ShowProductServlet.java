import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowProductServlet", urlPatterns= "/products/show")
public class ShowProductServlet extends HttpServlet {
    // 1. Listen for user request to view the products

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1. check the product ID --> parse the id
        long productID = Long.parseLong(request.getParameter("id"));

        // 2. Connect to DAO Factory
        Products productDao = DaoFactory.getProductsDao();

        // 3. Get product id
        Product product = productDao.findById(productID);

        // 4. set the object to product
        request.setAttribute("product", product);
        request.getRequestDispatcher("/products/product-show.jsp").forward(request,response);
    }

}
