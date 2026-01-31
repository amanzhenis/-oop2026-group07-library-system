package entity;

import java.time.LocalDate;

public class Reservation {
    private int guestId;
    private int roomId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private String status;

    public Reservation(int guestId, int roomId,
                       LocalDate checkIn, LocalDate checkOut,
                       String status) {
        this.guestId = guestId;
        this.roomId = roomId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
    }

    public int getGuestId() { return guestId; }
    public int getRoomId() { return roomId; }
    public LocalDate getCheckIn() { return checkIn; }
    public LocalDate getCheckOut() { return checkOut; }
    public String getStatus() { return status; }
}
