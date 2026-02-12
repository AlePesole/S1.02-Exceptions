package n3ejercicio1;

import n3ejercicio1.Exceptions.InvalidPersonNameException;
import n3ejercicio1.Exceptions.InvalidSeatException;
import n3ejercicio1.Exceptions.SeatAlreadyEmptyException;
import n3ejercicio1.Exceptions.SeatAlreadyTakenException;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {
    private int totalRows;
    private int seatsPerRow;
    private List<Seat> seats;

    ReservationService(int totalRows, int seatsPerRow) {
        if(totalRows <= 0 || seatsPerRow <= 0) {
            throw new InvalidSeatException("El número de filas y asientos tiene que ser mayor a 0");
        }
        this.totalRows = totalRows;
        this.seatsPerRow = seatsPerRow;
        seats = new ArrayList<>();
        for(int i = 1; i <= totalRows; i++) {
            for(int j = 1; j <= seatsPerRow; j++) {
                seats.add(new Seat(i, j, "Empty"));
            }
        }
    }

    private void validateSeatPosition(int seat, int row) {
        if(seat <= 0 || row <= 0 || seat > seatsPerRow || row > totalRows) {
            throw new InvalidSeatException("Asiento o fila fuera de rango");
        }
    }

    private void validatePersonName(String name) {
        if(name == null) {
            throw new InvalidPersonNameException("Nombre no puede ser null");
        }
        if(name.equalsIgnoreCase("Empty")) {
            throw new InvalidPersonNameException("Nombre no puede ser empty");
        }
        if(name.length() < 3 || name.length() > 15) {
            throw new InvalidPersonNameException("Nombre tiene que contener mínimo 3 carácteres y máximo 15 carácteres");
        }
        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                throw new InvalidPersonNameException("Nombre no puede contener números");
            }
        }
    }

    private int calculateSeatPosition(int seat, int row) {
        validateSeatPosition(seat, row);
        return row * seatsPerRow - (seatsPerRow - seat) - 1;
    }

    public boolean SeatIsEmpty(int seat, int row) {
        int position = calculateSeatPosition(seat, row);
        if(seats.get(position).getName().equalsIgnoreCase("Empty")) {
            return true;
        }
        return false;
    }

    public void reserveSeat(int seat , int row, String name) {
        int position = calculateSeatPosition(seat, row);
        if(!SeatIsEmpty(seat, row)) {
            throw new SeatAlreadyTakenException();
        }
        validatePersonName(name);
        seats.get(position).setName(name);
    }

    public void cancelSeat(int seat , int row) {
        int position = calculateSeatPosition(seat, row);
        if(SeatIsEmpty(seat, row)) {
            throw new SeatAlreadyEmptyException();
        }
        seats.get(position).setName("Empty");
    }

    public void cancelAllByPerson(String name) {
        validatePersonName(name);
        boolean exist = false;
        for(Seat seat : seats) {
            if(seat.getName().equalsIgnoreCase(name)) {
                seat.setName("Empty");
                exist = true;
            }
        }
        if(!exist) {
            throw new InvalidPersonNameException("Persona no tiene reservas o nombre incorrecto");
        }
    }

    public List<Seat> getAllSeats() {
        return List.copyOf(seats);
    }

    public List<Seat> getPersonSeats(String name) {
        validatePersonName(name);
        List<Seat> seatsByPerson = new ArrayList<>();
        boolean exist = false;
        for(Seat seat : seats) {
            if(seat.getName().equalsIgnoreCase(name)) {
                seatsByPerson.add(seat);
                exist = true;
            }
        }
        if(!exist) {
            throw new InvalidPersonNameException("Persona no tiene reservas o nombre incorrecto");
        }
        return List.copyOf(seatsByPerson);
    }

    public int getSeatsPerRow() {
        return seatsPerRow;
    }

    public int getTotalRows() {
        return totalRows;
    }
}
