package RevConnect.service;

import RevConnect.CustomExceptions.UnauthorizedActionException;
import RevConnect.dao.PostDAOImp;
import RevConnect.model.Post;
import java.util.*;

public class PostService {

    PostDAOImp postDAO = new PostDAOImp();

    public String createPost(Post post, String userType) throws UnauthorizedActionException {

        try{
            if("PROMOTIONAL".equalsIgnoreCase(post.getPostType())){
                if(!userType.equalsIgnoreCase("CREATOR") && !userType.equalsIgnoreCase("BUSINESS")){
                    throw new UnauthorizedActionException("Only creators and business user can create promotional posts");
                }
            }
            return postDAO.createPost(post);
        }catch(UnauthorizedActionException e){
            throw e;
        }catch(Exception e){
            e.printStackTrace();
            return "Error while creating post!";
        }
    }

    public List<Post> getAllPosts() {
        return postDAO.getAllPosts();
    }

    public String deletePost(int postId, int userId) {
        return postDAO.deletePost(postId, userId);
    }

    public String updatePost(int postId, int userId, String content) {
        return postDAO.updatePost(postId, userId, content);
    }
}
