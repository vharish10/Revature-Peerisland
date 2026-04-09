package RevConnect.CustomExceptions;

public class ConnectionNotFoundException extends Exception {
    public ConnectionNotFoundException(String msg) {
        super(msg);
    }
}