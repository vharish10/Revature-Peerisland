package RevConnect.model;

import java.sql.Timestamp;

public class Post {
    private int postId;
    private int userId;
    private String content;
    private Timestamp creationDate;
    private String postType;
    private String cta;
    private Timestamp scheduledTime;

    public Post(int userId,String content) {
        this.userId = userId;
        this.content = content;
    }

    public void setUserId(int userId){
        this.userId=userId;
    }

    public void setContent(String content){
        this.content=content;
    }

    public int getPostId(){
        return postId;
    }

    public int getUserId(){
        return userId;
    }

    public String getContent(){
        return content;
    }

    public Timestamp getCreatedAt(){
        return creationDate;
    }

    public String getPostType(){
        return postType;
    }

    public void setPostType(String postType) {
        this.postType = postType;
    }

    public void setCta(String cta) {
        this.cta = cta;
    }

    public void setScheduledTime(Timestamp scheduledTime) {
        this.scheduledTime = scheduledTime;
    }

    public String getCta(){
        return cta;
    }

    public Timestamp getScheduledTime(){
        return scheduledTime;
    }
}
