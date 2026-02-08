package n1ejercicio1;

public class EmptySaleException extends Exception {
    public EmptySaleException() {
        super("Para hacer una venta primero debes añadir productos");
    }

    public EmptySaleException(String message) {
        super(message);
    }
}
