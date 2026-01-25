import exception.*;
import service.ReservationService;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        ReservationService service = new ReservationService();

        int guestId = 1;
        int roomId = 1;

        try {
            System.out.println("Available rooms:");
            service.searchAvailableRooms(
                    LocalDate.of(2026, 1, 20),
                    LocalDate.of(2026, 1, 25)
            ).forEach(System.out::println);

            int reservationId = service.createReservation(
                    guestId,
                    roomId,
                    LocalDate.of(2026, 1, 20),
                    LocalDate.of(2026, 1, 25),
                    "CARD"
            );

            System.out.println("Reservation created with ID: " + reservationId);

            service.cancelReservation(reservationId);
            System.out.println("Reservation cancelled.");

        } catch (InvalidDateRangeException e) {
            System.out.println("Invalid date range.");
        } catch (RoomNotAvailableException e) {
            System.out.println("Room not available.");
        } catch (PaymentDeclinedException e) {
            System.out.println("Payment declined.");
        }
    }
}
