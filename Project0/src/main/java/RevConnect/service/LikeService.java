package RevConnect.service;

import RevConnect.CustomExceptions.*;
import RevConnect.dao.LikeDAOImp;
import RevConnect.model.Likes;

public class LikeService {

    LikeDAOImp likeDAO = new LikeDAOImp();

    public String likePost(int userId, int postId) throws PostNotFoundException, AlreadyLikedException {

        try {
            if (!likeDAO.postExists(postId)) {
                throw new PostNotFoundException("Post does not exist!");
            }

            if (likeDAO.isAlreadyLiked(userId, postId)) {
                throw new AlreadyLikedException("You already liked this post!");
            }

            likeDAO.addLike(userId, postId);
            return "Post liked successfully!";

        } catch (PostNotFoundException | AlreadyLikedException e) {
            throw e; // pass to main
        } catch (Exception e) {
            e.printStackTrace();
            return " Error while liking post!";
        }
    }

    public String unlikePost(int userId, int postId) throws LikeNotFoundException {

        try{
            int rows = likeDAO.removeLike(userId, postId);
            if (rows == 0) {
                throw new LikeNotFoundException("Like not found!");
            }
            return "Post unliked successfully!";
        } catch (LikeNotFoundException e) {
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error while unliking post!";
        }
    }
}