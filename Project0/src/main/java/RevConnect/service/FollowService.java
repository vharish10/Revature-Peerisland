package RevConnect.service;

import java.util.List;
import RevConnect.CustomExceptions.*;
import RevConnect.dao.*;

public class FollowService {

    FollowDAOImp dao=new FollowDAOImp();

    public String follow(int followerId, int followingId) throws AlreadyFollowingException, InvalidFollowException{

        try {
            if(followerId==followingId){
                throw new InvalidFollowException("You cannot follow yourself");
            }
            if(dao.exists(followerId, followingId)){
                throw new AlreadyFollowingException("You are already following this user");
            }

            dao.follow(followerId, followingId);
            return "Followed user successfully";

        } catch (AlreadyFollowingException | InvalidFollowException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error while following!";
        }
    }

    public String unfollow(int followerId, int followingId) throws FollowNotFoundException{

        try {
            int rows=dao.unfollow(followerId, followingId);

            if(rows==0){
                throw new FollowNotFoundException("Follower not found!");
            }

            return "Unfollowed successfully!";

        } catch (FollowNotFoundException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error while unfollowing!";
        }
    }

    public List<Integer> getFollowers(int userId) throws Exception {
        return dao.getFollowers(userId);
    }

    public List<Integer> getFollowing(int userId) throws Exception {
        return dao.getFollowing(userId);
    }
}