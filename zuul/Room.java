import java.util.*;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game along with its own set of items.
 * It is connected to other rooms via exits.  For each existing exit, the room
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * 
 * @author Lynn Marshall
 * @version October 21, 2012
 *
 * @author Daniel Yonkeu-Cheunko (101263845)
 * @version January 18th, 2024
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private ArrayList<Item> items;
    public ArrayList<Room> rooms;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open courtyard".
     * 
     * @param description The room's description.
     */
    public Room(String description, ArrayList<Item> items, ArrayList<Room> rooms) {
        this.description = description;
        this.items = items;
        this.rooms = rooms;
        exits = new HashMap<String, Room>();
    }

    /**
     * Define an exit from this room.
     * 
     * @param direction The direction of the exit
     * @param neighbour The room to which the exit leads
     */
    public void setExit(String direction, Room neighbour) 
    {
        exits.put(direction, neighbour);
    }

    /**
     * Returns a short description of the room, i.e. the one that
     * was defined in the constructor
     * 
     * @return The short description of the room
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a long description of the room along with its items in the form:
     *     You are in the kitchen.
     *     Exits: north west
     *     Items:
     * 	        a pan that weighs 5.0kg.
     * 	        a stove that weighs 100.0kg.
     *     
     * @return A long description of this room and its items
     */
    public String getLongDescription()
    {
        String itemString = "\nItems:\n";
        for (Item item: items) {
            itemString += "\t" + item.getDescription() + "\n";
        }

        return "You are " + description + ".\n" + getExitString() + itemString;
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * 
     * @return Details of the room's exits
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * 
     * @param direction The exit's direction
     * @return The room in the given direction
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }

    /**
     * Adds an item described as "description" with "weight" kilograms of weight
     * to a Room.
     *
     * @param description The item's description.
     * @param weight The item's weight.
     */
    public void addItem(String name, String description, double weight) {
        Item item = new Item(name, description, weight);
        items.add(item);
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public Item removeItem(String name) {

        for (int i = 0; i < items.size(); i++) {
            if (Objects.equals(items.get(i).getName(), name)) {
                return items.remove(i);
            }
        }

        return null;
    }
}

