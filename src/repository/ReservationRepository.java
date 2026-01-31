package repository;

import edu.aitu.oop3.db.DatabaseConnection;
import entity.Reservation;

import java.sql.*;
import java.time.LocalDate;

public class ReservationRepository {

    public boolean roomHasConflict(int roomId, LocalDate checkIn, LocalDate checkOut) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "SELECT 1 FROM reservations " +
                            "WHERE room_id=? AND status='ACTIVE' " +
                            "AND NOT (check_out <= ? OR check_in >= ?)"
            );
            ps.setInt(1, roomId);
            ps.setDate(2, Date.valueOf(checkIn));
            ps.setDate(3, Date.valueOf(checkOut));

            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int save(Reservation r) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO reservations (guest_id, room_id, check_in, check_out, status) " +
                            "VALUES (?, ?, ?, ?, ?) RETURNING id"
            );
            ps.setInt(1, r.getGuestId());
            ps.setInt(2, r.getRoomId());
            ps.setDate(3, Date.valueOf(r.getCheckIn()));
            ps.setDate(4, Date.valueOf(r.getCheckOut()));
            ps.setString(5, r.getStatus());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) return rs.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public void cancel(int reservationId) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "UPDATE reservations SET status='CANCELLED' WHERE id=?"
            );
            ps.setInt(1, reservationId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
