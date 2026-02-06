package services;

import exceptions.InvalidDateException;
import exceptions.RoomNotAvailableException;
import models.Reservation;
import repositories.ReservationRepository;

public class ReservationService {

    private ReservationRepository repo = new ReservationRepository();

    public void createReservation(Reservation r){

        if(r.getCheckOut().isBefore(r.getCheckIn()))
            throw new InvalidDateException("Invalid date!");

        if(repo.conflict(r.getRoomId(),r.getCheckIn(),r.getCheckOut()))
            throw new RoomNotAvailableException("Room already booked!");

        repo.save(r);
        System.out.println("Reservation created!");
    }
}
