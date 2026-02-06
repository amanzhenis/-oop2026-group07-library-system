package repositories;

import edu.aitu.oop3.db.DatabaseConnection;
import interfaces.Repository;
import models.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;


public class ReservationRepository implements Repository<Reservation>{

    public void save(Reservation r){
        try(Connection con=DatabaseConnection.getConnection()){
            PreparedStatement ps=con.prepareStatement(
                    "INSERT INTO reservations(guest_id,room_id,check_in,check_out) VALUES(?,?,?,?)");
            ps.setInt(1,r.getGuestId());
            ps.setInt(2,r.getRoomId());
            ps.setDate(3,Date.valueOf(r.getCheckIn()));
            ps.setDate(4,Date.valueOf(r.getCheckOut()));
            ps.executeUpdate();
        }catch(Exception e){ e.printStackTrace(); }
    }

    public boolean conflict(int roomId,LocalDate in,LocalDate out){
        try(Connection con=DatabaseConnection.getConnection()){
            PreparedStatement ps=con.prepareStatement(
                    "SELECT * FROM reservations WHERE room_id=? AND check_in<=? AND check_out>=?");
            ps.setInt(1,roomId);
            ps.setDate(2,Date.valueOf(out));
            ps.setDate(3,Date.valueOf(in));
            return ps.executeQuery().next();
        }catch(Exception e){ e.printStackTrace(); }
        return true;
    }

    public Reservation findById(int id){ return null; }
    public List<Reservation> findAll(){ return new ArrayList<>(); }
    public void delete(int id){}
}
