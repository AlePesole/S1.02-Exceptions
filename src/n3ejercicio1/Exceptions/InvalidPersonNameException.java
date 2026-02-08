package n3ejercicio1.Exceptions;

public class InvalidPersonNameException extends RuntimeException {
    public InvalidPersonNameException(String message) {
        super(message);
    }
}
