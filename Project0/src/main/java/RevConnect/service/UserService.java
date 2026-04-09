package RevConnect.service;

import RevConnect.dao.UserDAOImp;
import RevConnect.model.User;


public class UserService {

    UserDAOImp userDAO = new UserDAOImp();

    public String register(User user) {
        return userDAO.registerUser(user);
    }

    public User login(String email, String password) {
        return userDAO.loginUser(email, password);
    }

    public String updateProfile(User user){
        return userDAO.updateProfile(user);
    }
}
