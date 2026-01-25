package entity;

public class Room {
    private int id;
    private String roomNumber;
    private String type;
    private int capacity;
    private double pricePerNight;

    public Room(int id, String roomNumber, String type, int capacity, double pricePerNight) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.type = type;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
    }

    public int getId() { return id; }
    public double getPricePerNight() { return pricePerNight; }

    @Override
    public String toString() {
        return "Room{id=" + id + ", roomNumber='" + roomNumber + "', type='" + type +
                "', capacity=" + capacity + ", price=" + pricePerNight + "}";
    }
}
