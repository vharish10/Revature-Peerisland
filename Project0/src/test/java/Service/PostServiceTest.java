package Service;

import RevConnect.model.Post;
import RevConnect.service.PostService;
import RevConnect.CustomExceptions.UnauthorizedActionException;
import RevConnect.model.Post;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PostServiceTest {

    private PostService postService;

    @BeforeEach
    void setup() {
        postService = new PostService();
    }

    @Test
    void testCreateNormalPost() {
        Post post = new Post(1, "This is a normal post");
        post.setPostType("NORMAL");

        try {
            String result = postService.createPost(post, "PERSONAL");
            assertTrue(result.contains("Post") || result.contains("success"));
        } catch (Exception e) {
            fail("Exception should not occur for normal post");
        }
    }

    @Test
    void testCreatePromotionalPostByCreator() {
        Post post = new Post(2, "Check my content!");
        post.setPostType("PROMOTIONAL");
        try {
            String result = postService.createPost(post, "CREATOR");
            assertTrue(result.contains("Post") || result.contains("success"));
        } catch (Exception e) {
            fail("Creator should be allowed to post promotional content");
        }
    }

    @Test
    void testCreatePromotionalPostByPersonalUser() {
        Post post = new Post(4, "Buy this now!");
        post.setPostType("PROMOTIONAL");
        assertThrows(UnauthorizedActionException.class, () -> {
            postService.createPost(post, "PERSONAL");
        });
    }

    @Test
    void testDeletePost() {
        String result = postService.deletePost(1, 1);
        assertTrue(result.contains("deleted") || result.contains("not found"));
    }

    @Test
    void testUpdatePost() {
        String result = postService.updatePost(1, 1, "Updated content");
        assertTrue(result.contains("updated") || result.contains("not found"));
    }
}
