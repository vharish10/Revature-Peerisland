package RevConnect.dao;

import RevConnect.model.Comment;
import RevConnect.util.DBConnection;

import java.sql.*;
import java.util.*;

public class CommentDAOImp {

    public void addComment(Comment comment) throws Exception {
        String sql = "insert into comments(userId, postId, commentText) values (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, comment.getUserId());
            ps.setInt(2, comment.getPostId());
            ps.setString(3, comment.getCommentText());

            ps.executeUpdate();
        }
    }

    public List<Comment> getCommentsByPost(int postId) throws Exception {
        List<Comment> list = new ArrayList<>();

        String sql = "select * from comments where postId=? order by createdAt desc";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, postId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Comment c = new Comment(
                        rs.getInt("userId"),
                        rs.getInt("postId"),
                        rs.getString("commentText")
                );
                list.add(c);
            }
        }

        return list;
    }

    public int deleteComment(int commentId, int userId) throws Exception {
        String sql = "delete from comments where commentId=? AND userId=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, commentId);
            ps.setInt(2, userId);

            return ps.executeUpdate();
        }
    }
    public boolean commentExists(int commentId) throws Exception {
        String sql = "SELECT 1 FROM comments WHERE commentId=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, commentId);
            ResultSet rs = ps.executeQuery();

            return rs.next();
        }
    }
}