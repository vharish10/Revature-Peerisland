package Service;

import RevConnect.CustomExceptions.*;
import RevConnect.service.ConnectionService;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ConnectionServiceTest {

    private ConnectionService connectionService;

    @BeforeEach
    void setup() {
        connectionService = new ConnectionService();
    }

    @Test
    void testSendRequestSuccess() {
        int senderId = 1;
        int receiverId = 4;
        try {
            String result = connectionService.sendRequest(senderId, receiverId);
            assertTrue(result.contains("sent"));
        } catch (Exception e) {
            fail("Should not throw exception for valid request");
        }
    }

    @Test
    void testSendRequestToSelf() {
        assertThrows(InvalidConnectionRequestException.class, () -> {
            connectionService.sendRequest(1, 1);
        });
    }

    @Test
    void testDuplicateRequest() {
        int senderId = 2;
        int receiverId = 5;

        assertDoesNotThrow(() -> {
            connectionService.sendRequest(senderId, receiverId);
        });
        assertThrows(ConnectionAlreadyExistsException.class, () -> {
            connectionService.sendRequest(senderId, receiverId);
        });
    }

    @Test
    void testAcceptRequest() {
        int senderId = 3;
        int receiverId = 4;
        try {
            connectionService.sendRequest(senderId, receiverId);
            String result = connectionService.acceptRequest(senderId, receiverId);
            assertTrue(result.contains("accepted"));
        } catch (Exception e) {
            fail("Accept should succeed");
        }
    }

    @Test
    void testAcceptRequestNotFound() {
        assertThrows(ConnectionNotFoundException.class, () -> {
            connectionService.acceptRequest(100, 200);
        });
    }

    @Test
    void testRejectRequest() {

        int senderId = 4;
        int receiverId = 5;

        try {
            try {
                connectionService.sendRequest(senderId, receiverId);
            } catch (ConnectionAlreadyExistsException ignored) {
            }
            String result = connectionService.rejectRequest(senderId, receiverId);

            assertTrue(result.toLowerCase().contains("rejected"));

        } catch (Exception e) {
            e.printStackTrace();
            fail("Reject should succeed");
        }
    }

    @Test
    void testRejectRequestNotFound() {
        assertThrows(ConnectionNotFoundException.class, () -> {
            connectionService.rejectRequest(999, 888);
        });
    }
}