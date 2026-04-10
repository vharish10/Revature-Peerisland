package RevConnect.service;

import java.util.*;
import RevConnect.dao.*;
import RevConnect.model.Post;
import RevConnect.CustomExceptions.*;

public class FeedService {

    ConnectionDAOImp connectionDAO = new ConnectionDAOImp();
    FollowDAOImp followDAO = new FollowDAOImp();
    PostDAOImp postDAO = new PostDAOImp();

    public List<Post> getFeed(int userId) throws FeedGenerationException {
        if (userId <= 0) {
            throw new FeedGenerationException("Invalid user ID");
        }

        try {
            Set<Integer> userSet = new HashSet<>();
            userSet.add(userId);
            userSet.addAll(connectionDAO.getConnections(userId));
            userSet.addAll(followDAO.getFollowing(userId));

            return postDAO.getFeedPosts(new ArrayList<>(userSet));

        } catch (Exception e) {
            e.printStackTrace();
            throw new FeedGenerationException("Unable to generate feed!");
        }
    }
}
