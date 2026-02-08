package n3ejercicio1.Exceptions;

public class InvalidSeatException extends RuntimeException {

    public InvalidSeatException(){
        super("Seat out of range");
    }

    public InvalidSeatException(String message){
        super(message);
    }
}
