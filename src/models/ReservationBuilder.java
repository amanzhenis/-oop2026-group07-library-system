package models;

import java.time.LocalDate;

public class ReservationBuilder {

    private int guestId;
    private int roomId;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public ReservationBuilder setGuestId(int id){
        this.guestId=id;
        return this;
    }

    public ReservationBuilder setRoomId(int id){
        this.roomId=id;
        return this;
    }

    public ReservationBuilder setCheckIn(LocalDate d){
        this.checkIn=d;
        return this;
    }

    public ReservationBuilder setCheckOut(LocalDate d){
        this.checkOut=d;
        return this;
    }

    public Reservation build(){
        return new Reservation(guestId,roomId,checkIn,checkOut);
    }
}
