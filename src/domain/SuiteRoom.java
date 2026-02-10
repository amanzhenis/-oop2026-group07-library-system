package domain;

public class SuiteRoom extends Room {

    public SuiteRoom(int id, boolean available) {
        super(id, 20000, available);
    }

    @Override
    public String getType() {
        return "Suite";
    }
}
