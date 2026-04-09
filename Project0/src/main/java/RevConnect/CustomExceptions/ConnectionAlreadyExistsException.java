package RevConnect.CustomExceptions;

public class ConnectionAlreadyExistsException extends Exception {
    public ConnectionAlreadyExistsException(String msg) {
        super(msg);
    }
}