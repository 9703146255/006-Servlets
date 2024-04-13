package in.ashokit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import in.ashokit.entity.Product;

public class ProductDao {
    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
        Connection conn = ConnectionFactory.getConnection().
        try (Statement stmt = conn.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt("product_id"));
                product.setName(resultSet.getString("product_name"));
                product.setPrice(resultSet.getDouble("product_price"));
                product.setBuyer(resultSet.getString("product_buyer"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
}

	
	
	


