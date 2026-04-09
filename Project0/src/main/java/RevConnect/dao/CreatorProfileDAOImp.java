package RevConnect.dao;


import RevConnect.model.CreatorProfile;
import RevConnect.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CreatorProfileDAOImp {

    public String createOrUpdateProfile(CreatorProfile profile) {

        String sql = """
            insert ino catorprofiles(userId, category, bio, youtubeLink, instagramLink, twitterLink)
            values (?, ?, ?, ?, ?, ?)
            ON DUPLICATE KEY UPDATE
            category=?, bio=?, youtubeLink=?, instagramLink=?, twitterLink=?
        """;

        try (Connection connection=DBConnection.getConnection();
             PreparedStatement prepared=connection.prepareStatement(sql)) {

            prepared.setInt(1, profile.getUserId());
            prepared.setString(2, profile.getCategory());
            prepared.setString(3, profile.getBio());
            prepared.setString(4, profile.getYoutubeLink());
            prepared.setString(5, profile.getInstagramLink());
            prepared.setString(6, profile.getTwitterLink());

            prepared.setString(7, profile.getCategory());
            prepared.setString(8, profile.getBio());
            prepared.setString(9, profile.getYoutubeLink());
            prepared.setString(10, profile.getInstagramLink());
            prepared.setString(11, profile.getTwitterLink());

            prepared.executeUpdate();

            return "Creator profile saved";

        } catch (Exception e) {
            e.printStackTrace();
            return "Error saving creator profile";
        }
    }

    public int getFollowerCount(int userId) throws Exception {
        String sql = "select count(*) from follows where followingId=?";

        try (Connection connection=DBConnection.getConnection();
             PreparedStatement prepared =connection.prepareStatement(sql)) {

            prepared.setInt(1, userId);
            ResultSet result=prepared.executeQuery();
            return result.next()?result.getInt(1) : 0;
        }
    }

}