package service;

import domain.*;
import Exceptions.*;
import patterns.ReservationBuilder;
import persistence.ReservationRepository;

import java.time.LocalDate;

public class ReservationService {

    private final ReservationRepository repo = new ReservationRepository();
    private final PaymentService paymentService = new PaymentService();

    public void bookRoom(Guest guest, Room room,
                         LocalDate checkIn, LocalDate checkOut)
            throws RoomNotAvailableException,
            InvalidDateRangeException,
            PaymentDeclinedException {

        // Exception 1: Invalid date
        if (checkOut.isBefore(checkIn)) {
            throw new InvalidDateRangeException("Invalid date range!");
        }

        // Exception 2: Room not available
        if (!room.isAvailable()) {
            throw new RoomNotAvailableException("Room not available!");
        }

        // Calculate total price
        double total = paymentService.calculateTotal(room, checkIn, checkOut);

        // Exception 3: Payment declined
        paymentService.processPayment(total);

        // Build reservation
        Reservation reservation = new ReservationBuilder()
                .setGuest(guest)
                .setRoom(room)
                .setCheckIn(checkIn)
                .setCheckOut(checkOut)
                .build();

        // Save reservation
        repo.saveReservation(reservation);

        System.out.println("Room booked successfully!");
    }
}
