package RevConnect.dao;

import RevConnect.model.Post;
import RevConnect.util.DBConnection;
import java.sql.*;
import java.sql.ResultSet;
import java.util.*;

public class PostDAOImp {

    public String createPost(Post post) {
        String sql = "insert into Posts (userId, content,postType) values (?,?,?)";

        try (Connection connection=DBConnection.getConnection();
             PreparedStatement prepared =connection.prepareStatement(sql)) {

            prepared.setInt(1, post.getUserId());
            prepared.setString(2, post.getContent());
            prepared.setString(3, post.getPostType());

            if(prepared.executeUpdate()>0) {
                return "User Post created";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Post creation failed";
        }
        return " ";
    }

    public List<Post> getAllPosts() {
        List<Post> list=new ArrayList<>();

        String sql="select * from Posts order by creationDate desc";

        try(Connection connection=DBConnection.getConnection();
             PreparedStatement prepared=connection.prepareStatement(sql);
             ResultSet result =prepared.executeQuery()){

            while(result.next()){
                Post post=new Post(
                        result.getInt("user_id"),
                        result.getString("content")
                );
                list.add(post);
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return list;
    }

    public String deletePost(int postId, int userId) {
        String sql = "delete from Posts where postId=? and userId=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, postId);
            ps.setInt(2, userId);

            if(ps.executeUpdate() > 0){
                return "Post deleted";
            }
            else{
                return "Post deletion failed";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Error while deleting post";
        }
    }

    public String updatePost(int postId, int userId, String content) {
        String sql = "update Posts set content=? where postId=? and userId=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, content);
            ps.setInt(2, postId);
            ps.setInt(3, userId);

            if(ps.executeUpdate() > 0){
                return "Post updated";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "Post not found";
        }
        return " ";
    }

    public List<Post> getFeedPosts(List<Integer> userIds) throws Exception {
        List<Post> list = new ArrayList<>();
        if (userIds.isEmpty()){
            return list;
        }
        StringBuilder sql = new StringBuilder("select * from Posts where userId IN (");

        for(int i=0;i<userIds.size();i++){
            sql.append("?");
            if(i<userIds.size()-1){
                sql.append(",");
            }
        }
        sql.append(") order by creationDate desc");

        try (Connection connection=DBConnection.getConnection();
             PreparedStatement prepared =connection.prepareStatement(sql.toString())) {

            for(int i=0;i<userIds.size();i++){
                prepared.setInt(i+1,userIds.get(i));
            }

            ResultSet result=prepared.executeQuery();

            while (result.next()) {
                Post p=new Post(result.getInt("userId"),result.getString("content"));
                list.add(p);
            }
        }
        return list;
    }
}
