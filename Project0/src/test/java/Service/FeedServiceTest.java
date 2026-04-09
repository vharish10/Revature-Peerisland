package Service;

import RevConnect.CustomExceptions.FeedGenerationException;
import RevConnect.model.Post;
import RevConnect.service.FeedService;
import org.junit.jupiter.api.*;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class FeedServiceTest {
    private FeedService feedService;

    @BeforeEach
    void setup() {
        feedService = new FeedService();
    }

    @Test
    void testGetFeedSuccess() {
        try {
            List<Post> feed = feedService.getFeed(1);
            assertNotNull(feed);
        } catch (Exception e) {
            fail("Feed generation should not fail");
        }
    }

    @Test
    void testFeedHasPosts() {
        try {
            List<Post> feed = feedService.getFeed(2);
            assertNotNull(feed);

            if (!feed.isEmpty()) {
                assertNotNull(feed.get(0).getContent());
            }
        } catch (Exception e) {
            fail("Feed should load properly");
        }
    }

    @Test
    void testInvalidUserFeed() {
        assertThrows(FeedGenerationException.class, () -> {
            feedService.getFeed(-1);
        });
    }
}