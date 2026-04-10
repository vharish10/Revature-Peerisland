package Service;

import RevConnect.model.Likes;
import RevConnect.service.LikeService;
import RevConnect.CustomExceptions.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LikeServiceTest {
    private LikeService likeService;

    @BeforeEach
    void setup() {
        likeService = new LikeService();
    }

    @Test
    void testLikePostSuccess() {
        int userId = 2;
        int postId = 3;

        try {
            String result = likeService.likePost(userId, postId);
            assertTrue(result.toLowerCase().contains("liked"));
        } catch (Exception e) {
            fail("Should not throw exception for valid like");
        }
    }

    @Test
    void testAlreadyLikedPost() {

        int userId = 5;
        int postId = 3;

        try {
            try {
                likeService.likePost(userId, postId);
            } catch (AlreadyLikedException ignored) {}

            assertThrows(AlreadyLikedException.class, () -> {
                likeService.likePost(userId, postId);
            });

        } catch (PostNotFoundException e) {
            fail("Post should exist");
        }
    }

    @Test
    void testLikeNonExistingPost() {
        assertThrows(PostNotFoundException.class, () -> {
            likeService.likePost(1, 999); 
        });
    }

    @Test
    void testUnlikePostSuccess() {
        try {
            likeService.likePost(1, 3);
            String result = likeService.unlikePost(1, 3);
            assertTrue(result.contains("unliked"));
        } catch (Exception e) {
            fail("Should not fail unlike");
        }
    }

    @Test
    void testUnlikeWithoutLike() {
        assertThrows(LikeNotFoundException.class, () -> {
            likeService.unlikePost(1, 999);
        });
    }
}
