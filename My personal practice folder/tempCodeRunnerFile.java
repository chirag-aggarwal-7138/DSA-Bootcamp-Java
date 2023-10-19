/**
 * The NQueens class solves the N-Queens problem using backtracking.
 * The problem is to place N chess queens on an N×N chessboard so that no two queens threaten each other.
 * Thus, a solution requires that no two queens share the same row, column, or diagonal.
 */
public class NQueens {
    /**
     * The main method initializes the board and calls the nQueens method to solve the problem.
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        // Initialize the board with size n
        int n = 4;
        boolean[][] board = new boolean[n][n];
        // Call the nQueens method to solve the problem
        nQueens(board, 0);
    }

    /**
     * The nQueens method solves the N-Queens problem using backtracking.
     * @param board The chessboard.
     * @param r The current row.
     */
    static void nQueens(boolean[][] board, int r) {
        // If all queens have been placed, display the board and return
        if (r == board.length) {
            display(board);
            System.out.println();
            return;
        }

        // Try placing a queen in each column of the current row
        for (int c = 0; c < board.length; c++) {
            // Check if it is safe to place a queen at the current position
            if (isSafe(board, r, c)) {
                // Place the queen at the current position
                board[r][c] = true;
                // Recursively try placing queens in the remaining rows
                nQueens(board, r + 1);
                // Remove the queen from the current position
                board[r][c] = false;
            }
        }
    }

    /**
     * The display method prints the chessboard to the console.
     * @param board The chessboard.
     */
    static void display(boolean[][] board) {
        // Loop through each cell of the board and print either "Q" or "X"
        for(boolean[] i : board) {
            for (boolean j : i) {
                if (j) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    /**
     * The isSafe method checks if it is safe to place a queen at the given position.
     * @param board The chessboard.
     * @param r The row.
     * @param c The column.
     * @return True if it is safe to place a queen at the given position, false otherwise.
     */
    static boolean isSafe(boolean[][] board, int r, int c) {
        // Check if there is a queen in the same column
        for (int i = 0; i < r; i++) {
            if (board[i][c]) {
                return false;
            }
        }

        // Check if there is a queen in the same diagonal (top-left to bottom-right)
        int maxLeft = Math.min(r, c);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[r - i][c - i]) {
                return false;
            }
        }

        // Check if there is a queen in the same diagonal (top-right to bottom-left)
        int maxRight = Math.min(r, board.length - c - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (board[r - i][c + i]) {
                return false;
            }
        }
        // If there is no queen in the same row, column, or diagonal, it is safe to place a queen at the given position
        return true;
    }
}