/**
 * Contains Sudoku validation rules for rows, columns, and 3x3 boxes.
 */
public class Rules {

    /**
     * Checks whether it is valid to place num at board[row][col].
     * It verifies the row, the column, and the corresponding 3x3 box.
     */
    protected static boolean isValid(int[][] board, int row, int col, int num) {
        for (int x = 0; x < 9; x++) {
            if (board[row][x] == num || board[x][col] == num) return false;
        }
        int startRow = row - row % 3, startCol = col - col % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i + startRow][j + startCol] == num) return false;
            }
        }
        return true;
    }

    /**
     * Checks whether the given number already exists inside a 3x3 subgrid.
     */
    protected static boolean isInBox(int[][] board, int startRow, int startCol, int num) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) return true;
            }
        }
        return false;
    }
}
