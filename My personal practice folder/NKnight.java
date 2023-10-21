/**
 * This class contains a program that recursively finds all possible
 * configurations of placing n knights on an n x n chessboard
 * such that no two knights attack each other. It displays each valid
 * configuration found.
 */
public class NKnight {

    /**
     * The main method initializes the chessboard and calls the knight method to
     * find all possible
     * configurations of placing n knights on the board.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Initialize the board with size n
        int n = 4;
        boolean[][] board = new boolean[n][n];
        // Call the knight method to find all possible configurations of placing n
        // knights on the board
        knight(board, 0, 0, 4);
    }

    /**
     * This method recursively finds all possible configurations of placing n
     * knights on an n x n chessboard
     * such that no two knights attack each other. It displays each valid
     * configuration found.
     *
     * @param board a 2D boolean array representing the chessboard
     * @param r     the current row being considered
     * @param c     the current column being considered
     * @param n     the number of knights left to place on the board
     */
    static void knight(boolean[][] board, int r, int c, int n) {
        // If all knights have been placed, display the board and return
        if (n == 0) {
            display(board);
            System.out.println();
            return;
        }

        // Check if it is safe to place a knight at the current position
        if (isSafe(board, r, c)) {
            // Place a knight at the current position
            board[r][c] = true;
            // Recursively try placing knights in the remaining columns
            if (c < board.length - 1) {
                knight(board, r, c + 1, n - 1);
            } else if (r < board.length - 1) {
                knight(board, r + 1, 0, n - 1);
            }
            // Remove the knight from the current position
            board[r][c] = false;
        }

        // Try placing knights in the remaining positions in the current row
        if (c < board.length - 1) {
            knight(board, r, c + 1, n);
        } else {
            // If we have reached the end of the row, move to the next row
            if (r < board.length - 1) {
                knight(board, r + 1, 0, n);
            }
        }
    }

    /**
     * Displays the chess board with knights represented by "K" and empty squares
     * represented by "X".
     *
     * @param board the boolean 2D array representing the chess board
     */
    static void display(boolean[][] board) {
        // Loop through each row of the board
        for (boolean[] i : board) {
            // Loop through each column of the current row
            for (boolean j : i) {
                // If the current position contains a knight, print "K", otherwise print "X"
                if (j) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            // Print a newline character to move to the next row
            System.out.println();
        }
    }

    /**
     * Checks if it is safe to place a knight on the given position on the chess
     * board.
     * A knight is safe if it is not attacking any other knight on the board.
     *
     * @param board a 2D boolean array representing the chess board
     * @param r     the row index of the position to check
     * @param c     the column index of the position to check
     * @return true if it is safe to place a knight on the given position, false
     *         otherwise
     */
    static boolean isSafe(boolean[][] board, int r, int c) {
        // Check if the knight is attacking any other knight on the board
        if (r > 1 && c > 0 && board[r - 2][c - 1]) {
            return false;
        }

        if (r > 1 && c < board.length - 1 && board[r - 2][c + 1]) {
            return false;
        }

        if (r > 0 && c < board.length - 2 && board[r - 1][c + 2]) {
            return false;
        }

        if (r > 0 && c > 1 && board[r - 1][c - 2]) {
            return false;
        }

        // If the knight is not attacking any other knight, return true
        return true;
    }
}