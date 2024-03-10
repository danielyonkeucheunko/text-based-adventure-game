/**
 *  Class Item - an item in an adventure game.
 *
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * An "Item" represents one item in a room of the game.  It is
 * unique to each room. Each item stores a description of the item
 * and the weight of the item.
 *
 * @author Daniel Yonkeu-Cheunko (101263845)
 * @version March 9th, 2024
 */

public class Item {

    private String description;
    private double weight;
    private String name;

    /**
     * Create an item named "name" described with "description" that weighs "weight" kilograms.
     *
     * @param description The item's description.
     * @param weight The item's weight.
     * @param name The item's name.
     */
    public Item(String name, String description, double weight) {
        this.description = description;
        this.weight = weight;
        this.name = name;
    }

    /**
     * Returns a string describing the item in the form:
     *      "name": a "description" that weighs "weight"kg.
     *
     * @return a string describing the item
     */
    public String getDescription() {
        return this.name + ": a " + this.description + " that weighs " + this.weight + "kg.";
    }


    /**
     *
     * Gets the name of the item.
     *
     * @return name of item
     */
    public String getName() {
        return name;
    }





}
