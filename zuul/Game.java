import java.util.ArrayList;
import java.util.Stack;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates all the items in the rooms, creates the parser and starts the game.
 *  It also evaluates and executes the commands that the parser returns.
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

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Room previousRoom;
    private Stack<Room> previousRooms;
    private Item currentItem;

        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        previousRooms = new Stack<Room>();
        currentItem = null;
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theatre, pub, lab, office;
        ArrayList<Item> items;

        // create the rooms
        outside = new Room("outside the main entrance of the university", items = new ArrayList<Item>());
        outside.addItem("stick", "tiny stick on the ground",5);
        outside.addItem("leaf", "small maple leaf", 0.1);
        outside.addItem("apple","mysterious apple", 0.25);
        theatre = new Room("in a lecture theatre", items = new ArrayList<Item>());
        theatre.addItem("microphone","broken microphone", 5);
        theatre.addItem("sword","fake prop sword", 3);
        pub = new Room("in the campus pub", items = new ArrayList<Item>());
        pub.addItem("soda", "empty can of pepsi", 6);
        pub.addItem("carkeys", "car keys belonging to a beamer", 2);
        pub.addItem("apple","mysterious apple", 0.25);
        lab = new Room("in a computing lab", items = new ArrayList<Item>());
        lab.addItem("mouse","computer mouse", 1);
        lab.addItem("keyboard","computer keyboard", 10);
        office = new Room("in the computing admin office", items = new ArrayList<Item>());
        office.addItem("paperclip","random paper clip on the desk", 0.5);
        office.addItem("pen","dry pen", 0.9);
        
        // initialise room exits
        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theatre.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        currentRoom = outside;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printRoomAndCarry();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * 
     * @param command The command to be processed
     * @return true If the command ends the game, false otherwise
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        switch (commandWord) {
            case "help" -> printHelp();
            case "go" -> goRoom(command);
            case "quit" -> wantToQuit = quit(command);
            case "look" -> look(command);
            case "eat" -> eat(command);
            case "back" -> back(command);
            case "stackBack" -> stackBack(command);
            case "take" -> take(command);
            case "drop" -> drop(command);
        }
        // else command not recognised.
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print a cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(parser.getCommands());
    }

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     * 
     * @param command The command to be processed
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            previousRoom = currentRoom;
            previousRooms.push(previousRoom);
            currentRoom = nextRoom;
            printRoomAndCarry();
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * 
     * @param command The command to be processed
     * @return true, if this command quits the game, false otherwise
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }

    /**
     *Prints a long description of the current room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     *
     *
     * @param command The command to be processed
     */
    private void look(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Look what?");
            return;
        }

        printRoomAndCarry();

    }

    /**
     * Prints that the user has eaten in the form:
     *      You have eaten and are no longer hungry!
     *
     * @param command The command to be processed
     */
    private void eat(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Eat what?");
            return;
        }

        if (currentItem.getName() == "apple") {
            System.out.println("You have eaten and are no longer hungry!");
            currentItem = null;
        } else {
            System.out.println("You are not carrying food.");
        }

    }

    /**
     * Sends the user back a room. If the command is run a second time the user is sent back
     * to the room the user was just in. If the user is at the start of the game it sends a warning via
     * System.out.
     *
     * @param command The command to be processed
     */
    private void back(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Back what?");
            return;
        }
        else if (previousRoom == null){
            System.out.println("You are at the beginning of the game and thus you cannot go back.");
            return;
        }
        Room temp = currentRoom;
        previousRooms.push(currentRoom);
        currentRoom = previousRoom;
        previousRoom = temp;

        System.out.println("You have been sent back!");
        printRoomAndCarry();

    }

    /**
     * Sends the user back a room. If the command is run a second time the user is sent back
     * another room. If the user is at the start of the game it sends a warning via System.out.
     *
     * @param command The command to be processed
     */
    private void stackBack(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("stackBack what?");
            return;
        }
        else if (previousRooms.empty()) {
            System.out.println("You are at the beginning of the game and thus you cannot go back.");
            return;
        }
        previousRoom = currentRoom;
        currentRoom = previousRooms.pop();

        System.out.println("You have been sent back!");
        printRoomAndCarry();
    }

    private void take(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("take what?");
            return;
        }

        String wordItem = command.getSecondWord();

        if (currentItem == null) {
            Item item = currentRoom.removeItem(wordItem);
            if (item == null) {
                System.out.println("That item is not in the room");
            } else {
                System.out.println("You picked up a " + item.getName());
                currentItem = item;
            }
        } else {
            System.out.println("You are already holding something");
        }
    }

    private void drop(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("drop what?");
            return;
        }

        if (currentItem == null) {
            System.out.println("You have nothing to drop.");
        } else {
            System.out.println("You have dropped a " + currentItem.getName());
            currentRoom.addItem(currentItem);
            currentItem = null;
        }
    }

    public void printRoomAndCarry() {
        System.out.println(currentRoom.getLongDescription());

        if (currentItem == null) {
            System.out.println("You are not holding anything.");
        } else {
            System.out.println("You are holding a " + currentItem.getName());
        }
    }
}
