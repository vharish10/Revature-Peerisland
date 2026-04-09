package RevConnect.model;

public class Likes {

    private int likeId;
    private int userId;
    private int postId;

    public Likes(int userId, int postId) {
        this.userId = userId;
        this.postId = postId;
    }

    public int getLikeId(){
        return likeId;
    }

    public int getUserId(){
        return userId;
    }

    public int getPostId(){
        return postId;
    }

}