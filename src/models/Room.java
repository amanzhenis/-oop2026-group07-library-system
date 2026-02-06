package models;

public abstract class Room {
    protected int id;
    protected double price;
    protected String type;

    public Room(int id,double price,String type){
        this.id=id;
        this.price=price;
        this.type=type;
    }

    public int getId(){ return id; }
    public double getPrice(){ return price; }
    public String getType(){ return type; }
}
