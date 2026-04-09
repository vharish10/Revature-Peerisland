package RevConnect.model;

public class CreatorProfile {

    private int userId;
    private String category;
    private String bio;
    private String youtubeLink;
    private String instagramLink;
    private String twitterLink;

    public CreatorProfile(int userId, String category, String bio,
                          String youtubeLink, String instagramLink, String twitterLink) {
        this.userId = userId;
        this.category = category;
        this.bio = bio;
        this.youtubeLink = youtubeLink;
        this.instagramLink = instagramLink;
        this.twitterLink = twitterLink;
    }

    public int getUserId() { return userId; }
    public String getCategory() { return category; }
    public String getBio() { return bio; }
    public String getYoutubeLink() { return youtubeLink; }
    public String getInstagramLink() { return instagramLink; }
    public String getTwitterLink() { return twitterLink; }
}