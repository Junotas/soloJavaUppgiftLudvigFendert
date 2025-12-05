# Tic Tac Toe – Java Console Game

A simple, object-oriented Tic Tac Toe game built in Java.
Two human players can play against each other, or a human can play against a basic computer opponent.
The game is fully text-based and runs in the terminal.

## Features

### Core Gameplay

* 3×3 Tic Tac Toe grid.
* Two players take turns placing X or O.
* Automatic win detection (rows, columns, diagonals).
* Draw detection if the board is full.
* After each finished game, a new game starts automatically.
* Input validation ensures only free and valid positions can be chosen.

### Object-Oriented Structure

The project is divided into multiple classes:

* Main – starts the program
* TicTacToeGame – controls the game loop
* Board – stores and manages the board state
* Player (abstract) – shared functionality for all player types
* HumanPlayer – reads user input
* ComputerPlayer – simple AI that chooses a random free position

### Additional Functionality

* Asks for player names.
* Displays whose turn it is.
* Tracks number of wins for each player.
* Allows Human vs Human or Human vs Computer.
* Handles invalid input without crashing.


## How to Run the Program

### 1. Compile all Java files

Place all `.java` files in the same directory.
Run the following:

```bash
javac *.java
```

### 2. Start the game

```bash
java Main
```

No external libraries are required.

---

## Example Gameplay

```
=== Tic Tac Toe ===
Play vs human or vs computer? (h/c): h
Enter name for player 1 (X): Ludvig
Enter name for player 2 (O): Anna

 1 | 2 | 3
---+---+---
 4 | 5 | 6
---+---+---
 7 | 8 | 9
```

(this read.me is a polished version made with Open AI's LLM)
