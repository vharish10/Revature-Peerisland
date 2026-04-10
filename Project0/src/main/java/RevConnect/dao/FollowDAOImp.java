package RevConnect.dao;

import java.sql.*;
import java.util.*;
import RevConnect.util.DBConnection;

public class FollowDAOImp {

    public boolean exists(int followerId, int followingId) throws Exception{
        String sql="select 1 from Follow where followerId=? and followingId=?";

        try(Connection connection=DBConnection.getConnection();
             PreparedStatement prepared=connection.prepareStatement(sql)) {

            prepared.setInt(1, followerId);
            prepared.setInt(2, followingId);

            ResultSet result=prepared.executeQuery();
            return result.next();
        }
    }

    public void follow(int followerId, int followingId) throws Exception{
        String sql = "insert into Follow(followerId, followingId) values(?, ?)";

        try (Connection connection=DBConnection.getConnection();
             PreparedStatement prepared =connection.prepareStatement(sql)) {

            prepared.setInt(1, followerId);
            prepared.setInt(2, followingId);
            prepared.executeUpdate();
        }
    }

    public int unfollow(int followerId, int followingId) throws Exception{
        String sql="delete from Follow where followerId=? and followingId=?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement prepared = connection.prepareStatement(sql)) {

            prepared.setInt(1, followerId);
            prepared.setInt(2, followingId);

            return prepared.executeUpdate();
        }
    }

    public List<Integer> getFollowers(int userId) throws Exception{
        List<Integer> list = new ArrayList<>();

        String sql="select followerId from Follow where followingId=?";

        try (Connection connection=DBConnection.getConnection();
             PreparedStatement prepared=connection.prepareStatement(sql)) {

            prepared.setInt(1, userId);
            ResultSet result=prepared.executeQuery();

            while (result.next()) {
                list.add(result.getInt("followerId"));
            }
        }

        return list;
    }

    public List<Integer> getFollowing(int userId) throws Exception{
        List<Integer> list = new ArrayList<>();

        String sql="select followingId from Follow where followerId=?";

        try(Connection connection=DBConnection.getConnection();
            PreparedStatement prepared=connection.prepareStatement(sql)){

            prepared.setInt(1, userId);
            ResultSet rs = prepared.executeQuery();

            while (rs.next()) {
                list.add(rs.getInt("followingId"));
            }
        }

        return list;
    }
}
