package domain;

import java.time.LocalDate;

public class Reservation {

    private int id;
    private Guest guest;
    private Room room;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private ReservationStatus status;

    public Reservation(int id, Guest guest, Room room,
                       LocalDate checkIn, LocalDate checkOut,
                       ReservationStatus status) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public int getId() {
        return id;
    }
}
