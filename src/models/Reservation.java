package models;

import java.time.LocalDate;

public class Reservation {
    private int guestId;
    private int roomId;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation(int guestId,int roomId,
                       LocalDate in,LocalDate out){
        this.guestId=guestId;
        this.roomId=roomId;
        this.checkIn=in;
        this.checkOut=out;
    }

    public int getGuestId(){ return guestId; }
    public int getRoomId(){ return roomId; }
    public LocalDate getCheckIn(){ return checkIn; }
    public LocalDate getCheckOut(){ return checkOut; }
}
