package RevConnect.CustomExceptions;

public class InvalidConnectionRequestException extends Exception {
    public InvalidConnectionRequestException(String msg) {
        super(msg);
    }
}