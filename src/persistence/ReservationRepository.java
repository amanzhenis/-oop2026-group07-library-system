package persistence;

import domain.Reservation;

import java.sql.Connection;

public class ReservationRepository {

    private final Connection conn = DBManager.getInstance().getConnection();

    public void saveReservation(Reservation reservation) {
        System.out.println("Reservation saved in DB (demo).");
    }
}
