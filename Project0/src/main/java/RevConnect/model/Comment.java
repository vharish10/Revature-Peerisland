package RevConnect.model;

import java.sql.Timestamp;

public class Comment {

    private int commentId;
    private int userId;
    private int postId;
    private String commentText;
    private Timestamp createdAt;

    public Comment(int userId, int postId, String commentText) {
        this.userId = userId;
        this.postId = postId;
        this.commentText = commentText;
    }

    public int getCommentId(){
        return commentId;
    }

    public int getUserId(){
        return userId;
    }

    public int getPostId(){
        return postId;
    }

    public String getCommentText(){
        return commentText;
    }

    public Timestamp getCreatedAt(){
        return createdAt;
    }
}