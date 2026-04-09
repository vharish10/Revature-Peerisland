package RevConnect.model;

public class BusinessProfile {

    private int userId;
    private String businessName;
    private String category;
    private String bio;
    private String address;
    private String contactInfo;
    private String website;
    private String businessHours;

    public BusinessProfile(int userId, String businessName, String category, String bio, String address, String contactInfo, String website, String businessHours) {
        this.userId = userId;
        this.businessName = businessName;
        this.category = category;
        this.bio = bio;
        this.address = address;
        this.contactInfo = contactInfo;
        this.website = website;
        this.businessHours = businessHours;
    }

    public int getUserId() {
        return userId;
    }

    public String getBusinessName(){
        return businessName;
    }

    public String getCategory(){
        return category;
    }

    public String getBio(){
        return bio;
    }

    public String getAddress(){
        return address;
    }

    public String getContactInfo(){
        return contactInfo;
    }

    public String getWebsite(){
        return website;
    }

    public String getBusinessHours(){
        return businessHours;
    }
}