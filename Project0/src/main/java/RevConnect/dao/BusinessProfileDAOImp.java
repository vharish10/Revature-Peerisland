package RevConnect.dao;

import RevConnect.model.BusinessProfile;
import RevConnect.util.DBConnection;
import java.sql.*;
import java.sql.ResultSet;
import java.util.*;

public class BusinessProfileDAOImp {

    public String createOrUpdateProfile(BusinessProfile profile) {
        String sql = """
            insert into BusinessProfile(userId, businessName, category, bio, address, contactInfo, website, businessHours)
            values (?, ?, ?, ?, ?, ?, ?, ?)
            ON DUPLICATE KEY UPDATE
            business_name=?, category=?, bio=?, address=?, contact_info=?, website=?, business_hours=?
        """;

        try (Connection connection=DBConnection.getConnection();
             PreparedStatement prepared=connection.prepareStatement(sql)) {

            prepared.setInt(1, profile.getUserId());
            prepared.setString(2, profile.getBusinessName());
            prepared.setString(3, profile.getCategory());
            prepared.setString(4, profile.getBio());
            prepared.setString(5, profile.getAddress());
            prepared.setString(6, profile.getContactInfo());
            prepared.setString(7, profile.getWebsite());
            prepared.setString(8, profile.getBusinessHours());

            prepared.setString(9, profile.getBusinessName());
            prepared.setString(10, profile.getCategory());
            prepared.setString(11, profile.getBio());
            prepared.setString(12, profile.getAddress());
            prepared.setString(13, profile.getContactInfo());
            prepared.setString(14, profile.getWebsite());
            prepared.setString(15, profile.getBusinessHours());

            prepared.executeUpdate();
            return "✅ Business profile saved!";

        } catch (Exception e) {
            e.printStackTrace();
            return "❌ Error saving profile!";
        }
    }
}