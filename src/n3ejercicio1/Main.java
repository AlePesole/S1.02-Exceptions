package n3ejercicio1;

public class Main {
    public static void main(String[] args) {
        // Mejoras a implementar: Usar null y no "Empty" para indicar asientos vacíos
        // cambiaría un poco la estructura del programa ya que hay que implementar
        // más excepciones antes de operar con el valor null de los asientos vacíos.

        ReservationService reservationService = new ReservationService(4,3);
        ConsoleUI consoleUI = new ConsoleUI(reservationService);

        consoleUI.menuUI();
    }
}
