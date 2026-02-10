package domain;

public class DormBed extends Room {

    public DormBed(int id, boolean available) {
        super(id, 5000, available);
    }

    @Override
    public String getType() {
        return "Dorm";
    }
}
