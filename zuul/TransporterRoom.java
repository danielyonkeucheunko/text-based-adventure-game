import java.util.ArrayList;
import java.util.Random;

public class TransporterRoom extends Room {

    private Random randRoom;

    public TransporterRoom(String description, ArrayList<Item> items, ArrayList<Room> rooms) {
        super(description, items, rooms);
        randRoom = new Random();
    }


    /**
     * Returns a random room, independent of the direction parameter.
     *
     * @param direction Ignored.
     * @return A randomly selected room.
     */
    public Room getExit(String direction) {
        return findRandomRoom();
    }


    /**
     * Choose a random room.
     *
     * @return The room we end up in upon leaving this one.
     */
    private Room findRandomRoom() {

        int i = randRoom.nextInt(rooms.size());
        return rooms.get(i);

    }
}

