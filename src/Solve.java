/**
 * Solves Sudoku boards using backtracking and can count all valid solutions.
 */
public class Solve extends Rules {
    private static int count = 0;

    /**
     * Fills the board using backtracking and returns true when a complete valid solution is found.
     */
    public static boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) return true;
                            board[row][col] = 0; // backtrack if this path fails
                        }
                    }
                    return false; // no valid number fits here
                }
            }
        }
        return true; // board is complete and valid
    }

    /**
     * Counts how many valid solutions the given board has.
     */
    public static int countSolutions(int[][] board) {
        count = 0;
        solveAndCount(board);
        return count;
    }

    /**
     * Recursive helper that enumerates all solutions, but stops early if more than one is found.
     */
    private static void solveAndCount(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            solveAndCount(board);
                            board[row][col] = 0;
                            if (count > 1) return; // only need to know if more than one exists
                        }
                    }
                    return; // dead end for this branch
                }
            }
        }
        count++; // found a complete valid solution
    }
}