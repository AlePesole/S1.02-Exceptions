package n3ejercicio1;

public class Main {
    public static void main(String[] args) {
        ReservationService reservationService = new ReservationService(4,3);
        ConsoleUI consoleUI = new ConsoleUI(reservationService);

        consoleUI.menuUI();
    }
}
