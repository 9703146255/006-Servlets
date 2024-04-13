package in.ashokit.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ashokit.dao.ProductDao;
import in.ashokit.entity.Product;

@WebServlet("/productServlet")
public class ProductServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProductDao productDao = new ProductDao();
            List<Product> products = productDao.getAllProducts();
            
            
            request.setAttribute("products", products);
            
            
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the exception appropriately
        }
    }
}

