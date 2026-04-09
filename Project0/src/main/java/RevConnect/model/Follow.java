package RevConnect.model;

public class Follow {

    private int followId;
    private int followerId;
    private int followingId;

    public Follow(int followerId, int followingId) {
        this.followerId = followerId;
        this.followingId = followingId;
    }

    public int getFollowerId(){
        return followerId;
    }

    public int getFollowingId(){
        return followingId;
    }
}
