package RevConnect.CustomExceptions;

public class UnauthorizedActionException extends Exception {
    public UnauthorizedActionException(String msg) {
        super(msg);
    }
}