package Service;

import RevConnect.model.User;
import RevConnect.service.UserService;
import org.junit.jupiter.api.*;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setup() {
        userService = new UserService();
    }

    @Test
    void testRegisterSuccess() {

        User user = new User(
                "Akhil",
                "akkimahesh" + (int)(Math.random()*100),
                "akhil" + (int)(Math.random()*100) + "@gmail.com",
                "Babu05",
                "Hyderabad",
                true,
                LocalDate.of(2004, 8, 15),
                "PERSONAL"
        );
        String result = userService.register(user);
        assertTrue(result.toLowerCase().contains("success"));
    }

    @Test
    void testRegisterDuplicate() {
        User user = new User("Harish", "harish23", "reddyharish530@gmail.com", "Harsh23", "Hosur", true, LocalDate.of(2004,10,10),"PERSONAL");
        userService.register(user);
        String result = userService.register(user);
        assertTrue(result.toLowerCase().contains("exist"));
    }

    @Test
    void testLoginSuccess() {
        User user = new User("Test", "testuser", "test@gmail.com", "1234", "Hosur", true, LocalDate.of(2000,1,1), "PERSONAL");
        try {
            userService.register(user);
        } catch (Exception ignored) {}

        User loggedIn = userService.login("test@gmail.com", "1234");
        assertNotNull(loggedIn);
        assertEquals("testuser", loggedIn.getUserName());
    }

    @Test
    void testLoginFailure() {
        User user = userService.login("reddyharish530@gmail.com", "reddy10");
        assertNull(user);
    }
}