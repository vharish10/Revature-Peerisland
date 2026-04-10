package RevConnect.model;

import java.sql.Date;
import java.time.LocalDate;

public class User {

    private int userId;
    private String name;
    private String userName;
    private String password;
    private String location;
    private String email;
    private boolean isPublic;
    private LocalDate dob;
    private String userType;


    public User(String name, String userName, String email, String password, String location, boolean isPublic, LocalDate dob, String userType){
        this.name=name;
        this.userName=userName;
        this.email=email;
        this.password=password;
        this.location=location;
        this.isPublic=isPublic;
        this.dob=dob;
        this.userType=userType;
    }

    public void setUserId(int userId){
        this.userId=userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName){
        this.userName=userName;
    }

    public void setPassword(String password){
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserType(){
        return userType;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPublic(boolean isPublic){
        this.isPublic=isPublic;
    }

    public boolean getStatus() {
        return isPublic;
    }

    public String getLocation() {
        return location;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getEmail(){
        return email;
    }
}
