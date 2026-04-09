package RevConnect.dao;

import RevConnect.util.DBConnection;
import java.sql.*;
import java.util.*;

public class ConnectionDAOImp {

    public List<Integer> getConnections(int userId) throws Exception {

        List<Integer> list = new ArrayList<>();

        String sql = """
        SELECT 
            CASE 
                WHEN senderId = ? THEN receiverId
                ELSE senderId
            END AS userId
        FROM Connections
        WHERE (senderId = ? OR receiverId = ?)
        AND status = 'ACCEPTED'
        """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement prepared = connection.prepareStatement(sql)) {

            prepared.setInt(1, userId);
            prepared.setInt(2, userId);
            prepared.setInt(3, userId);

            ResultSet result = prepared.executeQuery();

            while (result.next()) {
                list.add(result.getInt("userId"));
            }
        }

        return list;
    }

    public boolean requestExists(int senderId, int receiverId) throws Exception {

        String sql = "SELECT 1 FROM Connections WHERE senderId = ? AND receiverId = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement prepared = connection.prepareStatement(sql)) {

            prepared.setInt(1, senderId);
            prepared.setInt(2, receiverId);

            ResultSet result = prepared.executeQuery();
            return result.next();
        }
    }

    public void sendRequest(int senderId, int receiverId) throws Exception {

        String sql = "INSERT INTO Connections(senderId, receiverId, status) VALUES (?, ?, 'PENDING')";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement prepared = connection.prepareStatement(sql)) {

            prepared.setInt(1, senderId);
            prepared.setInt(2, receiverId);
            prepared.executeUpdate();
        }
    }

    public int updateStatus(int senderId, int receiverId, String status) throws Exception {

        String sql = "UPDATE Connections SET status = ? WHERE senderId = ? AND receiverId = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement prepared = connection.prepareStatement(sql)) {

            prepared.setString(1, status);
            prepared.setInt(2, senderId);
            prepared.setInt(3, receiverId);

            return prepared.executeUpdate();
        }
    }

    public boolean connectionExists(int senderId, int receiverId) throws Exception {

        String sql = "SELECT 1 FROM Connections WHERE senderId = ? AND receiverId = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement prepared = connection.prepareStatement(sql)) {

            prepared.setInt(1, senderId);
            prepared.setInt(2, receiverId);

            ResultSet result = prepared.executeQuery();
            return result.next();
        }
    }
}