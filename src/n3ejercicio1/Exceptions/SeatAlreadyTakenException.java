package n3ejercicio1.Exceptions;

public class SeatAlreadyTakenException extends RuntimeException {
    public SeatAlreadyTakenException() {
        super("Seat already taken");
    }
}
