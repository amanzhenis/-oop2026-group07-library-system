import services.ReservationService;
import exceptions.RoomNotAvailableException;
import models.Reservation;
import java.time.LocalDate;


import java.sql.Date;

public class Main {
    public static void main(String[] args) {

        ReservationService reservationService = new ReservationService();

        Reservation reservation = new Reservation(
                1,  // guestId
                1,  // roomId
                LocalDate.of(2026, 6, 1),
                LocalDate.of(2026, 6, 5)
        );


        try {
            reservationService.createReservation(reservation);
            System.out.println(" Reservation created successfully!");
        } catch (RoomNotAvailableException e) {
            System.out.println(" " + e.getMessage());
        }

        System.out.println("Program finished normally ");
    }
}
