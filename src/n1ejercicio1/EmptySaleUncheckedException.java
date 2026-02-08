package n1ejercicio1;

public class EmptySaleUncheckedException extends RuntimeException {
    public EmptySaleUncheckedException() {
        super("Para hacer una venta primero debes añadir productos (unchecked-exception)");
    }

    public EmptySaleUncheckedException(String message) {
        super(message);
    }

}
