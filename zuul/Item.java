/**
 *  Class Item - an item in an adventure game.
 *
 *  This class is part of the "World of Zuul" application.
 *  "World of Zuul" is a very simple, text based adventure game.
 *
 * An "Item" represents one item in a room of the game.  It is
 * unique to each room. Each item stores a description of the item
 * and the weight of the item.
 *
 * @author Daniel Yonkeu-Cheunko (101263845)
 * @version January 18, 2024
 */

public class Item {

    private String description;
    private double weight;

    /**
     * Create an item described with "description" that weighs "weight" kilograms.
     *
     * @param description The item's description.
     * @param weight The item's weight.
     */
    public Item(String description, double weight) {
        this.description = description;
        this.weight = weight;
    }

    /**
     * Returns a string describing the item in the form:
     *      a "description" that weighs "weight"kg.
     *
     * @return a string describing the item
     */
    public String getDescription() {
        return "a " + this.description + " that weighs " + this.weight + "kg.";
    }





}
