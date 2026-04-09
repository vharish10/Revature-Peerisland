package RevConnect.dao;

import RevConnect.util.DBConnection;

import java.sql.*;

public class LikeDAOImp {

    public boolean postExists(int postId) throws Exception {
        String sql = "select 1 from Posts where postId=?";

        try (Connection connection=DBConnection.getConnection();
             PreparedStatement prepared =connection.prepareStatement(sql)) {

            prepared.setInt(1, postId);
            ResultSet result = prepared.executeQuery();

            return result.next();
        }
    }

    public boolean isAlreadyLiked(int userId, int postId) throws Exception {
        String sql = "select 1 from Likes where userId=? and postId=?";

        try (Connection connection=DBConnection.getConnection();
             PreparedStatement prepared = connection.prepareStatement(sql)) {

            prepared.setInt(1, userId);
            prepared.setInt(2, postId);

            ResultSet result=prepared.executeQuery();
            return result.next();
        }
    }

    public void addLike(int userId, int postId) throws Exception {
        String sql = "insert into Likes(userId, postId) values (?, ?)";

        try (Connection connection=DBConnection.getConnection();
             PreparedStatement prepared=connection.prepareStatement(sql)) {

            prepared.setInt(1, userId);
            prepared.setInt(2, postId);
            prepared.executeUpdate();
        }
    }

    public int removeLike(int userId, int postId) throws Exception {
        String sql="delete from Likes where userId=? and postId=?";

        try (Connection connection=DBConnection.getConnection();
             PreparedStatement prepared=connection.prepareStatement(sql)) {

            prepared.setInt(1, userId);
            prepared.setInt(2, postId);

            return prepared.executeUpdate();
        }
    }
}