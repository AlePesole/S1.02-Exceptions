package n3ejercicio1.Exceptions;

public class SeatAlreadyEmptyException extends RuntimeException{
    public SeatAlreadyEmptyException(){
        super("Seat already empty");
    }
}
