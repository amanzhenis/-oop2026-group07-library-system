package repository;

import edu.aitu.oop3.db.DatabaseConnection;
import entity.Guest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class GuestRepository {

    public Guest findById(int id) {
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM guests WHERE id=?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Guest(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
