package repositories;

import edu.aitu.oop3.db.DatabaseConnection;
import interfaces.Repository;
import models.Guest;
import java.sql.*;
import java.util.*;

public class GuestRepository implements Repository<Guest> {

    public void save(Guest g){
        try(Connection con=DatabaseConnection.getConnection()){
            PreparedStatement ps=con.prepareStatement(
                    "INSERT INTO guests(name,email) VALUES(?,?)");
            ps.setString(1,g.getName());
            ps.setString(2,g.getEmail());
            ps.executeUpdate();
        }catch(Exception e){ e.printStackTrace(); }
    }

    public Guest findById(int id){ return null; }
    public List<Guest> findAll(){ return new ArrayList<>(); }
    public void delete(int id){}
}
