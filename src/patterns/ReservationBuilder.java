package patterns;

import domain.*;

import java.time.LocalDate;

public class ReservationBuilder {

    private Guest guest;
    private Room room;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public ReservationBuilder setGuest(Guest guest) {
        this.guest = guest;
        return this;
    }

    public ReservationBuilder setRoom(Room room) {
        this.room = room;
        return this;
    }

    public ReservationBuilder setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
        return this;
    }

    public ReservationBuilder setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
        return this;
    }

    public Reservation build() {
        return new Reservation(
                0,
                guest,
                room,
                checkIn,
                checkOut,
                ReservationStatus.ACTIVE
        );
    }
}
