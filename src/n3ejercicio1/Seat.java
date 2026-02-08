package n3ejercicio1;

import java.util.Objects;

public class Seat {
    private int row;
    private int seat;
    private String name;

    public Seat(int row, int seat, String name) {
        this.row = row;
        this.seat = seat;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Seat other = (Seat) obj;
        return this.row == other.row && this.seat == other.seat;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, seat);
    }

    @Override
    public String toString() {
        return "•(Seat: " + row + "-" + seat + " | " + name + ")";
    }

    public String toStringNoName() {
        String sb = "•(Seat: " + row + "-" + seat;
        if (getName().equals("Empty")) {
            sb += " | Empty)";
        } else {
            sb += " | Reserved)";
        }
        return sb;
    }
}
