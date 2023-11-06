# Stratego Game Implementation

This repository contains a Java implementation of the classic two-player board game, Stratego. The game adheres to the specifications outlined in the coursework for CS5001 of St Andrews. This repository is mainly created to show the grasp on the OOPS concept in java.

## Stratego Overview

Stratego is a strategic board game where two players position their armies on a 10x10 board and take turns moving and attacking with their pieces. The game pieces have different ranks, hidden from the opponent. The objective is to attack the opponent's flag.

## Game Rules

The game involves setting up 40 pieces each, including a variety of ranks and specialized pieces. Players take turns moving or attacking, adhering to specific movement and combat rules. Here are the key rules for the game:

- **Setting Up:** Players position their pieces in the first 4 rows in front of them. Pieces are arranged arbitrarily.
- **Moving:** Players can move their pieces one space forward, backward, or sideways, excluding diagonal moves.
- **Attacking:** Players can attack an opponent's piece adjacent to theirs. The lower-ranking piece is eliminated.
- **Special Pieces:** Bombs, Miners, and Spies have unique combat rules.

Refer to the provided [game rules](https://www.ultraboardgames.com/stratego/game-rules.php) for more information on detailed game instructions.

## System Specification

This repository contains Java classes designed based on the UML class diagram provided in the coursework. The structure of the system is defined by the classes and methods in the UML diagram, including the necessary public methods and attributes. 

### Class Structure

- **Piece:** Base class representing all pieces in the game.
- **StepMover:** Subclass of Piece that encompasses pieces moving one square orthogonally.
- **Scout:** Subclass of StepMover allowing longer-distance movement.
- **ImmobilePiece:** Subclass of Piece for pieces that cannot move.
- **Game:** Represents the game environment with players and the 10x10 board.
- **Players and Squares:** Classes detailing player information and board squares.

## Running the Tests

The project did include a suite of JUnit tests located in the `Tests/` directory. These tests are essential in validating the functionality of the implemented classes. Running the provided tests validates the correctness of the implementation. Use the following command to run the tests:

```bash
stacscheck /cs/studres/CS5001/Coursework/p2-stratego/Tests
```

## Contributing

You may create additional tests or further extend the functionality by implementing additional methods or classes based on your implementation choices. Ensure that your code passes the tests and adheres to the game's rules.

For further clarification, refer to the original UML diagram provided or examine the test files that correspond to specific classes.

This project is part of the coursework for CS5001 and should be structured according to the provided UML class diagram and tests.



Feel free to run your own JUnit tests on the implementation to ensure its robustness and adherence to the specified game rules.

--- 

This README file offers a concise overview of the Stratego game implementation, detailing the rules, system structure, and testing instructions, ensuring clarity for developers and reviewers working on this project. Adjust or add additional sections as needed and incorporate your specific implementation details.
