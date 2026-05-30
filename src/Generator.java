import java.util.Random;

/**
 * Builds a Sudoku puzzle by generating a valid full board and then removing cells.
 */
public class Generator extends Solve {
    private static final Random random = new Random();

    /**
     * Creates a complete board, solves it, and removes digits to produce a puzzle.
     *
     * @param board the 9x9 Sudoku board to fill
     * @param targetEmptyCells how many cells should be blank in the final puzzle
     */
    public static void generate(int[][] board, int targetEmptyCells) {
        fillDiagonal(board);
        solve(board);
        removeDigits(board, targetEmptyCells);
    }

    /**
     * Fills the three diagonal 3x3 subgrids with random valid numbers.
     * These boxes do not interfere with each other, so this speeds up puzzle generation.
     */
    private static void fillDiagonal(int[][] board) {
        for (int i = 0; i < 9; i += 3) {
            fillBox(board, i, i);
        }
    }

    /**
     * Fills a 3x3 box at the given row and column with unique numbers 1 through 9.
     */
    private static void fillBox(int[][] board, int row, int col) {
        int num;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                do {
                    num = random.nextInt(9) + 1;
                } while (isInBox(board, row, col, num));
                board[row + i][col + j] = num;
            }
        }
    }

    /**
     * Attempts to remove digits from the solved board until the desired number of empty cells is reached.
     * Each removal is only kept if the resulting puzzle still has exactly one solution.
     */
    private static void removeDigits(int[][] board, int targetCount) {
        int removed = 0;
        int attempts = 0;

        while (removed < targetCount && attempts < 1000) {
            int r = random.nextInt(9);
            int c = random.nextInt(9);

            if (board[r][c] != 0) {
                int backup = board[r][c];
                board[r][c] = 0;

                // If removing this digit causes more than one solution, undo it.
                if (Solve.countSolutions(copyBoard(board)) != 1) {
                    board[r][c] = backup;
                    attempts++;
                } else {
                    removed++;
                }
            }
        }
    }

    /**
     * Creates a deep copy of the board so the solver can test removals safely.
     */
    private static int[][] copyBoard(int[][] board) {
        int[][] copy = new int[9][9];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, 9);
        }
        return copy;
    }
}