void main() {
    int[][] board = new int[9][9];
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    System.out.println("1---> Easy\n2---> Medium\n3---> Hard");
    System.out.print("Choose the difficulty: ");
    int x = scanner.nextInt();

    switch (x) {
        case 1:
            x = random.nextInt(20, 35);
            break;
        case 2:
            x = random.nextInt(35, 50);
            break;
        case 3:
            x = random.nextInt(50, 65);
            break;
        default:
            System.out.println("Invalid Number!");
            System.out.println("\n1---> Easy\n2---> Medium\n3---> Hard");
            System.out.print("Choose the difficulty: ");
            x = scanner.nextInt();
    }

    Generator.generate(board, x);

    IO.println("Puzzle: ");
    printBoard(board);

    if (Solve.solve(board)) {
        IO.println("\nSolution: ");
        printBoard(board);
    }
}

private static void printBoard(int[][] board) {
    for (int row = 0; row < 9; row++) {
        if (row % 3 == 0 && row != 0)
            IO.println("---------------------");
        for (int col = 0; col < 9; col++) {
            if (col % 3 == 0 && col != 0)
                IO.print("| ");
            IO.print(board[row][col] + " ");
        }
        IO.println();
    }
}