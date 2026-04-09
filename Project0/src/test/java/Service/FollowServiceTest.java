package Service;

import RevConnect.CustomExceptions.*;
import RevConnect.service.FollowService;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FollowServiceTest {
    private FollowService followService;

    @BeforeEach
    void setup() {
        followService = new FollowService();
    }

    @Test
    void testFollowSuccess() {
        try {
            String result = followService.follow(5, 2);
            assertTrue(result.contains("Followed"));
        } catch (Exception e) {
            fail("Should not throw exception for valid follow");
        }
    }

    @Test
    void testFollowSelf() {
        assertThrows(InvalidFollowException.class, () -> {
            followService.follow(1, 1);
        });
    }

    @Test
    void testAlreadyFollowing() {
        int followerId = 2;
        int followingId = 3;
        assertDoesNotThrow(() -> {
            followService.follow(followerId, followingId);
        });
        assertThrows(AlreadyFollowingException.class, () -> {
            followService.follow(followerId, followingId);
        });
    }

    @Test
    void testUnfollowSuccess() {
        try {
            followService.follow(3, 4);
            String result = followService.unfollow(3, 4);
            assertTrue(result.contains("Unfollowed"));
        } catch (Exception e) {
            fail("Unfollow should succeed");
        }
    }

    @Test
    void testUnfollowNotFound() {
        assertThrows(FollowNotFoundException.class, () -> {
            followService.unfollow(10, 20);
        });
    }

    @Test
    void testGetFollowers() {

        int followerId = 2;
        int followingId = 1;

        try {
            try {
                followService.follow(followerId, followingId);
            } catch (AlreadyFollowingException ignored) {}

            List<Integer> followers = followService.getFollowers(followingId);
            assertNotNull(followers);
            assertTrue(followers.contains(followerId));

        } catch (Exception e) {
            e.printStackTrace();
            fail("Should not fail while fetching followers");
        }
    }

    @Test
    void testGetFollowing() {
        try {
            List<Integer> following = followService.getFollowing(1);
            assertNotNull(following);
        } catch (Exception e) {
            fail("Should not fail while fetching following");
        }
    }
}