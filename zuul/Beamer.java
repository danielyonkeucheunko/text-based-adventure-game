/**
 *
 * Class Beamer - a subclass of the Item class
 *
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * A "Beamer" is an item with a special property of being able to teleport the player.
 * The item has two functionalities "charge" and "fire". When the Beamer is charged, the current room of
 * the player is saved into the Beamer and when the Beamer is fired, regardless of where the player is currently,
 * the player is sent back to the room the Beamer has saved.
 *
 * @author Daniel Yonkeu-Cheunko (101263845)
 * @version March 9th, 2024
 */

public class Beamer extends Item {

    private boolean charged;

    /**
     * Create a Beamer named "name" described with "description" that weighs "weight" kilograms,
     * as well as if it is charged or not.
     *
     * @param name name of the Beamer
     * @param description Description of the Beamer
     * @param weight Weight of the Beamer
     * @param charged Whether the Beamer is charged or not
     */
    public Beamer(String name, String description, double weight, boolean charged) {
        super(name, description, weight);
        this.charged = charged;

    }

    /**
     * Returns whether the Beamer is charged or not
     *
     * @return whether the Beamer is charged or not.
     */
    public boolean isCharged() {
        return charged;
    }

    /**
     * Charges the Beamer if it has not been charged already.
     *
     * @return whether the Beamer has been charged or not
     */
    public boolean chargeBeamer() {
        if (!isCharged()) {
            System.out.println("Beamer successfully charged!");
            charged = true;
            return true;
        } else {
            System.out.println("Beamer has already been charged.");
            return false;
        }
    }

    /**
     * Fires the Beamer if it has been charged.
     *
     * @return whether the Beamer has been fired or not
     */
    public boolean fireBeamer() {
        if (isCharged()) {
            System.out.println("Beamer has been fired!");
            charged = false;
            return true;
        } else {
            System.out.println("Beamer is not charged.");
            return false;
        }
    }
}
