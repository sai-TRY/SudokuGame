public class Solve extends Rules {
    private static int count = 0;

    public static boolean solve(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            if (solve(board)) return true;
                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static int countSolutions(int[][] board) {
        count = 0;
        solveAndCount(board);
        return count;
    }

    private static void solveAndCount(int[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;
                            solveAndCount(board);
                            board[row][col] = 0;
                            if (count > 1) return;
                        }
                    }
                    return;
                }
            }
        }
        count++;
    }
}