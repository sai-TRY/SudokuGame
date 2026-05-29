import java.util.Random;

public class Generator extends Solve {
    private static final Random random = new Random();

    public static void generate(int[][] board, int targetEmptyCells) {
        fillDiagonal(board);
        solve(board);
        removeDigits(board, targetEmptyCells);
    }

    private static void fillDiagonal(int[][] board) {
        for (int i = 0; i < 9; i += 3) {
            fillBox(board, i, i);
        }
    }

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

    private static void removeDigits(int[][] board, int targetCount) {
        int removed = 0;
        int attempts = 0;

        while (removed < targetCount && attempts < 1000) {
            int r = random.nextInt(9);
            int c = random.nextInt(9);

            if (board[r][c] != 0) {
                int backup = board[r][c];
                board[r][c] = 0;

                if (Solve.countSolutions(copyBoard(board)) != 1) {
                    board[r][c] = backup;
                    attempts++;
                } else {
                    removed++;
                }
            }
        }
    }

    private static int[][] copyBoard(int[][] board) {
        int[][] copy = new int[9][9];
        for (int i = 0; i < 9; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, 9);
        }
        return copy;
    }
}