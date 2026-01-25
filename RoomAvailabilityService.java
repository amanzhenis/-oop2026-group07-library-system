package service;

import repository.ReservationRepository;

import java.time.LocalDate;

public class RoomAvailabilityService {

    private final ReservationRepository reservationRepo = new ReservationRepository();

    public boolean isAvailable(int roomId, LocalDate checkIn, LocalDate checkOut) {
        return !reservationRepo.roomHasConflict(roomId, checkIn, checkOut);
    }
}
