package repositories;

import edu.aitu.oop3.db.DatabaseConnection;
import interfaces.Repository;
import models.Room;
import models.RoomFactory;

import java.sql.*;
import java.util.*;

public class RoomRepository implements Repository<Room> {

    public List<Room> findAll() {

        List<Room> rooms = new ArrayList<>();

        try(Connection con = DatabaseConnection.getConnection()) {

            ResultSet rs = con.createStatement()
                    .executeQuery("SELECT * FROM rooms");

            while(rs.next()) {
                int id = rs.getInt("id");
                String type = rs.getString("type");

                Room room = RoomFactory.createRoom(type,id);
                rooms.add(room);
            }

        } catch(Exception e){ e.printStackTrace(); }

        return rooms;
    }

    public void save(Room r){}
    public Room findById(int id){ return null; }
    public void delete(int id){}
}
