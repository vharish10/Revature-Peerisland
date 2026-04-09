package RevConnect.dao;

import RevConnect.util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AnalyticsDAOImp{

    public int getLikeCount(int postId) throws Exception {
        String sql="select count(*) from Likes where postId=?";

        try (Connection connection=DBConnection.getConnection();
             PreparedStatement prepared=connection.prepareStatement(sql)) {

            prepared.setInt(1, postId);
            ResultSet result=prepared.executeQuery();
            return result.next()?result.getInt(1) : 0;
        }
    }

    public int getCommentCount(int postId) throws Exception {
        String sql="select count(*) from Comments where postId=?";

        try (Connection connection=DBConnection.getConnection();
             PreparedStatement prepared=connection.prepareStatement(sql)) {

            prepared.setInt(1, postId);
            ResultSet result=prepared.executeQuery();
            return result.next()?result.getInt(1):0;
        }
    }

    public int getReach(int postId) throws Exception {
        String sql = """
            select count(DISTINCT userId) FROM (
                SELECT userId FROM likes WHERE postId=?
                UNION
                SELECT userId FROM comments WHERE postId=?
            ) AS reach
        """;

        try (Connection connection=DBConnection.getConnection();
             PreparedStatement prepared=connection.prepareStatement(sql)) {

            prepared.setInt(1, postId);
            prepared.setInt(2, postId);

            ResultSet rs = prepared.executeQuery();
            return rs.next() ? rs.getInt(1) : 0;
        }
    }
}