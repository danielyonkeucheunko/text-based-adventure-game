import java.util.Random;

/**
 *
 * Class TransporterRoom - a subclass of the Room class
 *
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * A "TransporterRoom" is a Room with a special property of being able to teleport the player anywhere in the game.
 *
 * @author Daniel Yonkeu-Cheunko (101263845)
 * @version March 9th, 2024
 */

public class TransporterRoom extends Room {

    private Random randRoom;

    /**
     * Create a Transporter Room with "description as its description"
     *
     * @param description Description of the Room
     */
    public TransporterRoom(String description) {
        super(description);
        randRoom = new Random();
    }

    /**
     * Returns a random room, independent of the direction parameter.
     *
     * @param direction Ignored.
     * @return A randomly selected room.
     */
    public Room getExit(String direction) {
        return rooms.get(randRoom.nextInt(rooms.size()));
    }

}

