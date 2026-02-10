package persistence;

import domain.Room;
import patterns.RoomFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomRepository {

    private final Connection conn = DBManager.getInstance().getConnection();

    public List<Room> getAvailableRooms() {

        List<Room> rooms = new ArrayList<>();

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(
                    "SELECT * FROM rooms WHERE available=true"
            );

            while (rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("room_type");
                boolean available = rs.getBoolean("available");

                rooms.add(RoomFactory.createRoom(type, id, available));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rooms;
    }
}
