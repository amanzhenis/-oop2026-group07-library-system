package repository;

import edu.aitu.oop3.db.DatabaseConnection;
import entity.Payment;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class PaymentRepository {

    public void save(Payment p) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO payments (reservation_id, amount, method, status) VALUES (?, ?, ?, ?)"
            );
            ps.setInt(1, p.getReservationId());
            ps.setDouble(2, p.getAmount());
            ps.setString(3, p.getMethod());
            ps.setString(4, p.getStatus());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
