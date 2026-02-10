package domain;

public abstract class Room {

    protected int id;
    protected double pricePerNight;
    protected boolean available;

    public Room(int id, double pricePerNight, boolean available) {
        this.id = id;
        this.pricePerNight = pricePerNight;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public boolean isAvailable() {
        return available;
    }

    public abstract String getType();
}
