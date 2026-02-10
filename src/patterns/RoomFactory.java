package patterns;

import domain.*;

public class RoomFactory {

    public static Room createRoom(String type, int id, boolean available) {

        return switch (type.toLowerCase()) {
            case "standard" -> new StandardRoom(id, available);
            case "suite" -> new SuiteRoom(id, available);
            case "dorm" -> new DormBed(id, available);
            default -> throw new IllegalArgumentException("Invalid room type!");
        };
    }
}
