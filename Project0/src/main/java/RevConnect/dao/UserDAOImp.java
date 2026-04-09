package RevConnect.dao;

import RevConnect.model.User;
import RevConnect.util.DBConnection;
import java.sql.*;
import java.sql.ResultSet;
import java.time.LocalDate;

public class UserDAOImp {

    public String registerUser(User user) {
        String sql = "INSERT INTO User(Name, userName, email, password, location, isPublic, DOB, userType) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement prepared = connection.prepareStatement(sql)) {
            prepared.setString(1, user.getName());
            prepared.setString(2, user.getUserName());
            prepared.setString(3, user.getEmail());
            prepared.setString(4, user.getPassword());
            prepared.setString(5, user.getLocation());
            prepared.setBoolean(6, user.getStatus());
            prepared.setDate(7, java.sql.Date.valueOf(user.getDob()));
            prepared.setString(8, user.getUserType());

            if(prepared.executeUpdate() > 0){
                return "User Successfully Registered";
            }
        } catch (SQLIntegrityConstraintViolationException e) {
            return "UserName Already Exist";
        } catch (Exception e) {
            e.printStackTrace();
            return "Registration failure";
        }
        return "Registrati0n failed";
    }

    public String updateProfile(User user) {
        StringBuilder sql=new StringBuilder("UPDATE User SET ");
        boolean hasField=false;

        if(user.getName()!=null){
            sql.append("Name=?, ");
            hasField=true;
        }
        if(user.getLocation()!=null){
            sql.append("location=?, ");
            hasField=true;
        }
        if(user.getDob()!=null){
            sql.append("DOB=?, ");
            hasField=true;
        }
        if(user.getUserType()!=null){
            sql.append("userType=?, ");
            hasField=true;
        }
        if(user.getStatus()!=true){
            sql.append("isPublic=?, ");
            hasField=true;
        }
        if(!hasField){
            return "No Fields to update since no new filed data is given";
        }

        sql.delete(sql.length()-2,sql.length());
        sql.append(" WHERE userId=?");

        try(Connection connection=DBConnection.getConnection();
             PreparedStatement prepared= connection.prepareStatement(sql.toString())) {
            int index=1;

            if (user.getName()!=null) {
                prepared.setString(index++,user.getName());
            }
            if(user.getLocation()!=null){
                prepared.setString(index++,user.getLocation());
            }
            if(user.getDob()!=null){
                prepared.setDate(index++, java.sql.Date.valueOf(user.getDob()));
            }
            if(user.getUserType()!=null) {
                prepared.setString(index++,user.getUserType());
            }
            if(user.getStatus()!=true){
                prepared.setBoolean(index++,user.getStatus());
            }

            prepared.setInt(index, user.getUser_id());

            if(prepared.executeUpdate() > 0){
                return "User Profile updated successfully";
            }

        } catch (Exception e) {
            e.printStackTrace();
            return "User Registration failed";
        }
        return "User Profile updation failed";
    }

    public User loginUser(String email, String password) {
        String sql = "SELECT * FROM user WHERE email = ? AND password = ?";
        try(Connection connection=DBConnection.getConnection();
            PreparedStatement prepared= connection.prepareStatement(sql);) {
            prepared.setString(1, email);
            prepared.setString(2, password);

            ResultSet result=prepared.executeQuery();
            if (result.next()) {

                Date sqlDate = result.getDate("DOB");

                LocalDate dob = null;
                if (sqlDate != null) {
                    dob = sqlDate.toLocalDate();
                }

                return new User(
                        result.getString("Name"),
                        result.getString("userName"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("location"),
                        result.getBoolean("isPublic"),
                        dob,
                        result.getString("userType")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}

