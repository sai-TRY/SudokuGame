# SudokuGame

A simple Java console application that generates and solves Sudoku puzzles.

## Project Structure

- `src/Main.java` - Application entry point and difficulty selection.
- `src/Generator.java` - Generates the Sudoku puzzle board.
- `src/Solve.java` - Solves a given Sudoku board.
- `src/Rules.java` - Contains validation rules used by the generator and solver.

## Requirements

- Java 17 or later
- A Java build tool or IDE that can compile plain Java source files

## Run the Project

From the project root, compile and run the project using Java commands:

```bash
javac src/*.java
java -cp src Main
```

Then choose a difficulty:

- `1` for Easy
- `2` for Medium
- `3` for Hard

The program will print a generated Sudoku puzzle followed by its solution.

## Notes

- The program uses a random number of pre-filled cells depending on the chosen difficulty.
- If an invalid difficulty is entered, the program prompts again for a valid choice.
