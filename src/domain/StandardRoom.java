package domain;

public class StandardRoom extends Room {

    public StandardRoom(int id, boolean available) {
        super(id, 10000, available);
    }

    @Override
    public String getType() {
        return "Standard";
    }
}
