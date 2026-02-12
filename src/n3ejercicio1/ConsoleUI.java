package n3ejercicio1;

import n3ejercicio1.Exceptions.InvalidPersonNameException;
import n3ejercicio1.Exceptions.InvalidSeatException;
import n3ejercicio1.Exceptions.SeatAlreadyEmptyException;
import n3ejercicio1.Exceptions.SeatAlreadyTakenException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleUI {
    ReservationService reservationService;
    private static Scanner sc = new Scanner(System.in);
    public ConsoleUI(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    public void menuUI() {
        boolean exit = false;

        do {
            try {
                System.out.print("""
                ----------------Reservation-Service----------------
                1.- Mostrar todas las butacas reservadas.
                2.- Mostrar las butacas reservadas por una persona.
                3.- Reservar una butaca.
                4.- Anular la reserva de una butaca.
                5.- Anular todas las reservas de una persona.
                0.- Salir.
                ___________________________________________________
                Elección: 
                """);
                int eleccion = sc.nextInt();

                switch(eleccion) {
                    case 1: {
                        showAllSeatsUI();
                        break;
                    }
                    case 2: {
                        sc.nextLine();
                        showPersonSeatsUI();
                        break;
                    }
                    case 3: {
                        sc.nextLine();
                        seatReservationUI();
                        break;
                    }
                    case 4: {
                        sc.nextLine();
                        seatCancellationUI();
                        break;
                    }
                    case 5: {
                        sc.nextLine();
                        seatCancellationByNameUI();
                        break;
                    }
                    case 0: {
                        exit = true;
                        break;
                    }
                    default: {
                        System.out.println("Elección fuera del rango, intente nuevamente");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Elección tiene que ser un número");
            }
        } while (!exit);
    }

    void showAllSeatsUI() {
        for (Seat seat : reservationService.getAllSeats()) {
            System.out.print(seat.toStringNoName() + " ");
            if(seat.getSeat() == reservationService.getSeatsPerRow()) {
                System.out.println();
            }
        }
    }

    void showPersonSeatsUI() {
        try {
            System.out.print("Nombre de la persona: ");
            String personName = sc.nextLine();
            ArrayList<Seat> seats = new ArrayList<>(reservationService.getPersonSeats(personName));
            for (Seat seat : seats) {
                System.out.println(seat);
            }
        } catch (InvalidPersonNameException e) {
            System.out.println(e.getMessage());
        }
    }

    void seatReservationUI() {
        boolean exit = true;
        do {
            try {
                System.out.print("Número de fila: ");
                int row = sc.nextInt();
                System.out.print("Número de asiento: ");
                int seat = sc.nextInt();
                sc.nextLine();
                System.out.print("Nombre de la persona: ");
                String personName = sc.nextLine();
                reservationService.reserveSeat(seat, row, personName);
                System.out.println("Reserva realizada correctamente");
                exit = true;
            } catch (InvalidPersonNameException | SeatAlreadyTakenException | InvalidSeatException e) {
                System.out.println(e.getMessage());
                exit = false;
            } catch (InputMismatchException e) {
                System.out.println("Solo números para asiento y fila");
                exit = false;
            }
        } while (!exit);
    }

    void seatCancellationUI() {
        boolean exit = true;
        do {
            try {
                System.out.print("Número de fila: ");
                int row = sc.nextInt();
                System.out.print("Número de asiento: ");
                int seat = sc.nextInt();
                reservationService.cancelSeat(seat, row);
                System.out.println("Reserva del asiento cancelada correctamente");
                exit = true;
            } catch (InputMismatchException e) {
                System.out.println("Solo números para asiento y fila");
                exit = false;
            } catch (InvalidSeatException | SeatAlreadyEmptyException e) {
                System.out.println(e.getMessage());
                exit = false;
            }
        } while (!exit);
    }

    void seatCancellationByNameUI() {
        boolean exit = true;
        do {
            try {
                System.out.print("Nombre de la persona: ");
                String personName = sc.nextLine();
                reservationService.cancelAllByPerson(personName);
                System.out.println("Reservas a nombre de: " + personName + " ha sido canceladas correctamente");
                exit = true;
            } catch (InvalidPersonNameException e) {
                System.out.println(e.getMessage());
                exit = false;
            }
        } while (!exit);
    }
}
