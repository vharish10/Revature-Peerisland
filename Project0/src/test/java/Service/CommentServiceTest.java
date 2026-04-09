package Service;

import RevConnect.service.CommentService;
import RevConnect.CustomExceptions.*;
import RevConnect.model.Comment;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class CommentServiceTest {
    private CommentService commentService;

    @BeforeEach
    void setup() {
        commentService = new CommentService();
    }

    @Test
    void testAddCommentSuccess() {
        Comment comment = new Comment(1, 2, "Nice post!");
        try {
            String result = commentService.addComment(comment);
            assertTrue(result.contains("Comment"));
        } catch (Exception e) {
            fail("Should not throw exception for valid comment");
        }
    }

    @Test
    void testAddCommentPostNotFound() {
        Comment comment = new Comment(1, 999, "Invalid post");
        assertThrows(PostNotFoundException.class, () -> {
            commentService.addComment(comment);
        });
    }

    @Test
    void testViewCommentsSuccess() {
        try {
            List<Comment> comments = commentService.viewComments(2);
            assertNotNull(comments);
        } catch (Exception e) {
            fail("Should not fail for valid post");
        }
    }

    @Test
    void testViewCommentsPostNotFound() {
        assertThrows(PostNotFoundException.class, () -> {
            commentService.viewComments(999);
        });
    }

    @Test
    void testDeleteCommentSuccess() {
        try {
            Comment comment = new Comment(1, 2, "To be deleted");
            commentService.addComment(comment);
            String result = commentService.deleteComment(1, 1);
            assertTrue(result.contains("deleted"));
        } catch (Exception e) {
            fail("Delete should work for valid user");
        }
    }

    @Test
    void testDeleteCommentNotFound() {
        assertThrows(CommentNotFoundException.class, () -> {
            commentService.deleteComment(999, 1);
        });
    }

    @Test
    void testDeleteCommentUnauthorized() {

        try {
            Comment comment = new Comment(1, 2, "Unauthorized test");
            commentService.addComment(comment);

            assertThrows(UnauthorizedException.class, () -> {
                commentService.deleteComment(1, 2);
            });

        } catch (PostNotFoundException e) {
            fail("Post should exist");
        }
    }
}