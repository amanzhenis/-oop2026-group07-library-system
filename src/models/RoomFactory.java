package models;

public class RoomFactory {

    public static Room createRoom(String type,int id){

        if(type.equalsIgnoreCase("STANDARD"))
            return new StandardRoom(id);

        if(type.equalsIgnoreCase("LUXURY"))
            return new LuxuryRoom(id);

        return null;
    }
}
