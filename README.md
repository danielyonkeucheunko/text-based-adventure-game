# text-based-adventure-game

A simple text-based adventure game implemented in Java. Players can explore different rooms and interact with various items. A unique item, the Beamer, allows setting a savepoint in a room and teleporting back to it later.

## Features

- Navigate through various rooms in a text-based environment.
- Collect and interact with items within the game.
- Use the Beamer item to set a savepoint and teleport back to it.

## Tech Stack

- **Language**: Java

## Setup Instructions

1. Clone this repository to your local machine using the following URL: `https://github.com/danielyonkeucheunko/text-based-adventure-game.git`.
2. Navigate to the `zuul` subfolder.
3. Compile all Java files in the folder:
   ```bash
   javac *.java
   ```
4. Run the `Main.java` file to start the game:
   ```bash
   java Main
   ```

## Commands

- **go [direction]**: Move to a different room in the specified direction (e.g., `go north`).
- **eat**: Eat current item in inventory. Currently the only edible items are apples.
- **take [item]**: Pick up an item in the current room. Must have eaten first.
- **drop**: Drop item from your inventory.
- **fire**: Use the Beamer to teleport to your save point. Must have beamer in inventory.
- **charge**: Set the Beamer’s save point to your current location. Must have beamer in inventory.
- **back**: Go back to previous room. If used twice in a row, it sends you back to the room you were already in.
- **stackBack**: Go back to previous rooms. If used twice in a row, it sends you back two rooms.
- **look**: Gives a description of the current room.
- **help**: Gives a list of all commands.
- **quit**: Leaves the game.

## Contact

Developed by Daniel Yonkeu-Cheunko. Check out my [GitHub profile](https://github.com/danielyonkeucheunko) for more projects! For questions or feedback, feel free to reach out at:

- **Email**: [danielyonkeucheunko@cmail.carleton.ca](mailto:danielyonkeucheunko@cmail.carleton.ca)
