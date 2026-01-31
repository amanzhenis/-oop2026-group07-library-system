package service;

import entity.Reservation;
import entity.Room;
import exception.InvalidDateRangeException;
import exception.RoomNotAvailableException;
import repository.ReservationRepository;
import repository.RoomRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationService {

    private final RoomRepository roomRepo = new RoomRepository();
    private final ReservationRepository reservationRepo = new ReservationRepository();
    private final RoomAvailabilityService availabilityService = new RoomAvailabilityService();
    private final PaymentService paymentService = new PaymentService();

    // USER STORY 1: Search available rooms by date
    public List<Room> searchAvailableRooms(LocalDate checkIn, LocalDate checkOut) {
        validateDateRange(checkIn, checkOut);

        List<Room> rooms = roomRepo.findAll();

        return rooms.stream()
                .filter(r -> availabilityService.isAvailable(r.getId(), checkIn, checkOut))
                .collect(Collectors.toList());
    }

    // USER STORY 2: Create reservation
    public int createReservation(int guestId,
                                 int roomId,
                                 LocalDate checkIn,
                                 LocalDate checkOut,
                                 String paymentMethod) {

        validateDateRange(checkIn, checkOut);

        if (!availabilityService.isAvailable(roomId, checkIn, checkOut)) {
            throw new RoomNotAvailableException();
        }

        // Save reservation (ACTIVE)
        Reservation reservation = new Reservation(
                guestId,
                roomId,
                checkIn,
                checkOut,
                "ACTIVE"
        );

        int reservationId = reservationRepo.save(reservation);

        // Calculate payment
        Room room = roomRepo.findById(roomId);
        if (room == null) {
            throw new RuntimeException("Room not found in DB");
        }

        long nights = checkOut.toEpochDay() - checkIn.toEpochDay();
        double amount = nights * room.getPricePerNight();

        // Process payment
        paymentService.processPayment(reservationId, amount, paymentMethod);

        return reservationId;
    }

    // USER STORY 3: Cancel reservation
    public void cancelReservation(int reservationId) {
        reservationRepo.cancel(reservationId);
    }

    // Helper: Validate check-in/check-out dates
    private void validateDateRange(LocalDate checkIn, LocalDate checkOut) {
        if (checkIn == null || checkOut == null || !checkOut.isAfter(checkIn)) {
            throw new InvalidDateRangeException();
        }
    }
}
