package RevConnect.dao;

import RevConnect.util.DBConnection;
import RevConnect.model.*;
import java.sql.*;
import java.sql.Connection;

public class ProductDAOImp {

    public String addProduct(Products product) {
        String sql = "INSERT INTO products(user_id, name, description, price) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, product.getUserId());
            ps.setString(2, product.getName());
            ps.setString(3, product.getDescription());
            ps.setDouble(4, product.getPrice());

            ps.executeUpdate();
            return "✅ Product added!";

        } catch (Exception e) {
            e.printStackTrace();
            return "❌ Error adding product!";
        }
    }
}
